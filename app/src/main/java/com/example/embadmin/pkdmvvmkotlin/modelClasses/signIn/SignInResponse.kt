package com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn

import com.google.gson.annotations.SerializedName


data class SignInResponse(
        @SerializedName("responseCode") val responseCode: Int = 0, // 200
        @SerializedName("responseMessage") val responseMessage: String = "", // Successful: OK
        @SerializedName("responseData") val responseData: ResponseData = ResponseData()
) {

    data class ResponseData(
            @SerializedName("customerId") val customerId: String = "", // 155
            @SerializedName("isFPCustomer") val isFPCustomer: String = "", // 1
            @SerializedName("isAnExistingCustomer") val isAnExistingCustomer: Boolean = false // true
    )
}