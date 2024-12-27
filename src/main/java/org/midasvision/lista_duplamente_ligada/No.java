package org.midasvision.lista_duplamente_ligada;

import java.util.Objects;

public class No<T> {

    private T valor;
    private No<T> proximo;
    private No<T> anterior;

    public No(T valor) {
        this.valor = valor;
    }

    public No(T valor, No<T> proximo, No<T> anterior) {
        this.valor = valor;
        this.proximo = proximo;
        this.anterior = anterior;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public No<T> getProximo() {
        return proximo;
    }

    public void setProximo(No<T> proximo) {
        this.proximo = proximo;
    }

    public No<T> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<T> anterior) {
        this.anterior = anterior;
    }

    @Override
    public String toString() {
        return "No{" +
                "valor=" + valor +
                ", proximo=" + proximo +
                ", anterior=" + anterior +
                '}';
    }
}
