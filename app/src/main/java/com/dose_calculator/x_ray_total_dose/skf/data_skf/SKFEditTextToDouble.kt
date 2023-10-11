package com.dose_calculator.x_ray_total_dose.skf.data_skf

import android.widget.EditText

class SKFEditTextToDouble {

    private val default = "0.0"
    private val listDoubleReturn = ArrayList<Double>()

   fun mod (editText: ArrayList<EditText>):ArrayList<Double> {
       for (i in editText) {
           val text = i.text.toString()
           val checkText: String = if (text == "") default else text
           val getDouble:Double = checkText.toDouble()
           listDoubleReturn.add(getDouble)
       }
       return listDoubleReturn
   }
}