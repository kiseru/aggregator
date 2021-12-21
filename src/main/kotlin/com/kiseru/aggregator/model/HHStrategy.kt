package com.kiseru.aggregator.model

import org.jsoup.HttpStatusException
import org.jsoup.Jsoup

class HHStrategy : Strategy {
    private val URL_FORMAT = "https://hh.ru/search/vacancy?text=%s&page=%d"

    override fun getVacancies(searchString: String): List<Vacancy> {
        val vacancies = ArrayList<Vacancy>()
        var page = 0
        try {
            do {
                val document = getDocument(searchString, page)
                val elements = document.getElementsByAttributeValueMatching("data-qa", "vacancy-serp__vacancy .*")
                if (elements.isEmpty()) {
                    break
                }

                val pageVacancies = elements.map {
                    val title = it.select("[data-qa=vacancy-serp__vacancy-title]")
                    val address = it.select("[data-qa=vacancy-serp__vacancy-address]")
                    val employer = it.select("[data-qa=vacancy-serp__vacancy-employer]")
                    val compensation = it.select("[data-qa=vacancy-serp__vacancy-compensation]")

                    Vacancy(
                        title.text(),
                        compensation.text(),
                        address.text(),
                        employer.text(),
                        title.attr("href")
                    )
                }

                vacancies.addAll(pageVacancies)

                page++
            } while (true)
        } catch (_: HttpStatusException) {
        }

        return vacancies
    }

    private fun getDocument(searchString: String, page: Int) = Jsoup.connect(URL_FORMAT.format(searchString, page))
        .userAgent("Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36")
        .referrer("https://hh.ru")
        .get()
}