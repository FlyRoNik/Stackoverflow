package com.nikitafrolov.stackoverflow.screens.common.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {

    private var compositeDisposable: CompositeDisposable? = null

    override fun onCleared() {
        clearSubscription()
        super.onCleared()
    }

    protected fun Disposable.addSubscription() =
        compositeDisposable?.apply {
            add(this)
        } ?: let {
            compositeDisposable = CompositeDisposable()
            compositeDisposable?.add(this)
        }

    protected fun clearSubscription() {
        compositeDisposable?.apply {
            dispose()
            compositeDisposable = null
        }
    }
}