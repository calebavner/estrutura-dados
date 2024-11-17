package org.midasvision.fila;

public class MidasQueue {

    private int tamanho;
    private int[] fila;
    private int comecoFila;
    private int fimFila;

    public MidasQueue(int tamanho) {
        this.tamanho = tamanho;
        this.fila = new int[tamanho];
        this.comecoFila = this.fila.length;
        this.fimFila = this.fila.length - 1;
    }

    public boolean isFull() {
        return this.comecoFila == 0;
    }

    public boolean isEmpty() {
        return this.qtdElementos() == 0;
    }

    public int capacidadeFila() {
        return this.tamanho;
    }

    public int qtdElementos() {
        return capacidadeFila() - comecoFila;
    }

    public boolean adicionar(int e) {

        if(this.isFull()) {
            System.out.println("Não e possivel adicionar elementos, a fila esta cheia");
            return false;
        }

        comecoFila--;
        this.fila[comecoFila] = e;
        return true;
    }

    public boolean remover() {

        if(this.isEmpty()) {
            System.out.println("Não e possivel remover elementos, a fila esta vazia");
            return false;
        }

        fimFila--;
        return true;
    }

    public String imprimir() {

        if(this.isEmpty())
            return "A fila esta vazia";

        StringBuilder s = new StringBuilder();

        for(int i = comecoFila; i <= fimFila; i++) {
            s.append(fila[i] + " ");
        }

        return s.toString();
    }
}
