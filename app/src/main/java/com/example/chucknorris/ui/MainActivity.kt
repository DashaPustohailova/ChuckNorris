package com.example.chucknorris.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.chucknorris.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigationGraph()
        initBottomNavigation()
    }

    private fun initBottomNavigation() {
        bottomNav.selectedItemId = R.id.item1
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.item1 -> {
                    this.mNavController.navigate(R.id.action_webFragment_to_jokesFragment)
                }
                R.id.item2 -> {
                    this.mNavController.navigate(R.id.action_jokesFragment_to_webFragment)
                }

            }
            true
        }
    }

    private fun initNavigationGraph() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        mNavController = navHostFragment.navController
    }

}