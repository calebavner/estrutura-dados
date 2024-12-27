package org.midasvision.lista_ligada;

public class MidasListaEncadeadaMain {
    public static void main(String[] args) {

        MidasListaEncadeada<Integer> lista = new MidasListaEncadeada<>();
        lista.adicionar(0);
        lista.adicionar(1);
        lista.adicionar(3);
        lista.adicionar(4);
        System.out.println(lista);
        lista.removePorPosicao(1);
        System.out.println(lista);
        No<Integer> no = new No<>(10);
        System.out.println(no);
    }
}
