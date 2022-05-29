package com.example.seat_booking.ui.menu.ListTrain.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.seat_booking.R
import com.example.seat_booking.ui.menu.ListTrain.adapter.TrainAdapter
import com.example.seat_booking.ui.menu.ListTrain.model.TrainModel
import kotlinx.android.synthetic.main.activity_list_train.*

class ListTrainActivity : AppCompatActivity() {
    lateinit var trainAdapter: TrainAdapter
    val arrayList = ArrayList<TrainModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_train)

        arrayList.add(TrainModel(name = "A item 1"))
        arrayList.add(TrainModel(name = "A item 2"))
        arrayList.add(TrainModel(name = "A item 3"))
        arrayList.add(TrainModel(name = "A item 4"))
        arrayList.add(TrainModel(name = "A item 5"))
        arrayList.add(TrainModel(name = "A item 1"))
        arrayList.add(TrainModel(name = "A item 2"))
        arrayList.add(TrainModel(name = "A item 3"))
        arrayList.add(TrainModel(name = "A item 4"))
        arrayList.add(TrainModel(name = "A item 5"))
        arrayList.add(TrainModel(name = "A item 1"))
        arrayList.add(TrainModel(name = "A item 2"))
        arrayList.add(TrainModel(name = "A item 3"))
        arrayList.add(TrainModel(name = "A item 4"))
        arrayList.add(TrainModel(name = "A item 5"))
        arrayList.add(TrainModel(name = "A item 1"))
        arrayList.add(TrainModel(name = "A item 2"))
        arrayList.add(TrainModel(name = "A item 3"))
        arrayList.add(TrainModel(name = "A item 4"))
        arrayList.add(TrainModel(name = "A item 5"))

        arrayList.add(TrainModel(name = "B item 1"))
        arrayList.add(TrainModel(name = "B item 2"))
        arrayList.add(TrainModel(name = "B item 3"))
        arrayList.add(TrainModel(name = "B item 4"))
        arrayList.add(TrainModel(name = "B item 5"))

        arrayList.add(TrainModel(name = "B item 1"))
        arrayList.add(TrainModel(name = "B item 2"))
        arrayList.add(TrainModel(name = "B item 3"))
        arrayList.add(TrainModel(name = "B item 4"))
        arrayList.add(TrainModel(name = "B item 5"))

        arrayList.add(TrainModel(name = "B item 1"))
        arrayList.add(TrainModel(name = "B item 2"))
        arrayList.add(TrainModel(name = "B item 3"))
        arrayList.add(TrainModel(name = "B item 4"))
        arrayList.add(TrainModel(name = "B item 5"))

        arrayList.add(TrainModel(name = "B item 1"))
        arrayList.add(TrainModel(name = "B item 2"))
        arrayList.add(TrainModel(name = "B item 3"))
        arrayList.add(TrainModel(name = "B item 4"))
        arrayList.add(TrainModel(name = "B item 5"))

        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        arrayList.add(TrainModel(name = "C item 5"))
        trainAdapter = TrainAdapter(this)
        trainAdapter.addList(arrayList)

        fast_scroller_recycler.run {
            setLayoutManager(LinearLayoutManager(this@ListTrainActivity))
            adapter = trainAdapter
            setIndexTextSize(12)
            setIndexBarColor("#33334c")
            setIndexBarCornerRadius(0)
            setIndexBarTransparentValue(0.4.toFloat())
            setIndexbarMargin(0F)
            setIndexbarWidth(40F)
            setPreviewPadding(0)
            setIndexBarTextColor("#FFFFFF")
            setPreviewTextSize(60)
            setPreviewColor("#33334c")
            setPreviewTextColor("#FFFFFF")
            setPreviewTransparentValue(0.6f)
            setIndexBarVisibility(true)
            setIndexBarStrokeVisibility(true)
            setIndexBarStrokeWidth(1)
            setIndexBarStrokeColor("#000000")
            setIndexbarHighLightTextColor("#33334c")
            setIndexBarHighLightTextVisibility(true)

        }
    }
}