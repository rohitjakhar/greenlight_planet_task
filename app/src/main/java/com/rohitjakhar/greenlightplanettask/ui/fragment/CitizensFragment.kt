package com.rohitjakhar.greenlightplanettask.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import com.rohitjakhar.greenlightplanettask.databinding.FragmentCitizensBinding
import com.rohitjakhar.greenlightplanettask.ui.adapter.GenericAdapter
import com.rohitjakhar.greenlightplanettask.ui.viewmodel.CitizenViewModel
import com.rohitjakhar.greenlightplanettask.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class CitizensFragment : Fragment() {
    private var _binding: FragmentCitizensBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<CitizenViewModel>()
    private val mAdapter by lazy {
        GenericAdapter {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCitizensBinding.inflate(layoutInflater, container, false)
        viewModel.getCitizen()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        collectData()
    }

    override fun onResume() {
        super.onResume()
        initClick()
    }

    private fun initClick() = binding.apply {
        includeList.tvHeader.setOnClickListener {
            mAdapter.submitList(mAdapter.currentList.reversed())
        }
    }

    private fun collectData() {
        lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.RESUMED) {
                viewModel.citizenState.collectLatest {
                    when (it) {
                        is Resource.Empty -> {}
                        is Resource.Error -> {}
                        is Resource.Loading -> {
                        }
                        is Resource.Success -> {
                            mAdapter.submitList(it.data!!.sortedBy { it.name })
                        }
                    }
                }
            }
        }
    }

    private fun initRecyclerView() {
        binding.includeList.recycleViewName.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = mAdapter
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
