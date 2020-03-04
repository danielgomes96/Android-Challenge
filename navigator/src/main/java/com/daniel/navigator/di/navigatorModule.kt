package com.daniel.navigator.di

import com.daniel.navigator.Navigator
import com.daniel.navigator.NavigatorImpl
import org.koin.dsl.module

val navigatorModule = module {
    single {
        NavigatorImpl as Navigator
    }
}