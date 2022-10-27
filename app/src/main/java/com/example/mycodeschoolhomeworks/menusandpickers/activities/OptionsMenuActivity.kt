package com.example.mycodeschoolhomeworks.menusandpickers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import com.example.mycodeschoolhomeworks.R

class OptionsMenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options_menu)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.nav_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.nav_delete->Toast.makeText(this, "Delete selected", Toast.LENGTH_SHORT).show()
            R.id.nav_favorite->Toast.makeText(this, "Favorite selected", Toast.LENGTH_SHORT).show()
            R.id.nav_third_item->Toast.makeText(this, "Third Item Selected", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}