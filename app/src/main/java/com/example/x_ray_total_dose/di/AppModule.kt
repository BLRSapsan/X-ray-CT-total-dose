package com.example.x_ray_total_dose.di

import com.example.x_ray_total_dose.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            calculateUseCase = get(),
            clearUseCase = get(),
            stringToDoubleUseCase = get(),
            coefficientYearsUseCase = get()
        )
    }
}