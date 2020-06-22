package com.nikitafrolov.stackoverflow

import android.app.Application
import com.nikitafrolov.stackoverflow.common.di.application.ApplicationComponent
import com.nikitafrolov.stackoverflow.common.di.application.DaggerApplicationComponent

class SOApp : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.create()
    }

    fun getApplicationComponent(): ApplicationComponent = applicationComponent
}