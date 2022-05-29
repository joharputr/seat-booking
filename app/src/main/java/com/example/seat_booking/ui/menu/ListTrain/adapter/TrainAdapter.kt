package com.example.seat_booking.ui.menu.ListTrain.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SectionIndexer
import androidx.recyclerview.widget.RecyclerView
import com.example.seat_booking.R
import com.example.seat_booking.ui.menu.ListTrain.model.TrainModel
import kotlinx.android.synthetic.main.trainlayout.view.*
import java.util.*
import kotlin.collections.ArrayList

class TrainAdapter(
    val context: Context,
) :
    RecyclerView.Adapter<TrainAdapter.ViewHolder>(), SectionIndexer {

    var list = arrayListOf<TrainModel>()
    var mSectionPositions = ArrayList<Int>(26)

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text = view.et_text
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.trainlayout, parent, false)
        )
    }

    fun addList(list: ArrayList<TrainModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.text.text = item.name
    }


    override fun getItemCount(): Int {
        return list.size
    }


    override fun getSections(): Array<String> {
        val sections: MutableList<String> = ArrayList(26)
        mSectionPositions = ArrayList(26)
        var i = 0
        val size: Int = list.size
        while (i < size) {
            val section: String =
                java.lang.String.valueOf(list.get(i).name?.get(0)).toUpperCase()
            if (!sections.contains(section)) {
                sections.add(section)
                mSectionPositions.add(i)
            }
            i++
        }
        return sections.toTypedArray<String>()
    }

    override fun getPositionForSection(p0: Int): Int {
        return mSectionPositions[p0]
    }

    override fun getSectionForPosition(p0: Int): Int {
        return 0
    }
}