package com.kimdo.viewmodelcountertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.kimdo.viewmodelcountertest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )

        val factory = MyViewModelProoviderFactory( 12 , this )
        val viewModel: MyViewModel by viewModels(){ factory }
//        val viewModel: MyViewModel = ViewModelProvider(this, factory )[MyViewModel::class.java]

        viewModel.liveCounter.observe(this) { count ->
            binding.txtCounter.text = count.toString()
        }

        binding.btnCount.setOnClickListener {
            viewModel.liveCounter.value  = viewModel.liveCounter.value?.plus(1)
            viewModel.saveState()
        }
    }
}