package com.example.randompeopletestapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.randompeopletestapp.core.di.get
import com.example.randompeopletestapp.R
import com.example.randompeopletestapp.presentation.main.view.DetailFragment
import com.example.randompeopletestapp.presentation.main.view.ListFragment

class MainActivity : AppCompatActivity() {

    init {
        WorkManager.getInstance().enqueue(get<WorkRequest>())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listFragment = ListFragment()
        val detailFragment = DetailFragment()

        supportFragmentManager.beginTransaction()
            .replace(R.id.listContainer, listFragment)
            .replace(R.id.detailContainer, detailFragment)
            .commit()
    }

    override fun onDestroy() {
        WorkManager.getInstance().cancelAllWork()
        Log.d("WORK", "Cancelled")
        super.onDestroy()
    }
}