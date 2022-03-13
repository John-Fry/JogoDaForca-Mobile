package com.example.jogodaforca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.jogodaforca.fachada.Fachada

class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Fachada
    private lateinit var viewDica: TextView
    private lateinit var viewPalavra: TextView
    private lateinit var viewJogo: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.jogo = Fachada()
        this.jogo.start()
        this.viewDica = findViewById(R.id.viewDica)
        this.viewPalavra = findViewById(R.id.viewPalavra)
        this.viewJogo = findViewById(R.id.viewJogo)
        this.viewDica.text = this.jogo.dica()
        this.viewPalavra.text = this.jogo.palavra()
        this.viewJogo.text = this.jogo.tentativas().toString()
    }


}