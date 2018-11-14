package com.example.embadmin.pkdmvvmkotlin.signin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.example.embadmin.pkdmvvmkotlin.R

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        supportActionBar?.title="Sign In"

        supportFragmentManager.beginTransaction().add(R.id.signIn_content, SignInFragment.newInstance()).commit()
    }
}
