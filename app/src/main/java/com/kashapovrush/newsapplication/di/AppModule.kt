package com.kashapovrush.newsapplication.di

import com.apollographql.apollo3.ApolloClient
import com.kashapovrush.newsapplication.data.ApolloCountryClient
import com.kashapovrush.newsapplication.domain.CountryClient
import com.kashapovrush.newsapplication.domain.GetCountriesUseCase
import com.kashapovrush.newsapplication.domain.GetCountryUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApolloClient(): ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("https://countries.trevorblades.com/graphql")
            .build()
    }

    @Provides
    @Singleton
    fun provideCountryClient(apolloClient: ApolloClient): CountryClient {
        return ApolloCountryClient(apolloClient)
    }

    @Provides
    @Singleton
    fun provideGetCountryUseCase(client: CountryClient): GetCountryUseCase {
        return GetCountryUseCase(client)
    }

    @Provides
    @Singleton
    fun provideGetCountriesUseCase(client: CountryClient): GetCountriesUseCase {
        return GetCountriesUseCase(client)
    }
}