package com.betrybe.trybeclima.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.betrybe.trybeclima.R
import com.betrybe.trybeclima.databinding.FragmentCurrentWeatherBinding
import com.betrybe.trybeclima.databinding.FragmentForecastWeatherBinding
import com.betrybe.trybeclima.ui.viewmodel.CurrentWeatherViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class CurrentWeatherFragment : Fragment() {

    private lateinit var binding: FragmentCurrentWeatherBinding
    private val currentWeatherViewModel: CurrentWeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil
            .inflate(inflater, R.layout.fragment_current_weather, container, false)
        binding.vm = currentWeatherViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        currentWeatherViewModel.error.observe(viewLifecycleOwner) { error ->
            if(error) {
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Trybe Clima")
                    .setMessage("A cidade informada não foi encontrada.")
                    .setPositiveButton("Ok") { dialog, _ ->
                        dialog.dismiss()
                    }
                    .setCancelable(false)
                    .create().show()
            }
        }

        return binding.root
    }
}