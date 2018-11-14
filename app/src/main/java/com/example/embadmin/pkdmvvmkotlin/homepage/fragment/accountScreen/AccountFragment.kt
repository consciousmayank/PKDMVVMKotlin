package com.example.embadmin.pkdmvvmkotlin.homepage.fragment.accountScreen

import android.app.Activity
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide

import com.example.embadmin.pkdmvvmkotlin.R
import com.example.embadmin.pkdmvvmkotlin.databinding.AccountFragmentBinding
import com.example.embadmin.pkdmvvmkotlin.interfaces.ToolBarTitleListener
import com.example.embadmin.pkdmvvmkotlin.modelClasses.account.AccountResponse
import com.example.embadmin.pkdmvvmkotlin.utils.CommonBindingUtils

class AccountFragment : Fragment() {

    companion object {
        fun newInstance() = AccountFragment()
    }

    lateinit var binding: AccountFragmentBinding
    private lateinit var viewModel: AccountViewModel
    private lateinit var toolbarTitleListenerListener: ToolBarTitleListener

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        toolbarTitleListenerListener = context as ToolBarTitleListener
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        toolbarTitleListenerListener = activity as ToolBarTitleListener
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.account_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AccountViewModel::class.java)
        toolbarTitleListenerListener.changeToolBarTitle("My Account")
        binding.viewModel = viewModel
        val userInfo: AccountResponse.ResponseData.Details = AccountResponse.ResponseData.Details("000", "First", "Last", "dd-mm-yyyy",
                "male", "asdasd", "abc@def.com", "abcdefgh", "560066")
        binding.userInfo = userInfo

        viewModel.getUserDetials()
        viewModel.accountResponse.observe(this, object : Observer<AccountResponse> {
            override fun onChanged(t: AccountResponse?) {
                binding.userInfo = t?.responseData?.details
            }
        })
    }
}
