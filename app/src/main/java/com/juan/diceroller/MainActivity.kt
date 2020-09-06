package com.juan.diceroller

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    lateinit var  diceImage :ImageView
    lateinit var  diceImageTwo: ImageView
    lateinit var  textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        Toast.makeText(this,"Bienvenidos a mi App\n  les saluda juan ",Toast.LENGTH_SHORT).show()
    }
    private fun rollDice(){
        val textView: TextView = findViewById(R.id.tvNumber)
        val diceImage: ImageView = findViewById(R.id.dice_image)
        val diceImageTwo: ImageView = findViewById(R.id.dice_image_two)

        val diceOne  = getRandomDiceImage()
        val diceTwo: IntArray = getRandomDiceImage()
        diceImage.setImageResource(diceOne[1])
        diceImageTwo.setImageResource(diceTwo[1])

        val plusThedice = diceOne[0] + diceTwo [0]
        textView.text = plusThedice.toString()

    }

    private fun getRandomDiceImage() : IntArray {
        val randomInt = (1..6).random()
        val drawableResourse = when(randomInt){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        var list: IntArray = intArrayOf(randomInt,drawableResourse)
        return list
    }

}
