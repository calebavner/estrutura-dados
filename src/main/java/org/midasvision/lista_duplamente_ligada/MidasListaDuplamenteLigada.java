package org.midasvision.lista_duplamente_ligada;

public class MidasListaDuplamenteLigada<T> {

    private No<T> head;
    private No<T> tail;
    private int tamanho;

    public int size() {
        return this.tamanho;
    }

    public void addInicio(T dado) {

        if(this.size() == 0) {
            No<T> novoNo = new No<>(dado, null, null);
            this.head = novoNo;
            this.tail = novoNo;
        } else {
            No<T> novoNo = new No<>(dado, head, null);
            head.setAnterior(novoNo);
            head = novoNo;
        }
        this.tamanho++;
    }

    public void addFim(T dado) {
        if(this.size() == 0) {
            No<T> novoNo = new No<>(dado, null, null);
            this.head = novoNo;
            this.tail = novoNo;
        } else {
            No<T> novoNo = new No<>(dado, null, tail);
            tail.setProximo(novoNo);
            tail = novoNo;
        }
        this.tamanho++;
    }

    public void addPosicao(int posicao, T dado) {

        if(posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("A posição não existe");
        }

        if(this.size() == 0) {
            this.addInicio(dado);
        }

        No<T> atual = this.head;

        for(int i = 0; i < posicao - 1; i++) {
            atual = atual.getProximo();
        }

        No<T> novoNo = new No<>(dado, atual.getProximo(), atual);
        atual.setProximo(novoNo);
        atual.getProximo().setAnterior(novoNo);

        tamanho++;
    }

    @Override
    public String toString() {

        if(size() == 0) {
            return "[]";
        }

        StringBuilder s = new StringBuilder("[");
        No<T> atual = this.head;

        for(int i = 0; i < this.tamanho - 1; i++) {
            s.append(atual.getValor()).append(", ");
            atual = atual.getProximo();
        }
        s.append(atual.getValor()).append("]");

        return s.toString();
    }
}
