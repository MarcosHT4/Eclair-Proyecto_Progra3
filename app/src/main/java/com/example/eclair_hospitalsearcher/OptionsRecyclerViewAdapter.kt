package com.example.eclair_hospitalsearcher

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class OptionsRecyclerViewAdapter(val context:Context, val list:List<HospitalOption>):RecyclerView.Adapter<OptionsViewHolder>() {

    var funcionMenuOptionClick: ((hospitalOption:HospitalOption) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OptionsViewHolder {

        val layoutInflater = LayoutInflater.from(context)
        val itemListView = layoutInflater.inflate(R.layout.layout_hospitals_list, parent, false)
        return OptionsViewHolder(itemListView)

    }

    override fun onBindViewHolder(holder: OptionsViewHolder, position: Int) {

        holder.bind(list[position])
        holder.itemView.setOnClickListener {

            funcionMenuOptionClick?.invoke(list[position])

        }

    }

    override fun getItemCount(): Int {

        return list.size

    }

    fun setOnMenuOptionClickListener(funcion:(hospitalOption:HospitalOption) ->Unit) {

        funcionMenuOptionClick = funcion

    }

}

class OptionsViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    val textViewTitle: TextView = itemView.findViewById(R.id.textTitleHospital)
    val textViewSubtitle:TextView = itemView.findViewById(R.id.textSubtitleHospital)
    val textViewHeader:TextView = itemView.findViewById(R.id.textHeaderHospital)
    val imageViewIcon:ImageView = itemView.findViewById(R.id.iconVaccine)

    fun bind(hospitalOption: HospitalOption) {

        textViewTitle.text = hospitalOption.title
        textViewSubtitle.text = hospitalOption.subtitle
        textViewHeader.text = hospitalOption.headTitle
        imageViewIcon.setImageResource(hospitalOption.icon)
    }


}