package com.example.randompeopletestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.work.WorkManager
import androidx.work.WorkRequest
import com.example.randompeopletestapp.R
import com.example.randompeopletestapp.core.di.get
import com.example.randompeopletestapp.presentation.main.view.DetailFragment
import com.example.randompeopletestapp.presentation.main.view.ListFragment
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

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

    override fun onResume() {
        cancelAllWork()
        updateWork()

        super.onResume()
    }

    override fun onPause() {
        cancelAllWork()

        super.onPause()
    }

    private fun cancelAllWork() = WorkManager.getInstance().cancelAllWork()

    private fun updateWork() {
        cancelAllWork()

        val scheduleTaskExecutor = Executors.newScheduledThreadPool(5)

        scheduleTaskExecutor.scheduleAtFixedRate({
            WorkManager.getInstance().enqueue(get<WorkRequest>())
        }, 0, 10, TimeUnit.SECONDS)
    }
}