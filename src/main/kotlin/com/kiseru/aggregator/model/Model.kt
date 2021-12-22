package com.kiseru.aggregator.model

import com.kiseru.aggregator.view.View

class Model(
    private val view: View,
    private vararg val providers: Provider
) {
    fun selectCity(city: String) {
        val vacancies = providers.flatMap { it.getVacancies(city) }
        view.update(vacancies)
    }
}