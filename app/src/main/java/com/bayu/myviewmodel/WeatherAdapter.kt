package com.bayu.myviewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bayu.myviewmodel.databinding.WeatherItemsBinding

class WeatherAdapter:RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {
    private val mData = ArrayList<WeatherItems>()

    fun setData(item:ArrayList<WeatherItems>){
        mData.clear()
        mData.addAll(item)
        notifyDataSetChanged()
    }

    inner class WeatherViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        private val binding = WeatherItemsBinding.bind(itemView)
        fun bind(weatherItems: WeatherItems) {
            with(itemId){
                binding.textCity.text = weatherItems.name
                binding.textTemp.text = weatherItems.temperature
                binding.textDesc.text = weatherItems.description
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val mView = LayoutInflater.from(parent.context).inflate(R.layout.weather_items,parent,false)
        return WeatherViewHolder(mView)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        holder.bind(mData[position])

    }

    override fun getItemCount(): Int = mData.size
}