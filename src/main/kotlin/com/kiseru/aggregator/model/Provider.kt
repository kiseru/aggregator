package com.kiseru.aggregator.model

class Provider(private val strategy: Strategy) {
    fun getVacancies(searchString: String): List<Vacancy> {
        return strategy.getVacancies(searchString)
    }
}