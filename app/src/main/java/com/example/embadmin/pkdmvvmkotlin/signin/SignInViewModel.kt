package com.example.embadmin.pkdmvvmkotlin.signin

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.embadmin.pkdmvvmkotlin.MyPkdApplication
import com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn.OtpResponse
import com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn.SignInRequest
import com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn.SignInResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class SignInViewModel : ViewModel() {

    val SIGN_IN_REQUEST: String="sign_in_request"
    val GET_OTP_REQUEST: String="get_otp_request"

    val disposable: CompositeDisposable = CompositeDisposable()
    var mOtpResponse: MutableLiveData<OtpResponse> = MutableLiveData()
    var mSignInResponse: MutableLiveData<SignInResponse> = MutableLiveData()
    var userMobileNumber: String= String()
    var otpRequestId: String = String()
    var otpRecieved: String = String()

    fun askForOtp(){
        disposable.add(MyPkdApplication.apiService
                .getOtp(userMobileNumber)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<OtpResponse>(){
                    override fun onComplete() {
                    }

                    override fun onNext(response: OtpResponse) {
                        mOtpResponse.postValue(response)
                    }

                    override fun onError(e: Throwable) {
                    }

                }))
    }

    fun signIn(){
        var signInReq : SignInRequest = SignInRequest(otpRequestId, otpRecieved)
        disposable.add(MyPkdApplication.apiService
                .signIn(userMobileNumber, signInReq)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableObserver<SignInResponse>(){
                    override fun onComplete() {
                    }

                    override fun onNext(t: SignInResponse) {
                        mSignInResponse.value=t
                    }

                    override fun onError(e: Throwable) {
                    }

                }))
    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }
}
