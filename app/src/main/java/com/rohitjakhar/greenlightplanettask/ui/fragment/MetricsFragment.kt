package com.rohitjakhar.greenlightplanettask.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.rohitjakhar.greenlightplanettask.databinding.FragmentMetricsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MetricsFragment : Fragment() {
    private var _binding: FragmentMetricsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMetricsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        initClick()
    }

    private fun initClick() = binding.apply {
        btnPerformanceZone.setOnClickListener {
            findNavController().navigate(MetricsFragmentDirections.actionMetricsFragmentToZonePerformanceFragment())
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
