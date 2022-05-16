package com.example.seat_booking.fragment

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.seat_booking.R
import com.example.seat_booking.adapter.SeatAdapter
import com.example.seat_booking.model.SeatModel
import com.example.seat_booking.viewModel.SeatViewModel
import com.google.gson.Gson
import kotlinx.android.synthetic.main.fragment_seat.*

class SeatFragment(val page: Int) : Fragment() {
    lateinit var adapter: SeatAdapter
    val viewModel: SeatViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_seat, container, false)
    }

    override fun onResume() {
        super.onResume()
        Log.d(
            "listAdapter",
            " = " + Gson().toJson(viewModel.sumSeat.value) + "page = " + Gson().toJson(viewModel.sumSeat.value?.filter { it.pageTo == this.page } as ArrayList<SeatModel>))

        adapter.addList(viewModel.sumSeat.value?.filter { it.pageTo == this.page } as ArrayList<SeatModel>)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SeatAdapter(requireContext(), object : SeatAdapter.ClickCallback {
            override fun onClicked(
                item: SeatModel,
                position: Int,
                list: ArrayList<SeatModel>
            ) {
                val item2 = SeatModel(
                    name = item.name,
                    isClicked = !item.isClicked,
                    id = item.id,
                    pageTo = item.pageTo
                )
                list.set(index = position, item2)
                list.forEach {
                    if (it.name != list[position].name) {
                        it.isClicked = false
                    }
                }
                adapter.updateItem(list)

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    viewModel.sumSeat.value?.removeIf { it.id == item.id }
                } else {
                    Log.d("cek", "= ")
                }

                viewModel.addItem(item2)

                val tempDataAll = arrayListOf<SeatModel>()
                viewModel.sumSeat.value?.forEach {
                    if (item2.isClicked) {
                        if (it.pageTo != this@SeatFragment.page) {
                            it.isClicked = false
                        }
                    }
                    tempDataAll.add(it)
                }

                viewModel.setList(tempDataAll)
            }
        })


        rv_seat.run {
            adapter = this@SeatFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), 4)
        }
    }
}