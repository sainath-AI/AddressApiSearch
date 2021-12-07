package com.masai.sainath.theaddressapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.masai.sainath.theaddressapp.remote.responses.AddressModel
import com.masai.sainath.theaddressapp.viewmodels.AppViewModel
import com.masai.sainath.theaddressapp.adapters.CityAdapter
import com.masai.sainath.theaddressapp.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: AppViewModel
    lateinit var homeFragmentHomeBinding: ActivityMainBinding
    lateinit var cityAdapter: CityAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeFragmentHomeBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(homeFragmentHomeBinding.root)
        viewModel = AppViewModel()
        searchEditText()
        setRecyclerView()
    }

    private fun setRecyclerView() {

        homeFragmentHomeBinding.recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            cityAdapter = CityAdapter()
            adapter = cityAdapter
        }
    }

    private fun searchEditText() {

        homeFragmentHomeBinding.etCityName.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                loadApiData(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

    }

    fun loadApiData(input: String) {
        viewModel.getCityListObserver().observe(this, Observer {
            if (it != null) {
                cityAdapter.addressList = it.dataModel.addressModelList as ArrayList<AddressModel>
                cityAdapter.notifyDataSetChanged()
            }
        })
        viewModel.makeApiCall(input)
    }

}