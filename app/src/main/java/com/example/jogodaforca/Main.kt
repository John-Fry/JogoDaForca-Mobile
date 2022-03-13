package com.example.jogodaforca
import com.example.jogodaforca.fachada.Fachada

fun main(args: Array<String>) {

    val fachada = Fachada()
    fachada.adicionar()
    fachada.start()

    println("|-------------- JOGO DA FORCA --------------|")
    println("A Palavra a adivinhar tem ${fachada.tamanho()}, dentre as quais ${fachada.letrasDistintas()} são distintas")
    println("Dica: ${fachada.dica()}")
    println("Palavra: ${fachada.palavra()}")

    while(!fachada.terminou()){
        fachada.jogo()
        println("Palavra: ${fachada.palavra()}")
        println("Tentativas: ${fachada.tentativas()}")
    }
}