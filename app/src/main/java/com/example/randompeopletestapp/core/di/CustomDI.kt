package com.example.randompeopletest.core.di


val dependencies = mutableListOf<Dependency<*>>()


fun <T> single(initializer: () -> T) {
    dependencies.add(Single(initializer))
}

fun <T> factory(initializer: () -> T) {
    dependencies.add(Factory(initializer))
}

inline fun <reified T> injectDep(): Dependency<T> {
    for (d in dependencies)
        if (d.value is T)
            return SimpleDependency(d.value as T)

    throw IllegalStateException("No such dependency found")
}

inline fun <reified T> get(): T {
    for (d in dependencies)
        if (d.value is T) return d.value as T

    throw IllegalStateException("No such dependency found")
}