package com.daniel.travel_list

import com.daniel.domain.entity.Travel
import com.daniel.domain.usecase.FetchTravelsUseCase
import com.daniel.domain.usecase.GetTravelsUseCase
import com.daniel.domain.usecase.HandleErrorUseCase
import com.daniel.travel_list.ui.TravelListViewModel
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.dsl.module

class TravelListViewModelTest {
    private val travelListModule = module {
        single {
            fetchTravelsUseCase
        }
        factory {
            getTravelsUseCase
        }
    }
    @MockK
    private lateinit var fetchTravelsUseCase: FetchTravelsUseCase

    @MockK
    private lateinit var getTravelsUseCase: GetTravelsUseCase

    @MockK
    private lateinit var handleErrorUseCase: HandleErrorUseCase

    private lateinit var travelListViewModel: TravelListViewModel

    @Before
    fun onSetup() {
        MockKAnnotations.init(this, relaxUnitFun = true)
        loadKoinModules(travelListModule)

        travelListViewModel = TravelListViewModel(
            fetchTravelsUseCase,
            getTravelsUseCase,
            handleErrorUseCase
        )
    }

    @After
    fun tearDown() {
        stopKoin()
    }
}