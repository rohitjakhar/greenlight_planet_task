package com.rohitjakhar.greenlightplanettask.data.remote.webservice

import com.rohitjakhar.greenlightplanettask.data.remote.dto.SaleDataDto
import retrofit2.Response
import retrofit2.http.GET

interface WebService {
    @GET("286f38b4-c6c1-4348-aabc-6d396dcbc4de")
    suspend fun getSaleData(): Response<SaleDataDto>
}
