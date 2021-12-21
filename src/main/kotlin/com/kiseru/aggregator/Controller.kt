package com.kiseru.aggregator

import com.kiseru.aggregator.model.Provider

class Controller(private vararg val providers: Provider) {
    override fun toString(): String {
        return "Controller(providers=${providers.contentToString()})"
    }

    fun scan() {
        providers
            .asSequence()
            .flatMap { it.getVacancies("java") }
            .forEach(::println)
    }
}