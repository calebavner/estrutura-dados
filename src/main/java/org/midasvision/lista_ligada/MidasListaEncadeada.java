package org.midasvision.lista_ligada;

public class MidasListaEncadeada<T> {

    private No<T> inicio;
    private No<T> fim;
    private int tamanho;


    public void adicionar(T valor) {
        var n = new No<>(valor);

        if(this.tamanho == 0) {
            this.inicio = n;
        } else {
            this.fim.setProximo(n);
        }
        this.fim = n;
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

        for(int i = 0; i < this.tamanho - 1; i++) {
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
