package org.midasvision.lista_duplamente_ligada;

public class MidasListaDuplamenteLigadaMain {
    public static void main(String[] args) {

        MidasListaDuplamenteLigada<Integer> lista = new MidasListaDuplamenteLigada<>();
        lista.addInicio(10);
        lista.addInicio(20);
        lista.addFim(30);
        lista.addInicio(40);
        lista.addFim(50);
        lista.addPosicao(3, 5);
        lista.addPosicao(1, 100);
        lista.addPosicao(10, 200);
        System.out.println(lista);
    }
}
