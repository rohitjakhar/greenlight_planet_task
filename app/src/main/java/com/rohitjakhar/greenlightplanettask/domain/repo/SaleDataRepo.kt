package com.rohitjakhar.greenlightplanettask.domain.repo

import com.rohitjakhar.greenlightplanettask.domain.model.GenericModel
import com.rohitjakhar.greenlightplanettask.utils.Resource

interface SaleDataRepo {
    suspend fun getArea(): Resource<GenericModel>
    suspend fun getCitizen(): Resource<GenericModel>
    suspend fun getMetrics(): Resource<GenericModel>
    suspend fun getRegionPerformance(): Resource<GenericModel>
    suspend fun getZonePerformance(): Resource<GenericModel>
}