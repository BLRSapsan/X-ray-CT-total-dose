package com.example.x_ray_total_dose.data.repository.repositoryCoefficient

import android.widget.EditText

class EditTextToDoubleTrans {

    private val zero = "0"
    private val mass = ArrayList<Double>()

    fun modify(e: ArrayList<EditText>): ArrayList<Double> {

        for (i in e) {
            var sum = 0.0
            val primaryString = i.text.toString()
            val secondString: String = if (primaryString == "") zero else primaryString
            val getMassiveString = secondString.split("+")
            for (n in getMassiveString) {
                if (n == "") break else {
                    sum += n.toDouble()
                }
            }
            mass.add(sum)
        }
        return mass
    }
}