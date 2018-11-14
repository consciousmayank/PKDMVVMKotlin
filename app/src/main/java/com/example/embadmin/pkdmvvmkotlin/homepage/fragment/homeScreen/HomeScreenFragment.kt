package com.example.embadmin.pkdmvvmkotlin.homepage.fragment.homeScreen

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.embadmin.pkdmvvmkotlin.R
import com.example.embadmin.pkdmvvmkotlin.interfaces.ToolBarTitleListener
import com.example.embadmin.pkdmvvmkotlin.modelClasses.homepage.HomePageResponse
import com.google.gson.JsonObject

class HomeScreenFragment : Fragment() {

    companion object {
        fun newInstance() = HomeScreenFragment()
    }

    private lateinit var viewModel: HomeScreenViewModel
    private lateinit var toolbarTitleListenerListener : ToolBarTitleListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        toolbarTitleListenerListener=context as ToolBarTitleListener
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        toolbarTitleListenerListener= activity as ToolBarTitleListener
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.home_screen_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(HomeScreenViewModel::class.java)
        toolbarTitleListenerListener.changeToolBarTitle("Home")
//        getHomePAgeData()
        viewModel.getHomePageData()

        viewModel.mHomePageResponse.observe(this, Observer<HomePageResponse> {
            Log.i("lovely", it?.responseData?.homepage?.size.toString())
        })

    }


}
