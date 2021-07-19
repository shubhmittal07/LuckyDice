package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val RollBut: Button = findViewById(R.id.button)
        val DiceImage: ImageView = findViewById(R.id.imageView)
        RollBut.setOnClickListener {
            rollDice(6,false,DiceImage)
        }
    }

    private fun rollDice(number: Int,SecTxt: Boolean,diceImg: ImageView)
    {
        val dice = Dice(number)
        loadImage(diceImg,dice.roll())
    }

    private fun loadImage(diceImg: ImageView, num:Int)
    {
        val drawableResource = when (num) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        diceImg.setImageResource(drawableResource)
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
