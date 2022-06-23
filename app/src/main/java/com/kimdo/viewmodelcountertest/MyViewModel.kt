package com.kimdo.viewmodelcountertest

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MyViewModel(count: Int, private val savedStateHandle: SavedStateHandle ) : ViewModel() {

    private var counter: Int =savedStateHandle.get<Int>(COUNTER_KEY) ?: count

    val liveCounter: MutableLiveData<Int> = MutableLiveData(counter)

    fun saveState() {
        savedStateHandle.set(COUNTER_KEY, liveCounter.value)
    }
    companion object {
        const val COUNTER_KEY = "counter_key"
    }
}