package com.nisa.tanpadatabinding30maret20

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.ObservableInt
import com.nisa.tanpadatabinding30maret20.data.ProfileObservableField

class ObservableFieldProfileScreen: AppCompatActivity() {
    private val observableFieldProfile =
        ProfileObservableField(
            "Nisa Jamalia",
            "Nurhayati",
            ObservableInt(0)
        )

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

    }
}