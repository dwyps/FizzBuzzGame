package com.frangrgec.fizzbuzzdemo.fragments.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GameViewModel : ViewModel() {

    private val _counter = MutableLiveData<Int>()
    val counter: LiveData<Int>
        get() = _counter

    private val _gameDone = MutableLiveData<Int>()
    val gameDone: LiveData<Int>
        get() = _gameDone


    init {
        _counter.value = 0
        _gameDone.value = 0
    }

    //Increases the number
    private fun numberChange() {
        if ((_counter.value)!! < 100) {
            _counter.value = (_counter.value)?.plus(1)

        } else {

            gameWon()
        }
    }

    //Checks the user guess
    private fun checkGuess(divide: Int): Boolean {
        if (_counter.value == 0) {
            return false
        }
        return (_counter.value)!! % divide == 0

    }


    //Goes to the won game fragment
    private fun gameWon() {
        _gameDone.value = 1

    }

    //Goes to the lost game fragment
    private fun gameOver() {
        _gameDone.value = 2
    }

    fun fizzButton() {

        if (checkGuess(3)) {
            numberChange()
        } else {
            gameOver()
        }
    }

    fun buzzButton() {

        if (checkGuess(5)) {
            numberChange()
        } else {
            gameOver()
        }
    }

    fun fizzBuzzButton() {

        if (checkGuess(3) && checkGuess(5)) {
            numberChange()
        } else {
            gameOver()
        }
    }

    fun nextButton() {

        if (!checkGuess(3) && !checkGuess(5)) {
            numberChange()
        } else {
            gameOver()
        }
    }
}