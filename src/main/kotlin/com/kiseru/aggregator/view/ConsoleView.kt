package com.kiseru.aggregator.view

import com.kiseru.aggregator.Controller
import com.kiseru.aggregator.model.Vacancy

class ConsoleView() : View {
    private lateinit var controller: Controller

    override fun update(vacancies: List<Vacancy>) = vacancies.map {
        var result = "Вакансия: ${it.title}\nГород: ${it.city}\nКомпания: ${it.companyName}\n"
        if (it.salary.isNotEmpty()) {
            result += "Зарплата: ${it.salary}\n"
        }
        result
    }
        .forEach(::println)

    override fun setController(controller: Controller) {
        this.controller = controller
    }
}