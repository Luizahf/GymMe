package com.gymme.app.ui.MyWorksheet

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gymme.R
import com.gymme.domain.entities.CompleteExercise
import com.gymme.domain.entities.CompleteWorksheet
import kotlinx.android.synthetic.main.worksheet_layout.view.*

class WorksheetAdapter (private val context: Context,
                        ExerciseList: List<CompleteWorksheet>,
                        WorksheetExerciseViewId: Int,
                        ExerciseDescriptionId: Int,
                        val clickListenerStart: (Int) -> Unit) :
                        RecyclerView.Adapter<WorksheetAdapter.ViewHolder>() {
    val worksheetExerciseViewId: Int = WorksheetExerciseViewId
    val exerciseDescriptionId = ExerciseDescriptionId
    val exerciseList = ExerciseList

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.worksheet_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position < exerciseList.size) {
            holder.let {
                it.bindView(worksheetExerciseViewId, exerciseDescriptionId, exerciseList[position], position, clickListenerStart)
            }
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(WorksheetExerciseViewId: Int, exerciseDescriptionId: Int, exerciseList: CompleteWorksheet, position: Int, clickListenerStart: (Int) -> Unit) {
            itemView.start_workout.setOnClickListener { clickListenerStart(position) }
            val exercises = itemView.exercises
            itemView.worksheet_title.text = "FICHA " + exerciseList.worksheetName

            val arrayAdapter = ArrayAdapter<String>(
                    itemView.context,
                    WorksheetExerciseViewId,
                    exerciseDescriptionId,
                    exerciseList.exercises.map { it.exercise.description })

            exercises.adapter = arrayAdapter
        }
    }
}