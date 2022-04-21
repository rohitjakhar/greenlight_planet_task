package com.rohitjakhar.greenlightplanettask.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rohitjakhar.greenlightplanettask.domain.model.GenericModel
import com.rohitjakhar.greenlightplanettask.domain.repo.SaleDataRepo
import com.rohitjakhar.greenlightplanettask.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AreaViewModel @Inject constructor(
    private val saleDataRepo: SaleDataRepo
) : ViewModel() {
    var areaState = MutableStateFlow<Resource<List<GenericModel>>>(Resource.Loading())
        private set

    fun getArea() {
        viewModelScope.launch(IO) {
            areaState.emit(Resource.Loading())
            areaState.emit(saleDataRepo.getArea())
        }
    }
}
