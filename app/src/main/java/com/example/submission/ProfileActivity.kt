package com.example.submission

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class ProfileActivity : AppCompatActivity() {
    private var title: String = "Profile"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        setActionBarTitle(title)

    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.home -> {
                title = "Home"
                val intentHome = Intent(this,MainActivity::class.java)
                startActivity(intentHome)
            }
            R.id.profile -> {
                title = "Profile"
                val intentProfile = Intent(this, ProfileActivity::class.java)
                startActivity(intentProfile)
            }
        }
        setActionBarTitle(title)
    }
}
