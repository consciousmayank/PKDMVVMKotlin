package com.example.embadmin.pkdmvvmkotlin.homepage.fragment.categoryScreen

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.embadmin.pkdmvvmkotlin.R
import com.example.embadmin.pkdmvvmkotlin.interfaces.ToolBarTitleListener

class CategoryListFragment : Fragment() {

    companion object {
        fun newInstance() = CategoryListFragment()
    }

    private lateinit var viewModel: CategoryListViewModel
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
        return inflater.inflate(R.layout.category_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CategoryListViewModel::class.java)
        toolbarTitleListenerListener.changeToolBarTitle("Categories")
        // TODO: Use the ViewModel
    }

}
