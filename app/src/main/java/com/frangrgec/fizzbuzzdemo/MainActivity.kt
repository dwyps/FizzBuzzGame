package com.frangrgec.fizzbuzzdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View

class MainActivity : AppCompatActivity() {

    val manager = supportFragmentManager

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.about_app, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId)
        {
            R.id.aboutApp -> showAboutApp()
        }

        return super.onOptionsItemSelected(item)
    }

    //Shows the main menu fragment
    fun showMainMenu()
    {
        val transaction = manager.beginTransaction()
        val fragment = MainMenu()
        transaction.replace(R.id.constrain_layout, fragment)
            .addToBackStack(null)
            .commit()
    }

    //Shows the about app fragment
    fun showAboutApp()
    {
        val transaction = manager.beginTransaction()
        val fragment = AboutApp()
        transaction.replace(R.id.constrain_layout, fragment)
            .addToBackStack(null)
            .commit()
    }

    //Shows game fragment
    fun showGame()
    {
        val transaction = manager.beginTransaction()
        val fragment = Game()
        transaction.replace(R.id.constrain_layout, fragment)
            .addToBackStack(null)
            .commit()
    }

    //Goes back to main menu
    fun backMainMenu(view: View)
    {
            showMainMenu()
    }

    fun startGame(view: View)
    {
        showGame()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showMainMenu()

    }


}
