package com.dose_calculator.x_ray_total_dose.data.repository.repositoryCoefficient

import android.widget.EditText

class EditTextToDouble {

    private val zero = "0"
    private val listDouble = ArrayList<Double>()

    fun modify(editTexts: ArrayList<EditText>): ArrayList<Double> {

        for (i in editTexts) {
            var sum = 0.0
            val primaryString = i.text.toString()
            val secondString: String = if (primaryString == "") zero else primaryString
            val getMassiveString = secondString.split("+")
            for (n in getMassiveString) {
                if (n == "") break else {
                    sum += n.toDouble()
                }
            }
            listDouble.add(sum)
        }
        return listDouble
    }
}