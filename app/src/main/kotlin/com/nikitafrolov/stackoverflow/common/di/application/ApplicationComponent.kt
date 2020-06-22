package com.nikitafrolov.stackoverflow.common.di.application

import com.nikitafrolov.stackoverflow.common.di.presentation.PresentationComponent
import com.nikitafrolov.stackoverflow.common.di.presentation.PresentationModule
import com.nikitafrolov.stackoverflow.common.di.service.ServiceComponent
import com.nikitafrolov.stackoverflow.common.di.service.ServiceModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, NetworkModule::class])
interface ApplicationComponent {

    fun newPresentationComponent(presentationModule: PresentationModule): PresentationComponent
    fun newServiceComponent(serviceModule: ServiceModule): ServiceComponent
}