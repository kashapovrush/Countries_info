package com.kashapovrush.newsapplication.domain

interface CountryClient {

    suspend fun getCountries(): List<SimpleCountry>
    suspend fun detailCountry(code: String): DetailedCountry?
}