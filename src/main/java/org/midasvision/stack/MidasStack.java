package org.midasvision.stack;

import java.util.Arrays;

public class MidasStack {

    private int tamanho;
    private int[] elementos;
    private int topo;

    public MidasStack(int tamanho) {
        this.tamanho = tamanho;
        this.elementos = new int[tamanho];
        this.topo = -1;
    }

    public boolean isFull() {
        return this.topo == tamanho - 1;
    }

    public boolean isEmpty() {
        return this.qtdElementos() == 0;
    }

    public int tamanhoPilha() {
        return this.tamanho;
    }

    public int qtdElementos() {
        return this.topo + 1;
    }

    public boolean adicionar(int elemento) {

        if(isFull()) {
            System.out.println("Operação não realizada, a pilha esta cheia");
            return false;
        }

        topo++;
        elementos[topo] = elemento;
        return true;
    }

    public boolean remover() {

        if(this.isEmpty()) {
            System.out.println("Não existem elementos a serem removidos");
            return false;
        }
        topo--;
        return true;
    }

    public int exibirTopo() {
        return elementos[topo];
    }

    public String imprimir() {

        StringBuilder s = new StringBuilder();

        if(this.isEmpty()) {
            return "A pilha esta vazia";
        }

        for(int i = 0; i <= this.topo; i++)
            s.append(this.elementos[i] + " ");

        return s.toString();
    }
}
