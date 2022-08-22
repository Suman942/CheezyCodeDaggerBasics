package com.personal.cheezycodedaggerbasics.utils

import android.app.Application
import com.personal.cheezycodedaggerbasics.di.ApplicationComponent
import com.personal.cheezycodedaggerbasics.di.DaggerApplicationComponent

class App : Application() {
    lateinit var applicationComponent: ApplicationComponent
    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.factory().create(this)
    }
}