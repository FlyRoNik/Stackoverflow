package com.nikitafrolov.stackoverflow.common.di

import android.app.Service
import androidx.annotation.UiThread
import com.nikitafrolov.stackoverflow.exception.PerformInjectionAgainException
import com.nikitafrolov.stackoverflow.SOApp
import com.nikitafrolov.stackoverflow.common.di.application.ApplicationComponent
import com.nikitafrolov.stackoverflow.common.di.service.ServiceComponent
import com.nikitafrolov.stackoverflow.common.di.service.ServiceModule

abstract class BaseService : Service() {

    private var isServiceComponentUsed = false

    @UiThread
    protected open fun getServiceComponent(): ServiceComponent? {
        if (isServiceComponentUsed) throw PerformInjectionAgainException()
        isServiceComponentUsed = true
        return getApplicationComponent().newServiceComponent(ServiceModule(this))
    }

    private fun getApplicationComponent(): ApplicationComponent {
        return (application as SOApp).getApplicationComponent()
    }
}