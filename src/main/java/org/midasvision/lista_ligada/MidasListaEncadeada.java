package org.midasvision.lista_ligada;

public class MidasListaEncadeada<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    private final int NAO_ENCONTRADO = -1;


    public void adicionar(T valor) {
        var elemento = new No<>(valor);

        if(this.tamanho == 0) {
            this.inicio = elemento;
        } else {
            this.fim.setProximo(elemento);
        }
        this.fim = elemento;
        tamanho++;
    }

    public void limparLista() {
        for(No<T> atual = this.inicio; atual != null;) {
            No<T> proximo = atual.getProximo();
            atual.setValor(null);
            atual.setProximo(null);
            atual = proximo;
        }

        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public No<T> buscarPorPosicao(int posicao) {

        if(!(posicao >= 0 && posicao <= this.tamanho)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        No<T> noAtual = this.inicio;

        for(int i = 0; i < posicao; i++) {
            noAtual = noAtual.getProximo();
        }

        return noAtual;
    }

    public T buscar(int posicao) {
        return this.buscarPorPosicao(posicao).getValor();
    }

    public int retornaPosicao(T elemento) {

        int posicao = 0;
        No<T> noAtual = this.inicio;

        while(noAtual != null) {
            if(noAtual.getValor().equals(elemento)) {
                return posicao;
            }
            posicao++;
            noAtual = noAtual.getProximo();
        }
        return NAO_ENCONTRADO;
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {

        if(this.tamanho == 0) {
            return "[]";
        }

        StringBuilder s = new StringBuilder("[");
        No<T> atual = this.inicio;

        //s.append("[" + atual.getValor() + ", ");

        for(int i = 0; i < this.tamanho() - 1; i++) {
            s.append(atual.getValor()).append(", ");
            atual = atual.getProximo();
        }
        s.append(atual.getValor()).append("]");


        /*while(atual.getProximo() != null) {
            atual = atual.getProximo();
            s.append(atual.getValor());
        }*/

        return s.toString();
    }
}
