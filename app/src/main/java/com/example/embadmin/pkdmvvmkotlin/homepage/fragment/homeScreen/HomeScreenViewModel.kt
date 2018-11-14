package com.example.embadmin.pkdmvvmkotlin.homepage.fragment.homeScreen

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.embadmin.pkdmvvmkotlin.modelClasses.homepage.HomePageResponse
import com.example.embadmin.pkdmvvmkotlin.repository.ApiClient
import com.google.gson.Gson
import com.google.gson.JsonObject
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import org.json.JSONException

class HomeScreenViewModel : ViewModel() {

    private val disposable: CompositeDisposable = CompositeDisposable()
    var mHomePageResponse: MutableLiveData<HomePageResponse> = MutableLiveData()


    fun getHomePageData() {
        disposable.add(ApiClient.getInstance().githubReposApi.getHomePageData().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribeWith(object : DisposableObserver<JsonObject>() {
            override fun onComplete() {
            }

            override fun onNext(response: JsonObject) {
                val tempObject = HomePageResponse()
                try {
                    if (response.getAsJsonPrimitive("responseData").isString &&
                            response.getAsJsonPrimitive("responseData").toString().isNotEmpty()) {
                        val gson = Gson()
                        val homePageResponse = HomePageResponse()
                        var jsonString: String = response.getAsJsonPrimitive("responseData").toString().replace("\\n", "")
                        jsonString = jsonString.replace("\\", "")
                        jsonString = jsonString.substring(1, jsonString.length - 1)
                        homePageResponse.responseData = (Gson().fromJson(jsonString, HomePageResponse.ResponseData::class.java))
                        mHomePageResponse.postValue(tempObject)
                    }
                } catch (e: JSONException) {
                    e.printStackTrace()
                } catch (e: NullPointerException) {
                    e.printStackTrace()

                }
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
