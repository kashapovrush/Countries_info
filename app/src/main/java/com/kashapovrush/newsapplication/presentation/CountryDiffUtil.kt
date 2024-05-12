package com.kashapovrush.newsapplication.presentation

import androidx.recyclerview.widget.DiffUtil
import com.kashapovrush.newsapplication.domain.SimpleCountry

class CountryDiffUtil: DiffUtil.ItemCallback<SimpleCountry>() {
    override fun areItemsTheSame(oldItem: SimpleCountry, newItem: SimpleCountry): Boolean {
        return oldItem.code == newItem.code
    }

    override fun areContentsTheSame(oldItem: SimpleCountry, newItem: SimpleCountry): Boolean {
        return oldItem == newItem
    }
}