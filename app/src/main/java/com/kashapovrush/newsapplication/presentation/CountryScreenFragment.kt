package com.kashapovrush.newsapplication.presentation

import android.app.AlertDialog
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kashapovrush.newsapplication.databinding.FragmentCountryScreenBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch


@AndroidEntryPoint
class CountryScreenFragment : Fragment() {

    private val viewModel: CountryViewModel by viewModels()
    private lateinit var countryAdapter: CountryAdapter


    private lateinit var binding: FragmentCountryScreenBinding
    private lateinit var alert: AlertDialog.Builder

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCountryScreenBinding.inflate(inflater)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initRecyclerView()

        viewModel.getCountries()

        viewModel.countries.observe(viewLifecycleOwner) {
            countryAdapter.submitList(it)
        }

        countryAdapter.onClickToItem = {
            lifecycleScope.launch {
                viewModel.getCountry(it.code)
            }

        }

        viewModel.country.observe(viewLifecycleOwner) {
            alert = AlertDialog.Builder(context).apply {
                setTitle("${it.emoji} ${it.name}")
                setMessage("${it.capital} \n${it.name} \n${it.currency}")
            }

            alert.create().show()
        }


    }

    private fun initRecyclerView() {
        countryAdapter = CountryAdapter(requireContext())
        with(binding.rvCountries) {
            adapter = countryAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
    }

    companion object {

        fun newInstance() = CountryScreenFragment()
    }
}