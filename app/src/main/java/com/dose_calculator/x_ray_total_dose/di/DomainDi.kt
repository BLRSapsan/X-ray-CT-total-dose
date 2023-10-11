package com.dose_calculator.x_ray_total_dose.di

import com.dose_calculator.x_ray_total_dose.domain.useCase.CoefficientCalculate.CoefficientUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.CoefficientCalculate.CalculateUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.SaveDelete.SaveUseCase
import com.dose_calculator.x_ray_total_dose.domain.useCase.SaveDelete.DeleteUseCase
import com.dose_calculator.x_ray_total_dose.skf.domainSKF.useCase_skf.CalculateSkfUseCase
import org.koin.dsl.module

val domainDi = module {
    factory<SaveUseCase> {
        SaveUseCase(saveDeleteInterface = get())
    }
    factory<DeleteUseCase> {
        DeleteUseCase(saveDeleteInterface = get())
    }

    factory<CalculateUseCase> {
        CalculateUseCase(ageCalculateInterface = get())
    }
    factory<CoefficientUseCase> {
        CoefficientUseCase(ageCalculateInterface = get())
    }

    //skf
    factory <CalculateSkfUseCase> {
        CalculateSkfUseCase(skfCalculateInterface = get())
    }
}