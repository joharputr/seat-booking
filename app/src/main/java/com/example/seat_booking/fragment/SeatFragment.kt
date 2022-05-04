package com.example.seat_booking.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.seat_booking.R
import com.example.seat_booking.adapter.SeatAdapter
import com.example.seat_booking.model.SeatNumberModel
import kotlinx.android.synthetic.main.fragment_seat.*


class SeatFragment : Fragment() {
    lateinit var adapter: SeatAdapter
    var numberSeat: ArrayList<SeatNumberModel> = arrayListOf()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_seat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SeatAdapter(requireContext(), object : SeatAdapter.ClickCallback {
            override fun onClicked(
                item: SeatNumberModel,
                position: Int,
                list: ArrayList<SeatNumberModel>
            ) {
                val item2 = SeatNumberModel(name = item.name, isClicked = !item.isClicked)
                list.set(index = position, item2)
                list.forEach {
                    if (it.name != list[position].name) {
                        it.isClicked = false
                    }
                }
                adapter.updateItem(list)
            }
        })

        for (i in 0..7) {
            numberSeat.add(SeatNumberModel("$i"))
        }

        adapter.addList(numberSeat)


        rv_seat.run {
            adapter = this@SeatFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), 4)
        }

    }

}