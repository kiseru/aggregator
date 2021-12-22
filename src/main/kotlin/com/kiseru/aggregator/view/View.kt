package com.kiseru.aggregator.view

import com.kiseru.aggregator.Controller
import com.kiseru.aggregator.model.Vacancy

interface View {
    fun update(vacancies: List<Vacancy>)

    fun setController(controller: Controller)
}