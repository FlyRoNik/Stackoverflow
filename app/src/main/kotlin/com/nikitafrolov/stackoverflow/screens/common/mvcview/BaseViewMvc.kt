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

    override lateinit var rootView: View
        protected set

    /**
     * Convenience method for obtaining reference to [Context]
     * @return instance of [Context] associated with the root [View] of this MVC view
     */
    protected open val context: Context
        get() = rootView.context

    /**
     * Convenience method for obtaining a string resource
     */
    protected open fun getString(@StringRes id: Int): String = context.getString(id)

    /**
     * Convenience method for obtaining a string resource with format arguments.
     */
    protected open fun getString(@StringRes id: Int, vararg formatArgs: Any): String =
        context.getString(id, *formatArgs)
}