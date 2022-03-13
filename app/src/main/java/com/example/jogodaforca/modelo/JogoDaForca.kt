package com.example.jogodaforca.modelo;


class JogoDaForca {
    public var palavra: String
    public var dica: String
    public var tentativa: Int
    public var palavraSecreta = mutableListOf<Char>()
    public var end = false
    public var letrasUtilizadas: String = String()

    constructor(palavra: String, dica: String, tentativa: Int){
        this.tamanhoPalavra()
        this.palavra = palavra
        this.dica = dica
        this.tentativa = tentativa
    }

    fun esconder() {
        for (i in 0 until palavra.length) {
            palavraSecreta.add('_')
        }
    }

    fun getLetrasUsed():String {
        return letrasUtilizadas
    }

    fun tamanhoPalavra(): Int {
        return palavraSecreta.size
    }

    fun letrasDistinc(): Int {
        return palavra.lowercase().chars().distinct().count().toInt()
    }

    fun letrasUsed(letra: String){
        if (letrasUtilizadas.contains(letra[0])) {
            throw Throwable(
                    "Letra Utilizada: ${letra[0]}"
            )

        }
        else {
            letrasUtilizadas += "${letra[0]} "
        }
    }

    fun verifyLetra(letra: String) {
        try {
            var tentativaErro = false
            letrasUsed(letra)
            for ((i, item) in palavra.lowercase().withIndex()) {
                if (letra[0].lowercaseChar() == item.lowercaseChar()) {
                    tentativaErro = true
                    palavraSecreta[i] =  letra[0].uppercaseChar()
                }
            }
            if (!palavraSecreta.contains('_')) {
                EndGame()
                return
            }
            if (!tentativaErro) {
                tentativa--
            }
        }
        catch (e: Throwable){
            println(e.message)
        }
    }

    fun EndGame() {
        end = true
        if (palavraSecreta.contains('_')) {
            println("Perdeu!")
            println("A palavra era $palavra")
        } else {
            println("Ganhou!")
            println("Tentativas $tentativa")
            println("A palavra era $palavra")
        }

    }
}
