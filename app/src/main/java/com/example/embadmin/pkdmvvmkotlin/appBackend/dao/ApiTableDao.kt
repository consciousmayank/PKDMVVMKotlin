package com.example.embadmin.pkdmvvmkotlin.appBackend.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy.REPLACE
import android.arch.persistence.room.Query
import com.example.embadmin.pkdmvvmkotlin.appBackend.entity.ApiTable
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface ApiTableDao {

    @Insert(onConflict = REPLACE)
    fun insert(apiTableData: ApiTable) : Completable

    @Query("SELECT * from myApiTable where API_NAME LIKE :apiName")
    fun getByApiName(apiName : String) : Flowable<ApiTable>

}