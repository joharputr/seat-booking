package com.example.seat_booking.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class SeatModel(
    val id: Int? = 0,
    val name: String,
    var isClicked: Boolean = false,
    var pageTo: Int = 0
) : Parcelable
