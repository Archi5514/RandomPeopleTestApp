package com.example.randompeopletest.core.di

class SimpleDependency<T>(override val value: T) : Dependency<T> {
    override fun isInitialized() = false
}