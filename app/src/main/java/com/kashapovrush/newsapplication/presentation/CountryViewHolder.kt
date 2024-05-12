package com.kashapovrush.newsapplication.presentation

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kashapovrush.newsapplication.R

class CountryViewHolder(val view: View): RecyclerView.ViewHolder(view) {


    val countryName = view.findViewById<TextView>(R.id.country_name)
    val capital = view.findViewById<TextView>(R.id.country_capital)
    val emoji = view.findViewById<TextView>(R.id.country_image)
}