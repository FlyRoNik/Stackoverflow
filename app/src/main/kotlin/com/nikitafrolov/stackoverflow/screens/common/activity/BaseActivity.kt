package com.nikitafrolov.stackoverflow.screens.common.activity

import androidx.annotation.UiThread
import androidx.appcompat.app.AppCompatActivity
import com.nikitafrolov.stackoverflow.SOApp
import com.nikitafrolov.stackoverflow.common.di.application.ApplicationComponent
import com.nikitafrolov.stackoverflow.common.di.presentation.PresentationComponent
import com.nikitafrolov.stackoverflow.common.di.presentation.PresentationModule
import com.nikitafrolov.stackoverflow.exception.PerformInjectionAgainException

abstract class BaseActivity : AppCompatActivity() {

    private var isInjectorUsed = false

    @UiThread
    protected open fun getPresentationComponent(): PresentationComponent {
        if (isInjectorUsed) throw PerformInjectionAgainException()
        isInjectorUsed = true
        return getApplicationComponent().newPresentationComponent(PresentationModule(this))
    }

    private fun getApplicationComponent(): ApplicationComponent =
        (application as SOApp).getApplicationComponent()
}