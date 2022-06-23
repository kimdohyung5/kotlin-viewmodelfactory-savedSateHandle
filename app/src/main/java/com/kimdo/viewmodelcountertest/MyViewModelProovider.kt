package com.kimdo.viewmodelcountertest

import android.os.Bundle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.savedstate.SavedStateRegistryOwner

//class MyViewModelProovider(val count: Int) : ViewModelProvider.Factory {
//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        if( modelClass.isAssignableFrom(MyViewModel::class.java)) {
//            return MyViewModel(count) as T
//        }
//        throw IllegalArgumentException("ViewModel class not found")
//    }
//}

class MyViewModelProovider(val count: Int
                           , owner: SavedStateRegistryOwner
                           , defaultArgs: Bundle? = null,
) : AbstractSavedStateViewModelFactory(owner, defaultArgs) {
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if(modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(count, handle) as T
        }
        throw IllegalArgumentException("viewModel class not found")
    }
}