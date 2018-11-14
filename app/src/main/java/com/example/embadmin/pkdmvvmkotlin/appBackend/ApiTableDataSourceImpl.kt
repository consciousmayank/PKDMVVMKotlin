package com.example.embadmin.pkdmvvmkotlin.appBackend

import com.example.embadmin.pkdmvvmkotlin.appBackend.dao.ApiTableDao
import com.example.embadmin.pkdmvvmkotlin.appBackend.entity.ApiTable
import io.reactivex.Flowable

class ApiTableDataSourceImpl(apiTableDao: ApiTableDao) : ApiTableDataSource {

    var mApiTableDao: ApiTableDao = apiTableDao

    override fun getResponseForApi(apiName: String): Flowable<ApiTable> {
        return mApiTableDao.getByApiName(apiName)
    }
}