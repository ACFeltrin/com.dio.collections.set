package com.dio.collections.set1.com.dio.collections.exerciciosPropostos;

import java.util.*;

public class exercicioProp1 {
    public static void main(String[] args) {
        System.out.println("\nCrie um conjunto contendo as cores do arco-iris");
        System.out.println("-------------");
        Set<String> cores = new HashSet<>(Arrays.asList("vermelho", "laranja", "amarelo", "verde","azul", "anil", "violeta"));
        System.out.println("Exiba as cores uma abaixo da outra: ");
        for (String cor : cores) {
            System.out.println(cor);
        }

        System.out.println("Quantas cores possui no Arco-Iris: " + cores.size());

        System.out.println("Exiba as cores em ordem alfabética: ");
        Set<String> cores2 = new TreeSet<>(cores);
        System.out.println(cores2);

        List<String> cores3 = new ArrayList<>(cores);

        Collections.reverse(cores3);

        System.out.println("Exiba as cores em ordem reversa: ");
        System.out.println(cores3);

        System.out.println("Exiba as cores que começam com a letra ”V”: ");
        for (String cor: cores) {
            if(cor.startsWith("v")) System.out.println(cor);
        }

        System.out.println("Remova as cores que não começam com a letra ”V”: ");

        Iterator<String> cor2 = cores.iterator();
        while (cor2.hasNext()) {
            if(!cor2.next().startsWith("v")) cor2.remove();

        }
        System.out.println(cores);

        System.out.println("\n----------\n");

        System.out.println("Limpe o conjunto");
        cores.clear();

        System.out.println("\nO conjunto foi limpo: " + cores.isEmpty());

    }
}
