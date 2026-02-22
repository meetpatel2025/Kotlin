package com.training.libraryofalltopics.livedata

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.training.libraryofalltopics.R
import com.training.libraryofalltopics.databinding.LiveDataActivityMainBinding

class LiveDataMainActivity : AppCompatActivity() {
    lateinit var binding: LiveDataActivityMainBinding
    lateinit var counterViewModel: Eventhandler
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.live_data_activity_main)
        binding = DataBindingUtil.setContentView(
            this,
            R.layout.live_data_activity_main
        )
        counterViewModel = ViewModelProvider(this).get(Eventhandler::class.java)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        binding.textView.text = counterViewModel.counter.toString()
//
//        binding.countBtn.setOnClickListener {
//            counterViewModel.incrementCount()
//            binding.textView.text = counterViewModel.counter.toString()

        binding.lifecycleOwner = this
        binding.eventHandler = counterViewModel


    }
}