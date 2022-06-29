package com.example.randompeopletestapp.core.di

class Single<T>(
    private val initializer: () -> T
) : Dependency<T> {

    override fun isInitialized() = false

    private var _value: T? = null

    override val value: T
        get() = _value ?: initializer().apply { _value = this }
}