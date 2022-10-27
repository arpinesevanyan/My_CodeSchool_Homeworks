package com.example.mycodeschoolhomeworks.menusandpickers.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.example.mycodeschoolhomeworks.R

class ContextMenuActivity : AppCompatActivity() {

    private var itemList = arrayOf("Item 1", "Item 2", "Item 3")
    private var listView: ListView? = null
    private var arrayAdapter: ArrayAdapter<String>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context_menu)

        listView = findViewById(R.id.contextListView)
        arrayAdapter =
            ArrayAdapter(applicationContext, android.R.layout.simple_list_item_1, itemList)
        listView?.adapter = arrayAdapter
        registerForContextMenu(listView)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        menuInflater.inflate(R.menu.main_menu, menu)
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menuCall -> {
                Toast.makeText(applicationContext, "Call Menu", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.menuPhone -> {
                Toast.makeText(applicationContext, "Phone Menu", Toast.LENGTH_LONG).show()
                return true
            }
            R.id.menuMessage -> {
                Toast.makeText(applicationContext, "Message Menu", Toast.LENGTH_LONG).show()
                return true
            }
            else -> return super.onContextItemSelected(item)
        }
    }
}