package com.nikitafrolov.stackoverflow.screens.common.fragment

import androidx.annotation.UiThread
import androidx.fragment.app.Fragment
import com.nikitafrolov.stackoverflow.SOApp
import com.nikitafrolov.stackoverflow.common.di.application.ApplicationComponent
import com.nikitafrolov.stackoverflow.common.di.presentation.PresentationComponent
import com.nikitafrolov.stackoverflow.common.di.presentation.PresentationModule
import com.nikitafrolov.stackoverflow.common.exception.PerformInjectionAgainException

abstract class BaseFragment : Fragment() {

    private var isInjectorUsed = false

    @UiThread
    protected open fun getPresentationComponent(): PresentationComponent {
        if (isInjectorUsed) throw PerformInjectionAgainException()
        isInjectorUsed = true
        return getApplicationComponent().newPresentationComponent(PresentationModule(requireActivity()))
    }

    private fun getApplicationComponent(): ApplicationComponent =
        (requireActivity().application as SOApp).getApplicationComponent()
}