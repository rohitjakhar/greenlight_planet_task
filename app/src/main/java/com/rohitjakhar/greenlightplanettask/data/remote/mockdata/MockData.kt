package com.rohitjakhar.greenlightplanettask.data.remote.mockdata

import com.rohitjakhar.greenlightplanettask.domain.model.GenericModel

fun getZonePerformanceList(): List<GenericModel> =
    listOf(GenericModel("West"), GenericModel("East"), GenericModel("Central"))

fun getRegionPerformanceList(): List<GenericModel> =
    listOf(GenericModel("Western"), GenericModel("Paris"), GenericModel("E. France"))

fun getCitizenList(): List<GenericModel> = listOf(
    GenericModel("Gopabandhu Meher"),
    GenericModel("Dolamani Nag"),
    GenericModel("Jayachandra Majhi"),
    GenericModel("Micheal omotosho"),
    GenericModel("Joe Chukwu"),
    GenericModel("Bimalendu Mishra"),
    GenericModel("Ezekwesili Eva"),
    GenericModel("Pratima Panigrahi")
)
