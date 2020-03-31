package com.raywenderlich.gymme.Features.MyWorksheet

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.raywenderlich.gymme.R
import kotlinx.android.synthetic.main.worksheet_layout.view.*
import java.util.ArrayList

class WorksheetAdapter (private val context: Context,
                        WorksheetExerciseViewId: Int,
                        ExerciseDescriptionId: Int,
                        val clickListenerStart: () -> Unit) :
                        RecyclerView.Adapter<WorksheetAdapter.ViewHolder>() {
    val worksheetExerciseViewId: Int = WorksheetExerciseViewId
    val exerciseDescriptionId = ExerciseDescriptionId

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.worksheet_layout, viewGroup, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.let {
            it.bindView(worksheetExerciseViewId, exerciseDescriptionId)
        }
    }

    override fun getItemCount(): Int {
        return 3
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindView(WorksheetExerciseViewId: Int, exerciseDescriptionId: Int) {

            // Creating the exercise list
            val exerciseList = itemView.exercises

            // Instanciating an array list will come from the API later
            val your_array_list = ArrayList<String>()
            your_array_list.add("Agachamento")
            your_array_list.add("Desenvolvimento")
            your_array_list.add("Afundo")
            your_array_list.add("Rosca Direta")

            // This is the array adapter, it takes the context of the activity as a
            // first parameter, the type of list view as a second parameter and your
            // array as a third parameter.
            val arrayAdapter = ArrayAdapter<String>(
                    itemView.getContext(),
                    WorksheetExerciseViewId,
                    exerciseDescriptionId,
                    your_array_list)

            exerciseList.setAdapter(arrayAdapter)
        }
    }
}
