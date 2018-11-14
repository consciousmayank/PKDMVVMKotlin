package com.example.embadmin.pkdmvvmkotlin.appBackend

import com.example.embadmin.pkdmvvmkotlin.appBackend.entity.ApiTable
import io.reactivex.Flowable

interface ApiTableDataSource {

    abstract fun getResponseForApi(apiName : String): Flowable<ApiTable>

}