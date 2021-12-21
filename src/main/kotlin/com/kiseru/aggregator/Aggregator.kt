package com.kiseru.aggregator

import com.kiseru.aggregator.model.HHStrategy
import com.kiseru.aggregator.model.Provider

fun main() {
    val strategy = HHStrategy()
    val provider = Provider(strategy)
    val controller = Controller(provider)
    controller.scan()
}