package com.rohitjakhar.greenlightplanettask.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.rohitjakhar.greenlightplanettask.databinding.FragmentCitizensBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitizensFragment : Fragment() {
    private var _binding: FragmentCitizensBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCitizensBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}
