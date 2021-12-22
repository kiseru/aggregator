package com.kiseru.aggregator

import com.kiseru.aggregator.model.Model

class Controller(private val model: Model) {
    fun onCitySelect() {
        model.selectCity("Odessa")
    }
}