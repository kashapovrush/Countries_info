package com.kashapovrush.newsapplication.data

import com.apollographql.apollo3.ApolloClient
import com.kashapovrush.newsapplication.CountriesQuery
import com.kashapovrush.newsapplication.CountryQuery
import com.kashapovrush.newsapplication.domain.CountryClient
import com.kashapovrush.newsapplication.domain.DetailedCountry
import com.kashapovrush.newsapplication.domain.SimpleCountry

class ApolloCountryClient(
    private val apolloClient: ApolloClient
): CountryClient {
    override suspend fun getCountries(): List<SimpleCountry> {
        return apolloClient
            .query(CountriesQuery())
            .execute()
            .data
            ?.countries
            ?.map { it.toSimpleCountry() }
            ?: emptyList()
    }

    override suspend fun detailCountry(code: String): DetailedCountry? {
        return apolloClient
            .query(CountryQuery(code))
            .execute()
            .data
            ?.country
            ?.toDetailedCountry()
    }


}