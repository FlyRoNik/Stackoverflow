package com.nikitafrolov.stackoverflow.screens.common.mvcview

import android.content.Context
import android.view.View
import androidx.annotation.StringRes
import com.nikitafrolov.stackoverflow.common.di.BaseObservable

/**
 * This is the base class which provides basic common functionality to MVC views implementations
 */
abstract class BaseViewMvc<ListenerType> : BaseObservable<ListenerType>(),
    ObservableViewMvc<ListenerType> {

    private lateinit var rootView: View

    override fun getRootView(): View = rootView

    /**
     * Set the root android view of this MVC view
     */
    protected open fun setRootView(rootView: View) {
        this.rootView = rootView
    }

    /**
     * Convenience method for obtaining reference to [Context]
     * @return instance of [Context] associated with the root [View] of this MVC view
     */
    protected open fun getContext(): Context = getRootView().context

    /**
     * Convenience method for obtaining a string resource
     */
    protected open fun getString(@StringRes id: Int): String = getContext().getString(id)

    /**
     * Convenience method for obtaining a string resource with format arguments.
     */
    protected open fun getString(@StringRes id: Int, vararg formatArgs: Any): String =
        getContext().getString(id, *formatArgs)
}