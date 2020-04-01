package com.nisa.tanpadatabinding30maret20.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.nisa.tanpadatabinding30maret20.R
import com.nisa.tanpadatabinding30maret20.data.ProfileLiveViewModel
import com.nisa.tanpadatabinding30maret20.databinding.ProfileScreenBinding

class ProfileScreenViewModel : AppCompatActivity() {
    //isisnya life data dan data binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val profileViewModel = ViewModelProviders.of(this).get(ProfileLiveViewModel::class.java)

        val bindingLayout: ProfileScreenBinding = DataBindingUtil.setContentView(this, R.layout.profile_screen)
        bindingLayout.viewModel = profileViewModel
        bindingLayout.lifecycleOwner = this
        //servernya ngedapetin datanya dari observableviewmodel

    }
}