package com.kashapovrush.newsapplication.domain

class GetCountryUseCase(
    private val client: CountryClient
) {

    suspend fun execute(code: String): DetailedCountry? {
        return client.detailCountry(code)
    }
}