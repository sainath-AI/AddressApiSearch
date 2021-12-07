package com.masai.sainath.theaddressapp.remote.responses


import com.google.gson.annotations.SerializedName
import com.masai.sainath.theaddressapp.remote.responses.AddressModel

data class DataModel(
    @SerializedName("addressList")
    val addressModelList: List<AddressModel>,
    @SerializedName("autoCompleteRequestString")
    val autoCompleteRequestString: String,
    @SerializedName("focusWord")
    val focusWord: String,
    @SerializedName("totalFindByRSUHits")
    val totalFindByRSUHits: Int,
    @SerializedName("totalNoRSUReturned")
    val totalNoRSUReturned: Int
)