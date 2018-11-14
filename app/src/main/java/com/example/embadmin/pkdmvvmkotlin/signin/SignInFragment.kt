package com.example.embadmin.pkdmvvmkotlin.signin

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.embadmin.pkdmvvmkotlin.homepage.ContainerActivity
import com.example.embadmin.pkdmvvmkotlin.R
import com.example.embadmin.pkdmvvmkotlin.databinding.SignInFragmentBinding
import com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn.OtpResponse
import com.example.embadmin.pkdmvvmkotlin.modelClasses.signIn.SignInResponse
import com.example.embadmin.pkdmvvmkotlin.utils.MyPreferences

class SignInFragment : Fragment() {

    lateinit var dataBinding: SignInFragmentBinding
    lateinit var myPreferences : MyPreferences

    companion object {
        fun newInstance() = SignInFragment()
    }

    private lateinit var viewModel: SignInViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        dataBinding = DataBindingUtil.inflate(inflater, R.layout.sign_in_fragment, container, false)
        return dataBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(SignInViewModel::class.java)
        dataBinding.viewModel = viewModel;
        observeMobileNumber()
        myPreferences=MyPreferences(activity!!.applicationContext)
    }

    private fun observeMobileNumber() {
        dataBinding.mobileNumber.editText?.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(string: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (string?.length == 10) {
                    dataBinding.requestOtpButton.visibility = View.VISIBLE
                    viewModel.userMobileNumber = string.toString()
                    startObservingForOtpResponse()
                } else {
                    dataBinding.requestOtpButton.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun observeOtp() {
        dataBinding.otp.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(string: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (string?.length == 4) {
                    dataBinding.signInButton.visibility = View.VISIBLE
                    viewModel.otpRecieved = string.toString()
                } else {
                    dataBinding.signInButton.visibility = View.INVISIBLE
                }
            }
        })
    }

    private fun startObservingForOtpResponse() {
        observeOtp()
        viewModel.mOtpResponse.observe(this, Observer<OtpResponse> { t ->
            var mOtpResponse = t!!
            viewModel.otpRequestId = mOtpResponse.responseData?.requestId.toString()
            dataBinding.signInButton.visibility=View.VISIBLE
            observeSignIn()
        })

    }

    private fun observeSignIn() {
        viewModel.mSignInResponse.observe(
                this,
                Observer<SignInResponse> {
                    var signInResponse=it
                    val customerId = signInResponse?.responseData?.customerId
                    if (customerId!=null){
                        myPreferences.isUserLoggedIn=true
                        startActivity(Intent(activity, ContainerActivity::class.java))
                    }
                }
        )
    }

    private fun makeToast(message: String) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show()
    }

}
