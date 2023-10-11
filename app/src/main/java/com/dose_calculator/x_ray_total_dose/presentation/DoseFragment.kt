package com.dose_calculator.x_ray_total_dose.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import androidx.fragment.app.Fragment
import com.dose_calculator.x_ray_total_dose.R
import com.dose_calculator.x_ray_total_dose.databinding.EffectiveDoseBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DoseFragment:Fragment() {

    private var ctx: Context? = null
    private var ageGroup: Byte = 1
    private lateinit var binding: EffectiveDoseBinding

    private val viewModel by viewModel<DoseViewModel>()

    private var coefficient = object : AdapterView.OnItemSelectedListener {
        override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
            when (p2) {
                0 -> ageGroup = 0
                1 -> ageGroup = 1
                2 -> ageGroup = 2
                3 -> ageGroup = 3
                4 -> ageGroup = 4
            }
        }

        override fun onNothingSelected(p0: AdapterView<*>?) {
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        ctx = context
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = EffectiveDoseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val arrayEditText: ArrayList<EditText> = ArrayList<EditText>().apply {
            add(0, binding.headNeck)
            add(1, binding.head)
            add(2, binding.neck)
            add(3, binding.chest)
            add(4, binding.abdomenPelvis)
            add(5, binding.trunk)
            add(6, binding.coxae)
            add(7, binding.knee)
            add(8, binding.crus)
        }

        ctx?.let {
            ArrayAdapter.createFromResource(
                it,
                R.array.adult_or_child,
                android.R.layout.simple_spinner_item
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice)
                binding.spinner.adapter = adapter
            }
        }

        binding.spinner.onItemSelectedListener = coefficient

        //подписка на изменение данных.
        viewModel.openResultValue.observe(viewLifecycleOwner) {
            binding.effectiveDose.text = it
        }

        binding.calculateDose.setOnClickListener {
            it.hideKeyboard()
            viewModel.calculate(array = arrayEditText, coefficient = ageGroup)
        }

        binding.deleteDose.setOnClickListener {
            it.hideKeyboard()
            for (clearEditText in arrayEditText) {
                clearEditText.text.clear()
                viewModel.deleteValues()
            }
        }
    }
}