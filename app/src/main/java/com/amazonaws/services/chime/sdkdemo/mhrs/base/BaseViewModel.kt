package com.amazonaws.services.chime.sdkdemo.mhrs.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

abstract class BaseViewModel (applicaton: Application): AndroidViewModel(applicaton) , CoroutineScope {

    private val job= Job()
    override val coroutineContext: CoroutineContext
    get() = job+ Dispatchers.Main//işini yap  sonra maina threade dön

    override fun onCleared() {
        //viewmodel kapanınca job bitsin
        super.onCleared()
        job.cancel()
    }

}