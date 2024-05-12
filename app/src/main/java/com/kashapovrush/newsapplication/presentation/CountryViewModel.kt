package com.kashapovrush.newsapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kashapovrush.newsapplication.domain.DetailedCountry
import com.kashapovrush.newsapplication.domain.GetCountriesUseCase
import com.kashapovrush.newsapplication.domain.GetCountryUseCase
import com.kashapovrush.newsapplication.domain.SimpleCountry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CountryViewModel @Inject constructor(
    private val getCountriesUseCase: GetCountriesUseCase,
    private val getCountryUseCase: GetCountryUseCase
): ViewModel() {

    private val _countries = MutableLiveData<List<SimpleCountry>>()
    val countries: LiveData<List<SimpleCountry>>
        get() = _countries

    private val _country = MutableLiveData<DetailedCountry>()
    val country: LiveData<DetailedCountry>
        get() = _country




    fun getCountries() {
        viewModelScope.launch {
            _countries.value = getCountriesUseCase.execute()
        }
    }

    suspend fun getCountry(code: String): DetailedCountry? {
        viewModelScope.launch {
            _country.value = getCountryUseCase.execute(code)
        }
        return getCountryUseCase.execute(code)
    }

}