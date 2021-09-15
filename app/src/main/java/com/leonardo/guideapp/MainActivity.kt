package com.leonardo.guideapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.fragment.app.Fragment
import com.leonardo.guideapp.ui.MainFragment
import dagger.hilt.android.AndroidEntryPoint

import android.app.Application
import dagger.hilt.android.HiltAndroidApp


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        openFragment(MainFragment.newInstance())


    }

    fun openFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_fragment, fragment).commit()
    }


}

@HiltAndroidApp
class MainApplication : Application()