package com.example.seat_booking.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.seat_booking.model.SeatModel

class SeatViewModel() : ViewModel() {
    val sumSeat =  MutableLiveData<ArrayList<SeatModel>>()

    fun setList(sumSeat: ArrayList<SeatModel>){
        this.sumSeat.value = sumSeat
    }

    fun addItem(item : SeatModel){
        this.sumSeat.value?.add(item)
    }

    fun triggerFragment(){
    }
}