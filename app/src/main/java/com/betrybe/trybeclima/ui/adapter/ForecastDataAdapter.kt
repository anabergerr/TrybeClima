package com.betrybe.trybeclima.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.betrybe.trybeclima.R

class ForecastDataAdapter(private val forecastList: List<ForecastData>) :
    Adapter<ForecastDataAdapter.ForecastViewHolder>() {

    class ForecastViewHolder(view: View) : ViewHolder(view) {
        val minTemp: TextView = view.findViewById(R.id.item_forecast_min_temp)
        val maxTemp: TextView = view.findViewById(R.id.item_forecast_max_temp)
        val date: TextView = view.findViewById(R.id.item_forecast_date)
    }

    override fun getItemCount(): Int = forecastList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ForecastViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_forecast_layout, parent, false)
        return ForecastViewHolder(view)
    }

    override fun onBindViewHolder(holder: ForecastViewHolder, position: Int) {
        holder.minTemp.text = forecastList[position].minTemp.toString()
        holder.maxTemp.text = forecastList[position].maxTemp.toString()
        holder.date.text = forecastList[position].date
    }

}