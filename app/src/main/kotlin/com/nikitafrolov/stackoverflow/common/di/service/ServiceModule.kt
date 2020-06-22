package com.nikitafrolov.stackoverflow.common.di.service

import android.app.Service
import android.content.Context
import dagger.Module
import dagger.Provides

@Module
class ServiceModule(private val service: Service) {

    @Provides
    fun provideService(): Service = service

    @Provides
    fun provideContext(service: Service): Context = service
}