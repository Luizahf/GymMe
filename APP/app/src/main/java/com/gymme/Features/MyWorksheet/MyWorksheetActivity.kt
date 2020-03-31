package com.raywenderlich.gymme.Features.MyWorksheet

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.raywenderlich.gymme.R

class MyWorksheetActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var worksheetsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_worksheet)

        worksheetsRecyclerView = findViewById(R.id.worksheets)
        worksheetsRecyclerView.layoutManager = LinearLayoutManager(this)
        worksheetsRecyclerView.adapter = WorksheetAdapter(this, R.layout.worksheet_exercise_layout, R.id.exercise_description, this::clickListnerWorksheet)



    }

    fun clickListnerWorksheet() {
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
