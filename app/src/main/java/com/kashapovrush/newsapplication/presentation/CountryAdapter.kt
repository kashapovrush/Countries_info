package com.kashapovrush.newsapplication.presentation

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import com.kashapovrush.newsapplication.R
import com.kashapovrush.newsapplication.domain.SimpleCountry

class CountryAdapter(val context: Context) :
    ListAdapter<SimpleCountry, CountryViewHolder>(CountryDiffUtil()) {

        var onClickToItem: ((SimpleCountry) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        return CountryViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_simple_country, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = getItem(position)

        holder.countryName.text = country.name
        holder.capital.text = country.capital
        holder.emoji.text = country.emoji

//        Glide.with(context)
//            .load(country.emoji)
//            .placeholder(R.drawable.ic_launcher_foreground)
//            .into(holder.emoji)

        holder.view.setOnClickListener {
            onClickToItem?.invoke(country)
        }

    }
}