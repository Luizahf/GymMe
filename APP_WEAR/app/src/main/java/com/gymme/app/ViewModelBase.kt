package com.gymme.app

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.*
import java.lang.Exception

open class ViewModelBase(application: Application) : AndroidViewModel(application)  {

    protected fun doAsyncWork(work: suspend () -> Unit) {
        GlobalScope.launch { // launch a new coroutine in background and continue
            try {
                work()
            } catch(e: Exception) {
                throw Exception(e.message)
            }
        }
    }
}