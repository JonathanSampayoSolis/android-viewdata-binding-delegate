package com.sampacodes.viewdatabindingdelegate

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.sampacodes.viewdatabindingdelegate.arch.presentation.tagClass
import com.sampacodes.viewdatabindingdelegate.databinding.ActivityMainBinding
import com.sampacodes.viewdatabindingdelegate.presentation.bottomSheetDialogFragment.BindingBottomSheetDialogFragment

class MainActivity : AppCompatActivity() {

    private val mTag by tagClass()

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navController: NavController by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment).let {
            (it as NavHostFragment).navController
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val appBarConfig = AppBarConfiguration(
            setOf(R.id.viewBindingFragment, R.id.dataBindingFragment),
            binding.drawerLayout,
        )
        setupActionBarWithNavController(navController, appBarConfig)

        binding.navigationView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_contextual, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                binding.drawerLayout.openDrawer(GravityCompat.START)
                true
            }

            R.id.item_bottom_dialog_fragment -> {
                BindingBottomSheetDialogFragment.newInstance()
                    .show(supportFragmentManager, mTag)
                true
            }

            else -> false
        }
    }

}