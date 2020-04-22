package com.gymme.app.ui.MyWorksheet

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.gymme.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MyWorksheetActivity : AppCompatActivity(), View.OnClickListener {
    private val myWorksheetViewModel: MyWorksheetViewModel by viewModel()
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
