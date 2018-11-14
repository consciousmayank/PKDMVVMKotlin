package com.example.embadmin.pkdmvvmkotlin.repository


import android.arch.lifecycle.LiveData
import com.example.embadmin.pkdmvvmkotlin.modelClasses.account.AccountResponse
import com.example.embadmin.pkdmvvmkotlin.modelClasses.homepage.HomePageResponse
import com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn.OtpResponse
import com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn.SignInRequest
import com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn.SignInResponse
import com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn.UserProfileResponse
import com.google.gson.JsonObject
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @GET("customer/{phNo}/loginOtpInitiate")
    fun getOtp(@Path("phNo") userPhoneNumber: String): Observable<OtpResponse>


    @POST("customer/{phNo}/loginOtpValidate")
    fun signIn(@Path("phNo") userPhoneNumber: String,
               @Body request: SignInRequest): Observable<SignInResponse>

    @GET("customer/{customerId}/profile/{storeId}")
    fun getUserProfile(@Path("customerId") customerId: String,
                       @Path("storeId") storeId: Int): Observable<AccountResponse>

    @GET("content/homepage")
    fun getHomePageData(): Observable<JsonObject>

}
