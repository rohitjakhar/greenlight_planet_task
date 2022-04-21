package com.rohitjakhar.greenlightplanettask.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohitjakhar.greenlightplanettask.domain.model.GenericModel
import com.rohitjakhar.greenlightplanettask.domain.repo.SaleDataRepo
import com.rohitjakhar.greenlightplanettask.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MetricsViewModel @Inject constructor(
    private val saleDataRepo: SaleDataRepo
) : ViewModel() {
    var metricsState = MutableStateFlow<Resource<GenericModel>>(Resource.Loading())
        private set

    fun getMetrics() {
        viewModelScope.launch(Dispatchers.IO) {
            metricsState.emit(Resource.Loading())
            metricsState.emit(saleDataRepo.getCitizen())
        }
    }
}