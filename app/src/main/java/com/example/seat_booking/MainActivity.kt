package com.example.seat_booking

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback
import com.example.seat_booking.adapter.ViewPagerAdapter
import com.example.seat_booking.databinding.ActivityMainBinding
import com.example.seat_booking.fragment.SeatFragment
import com.example.seat_booking.model.SeatModel
import com.example.seat_booking.model.SeatNumberModel
import com.example.seat_booking.viewModel.SeatViewModel
import com.example.seat_booking.viewModel.ViewModelFactory
import com.google.android.material.tabs.TabLayoutMediator
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: SeatViewModel
    val listFragment = arrayListOf<Fragment>()

    var numberSeat: ArrayList<SeatNumberModel> = arrayListOf()
    var sumSeat: ArrayList<SeatModel> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this, ViewModelFactory()).get(SeatViewModel::class.java)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        for (i in 1..3) {
            numberSeat.add(SeatNumberModel(i.toString()))
            listFragment.add(SeatFragment(page = i))
        }
        var id = 0
        numberSeat.forEachIndexed { index, seatNumberModel ->
            for (i in index..index) {
                id = index + i
                sumSeat.add(SeatModel(id, "$i", pageTo = index + 1))
            }
        }
        viewModel.setList(sumSeat)


        setViewPager()

    }

    private fun setViewPager() {

        val adapter =
            ViewPagerAdapter(supportFragmentManager, lifecycle, numberSeat.size, listFragment)
        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager2) { tab, position ->
            tab.text = numberSeat[position].name
        }.attach()

        binding.viewPager2.registerOnPageChangeCallback(object : OnPageChangeCallback() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels)
            }

            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.d("onPageSelected", "onPageSelected = " + position)

            }

            override fun onPageScrollStateChanged(state: Int) {
                super.onPageScrollStateChanged(state)
            }

        })
    }
}

