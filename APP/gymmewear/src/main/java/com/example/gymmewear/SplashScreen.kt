package com.example.gymmewear

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class SplashScreen : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen_wear)

        // Enables Always-on
        setAmbientEnabled()
    }
}
