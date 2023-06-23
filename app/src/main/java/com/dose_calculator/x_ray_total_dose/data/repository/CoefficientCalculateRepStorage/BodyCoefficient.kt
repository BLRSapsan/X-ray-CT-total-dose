package com.dose_calculator.x_ray_total_dose.data.repository.CoefficientCalculateRepStorage

data class BodyCoefficient(var headNeck: Double,
                       var head : Double,
                       var neck : Double,
                       var chest : Double,
                       var abdomenPelvis: Double,
                       var trunk: Double,
                       var coxae: Double,
                       var knee: Double,
                       var crus: Double)
