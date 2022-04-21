package com.rohitjakhar.greenlightplanettask.domain.repo

import com.rohitjakhar.greenlightplanettask.domain.model.GenericModel
import com.rohitjakhar.greenlightplanettask.utils.Resource

interface SaleDataRepo {
    suspend fun getArea(): Resource<List<GenericModel>>
    suspend fun getCitizen(): Resource<List<GenericModel>>
    suspend fun getMetrics(): Resource<List<GenericModel>>
    suspend fun getRegionPerformance(): Resource<List<GenericModel>>
    suspend fun getZonePerformance(): Resource<List<GenericModel>>
}