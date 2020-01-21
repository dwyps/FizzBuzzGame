package com.frangrgec.fizzbuzzdemo

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main_menu.*

class MainMenu : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    //Enables the about app menu
    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true)
        super.onCreate(savedInstanceState)
    }

    //Inflates about app menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        inflater.inflate(R.menu.about_app, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    //Enables the on click menu to about app fragment
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.aboutApp -> navController.navigate(R.id.action_mainMenu_to_aboutApp2)
        }

        return super.onOptionsItemSelected(item)
    }

    //Inflates the fragment main menu
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main_menu, container, false)
    }

    //Sets the navigation controller to the current fragment
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        startButton.setOnClickListener(this)

    }

    //Switches to the game fragment
    override fun onClick(v: View?) {

        when (v!!) {
            startButton -> navController.navigate(R.id.action_mainMenu_to_game)
        }

    }
}
