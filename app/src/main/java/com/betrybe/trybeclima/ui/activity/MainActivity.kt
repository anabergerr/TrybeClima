package com.betrybe.trybeclima.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import com.betrybe.trybeclima.R
import com.betrybe.trybeclima.ui.fragment.CurrentWeatherFragment
import com.betrybe.trybeclima.ui.fragment.ForecastWeatherFragment
import com.betrybe.trybeclima.ui.viewmodel.CurrentWeatherViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {

    private val currentWeatherViewModel:CurrentWeatherViewModel by viewModels()

    private val mNavigationMenu: BottomNavigationView by lazy { findViewById(R.id.navigation_menu) }
    private val mTextInputLayout: TextInputLayout by lazy { findViewById(R.id.textField)}
    private val mTextInputEditText: TextInputEditText by lazy { findViewById(R.id.textInputEditText)}

    private val mCurrentWeatherFragment = CurrentWeatherFragment()
    private val mForecastWeatherFragment = ForecastWeatherFragment()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mTextInputLayout.setEndIconOnClickListener {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(mTextInputLayout.windowToken, 0)
            val cityName = mTextInputEditText.text.toString()
            currentWeatherViewModel.getCurrentWeather(cityName)
        }


        mNavigationMenu.setOnItemSelectedListener { item ->
            when(item.itemId) {
                R.id.menu_current_weather -> {
                    supportFragmentManager
                        .beginTransaction()
                        .setCustomAnimations(
                            R.anim.slide_in,
                            R.anim.fade_out,
                            R.anim.slide_out,
                            R.anim.fade_in
                        )
                        .replace(R.id.fragmentContainerView, mCurrentWeatherFragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                R.id.menu_forecast_weather -> {
                    supportFragmentManager
                        .beginTransaction()
                        .setCustomAnimations(
                            R.anim.slide_in,
                            R.anim.fade_out,
                            R.anim.slide_out,
                            R.anim.fade_in
                        )
                        .replace(R.id.fragmentContainerView, mForecastWeatherFragment)
                        .addToBackStack(null)
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}
