package com.example.embadmin.pkdmvvmkotlin.appBackend.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.embadmin.pkdmvvmkotlin.appBackend.dao.ApiTableDao
import com.example.embadmin.pkdmvvmkotlin.appBackend.entity.ApiTable

@Database(entities = arrayOf(ApiTable::class), version = 1)
public abstract class ApiTableDatabase : RoomDatabase() {

    companion object {

        private var INSTANCE: ApiTableDatabase? = null

        fun getInstance(context: Context): ApiTableDatabase? {
            if (INSTANCE == null) {
                synchronized(ApiTableDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                            ApiTableDatabase::class.java, "weather.db")
                            .build()
                }
            }
            return INSTANCE
        }
    }

    public abstract fun apiDao(): ApiTableDao

    fun destroyInstance() {
        INSTANCE = null
    }
}