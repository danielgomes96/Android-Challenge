package com.daniel.travel_list.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daniel.core.extension.bind
import com.daniel.domain.entity.Travel
import com.daniel.travel_list.R
import com.daniel.travel_list.di.travelListModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class TravelListActivity : AppCompatActivity() {

    private val travelListViewModel by viewModel<TravelListViewModel>()
    private lateinit var travelsAdapter: TravelListAdapter

    private val rvTravelList: RecyclerView by bind(R.id.activity_travel_list_rv_list)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_list)
        loadKoinModules(travelListModule)
        setupRecycler()
        initObservers()

    }

    private fun initObservers() {
        travelListViewModel.apply {
            getTravelList()
            travelListLiveData.observe(this@TravelListActivity, Observer(::displayList))
        }
    }

    private fun setupRecycler() {
        travelsAdapter = TravelListAdapter(this)
        rvTravelList.adapter = travelsAdapter
        rvTravelList.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun displayList(travelList: List<Travel>) {
        travelsAdapter.setItems(travelList)
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(travelListModule)
    }
}