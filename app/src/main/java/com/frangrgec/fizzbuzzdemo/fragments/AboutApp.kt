package com.frangrgec.fizzbuzzdemo.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.frangrgec.fizzbuzzdemo.R
import kotlinx.android.synthetic.main.fragment_about_app.*

class AboutApp : Fragment(), View.OnClickListener {

    lateinit var navController: NavController

    //Inflates about app fragment
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_about_app, container, false)
    }

    //Sets the navigation controller
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        mainMenuButton.setOnClickListener(this)
    }

    //Sets the back button to main menu
    override fun onClick(v: View?) {
        when (v!!) {
            mainMenuButton -> navController.navigate(R.id.action_aboutApp2_to_mainMenu)
        }
    }
}
