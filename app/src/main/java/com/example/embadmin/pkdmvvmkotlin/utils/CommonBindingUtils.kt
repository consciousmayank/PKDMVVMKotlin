package com.example.embadmin.pkdmvvmkotlin.utils

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.bumptech.glide.Glide

class CommonBindingUtils {

    companion object {
        @BindingAdapter("android:src")
        @JvmStatic
        fun setImageUrl(view: ImageView, url: String?) {
            if (url!=null)
                Glide.with(view.context.applicationContext).load("https://preprod.easyday.in/$url").into(view)
        }

    }


}