package com.example.jogodaforca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.jogodaforca.fachada.Fachada

class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Fachada
    private lateinit var viewDica: TextView
    private lateinit var viewPalavra: TextView
    private lateinit var viewJogo: TextView
    private lateinit var inputLetra: EditText
    private lateinit var bntJogar: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.jogo = Fachada()
        this.jogo.start()
        this.viewDica = findViewById(R.id.viewDica)
        this.viewPalavra = findViewById(R.id.viewPalavra)
        this.viewJogo = findViewById(R.id.textView3)
        this.inputLetra = findViewById(R.id.inputLetra)
        this.bntJogar = findViewById(R.id.bntJogar)
        this.viewDica.text = this.jogo.dica()
        this.viewPalavra.text = this.jogo.palavra()
        this.viewJogo.text = "Número de tentativas ${jogo.tentativas()}"

        this.bntJogar.setOnClickListener(ButtonClick())
    }

    inner class ButtonClick: View.OnClickListener {
        override fun onClick(p0: View?) {
            val letra = this@MainActivity.inputLetra.text.toString()
            this@MainActivity.jogo.jogo(letra)
            this@MainActivity.viewPalavra.text = this@MainActivity.jogo.palavra()
            this@MainActivity.viewJogo.text = "Número de tentativas ${jogo.tentativas()}"
            if (letra.length == 1) {
                Log.i("JogoDaForca", "${letra.uppercase().first()}")
            }else {
                Toast.makeText(this@MainActivity, "Jogada Inválidaa", Toast.LENGTH_SHORT).show()
            }

            if (jogo.terminou()) {
                this@MainActivity.viewJogo.text = "Número de tentativas ${jogo.tentativas()}\n\n${jogo.resultado()}"
                this@MainActivity.bntJogar.isEnabled = false
            }
        }
    }


}