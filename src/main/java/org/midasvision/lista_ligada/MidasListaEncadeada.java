package org.midasvision.lista_ligada;

public class MidasListaEncadeada<T> {

    private No<T> inicio;
    private int tamanho;


    public void adicionar(T valor) {
        var n = new No<>(valor);
        inicio = n;
        tamanho++;
    }

    public void adicionarNoFim(T valor) {

    }


    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        return "MidasListaEncadeada{" +
                "inicio=" + inicio +
                ", tamanho=" + tamanho +
                '}';
    }
}
