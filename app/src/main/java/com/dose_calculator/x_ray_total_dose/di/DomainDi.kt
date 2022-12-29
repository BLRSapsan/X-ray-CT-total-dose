package com.dose_calculator.x_ray_total_dose.di

import com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase.CoefficientUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.ChangeAndCoeffUseCase.CalculateUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase.SaveUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.GetAndClearUseCase.DeleteUseCase
import org.koin.dsl.module

val domainDi = module {
    factory<SaveUseCase> {
        SaveUseCase(repositoryInterface = get())
    }
    factory<DeleteUseCase> {
        DeleteUseCase(repositoryInterface = get())
    }

    factory<CalculateUseCase> {
        CalculateUseCase(ageCalculateInterface = get())
    }
    factory<CoefficientUseCase> {
        CoefficientUseCase(ageCalculateInterface = get())
    }
}