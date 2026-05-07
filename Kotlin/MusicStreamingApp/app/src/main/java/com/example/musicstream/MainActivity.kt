package com.example.musicstream

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navOptions
import com.example.musicstream.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

/**
 * Single-activity host. Wires the nav graph to a [BottomNavigationView] and
 * coordinates which destinations are top-level vs. detail screens.
 */
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    private val topLevelDestinations = setOf(
        R.id.homeFragment,
        R.id.settingsFragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHost = supportFragmentManager
            .findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHost.navController

        setupBottomNav()
        observeDestinationChanges()
    }

    private fun setupBottomNav() = with(binding.bottomNav) {
        // Default selection
        selectedItemId = R.id.homeFragment

        setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    if (navController.currentDestination?.id != R.id.homeFragment) {
                        navController.popBackStack(R.id.homeFragment, false)
                    }
                    true
                }

                R.id.settingsFragment -> {
                    if (navController.currentDestination?.id != R.id.settingsFragment) {
                        navController.navigate(
                            R.id.settingsFragment,
                            null,
                            navOptions {
                                popUpTo(R.id.homeFragment) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        )
                    }
                    true
                }

                R.id.searchDestination -> {
                    Snackbar.make(binding.root, "Search coming soon.", Snackbar.LENGTH_SHORT).show()
                    false
                }

                R.id.libraryDestination -> {
                    Snackbar.make(binding.root, "Library coming soon.", Snackbar.LENGTH_SHORT).show()
                    false
                }

                else -> false
            }
        }

        setOnItemReselectedListener { /* no-op: avoid re-creating fragment */ }
    }

    private fun observeDestinationChanges() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            // Hide bottom nav on detail screens for a cleaner look.
            val showBottomNav = destination.id in topLevelDestinations
            binding.bottomNav.visibility =
                if (showBottomNav) android.view.View.VISIBLE else android.view.View.GONE

            if (showBottomNav && binding.bottomNav.selectedItemId != destination.id) {
                binding.bottomNav.menu.findItem(destination.id)?.isChecked = true
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean =
        navController.navigateUp() || super.onSupportNavigateUp()
}
