package com.example.randompeopletestapp.core.di

class Factory<T>(
    private val initializer: () -> T
) : Dependency<T> {

    override fun isInitialized() = false

    override val value: T
        get() = initializer()
}