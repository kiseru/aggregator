package com.kiseru.aggregator

import com.kiseru.aggregator.model.HHStrategy
import com.kiseru.aggregator.model.Model
import com.kiseru.aggregator.model.Provider
import com.kiseru.aggregator.view.ConsoleView

fun main() {
    val view = ConsoleView()

    val strategy = HHStrategy()
    val provider = Provider(strategy)
    val model = Model(view, provider)

    val controller = Controller(model)

    view.setController(controller)

    controller.onCitySelect()
}