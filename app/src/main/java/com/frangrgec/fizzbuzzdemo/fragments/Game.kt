package com.frangrgec.fizzbuzzdemo.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.frangrgec.fizzbuzzdemo.R
import com.frangrgec.fizzbuzzdemo.fragments.viewModels.GameViewModel
import kotlinx.android.synthetic.main.fragment_game.*


class Game : Fragment() {

    private lateinit var gameViewModel: GameViewModel
    lateinit var navController: NavController

    private fun fizz() {
        gameViewModel.fizzButton()
    }

    private fun buzz() {
        gameViewModel.buzzButton()
    }

    private fun fizzBuzz() {
        gameViewModel.fizzBuzzButton()
    }

    private fun next() {
        gameViewModel.nextButton()
    }

    private fun gameWon() {
        navController.navigate(R.id.action_game_to_wonGame)
    }

    private fun gameLost() {
        navController.navigate(R.id.action_game_to_lostGame)
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

        gameViewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        gameViewModel.counter.observe(
            this,
            Observer { newCounter -> numberView.text = newCounter.toString() })
        gameViewModel.gameDone.observe(this, Observer { gameState ->
            if (gameState == 1) gameWon() else if (gameState == 2) gameLost()
        })

        fizzButton.setOnClickListener { fizz() }
        buzzButton.setOnClickListener { buzz() }
        fizzBuzzButton.setOnClickListener { fizzBuzz() }
        nextButton.setOnClickListener { next() }

    }

}
