package com.daniel.travel_list.ui

import android.content.Intent
import android.os.Bundle
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.daniel.core.extension.bind
import com.daniel.core.extension.gone
import com.daniel.core.extension.visible
import com.daniel.domain.entity.Travel
import com.daniel.travel_list.R
import com.daniel.travel_list.di.travelListModule
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.context.unloadKoinModules

class TravelListActivity : AppCompatActivity() {

    companion object {
        const val INTENT_KEY_TRAVEL = "KEY_TRAVEL"
    }

    private val travelListViewModel by viewModel<TravelListViewModel>()
    private lateinit var travelsAdapter: TravelListAdapter

    private val rvTravelList: RecyclerView by bind(R.id.activity_travel_list_rv_list)
    private val progressLoading: ProgressBar by bind(R.id.activity_travel_list_progress)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_travel_list)
        loadKoinModules(travelListModule)
        setupRecycler()
        initObservers()
    }

    private fun initObservers() {
        travelListViewModel.apply {
            showLoading()
            fetchTravels()
            travelsLiveData().observe(this@TravelListActivity, Observer(::displayList))
        }
    }

    private fun setupRecycler() {
        travelsAdapter = TravelListAdapter(this, ::clickItem)
        rvTravelList.adapter = travelsAdapter
        rvTravelList.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )
    }

    private fun clickItem(travel: Travel) {
        val intent = Intent().setClassName(this, "com.daniel.travel_details.TravelDetailsActivity")
        intent.putExtra(INTENT_KEY_TRAVEL, travel)
        startActivity(intent)
    }

    private fun dismissLoading() {
        progressLoading.gone()
        rvTravelList.visible()
    }

    private fun showLoading() {
        progressLoading.visible()
    }

    private fun displayList(travelList: List<Travel>) {
        dismissLoading()
        travelsAdapter.setItems(travelList)
    }

    override fun onDestroy() {
        super.onDestroy()
        unloadKoinModules(travelListModule)
    }
}