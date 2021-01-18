package com.example.webviewgeofilter

import com.google.gson.annotations.SerializedName

data class Country(
    @SerializedName("country_name")
    var countryName: String? = null
) {
}