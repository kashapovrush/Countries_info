package com.kashapovrush.newsapplication.domain

data class DetailedCountry(
    val name: String,
    val code: String,
    val emoji: String,
    val capital: String,
    val currency: String,
    val language : List<String>,
    val continent: String
)
