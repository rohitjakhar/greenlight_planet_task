package com.rohitjakhar.greenlightplanettask.data.remote.dto

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import com.rohitjakhar.greenlightplanettask.domain.model.GenericModel

@Keep
data class SaleDataDto(
    @SerializedName("ResponseData")
    val responseData: ResponseData,
    @SerializedName("ResponseStatus")
    val responseStatus: Double,
    @SerializedName("Success")
    val success: Boolean
) {
    @Keep
    data class ResponseData(
        @SerializedName("sales_area")
        val salesArea: List<SalesArea>,
        @SerializedName("sales_country")
        val salesCountry: List<SalesCountry>,
        @SerializedName("sales_region")
        val salesRegion: List<SalesRegion>,
        @SerializedName("sales_zone")
        val salesZone: List<SalesZone>
    ) {
        @Keep
        data class SalesArea(
            @SerializedName("area")
            val area: String,
            @SerializedName("count_unsigned_contracts")
            val countUnsignedContracts: Double,
            @SerializedName("last_month_sales")
            val lastMonthSales: Double,
            @SerializedName("lmsd_weighted_units")
            val lmsdWeightedUnits: Double,
            @SerializedName("mtd_new_selling_agents")
            val mtdNewSellingAgents: Double,
            @SerializedName("mtd_unit_sales")
            val mtdUnitSales: Double,
            @SerializedName("mtd_weighted_units")
            val mtdWeightedUnits: Float,
            @SerializedName("signed_contracts")
            val signedContracts: Double,
            @SerializedName("territory")
            val territory: String
        )

        @Keep
        data class SalesCountry(
            @SerializedName("achievement")
            val achievement: Double,
            @SerializedName("count_unsigned_contracts")
            val countUnsignedContracts: Double,
            @SerializedName("country")
            val country: String,
            @SerializedName("daily_runrate_current")
            val dailyRunrateCurrent: Double,
            @SerializedName("daily_runrate_required")
            val dailyRunrateRequired: Double,
            @SerializedName("id")
            val id: Double,
            @SerializedName("last_month_sales")
            val lastMonthSales: Double,
            @SerializedName("lmsd_active_2_agents")
            val lmsdActive2Agents: Double,
            @SerializedName("lmsd_active_agents")
            val lmsdActiveAgents: Double,
            @SerializedName("lmsd_weighted_units")
            val lmsdWeightedUnits: Double,
            @SerializedName("mtd_active_2_agents")
            val mtdActive2Agents: Double,
            @SerializedName("mtd_active_agents")
            val mtdActiveAgents: Double,
            @SerializedName("mtd_new_selling_agents")
            val mtdNewSellingAgents: Double,
            @SerializedName("mtd_sales_bucket_1")
            val mtdSalesBucket1: Double,
            @SerializedName("mtd_sales_bucket_2")
            val mtdSalesBucket2: Double,
            @SerializedName("mtd_sales_bucket_3")
            val mtdSalesBucket3: Double,
            @SerializedName("mtd_sales_bucket_4")
            val mtdSalesBucket4: Double,
            @SerializedName("mtd_sales_bucket_5")
            val mtdSalesBucket5: Double,
            @SerializedName("mtd_sales_bucket_6")
            val mtdSalesBucket6: Double,
            @SerializedName("mtd_unit_sales")
            val mtdUnitSales: Double,
            @SerializedName("mtd_weighted_units")
            val mtdWeightedUnits: Double,
            @SerializedName("percent_agent_met")
            val percentAgentMet: Double,
            @SerializedName("sales_monthly_goal")
            val salesMonthlyGoal: Double,
            @SerializedName("signed_contracts")
            val signedContracts: Double,
            @SerializedName("territory")
            val territory: String,
            @SerializedName("today_sales")
            val todaySales: Double,
            @SerializedName("yesterday_sales")
            val yesterdaySales: Double
        )

        @Keep
        data class SalesRegion(
            @SerializedName("count_unsigned_contracts")
            val countUnsignedContracts: Double,
            @SerializedName("last_month_sales")
            val lastMonthSales: Double,
            @SerializedName("lmsd_weighted_units")
            val lmsdWeightedUnits: Double,
            @SerializedName("mtd_new_selling_agents")
            val mtdNewSellingAgents: Double,
            @SerializedName("mtd_unit_sales")
            val mtdUnitSales: Double,
            @SerializedName("mtd_weighted_units")
            val mtdWeightedUnits: Double,
            @SerializedName("region")
            val region: String,
            @SerializedName("signed_contracts")
            val signedContracts: Double,
            @SerializedName("territory")
            val territory: String
        )

        @Keep
        data class SalesZone(
            @SerializedName("count_unsigned_contracts")
            val countUnsignedContracts: Double,
            @SerializedName("last_month_sales")
            val lastMonthSales: Double,
            @SerializedName("lmsd_weighted_units")
            val lmsdWeightedUnits: Double,
            @SerializedName("mtd_new_selling_agents")
            val mtdNewSellingAgents: Double,
            @SerializedName("mtd_unit_sales")
            val mtdUnitSales: Double,
            @SerializedName("mtd_weighted_units")
            val mtdWeightedUnits: Double,
            @SerializedName("signed_contracts")
            val signedContracts: Double,
            @SerializedName("territory")
            val territory: String,
            @SerializedName("zone")
            val zone: String
        )
    }
}

fun SaleDataDto.toArea(): List<GenericModel> {
    val areaList = mutableListOf<GenericModel>()
    this.responseData.salesArea.forEach {
        areaList.add(GenericModel(name = it.area))
    }
    return areaList
}
