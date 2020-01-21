package com.frangrgec.fizzbuzzdemo

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_game.view.*
import java.util.prefs.AbstractPreferences


class Game : Fragment() {

    lateinit var navController: NavController
    lateinit var sharedPreferences: SharedPreferences
    private var counter = 0

    //Implements a click listener for the buttons
    private val clickListener = View.OnClickListener { view ->

        when (view) {
            fizzButton -> {
                if (checkGuess(3)) {
                    numberChange()
                } else {
                    gameOver()
                }
            }
            buzzButton -> {
                if (checkGuess(5)) {
                    numberChange()
                } else {
                    gameOver()
                }
            }
            fizzBuzzButton -> {
                if (checkGuess(3) && checkGuess(5)) {
                    numberChange()
                } else {
                    gameOver()
                }

            }
            nextButton -> {
                if (!checkGuess(3) && !checkGuess(5)) {
                    numberChange()

                } else {
                    gameOver()
                }
            }
        }
    }

    //Saves counter permanently
    private fun setCounter()
    {
        sharedPreferences.edit().putInt("counter", counter).apply()
        counter = sharedPreferences.getInt("counter", 99)
    }

    //Goes to the won game fragment
    private fun gameWon() {
        navController.navigate(R.id.action_game_to_wonGame)
        counter=0
        setCounter()
    }

    //Goes to the lost game fragment
    private fun gameOver()
    {
        navController.navigate(R.id.action_game_to_lostGame)
        counter=0
        setCounter()
    }

    //Increases the number
    private fun numberChange()
    {
        if (counter < 100)
        {
            counter+=1
            setCounter()
            numberView.text=counter.toString()

        } else {

            gameWon()
        }
    }

    //Checks the user guess
    private fun checkGuess(divide: Int): Boolean
    {
        if(counter==0)
        {
            return false
        }
        return counter%divide==0

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)

        sharedPreferences =
            activity!!.getSharedPreferences("com.frangrgec.fizzbuzzdemo", Context.MODE_PRIVATE)
        if (!sharedPreferences.contains("counter")) {
            setCounter()
        }

        counter = sharedPreferences.getInt("counter", 0)

        numberView.text = counter.toString()
        fizzButton.setOnClickListener(clickListener)
        buzzButton.setOnClickListener(clickListener)
        fizzBuzzButton.setOnClickListener(clickListener)
        nextButton.setOnClickListener(clickListener)

    }

}
