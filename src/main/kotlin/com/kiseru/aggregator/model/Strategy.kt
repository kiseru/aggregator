package com.kiseru.aggregator.model

interface Strategy {
    fun getVacancies(searchString: String): List<Vacancy>
}