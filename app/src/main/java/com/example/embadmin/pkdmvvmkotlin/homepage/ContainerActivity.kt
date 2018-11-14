package com.example.embadmin.pkdmvvmkotlin.homepage

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.embadmin.pkdmvvmkotlin.R
import com.example.embadmin.pkdmvvmkotlin.homepage.fragment.accountScreen.AccountFragment
import com.example.embadmin.pkdmvvmkotlin.homepage.fragment.categoryScreen.CategoryListFragment
import com.example.embadmin.pkdmvvmkotlin.homepage.fragment.homeScreen.HomeScreenFragment
import com.example.embadmin.pkdmvvmkotlin.interfaces.ToolBarTitleListener
import kotlinx.android.synthetic.main.activity_home.*

class ContainerActivity : AppCompatActivity(), ToolBarTitleListener{
    override fun changeToolBarTitle(toolbarTitle: String) {
        supportActionBar?.title=toolbarTitle
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                loadFragment(HomeScreenFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_categories -> {
                loadFragment(CategoryListFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                loadFragment(AccountFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        loadFragment(HomeScreenFragment.newInstance())
    }

    override fun onBackPressed() {
        if (supportFragmentManager.findFragmentById(R.id.home_page_content) !is HomeScreenFragment){
            loadFragment(HomeScreenFragment.newInstance())
            navigation.selectedItemId=R.id.navigation_home
        }else{
            super.onBackPressed()
        }
    }

    private fun loadFragment(fragmentToBeloaded : Fragment){
        if (supportFragmentManager.backStackEntryCount==0) {
            supportFragmentManager.beginTransaction().add(R.id.home_page_content, fragmentToBeloaded).commit()
        }else{
            supportFragmentManager.beginTransaction().replace(R.id.home_page_content, fragmentToBeloaded).commit()
        }

    }
}
