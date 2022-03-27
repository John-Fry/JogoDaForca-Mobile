package com.example.jogodaforca.fachada;
import com.example.jogodaforca.modelo.JogoDaForca;
import com.example.jogodaforca.repositorio.BancoPalavras;


class Fachada {

    private var banco = BancoPalavras()
    private lateinit var jogoDaForca: JogoDaForca

    fun adicionar() {
        this.banco.add("Bola", "Usado no futebol")
        this.banco.add("Pastel", "Comida desprovida de recheio")
    }

    fun start() {
        this.adicionar()
        this.banco.sorteio()
        jogoDaForca = JogoDaForca(this.banco.palavra(), this.banco.dica(), 7)
        jogoDaForca.esconder()
    }

    fun palavra():String {
        return jogoDaForca.palavraSecreta.joinToString(" ")
    }

    fun dica():String {
        return jogoDaForca.dica
    }

    fun jogo(palavra: String) {
        try {
            jogoDaForca.verifyLetra(palavra.trim())
        }
        catch (e: Throwable) {
            println(e.message)
        }
    }

    fun esconderPalavra() {
        return jogoDaForca.esconder()
    }

    fun tamanho():Int {
        return jogoDaForca.tamanhoPalavra()
    }

    fun letrasDistintas():Int {
        return jogoDaForca.letrasDistinc()
    }

    fun tentativas():Int {
        return jogoDaForca.tentativa
    }

    fun terminou():Boolean {
        return jogoDaForca.end
    }

   fun Ganhou():Boolean {
       return jogoDaForca.acertos == jogoDaForca.tamanhoPalavra()
   }

   fun Perdeu():Boolean {
       return jogoDaForca.tentativa == 0
   }

   fun resultado():String {
       if(Ganhou()) {
           return "Você Ganhou!"
       }
       return "Você Perdeu!"
   }
}
