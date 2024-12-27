package org.midasvision.lista_ligada;

public class MidasListaEncadeada<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    private final int NAO_ENCONTRADO = -1;

    public void adicionaInicio(T elemento) {

        if(tamanho == 0) {
            No<T> novoNo = new No<>(elemento);
            this.inicio = novoNo;
            this.fim = novoNo;
        } else {
            No<T> novoNo = new No<>(elemento, this.inicio);
            this.inicio = novoNo;
        }

        this.tamanho++;
    }

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

    public void adicionar(int posicao, T valor) {

        if(posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posição invalida");
        }

        if(posicao == 0) {
            this.adicionaInicio(valor);
        } else if(posicao == this.tamanho) {
            this.adicionar(valor);
        } else {
            No<T> noAnterior = this.buscarPorPosicao(posicao);
            No<T> proximoNo = noAnterior.getProximo();
            No<T> novoNo = new No<>(valor, proximoNo);
            noAnterior.setProximo(novoNo);
            this.tamanho++;
        }
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

    public T removerInicio() {

        if(this.tamanho == 0) {
            throw new IllegalArgumentException("A lista esta vazia");
        }

        T removido = this.inicio.getValor();
        this.inicio = this.inicio.getProximo();
        this.tamanho--;

        if(this.tamanho == 0) {
            this.fim = null;
        }

        return removido;
    }

    public void removerFinal() {
        if(this.tamanho == 0) {
            throw new IllegalArgumentException("A lista esta vazia");
        }

        if(this.tamanho == 1) {
            this.removerInicio();
        }

        No<T> penultimo = this.buscarPorPosicao(this.tamanho - 2);
        penultimo.setProximo(null);
        this.fim = penultimo;
        this.tamanho--;
    }

    private boolean posicaoExiste(int pos) {
        return (pos >= 0 && pos <= this.tamanho);
    }

    public void removePorPosicao(int posicao) {

        if(!this.posicaoExiste(posicao)) {
            throw new IllegalArgumentException("Posição não existe");
        }

        if(posicao == 0) {
            this.removerInicio();
        }

        if(posicao == this.tamanho - 1) {
            this.removerFinal();
        }

        No<T> noAnterior = this.buscarPorPosicao(posicao - 1);
        No<T> noAtual = noAnterior.getProximo();
        No<T> noProximo = noAtual.getProximo();
        noAnterior.setProximo(noProximo);
        noAtual.setProximo(null);
        this.tamanho--;
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
