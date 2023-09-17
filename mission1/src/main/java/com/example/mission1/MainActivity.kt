package com.example.mission1


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.navigation.NavigationBarView

class MainActivity : AppCompatActivity() {
    private lateinit var FirstFragment: FirstFragment
    private lateinit var SecondFragment: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        FirstFragment = FirstFragment()
        SecondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment).commit()

        val navigationBarView = findViewById<NavigationBarView>(R.id.bottom_navigationView)
        navigationBarView.setOnItemSelectedListener { item ->
            when(item.itemId){
                R.id.register -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, FirstFragment).commit()
                    true
                }
                R.id.check ->{
                    supportFragmentManager.beginTransaction().replace(R.id.container, SecondFragment).commit()
                    true
                }
                else -> {
                    false
                }
            }
        }

    }
}