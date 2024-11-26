package org.midasvision.lista_ligada;

public class MidasListaEncadeadaMain {
    public static void main(String[] args) {

        MidasListaEncadeada<Integer> lista = new MidasListaEncadeada<>();
        lista.adicionar(10);
        lista.adicionar(20);
        lista.adicionar(30);
        lista.adicionar(40);


        System.out.println(lista.toString());
    }
}
