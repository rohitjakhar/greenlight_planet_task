package com.rohitjakhar.greenlightplanettask.data.repo

import com.rohitjakhar.greenlightplanettask.data.remote.webservice.WebService
import com.rohitjakhar.greenlightplanettask.domain.model.GenericModel
import com.rohitjakhar.greenlightplanettask.domain.repo.SaleDataRepo
import com.rohitjakhar.greenlightplanettask.utils.Resource
import javax.inject.Inject

class SaleDataRepoImpl @Inject constructor(
    private val webService: WebService
) : SaleDataRepo {
    override suspend fun getArea(): Resource<GenericModel> {
        try {
            val task = webService.getSaleData()
            if (!task.isSuccessful) {
                return Resource.Error(message = task.message())
            }
            if (task.body() == null) {
                return Resource.Empty()
            }
            return Resource.Success(GenericModel(""))
        } catch (e: Exception) {
            return Resource.Error(message = e.localizedMessage)
        }
    }

    override suspend fun getCitizen(): Resource<GenericModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getMetrics(): Resource<GenericModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getRegionPerformance(): Resource<GenericModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getZonePerformance(): Resource<GenericModel> {
        TODO("Not yet implemented")
    }
}
