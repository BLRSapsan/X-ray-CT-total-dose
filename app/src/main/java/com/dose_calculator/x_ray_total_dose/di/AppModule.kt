package com.dose_calculator.x_ray_total_dose.di

import com.dose_calculator.x_ray_total_dose.presentation.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel<MainViewModel> {
        MainViewModel(
            calculateUseCase = get(),
            coefficientUseCase = get(),
            deleteUseCase = get(),
            saveUseCase = get()
        )
    }
}