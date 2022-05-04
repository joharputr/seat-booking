package com.example.seat_booking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.seat_booking.adapter.ViewPagerAdapter
import com.example.seat_booking.databinding.ActivityMainBinding
import com.example.seat_booking.fragment.SeatFragment
import com.example.seat_booking.model.SeatNumberModel
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    val listFragment = arrayListOf<Fragment>()

     var numberSeat: ArrayList<SeatNumberModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        for (i in 1..3) {
            numberSeat.add(SeatNumberModel(i.toString()))
            listFragment.add(SeatFragment())
        }

        val adapter =
            ViewPagerAdapter(supportFragmentManager, lifecycle, numberSeat.size, listFragment)
        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = numberSeat[position].name
        }.attach()

    }
}