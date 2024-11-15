package org.midasvision.fila;

public class MidasQueue {

    private int tamanho;
    private int base;
    private int[] fila;

    public MidasQueue(int tamanho) {
        this.tamanho = tamanho;
        this.fila = new int[tamanho];
        this.base = this.fila.length;
    }

    public int qtdElementos() {
        return this.fila.length - this.base;
    }

    public int tamanhoPilha() {
        return this.tamanho;
    }

    public boolean isFull() {
        return this.base == 0;
    }

    public boolean isEmpty() {
        return this.qtdElementos() == 0;
    }

    public boolean adicionar(int e) {

        if(this.isFull()) {
            System.out.println("A fila não comporta mais elementos");
            return false;
        }

        base--;
        fila[base] = e;
        return true;
    }

    public boolean remover() {

        if(this.isEmpty()) {
            System.out.println("Não existem elementos a serem removidos");
            return false;
        }

        base++;
        return true;
    }

    public String imprimir() {

        StringBuilder s = new StringBuilder();

        if(this.isEmpty()) {
            return "A pilha esta vazia";
        }

        for(int i = base; i <= this.fila.length - 1; i++)
            s.append(this.fila[i] + " ");

        return s.toString();
    }
}
