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
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.rohitjakhar.greenlightplanettask.R
import com.rohitjakhar.greenlightplanettask.databinding.FragmentRegionPerformanceBinding
import com.rohitjakhar.greenlightplanettask.ui.adapter.GenericAdapter
import com.rohitjakhar.greenlightplanettask.ui.viewmodel.RegionPerformanceViewModel
import com.rohitjakhar.greenlightplanettask.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RegionPerformanceFragment : Fragment() {
    private var _binding: FragmentRegionPerformanceBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModels<RegionPerformanceViewModel>()
    private val navArgs: RegionPerformanceFragmentArgs by navArgs()
    private val mAdapter by lazy {
        GenericAdapter {
            findNavController().navigate(
                RegionPerformanceFragmentDirections.actionRegionPerformanceFragmentToAreaFragment(
                    it
                )
            )
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRegionPerformanceBinding.inflate(layoutInflater, container, false)
        viewModel.getRegionPerformance()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initRecyclerView()
        collectData()
    }

    private fun initView() = binding.apply {
        tvTitle.text = resources.getString(R.string.performance, navArgs.name)
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
                viewModel.regionPerformanceState.collectLatest {
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
