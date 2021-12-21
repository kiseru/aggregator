package com.kiseru.aggregator.model

data class Vacancy(
    val title: String,
    val salary: String,
    val city: String,
    val companyName: String,
    val url: String
) {
    override fun toString(): String {
        val result = "Вакансия: $title\nГород: $city\nКомпания: $companyName\n"
        if (salary.isEmpty()) {
            return result
        }

        return result + "Зарплата: $salary\n"
    }
}