package com.dose_calculator.x_ray_total_dose.di

import com.dose_calculator.x_ray_total_dose.data.coefficient.CoefficientAgeFinal
import com.dose_calculator.x_ray_total_dose.data.coefficient.CoefficientInterface
import com.dose_calculator.x_ray_total_dose.data.sh.DoseStorage
import com.dose_calculator.x_ray_total_dose.data.repository.repositoryCoefficient.ChangeDataReposImpl
import com.dose_calculator.x_ray_total_dose.data.repository.repositoryGetAndClear.GetClearSumDoseRepositoryImpl
import com.dose_calculator.x_ray_total_dose.data.sh.SharedPrefDose
import com.dose_calculator.x_ray_total_dose.domain.repository.RepositoryInterface
import com.dose_calculator.x_ray_total_dose.domain.repository.StDInterface
import org.koin.dsl.module


val dataModule = module {
    single<DoseStorage> {
        SharedPrefDose(context = get())
    }
    single<RepositoryInterface> {
        GetClearSumDoseRepositoryImpl(doseStorage = get())
    }

    factory<StDInterface> {
        ChangeDataReposImpl(coefficientInterface = get())
    }
    factory<CoefficientInterface> {
        CoefficientAgeFinal()
    }
}