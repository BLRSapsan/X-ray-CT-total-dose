package com.dose_calculator.x_ray_total_dose.di

import com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase.CoefficientYearsUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase.CalculateUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase.ClearUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase.StringToDoubleUseCase
import org.koin.dsl.module

val domainDi = module {
    factory<CalculateUseCase> {
        CalculateUseCase(repositoryInterface = get())
    }
    factory<ClearUseCase> {
        ClearUseCase(repositoryInterface = get())
    }

    factory<StringToDoubleUseCase> {
        StringToDoubleUseCase(stDInterface = get())
    }
    factory<CoefficientYearsUseCase> {
        CoefficientYearsUseCase(stDInterface = get())
    }
}