package com.dose_calculator.x_ray_total_dose.di

import com.dose_calculator.x_ray_total_dose.data.coefficient.CoefficientCalculateImpl
import com.dose_calculator.x_ray_total_dose.data.coefficient.CoefficientCalculateInterface
import com.dose_calculator.x_ray_total_dose.data.sh.DoseShPrStorageInterface
import com.dose_calculator.x_ray_total_dose.data.repository.repositoryCoefficient.AgeCalculateImpl
import com.dose_calculator.x_ray_total_dose.data.repository.repositoryGetAndClear.SaveDeleteImpl
import com.dose_calculator.x_ray_total_dose.data.sh.DoseShPrStorageImpl
import com.dose_calculator.x_ray_total_dose.domain.repository.SaveDeleteInterface
import com.dose_calculator.x_ray_total_dose.domain.repository.AgeCalculateInterface
import org.koin.dsl.module


val dataModule = module {
    single<DoseShPrStorageInterface> {
        DoseShPrStorageImpl(context = get())
    }
    single<SaveDeleteInterface> {
        SaveDeleteImpl(doseStorage = get())
    }

    factory<AgeCalculateInterface> {
        AgeCalculateImpl(coefficientCalculateInterface = get())
    }
    factory<CoefficientCalculateInterface> {
        CoefficientCalculateImpl()
    }
}