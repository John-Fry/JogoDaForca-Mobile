package com.example.jogodaforca.repositorio;

class BancoPalavras() {

    private var BancoPalavras = LinkedHashMap<String, String>()
    private var palavraSorteada = String()

    fun add(palavra: String, dica: String) {
        this.BancoPalavras[palavra] = dica
    }

    fun sorteio() {
        this.palavraSorteada = this.BancoPalavras.keys.random()
    }

    fun palavra():String {
        return this.palavraSorteada
    }

    fun dica():String {
        return this.BancoPalavras.getValue(this.palavraSorteada)
    }

}
