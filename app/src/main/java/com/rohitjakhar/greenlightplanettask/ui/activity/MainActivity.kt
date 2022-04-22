package com.rohitjakhar.greenlightplanettask.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.rohitjakhar.greenlightplanettask.R
import com.rohitjakhar.greenlightplanettask.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val fragmentManager =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = fragmentManager.navController

        handleToolBar()
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun handleToolBar() {
        navController.addOnDestinationChangedListener { _, navDestination, _ ->
            when (navDestination.id) {
                R.id.testFragment -> {
                    supportActionBar?.hide()
                }
                else -> {
                    supportActionBar?.title = navDestination.label
                    supportActionBar?.show()
                    supportActionBar?.setDisplayHomeAsUpEnabled(true)
                }
            }
        }
    }
}
