package com.example.randompeopletestapp.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.randompeopletestapp.R
import com.example.randompeopletestapp.presentation.main.view.DetailFragment
import com.example.randompeopletestapp.presentation.main.view.ListFragment

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
}