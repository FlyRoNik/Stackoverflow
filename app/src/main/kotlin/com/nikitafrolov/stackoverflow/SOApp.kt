package com.nikitafrolov.stackoverflow

import android.app.Application
import com.nikitafrolov.stackoverflow.common.di.application.ApplicationComponent
import com.nikitafrolov.stackoverflow.common.di.application.ApplicationModule
import com.nikitafrolov.stackoverflow.common.di.application.DaggerApplicationComponent

class SOApp : Application() {

    private lateinit var applicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
    }

    fun getApplicationComponent(): ApplicationComponent = applicationComponent
}