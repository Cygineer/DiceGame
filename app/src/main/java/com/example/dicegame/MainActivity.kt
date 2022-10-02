package com.example.dicegame

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var diceImage: ImageView
    lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.diceImage)
        resultText = findViewById(R.id.resultText)

        val rollBtn: Button = findViewById(R.id.rollBtn)
        rollBtn.setOnClickListener{

            //주사위 던지기
            rollDice()
        }
    }

    //주사위 던지기
    private  fun rollDice(){

        //랜덤수
        val randomNum: Int = (1..6).random()

        //랜덤 이미지
        val selectedImage = when(randomNum){

            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }

        //애니메이션(회전)
        val animationRotate: ValueAnimator = ObjectAnimator
            .ofFloat(diceImage, "rotation", 0f, 180f, 360f)

        //지속시간(1000=1초)
        animationRotate.duration = 300
        animationRotate.start()

        //이미지적용
        diceImage.setImageResource(selectedImage)

        resultText.text = "주사위 숫자: $randomNum"


    }

}