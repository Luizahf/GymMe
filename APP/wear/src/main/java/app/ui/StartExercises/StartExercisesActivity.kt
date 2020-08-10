package com.gymme.app.ui.StartExercises

import Shared.Constants
import android.content.Intent
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.MotionEventCompat
import androidx.lifecycle.Observer
import com.gymme.R
import com.gymme.app.ui.SplashScreen.SplashScreenActivity
import com.gymme.data.data.Base.MetricsEntity
import com.gymme.domain.entities.CompleteExercise
import com.gymme.domain.entities.Exercise
import kotlinx.android.synthetic.main.start_exercises.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class StartExercisesActivity : AppCompatActivity(), View.OnClickListener, View.OnTouchListener {
    private val startExercisesViewModel: StartExercisesViewModel by viewModel()
    var exerciseList: List<CompleteExercise> = mutableListOf()
    private var exercise: Int = 0
    var worksheetId : String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.start_exercises)

        imageView.setOnTouchListener(object : OnSwipeTouchListener()) {
            override fun onSwipeLeft() {
            }

            override fun onSwipeRight() {
            }
        })

        worksheetId = intent.getStringExtra(Constants.WORKSHEET_ID)
        startExercisesViewModel.getWorksheetExercises(worksheetId.toInt())

        btn_right.setOnClickListener(this)
        btn_left.setOnClickListener(this)
        btn_finish.setOnClickListener(this)

        startExercisesViewModel.exercisesList.observe(this, Observer {
            it?.let {
                exercises ->
                run {
                    if (exercises.isNotEmpty()) {
                        exerciseList = exercises
                        exercise = 0
                        setDisplay()
                    } else {
                        Toast.makeText(this, "Não foi possível encontrar exercícios para essa ficha.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }

    fun setDisplay() {
        var description = exerciseList[exercise].exercise.description
        val ser = exerciseList[exercise].metrics.Series
        val repet = exerciseList[exercise].metrics.Repetitions
        val loads = exerciseList[exercise].metrics.Load
        val time = exerciseList[exercise].metrics.ExecutionTime

        exercise_description.setText(description)
        if (ser != null) {
            series.setText(ser.toString())
        }
        if (repet != null) {
            repetitions.setText(repet.toString())
        }
        if(loads != null) {
            load.setText(loads.toString())
        }
        if (time != null) {
            execution_time.setText(time.toString())
        }
    }

    override fun onClick(view: View) {
        val id = view.id

        when (id) {
            R.id.btn_right -> {
                if (changedMetrics()) {
                    saveNewMetrics()
                }
                if (exerciseList != null && !exerciseList.isEmpty() && exercise !== exerciseList.size-1) {
                    exercise++
                    setDisplay()
                }
            }
            R.id.btn_left -> {
                if (changedMetrics()) {
                    saveNewMetrics()
                }
                if (exercise !== 0) {
                    exercise--
                    setDisplay()
                }
            }
            R.id.btn_finish -> {
                if (changedMetrics()) {
                    saveNewMetrics()
                }
                startActivity(Intent(this, SplashScreenActivity::class.java))
            }
            R.id.series_up -> {
                series.setText((series.toString().toInt() + 1))
            }
            R.id.repetitions_up -> {
                repetitions.setText((repetitions.toString().toInt() + 1))
            }
            R.id.load_up -> {
                load.setText((load.toString().toInt() + 1))
            }
            R.id.execution_time_up -> {
                execution_time.setText((execution_time.toString().toInt() + 1))
            }
            R.id.series_down -> {
                series.setText((series.toString().toInt() - 1))
            }
            R.id.repetitions_down -> {
                repetitions.setText((repetitions.toString().toInt() - 1))
            }
            R.id.load_down -> {
                load.setText((load.toString().toInt() - 1))
            }
            R.id.execution_time_down -> {
                execution_time.setText((execution_time.toString().toInt() - 1))
            }
        }
    }

    private fun changedMetrics() : Boolean {
        return (series.text.toString() != exerciseList[exercise].metrics.Series.toString() ||
                repetitions.toString() != exerciseList[exercise].metrics.Repetitions.toString() ||
                execution_time.toString() != exerciseList[exercise].metrics.ExecutionTime.toString() ||
                load.toString() != exerciseList[exercise].metrics.Load.toString())

    }

    private fun saveNewMetrics() {
        if ((series.text.toString().isNotEmpty() && !series.text.toString().matches("\\d+(\\.\\d+)?".toRegex())) ||
                (repetitions.text.toString().isNotEmpty() && !repetitions.text.toString().matches("\\d+(\\.\\d+)?".toRegex())) ||
                (load.text.toString().isNotEmpty() && !load.text.toString().matches("\\d+(\\.\\d+)?".toRegex())) ||
                (execution_time.text.toString().isNotEmpty() && !execution_time.text.toString().matches("\\d+(\\.\\d+)?".toRegex())))   {
            Toast.makeText(this, "Os campos devem ser preenchidos com numeros.", Toast.LENGTH_SHORT).show()
        } else {
            exerciseList[exercise].metrics.Series = series.text.toString().toInt()
            exerciseList[exercise].metrics.Repetitions = repetitions.text.toString().toInt()
            exerciseList[exercise].metrics.Load = load.text.toString().toInt()
            exerciseList[exercise].metrics.ExecutionTime = execution_time.text.toString().toInt()

            startExercisesViewModel.insertExerciseMetrics(exerciseList[exercise].exercise.id, worksheetId.toInt(), MetricsEntity(0, exerciseList[exercise].metrics.Series,
                    exerciseList[exercise].metrics.Repetitions, exerciseList[exercise].metrics.Load, exerciseList[exercise].metrics.ExecutionTime))
        }
    }
}
open class OnSwipeTouchListener : View.OnTouchListener {

    private val gestureDetector = GestureDetector(GestureListener())

    fun onTouch(event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        private val SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THRESHOLD = 100

        override fun onDown(e: MotionEvent): Boolean {
            return true
        }

        override fun onSingleTapConfirmed(e: MotionEvent): Boolean {
            onTouch(e)
            return true
        }


        override fun onFling(e1: MotionEvent, e2: MotionEvent, velocityX: Float, velocityY: Float): Boolean {
            val result = false
            try {
                val diffY = e2.y - e1.y
                val diffX = e2.x - e1.x
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight()
                        } else {
                            onSwipeLeft()
                        }
                    }
                } else {
                    // onTouch(e);
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }

            return result
        }
    }

    override fun onTouch(v: View, event: MotionEvent): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    open fun onSwipeRight() {}

    open fun onSwipeLeft() {}
}