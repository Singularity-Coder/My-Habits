package com.singularitycoder.myhabits

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.singularitycoder.myhabits.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

// https://androiddvlpr.com/android-calendar-library/
// https://github.com/shrikanth7698/Collapsible-Calendar-View-Android

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        showScreen(HomeFragment.newInstance(), "HomeFragment")
    }
}