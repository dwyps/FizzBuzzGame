package com.frangrgec.fizzbuzzdemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_game.*
import kotlinx.android.synthetic.main.fragment_game.view.*


class Game : Fragment() {

    var counter = 0
    val clickListener = View.OnClickListener {view ->

        when(view)
        {
            fizzButton-> {
                if(checkGuess(3))
                {
                    numberChange()
                } else {
                    gameOver()
                }
            }
            buzzButton->{
                if(checkGuess(5))
                {
                    numberChange()
                } else {
                    gameOver()
                }
            }
            fizzBuzzButton-> {
                if(checkGuess(3)&&checkGuess(5))
                {
                    numberChange()
                } else {
                    gameOver()
                }

            }
            nextButton->{
                if(!checkGuess(3)&&!checkGuess(5))
                {
                    numberChange()

                } else {
                    gameOver()
                }
            }
        }
    }

    fun gameWon()
    {
        //showMainMenu()
        counter=0
    }

    fun gameOver()
    {
        //showMainMenu()
        counter=0
    }

    //Increases the number
    fun numberChange()
    {
        if(counter<=100)
        {
            counter+=1
            numberView.text=counter.toString()

        } else {
            //TODO WIN AND LOSE FRAGMENT
            gameWon()
        }
    }

    fun checkGuess (divide: Int ): Boolean
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

        val view =inflater.inflate(R.layout.fragment_game, container, false)
        counter=0
        view.numberView.text=counter.toString()
        view.fizzButton.setOnClickListener(clickListener)
        view.buzzButton.setOnClickListener(clickListener)
        view.fizzBuzzButton.setOnClickListener(clickListener)
        view.nextButton.setOnClickListener(clickListener)
        return view
    }

}
