package com.betrybe.trybeclima.ui.viewmodel

import android.net.wifi.rtt.WifiRttManager
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.betrybe.trybeclima.data.OpenWeatherApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException

class CurrentWeatherViewModel : ViewModel() {

    private var _temp = MutableLiveData(0.0)
    val temp: LiveData<Double>
        get() = _temp

    private var _cityName = MutableLiveData("-")
    val cityName: LiveData<String>
        get() = _cityName

    private var _maxTemp = MutableLiveData(0.0)
    val maxTemp: LiveData<Double>
        get() = _maxTemp

    private var _minTemp = MutableLiveData(0.0)
    val minTemp: LiveData<Double>
        get() = _minTemp

    private var _feelsLike = MutableLiveData(0.0)
    val feelsLike: LiveData<Double>
        get() = _feelsLike

    private var _humidity = MutableLiveData(0)
    val humidity: LiveData<Int>
        get() = _humidity

    private var _error = MutableLiveData(false)
    val error: LiveData<Boolean>
        get() = _error

    fun getCurrentWeather(cityName: String) {

        CoroutineScope(Dispatchers.IO).launch {
            try {
                val openWeatherApi = OpenWeatherApi.getInstance()
                val response =
                    openWeatherApi.getCurrentWeatherData(
                        cityName,
                        ""
                    )
                if (response.isSuccessful) {
                    val currentWeatherData = response.body()!!
                    _error.postValue(false)
                    _temp.postValue(currentWeatherData.main.temp)
                    _cityName.postValue(currentWeatherData.name)
                    _maxTemp.postValue(currentWeatherData.main.tempMax)
                    _minTemp.postValue(currentWeatherData.main.tempMin)
                    _feelsLike.postValue(currentWeatherData.main.feelsLike)
                    _humidity.postValue(currentWeatherData.main.humidity)
                } else {
                    _error.postValue(true)
//                    withContext(Dispatchers.Main) {
//                        MaterialAlertDialogBuilder(requireContext())
//                            .setTitle("Trybe Clima")
//                            .setMessage("A cidade informada não foi encontrada.")
//                            .setPositiveButton("Ok") { dialog, _ ->
//                                dialog.dismiss()
//                            }
//                            .setCancelable(false)
//                            .create().show()
//                    }
                }
            } catch (ex: IOException) {
//                withContext(Dispatchers.Main) {
//                    MaterialAlertDialogBuilder(requireContext())
//                        .setTitle("Trybe Clima")
//                        .setMessage("Ocorreu um erro ao acessar os dados. Verifique sua conexão de Internet e tente mais tarde")
//                        .setPositiveButton("Ok") { dialog, _ ->
//                            dialog.dismiss()
//                        }
//                        .setCancelable(false)
//                        .create().show()
//                }
            } catch (ex: HttpException) {
                Log.e("Trybe Clima", "Ocorreu um erro do tipo ${ex.code()}: ${ex.message}")
            }
        }

    }


}