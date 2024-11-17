package org.midasvision.fila;

import java.util.Stack;

public class MidasQueueMain {
    public static void main(String[] args) {

        MidasQueue m = new MidasQueue(4);
        m.remover();
        m.adicionar(1);
        m.adicionar(2);
        m.adicionar(3);
        m.adicionar(4);
        m.remover();
        //m.adicionar(10);
        System.out.println(m.imprimir());
        //System.out.println(m.capacidadeFila());
        //System.out.println(m.qtdElementos());
    }
}
