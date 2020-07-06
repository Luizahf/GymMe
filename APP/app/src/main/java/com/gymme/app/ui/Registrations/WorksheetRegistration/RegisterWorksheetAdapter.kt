package com.gymme.app.ui.Registrations.WorksheetRegistration

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.RecyclerView
import com.gymme.R
import kotlinx.android.synthetic.main.worksheet_layout.view.*
import java.util.ArrayList

class RegisterWorksheetAdapter (private val context: Context,
                                WorksheetExerciseViewId: Int,
                                ExerciseDescriptionId: Int,
                                ExerciseList: ArrayList<String>) :
                        RecyclerView.Adapter<RegisterWorksheetAdapter.ViewHolder>() {
    val worksheetExerciseViewId: Int = WorksheetExerciseViewId
    val exerciseDescriptionId = ExerciseDescriptionId
    val exerciseList = ExerciseList

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.exercise_list_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.let {
            it.bindView(worksheetExerciseViewId, exerciseDescriptionId, exerciseList)
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(WorksheetExerciseViewId: Int, exerciseDescriptionId: Int, exerciseList: ArrayList<String>) {
            val exercises = itemView.exercises

            val arrayAdapter = ArrayAdapter<String>(
                    itemView.getContext(),
                    WorksheetExerciseViewId,
                    exerciseDescriptionId,
                    exerciseList)

            exercises.setAdapter(arrayAdapter)
        }
    }
}
