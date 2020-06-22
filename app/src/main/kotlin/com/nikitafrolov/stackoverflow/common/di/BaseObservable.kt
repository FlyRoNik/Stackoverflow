package com.nikitafrolov.stackoverflow.common.di

import java.util.*
import java.util.concurrent.ConcurrentHashMap

abstract class BaseObservable<ListenerType> {

    //  thread-safe set of listeners
    private val listeners: MutableSet<ListenerType> = Collections
        .newSetFromMap(ConcurrentHashMap<ListenerType, Boolean>(1))

    fun registerListener(listener: ListenerType) {
        listeners.add(listener)
    }

    fun unregisterListener(listener: ListenerType) {
        listeners.remove(listener)
    }

    protected fun getListeners(): Set<ListenerType> = Collections.unmodifiableSet(listeners)
}