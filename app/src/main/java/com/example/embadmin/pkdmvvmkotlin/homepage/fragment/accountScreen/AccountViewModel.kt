package com.example.embadmin.pkdmvvmkotlin.homepage.fragment.accountScreen

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel;
import android.util.Log
import com.example.embadmin.pkdmvvmkotlin.MyPkdApplication
import com.example.embadmin.pkdmvvmkotlin.modelClasses.account.AccountResponse
import com.example.embadmin.pkdmvvmkotlin.repository.ApiClient
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class AccountViewModel : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    var accountResponse: MutableLiveData<AccountResponse> = MutableLiveData()

    fun getUserDetials(){
            disposable.add(ApiClient.getInstance().githubReposApi.
                    getUserProfile("414",1052).
                    subscribeOn(Schedulers.newThread()).
                    observeOn(AndroidSchedulers.mainThread()).
                    subscribeWith(object : DisposableObserver<AccountResponse>(){
                        override fun onComplete() {

                        }

                        override fun onNext(t: AccountResponse) {
                            accountResponse.postValue(t)
                        }

                        override fun onError(e: Throwable) {
                            Log.i("error", e.localizedMessage)
                        }
                    }))
    }


}

