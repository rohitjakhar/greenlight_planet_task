package com.rohitjakhar.greenlightplanettask.domain.repo

import com.rohitjakhar.greenlightplanettask.domain.model.AreaModel
import com.rohitjakhar.greenlightplanettask.utils.Resource

interface SaleDataRepo {
    suspend fun getArea(): Resource<AreaModel>
}