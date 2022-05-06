package com.example.seat_booking.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SeatViewModel::class.java)) {
            return SeatViewModel(
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }


}