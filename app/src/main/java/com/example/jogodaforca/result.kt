package com.example.jogodaforca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView

class result : AppCompatActivity() {
    //private lateinit var jogo: Fachada
    private lateinit var imageWinOrLose: ImageView
    private lateinit var buttonBack: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        this.imageWinOrLose = findViewById(R.id.WinOrLose)
        this.buttonBack = findViewById(R.id.buttonVoltar)

        if (intent.hasExtra("Result")) {
            if (intent.getStringExtra("Result") == "Ganhou!") {
                this.imageWinOrLose.setImageResource(getResources().getIdentifier("ganhou" , "drawable", getPackageName()))
            }
            else {
                this.imageWinOrLose.setImageResource(getResources().getIdentifier("perdeu" , "drawable", getPackageName()))
            }
        }

        this.buttonBack.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}