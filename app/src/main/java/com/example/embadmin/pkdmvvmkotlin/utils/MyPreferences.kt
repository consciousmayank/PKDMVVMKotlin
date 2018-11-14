package com.example.embadmin.pkdmvvmkotlin.utils

import android.content.Context
import android.content.SharedPreferences

class MyPreferences(internal var context: Context) {
    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor

    private val IS_USER_LOGGED_IN = "IS_USER_LOGGED_IN"
    private val CUSTOMER_ID = "CUSTOMER_ID"


    init {
        this.preferences = context.getSharedPreferences("MyPKDPreferences", Context.MODE_PRIVATE)
        editor = preferences.edit()
    }


    var isUserLoggedIn: Boolean
        get() = preferences.getBoolean(IS_USER_LOGGED_IN, false)
        set(value) {
            editor.putBoolean(IS_USER_LOGGED_IN, value)
            editor.commit()
        }

    var customerId: String
        get() = preferences.getString(CUSTOMER_ID, "")
        set(customerId) {
            editor.putString(CUSTOMER_ID, customerId)
            editor.commit()
        }


    }
