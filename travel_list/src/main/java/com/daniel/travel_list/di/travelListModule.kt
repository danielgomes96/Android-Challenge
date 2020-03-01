package com.daniel.travel_list.di

import com.daniel.travel_list.ui.TravelListViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val travelListModule = module {
    viewModel {
        TravelListViewModel(get())
    }
}