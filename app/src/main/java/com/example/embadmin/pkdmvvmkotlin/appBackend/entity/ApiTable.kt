package com.example.embadmin.pkdmvvmkotlin.appBackend.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "myApiTable")
class ApiTable(@PrimaryKey var API_NAME : String?,
               @ColumnInfo(name = "complete_url") var completeUrl: String,
               @ColumnInfo(name = "post_params") var postParams: String,
               @ColumnInfo(name = "response") var response : String){

    constructor():this(null, "","","")

}