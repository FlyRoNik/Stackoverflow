package com.nikitafrolov.stackoverflow.screens.common.mvcview

/**
 * This interface corresponds to MVC views that need to notify MVC controllers of input events
 */
interface ObservableViewMvc<ListenerType> : ViewMvc {

    fun registerListener(listener: ListenerType)

    fun unregisterListener(listener: ListenerType)
}