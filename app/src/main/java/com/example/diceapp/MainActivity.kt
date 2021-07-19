package com.example.diceapp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val RollBut: Button = findViewById(R.id.button)
        val diceTxt: TextView = findViewById(R.id.textView)
        val diceTxt2: TextView = findViewById(R.id.textView2)
        RollBut.setOnClickListener {
            rollDice(6,false,diceTxt,diceTxt2)
            rollDice(12,true,diceTxt,diceTxt2)
            winCheck(diceTxt,diceTxt2)
        }
    }

    private fun rollDice(number: Int,SecTxt: Boolean,txt1: TextView,txt2:TextView)
    {
        val dice = Dice(number)
        if(SecTxt)
            txt2.text = dice.roll().toString()
        else
            txt1.text = dice.roll().toString()

    }
    private fun winCheck(txt1: TextView,txt2:TextView) {
        if (txt1.text == txt2.text) {
            val toast = Toast.makeText(this, "JACKPOT!!!", Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}

class Dice(private val numSides: Int) {

    fun roll(): Int {
        return (1..numSides).random()
    }
}
