package com.example.seat_booking.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.seat_booking.R
import com.example.seat_booking.model.SeatNumberModel
import kotlinx.android.synthetic.main.seatlayout.view.*

class SeatAdapter(
    val context: Context,
    val clickCallback: ClickCallback
) :
    RecyclerView.Adapter<SeatAdapter.ViewHolder>() {

    var list = arrayListOf<SeatNumberModel>()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val text = view.text
        val layoutChoosen = view.layoutChoosen
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(context).inflate(R.layout.seatlayout, parent, false)
        )
    }

    fun addList(list: ArrayList<SeatNumberModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        if (item.isClicked) {
            holder.layoutChoosen.background = ContextCompat.getDrawable(context, R.color.purple_500)
        } else {
            holder.layoutChoosen.background = ContextCompat.getDrawable(context, R.color.black)
        }

        holder.layoutChoosen.setOnClickListener {
            clickCallback.onClicked(item, position, list)
        }
        holder.text.text = item.name
    }

    fun updateItem(list: ArrayList<SeatNumberModel>) {
        this.list = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return list.size
    }

    interface ClickCallback {
        fun onClicked(item: SeatNumberModel, position: Int, list: ArrayList<SeatNumberModel>)
    }
}