package com.example.x_ray_total_dose.di

import com.example.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase.CoefficientYearsUseCase
import com.example.x_ray_total_dose.domain.useCase.GetAndClearUseCase.CalculateUseCase
import com.example.x_ray_total_dose.domain.useCase.GetAndClearUseCase.ClearUseCase
import com.example.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase.StringToDoubleUseCase
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