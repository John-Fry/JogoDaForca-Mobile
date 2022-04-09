package com.example.jogodaforca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import com.example.jogodaforca.fachada.Fachada

class MainActivity : AppCompatActivity() {
    private lateinit var jogo: Fachada
    private lateinit var viewDica: TextView
    private lateinit var viewPalavra: TextView
    private lateinit var viewJogo: TextView
    private lateinit var inputLetra: EditText
    private lateinit var bntJogar: Button
    private lateinit var imageForca: ImageView

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
        this.imageForca = findViewById(R.id.imageView)
        this.viewDica.text = "Dica: ${this.jogo.dica()}"
        this.viewPalavra.text = this.jogo.palavra()
        this.viewJogo.text = "Número de tentativas: ${jogo.tentativas()}"

        this.bntJogar.setOnClickListener {
            val letra = this.inputLetra.text.toString()
            this.jogo.jogo(letra)
            this.viewPalavra.text = this.jogo.palavra()
            this.viewJogo.text = "Número de tentativas: ${jogo.tentativas()}"

            if (letra.length == 1) {
                Log.i("JogoDaForca", "${letra.uppercase().first()}")
            }else {
                Toast.makeText(this, "Jogada Inválidaa", Toast.LENGTH_SHORT).show()
            }

            if (jogo.Perdeu()) {
                this.bntJogar.isEnabled = false
                val intent = Intent(this, result::class.java).apply {
                    putExtra("Result", "Perdeu!")
                }
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }

            if (jogo.Ganhou()) {
                this.bntJogar.isEnabled = false
                val intent = Intent(this, result::class.java).apply {
                    putExtra("Result", "Ganhou!")
                }
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
            }

            var penalidade = "part${this.jogo.tentativas()}"
            this.imageForca.setImageResource(getResources().getIdentifier(penalidade , "drawable", getPackageName()))
        }
    }



}