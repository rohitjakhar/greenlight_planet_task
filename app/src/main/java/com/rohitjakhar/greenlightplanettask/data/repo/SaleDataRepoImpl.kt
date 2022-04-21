package com.rohitjakhar.greenlightplanettask.data.repo

import com.rohitjakhar.greenlightplanettask.data.remote.webservice.WebService
import com.rohitjakhar.greenlightplanettask.domain.model.AreaModel
import com.rohitjakhar.greenlightplanettask.domain.repo.SaleDataRepo
import com.rohitjakhar.greenlightplanettask.utils.Resource
import javax.inject.Inject

class SaleDataRepoImpl @Inject constructor(
    private val webService: WebService
) : SaleDataRepo {
    override suspend fun getArea(): Resource<AreaModel> {
        try {
            val task = webService.getSaleData()
            if (!task.isSuccessful) {
                return Resource.Error(message = task.message())
            }
            if (task.body() == null) {
                return Resource.Empty()
            }
            return Resource.Success(AreaModel(""))
        } catch (e: Exception) {
            return Resource.Error(message = e.localizedMessage)
        }
    }
}
