package com.frangrgec.fizzbuzzdemo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.frangrgec.fizzbuzzdemo.R
import kotlinx.android.synthetic.main.fragment_lost_game.*

class LostGame : Fragment(), View.OnClickListener {

    lateinit var navController: NavController


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_lost_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)
        tryAgainButton.setOnClickListener(this)
        mainMenuButton.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        when (v!!) {
            tryAgainButton -> navController.navigate(R.id.action_lostGame_to_game)
            mainMenuButton -> navController.navigate(R.id.action_lostGame_to_mainMenu)
        }

    }


}
