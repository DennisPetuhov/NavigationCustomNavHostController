package com.example.navigationcustomnavhostcontroller

import android.app.Application
import leakcanary.LeakCanary

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        LeakCanary.config = LeakCanary.config.copy(dumpHeap = true)
    }
}