package com.example.embadmin.pkdmvvmkotlin

import android.app.Application
import android.content.Context
import com.example.embadmin.pkdmvvmkotlin.repository.ApiService
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MyPkdApplication : Application() {
//    companion object {
//        lateinit var apiService: ApiService
//    }


    override fun onCreate() {
        super.onCreate()
        /*val cacheSize = 10 * 1024 * 1024 // 10 MB
        val cache = Cache(cacheDir, cacheSize.toLong())


        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val client = OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor { chain ->
                    var request = chain.request()
                    request = if (hasNetwork(this)!!)
                        request.newBuilder().header("Cache-Control", "public, max-age=" + 5*60*60).build()
                    else
                        request.newBuilder().header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7).build()
                    chain.proceed(request)
                }
                .build()
        val retrofit = Retrofit.Builder()
                .baseUrl("https://preprodapi.easyday.in/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()

        apiService = retrofit.create(ApiService::class.java)*/
    }

    fun hasNetwork(context: Context): Boolean? {
        /*val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork: NetworkInfo? = connectivityManager.activeNetworkInfo
        if (activeNetwork != null && activeNetwork.isConnected)
            isConnected = true*/
        return true
    }
}
