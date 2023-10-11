package com.dose_calculator.x_ray_total_dose.di

import com.dose_calculator.x_ray_total_dose.skf.presentation_skf.SKFViewModel
import com.dose_calculator.x_ray_total_dose.presentation.DoseViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {

    viewModel<DoseViewModel> {
        DoseViewModel(
            calculateUseCase = get(),
            coefficientUseCase = get(),
            deleteUseCase = get(),
            saveUseCase = get()
        )
    }

    viewModel <SKFViewModel> {
        SKFViewModel(
            calculateSkfUseCase = get ())
    }
}