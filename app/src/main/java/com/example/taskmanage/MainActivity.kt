package com.example.taskmanage

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.taskmanage.Data.Pref
import com.example.taskmanage.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val pref = Pref(this)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_main)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        if (!pref.isOnBoardingSeen())
            navController.navigate(R.id.onBoardingFragment2 )

        val appBarConfiguration = AppBarConfiguration(setOf(
            R.id.navigation_home, R.id.navigation_dashboard,
            R.id.navigation_notifications, R.id.navigation_profile,
            R.id.navigation_TaskFragment))


        val navFragment = arrayListOf(
            R.id.navigation_home, R.id.navigation_dashboard,
            R.id.navigation_notifications, R.id.navigation_profile
        )

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            navView.isVisible = navFragment.contains(destination.id)
            if (destination.id == R.id.onBoardingFragment2 ) {
                supportActionBar?.hide()
            } else supportActionBar?.show()

        }
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
}