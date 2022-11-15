package com.example.x_ray_total_dose.domain.repository

import com.example.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientArrayDoubleModelDomain
import com.example.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.CoefficientModelDomain
import com.example.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.EditTextStringArrayModelDomain
import com.example.x_ray_total_dose.domain.models.ChangeAndCoeffDomainModels.StringModelDomain

interface StDInterface {

    fun change(edit: EditTextStringArrayModelDomain, coef: CoefficientArrayDoubleModelDomain): StringModelDomain
    fun coeff(coefficient: CoefficientModelDomain): CoefficientArrayDoubleModelDomain
}