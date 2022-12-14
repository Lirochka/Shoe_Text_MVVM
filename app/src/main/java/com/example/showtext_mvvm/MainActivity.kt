package com.example.showtext_mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.showtext_mvvm.show.view.ShowTextFragment
import com.example.showtext_mvvm.utils.navigateToFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.navigateToFragment(fragment = ShowTextFragment())

    }
}