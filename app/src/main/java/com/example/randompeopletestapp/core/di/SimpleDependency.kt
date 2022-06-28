package com.example.randompeopletestapp.core.di

class SimpleDependency<T>(override val value: T) : Dependency<T> {
    override fun isInitialized() = false
}