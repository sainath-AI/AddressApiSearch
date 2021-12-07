package com.masai.sainath.theaddressapp.remote.responses


import com.google.gson.annotations.SerializedName
import com.masai.sainath.theaddressapp.remote.responses.DataModel

data class ResponseDTO(
    @SerializedName("data")
    val dataModel: DataModel,
    @SerializedName("requestId")
    val requestId: String
)