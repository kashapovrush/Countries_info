package com.kashapovrush.newsapplication.data

import com.kashapovrush.newsapplication.CountriesQuery
import com.kashapovrush.newsapplication.CountryQuery
import com.kashapovrush.newsapplication.domain.DetailedCountry
import com.kashapovrush.newsapplication.domain.SimpleCountry

fun CountryQuery.Country.toDetailedCountry(): DetailedCountry {
    return DetailedCountry(
        code = code,
        name = name,
        capital = capital ?: "no capital",
        emoji = emoji,
        continent = continent.name,
        currency = currency ?: "no currency",
        language = languages.map { it.name }
    )
}

fun CountriesQuery.Country.toSimpleCountry(): SimpleCountry {
    return SimpleCountry(
        code = code,
        emoji = emoji,
        capital = capital ?: "no capital",
        name = name
    )
}