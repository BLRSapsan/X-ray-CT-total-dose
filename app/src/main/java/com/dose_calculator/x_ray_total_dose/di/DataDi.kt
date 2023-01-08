package com.dose_calculator.x_ray_total_dose.di

import com.dose_calculator.x_ray_total_dose.data.Calculate.CoefficientCalculateImpl
import com.dose_calculator.x_ray_total_dose.data.Calculate.CoefficientCalculateInterface
import com.dose_calculator.x_ray_total_dose.data.SharedPref.DoseShPrStorageInterface
import com.dose_calculator.x_ray_total_dose.data.repository.CoefficientCalculateRepStorage.AgeCalculateImpl
import com.dose_calculator.x_ray_total_dose.data.repository.SaveDeleteRepStorage.SaveDeleteImpl
import com.dose_calculator.x_ray_total_dose.data.SharedPref.DoseShPrStorageImpl
import com.dose_calculator.x_ray_total_dose.domain.repository.SaveDeleteInterface
import com.dose_calculator.x_ray_total_dose.domain.repository.AgeCalculateInterface
import org.koin.dsl.module


val dataModule = module {
    single<DoseShPrStorageInterface> {
        DoseShPrStorageImpl(context = get())
    }
    single<SaveDeleteInterface> {
        SaveDeleteImpl(doseShPrStorageInterface = get())
    }

    factory<AgeCalculateInterface> {
        AgeCalculateImpl(coefficientCalculateInterface = get())
    }
    factory<CoefficientCalculateInterface> {
        CoefficientCalculateImpl()
    }
}