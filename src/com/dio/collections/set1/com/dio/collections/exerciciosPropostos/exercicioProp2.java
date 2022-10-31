package com.dio.collections.set1.com.dio.collections.exerciciosPropostos;

import java.util.*;

public class exercicioProp2 {

    public static void main(String[] args) {
        Set<Linguagem> lingFav = new HashSet<>();
        lingFav.add(new Linguagem("C#", 1999, "Visual Studio"));
        lingFav.add(new Linguagem("JavaScript", 1995, "Eclipse"));
        lingFav.add(new Linguagem("Java", 1991, "IntelliJ"));

        System.out.println("--\tOrdem de Inserção\t--");

        Set<Linguagem> lingFav2 = new HashSet<>() {{
            add(new Linguagem("C#", 1999, "Visual Studio"));
            add(new Linguagem("JavaScript", 1995, "Eclipse"));
            add(new Linguagem("Java", 1991, "IntelliJ"));
        }};
        for (Linguagem favorita : lingFav2) System.out.println(favorita.getNome() + " - " + favorita.getAno() + " - " + favorita.getIde()); {
        }

        System.out.println("--\tOrdem de Natural\t--");
        Set<Linguagem> lingFav3 = new TreeSet<>(lingFav2);
        for (Linguagem favorita : lingFav3) System.out.println(favorita.getNome() + " - " + favorita.getAno() + " - " + favorita.getIde()); {

        }

        System.out.println("--\tOrdem de IDE\t--");

        Set<Linguagem> lingFav4 = new TreeSet<Linguagem>(new ComparatorIde());
        lingFav4.addAll(lingFav2);
        for (Linguagem favorita : lingFav4) System.out.println(favorita.getNome() + " - " + favorita.getAno() + " - " + favorita.getIde());

        System.out.println("--\tOrdem por Ano e Nome\t--");

        Set<Linguagem> lingFav5 = new TreeSet<Linguagem>(new ComparatorAnoENome());
        lingFav5.addAll(lingFav2);
        for (Linguagem favorita : lingFav5) System.out.println(favorita.getNome() + " - " + favorita.getAno() + " - " + favorita.getIde());

        System.out.println("--\tOrdem por Ano e IDE\t--");

        Set<Linguagem> lingFav6 = new TreeSet<Linguagem>(new ComparatorAnoEIde());
        lingFav6.addAll(lingFav2);
        for (Linguagem favorita : lingFav6) System.out.println(favorita.getNome() + " - " + favorita.getAno() + " - " + favorita.getIde());

    }
}

class Linguagem implements Comparable<Linguagem> {

    public String nome;

    public Integer ano;

    public String ide;

    public String getNome() {
        return nome;
    }

    public Integer getAno() {
        return ano;
    }

    public String getIde() {
        return ide;
    }

    public Linguagem(String nome, Integer ano, String ide) {
        this.nome = nome;
        this.ano = ano;
        this.ide = ide;
    }

    @Override
    public String toString() {
        return "Linguagem{" +
                "nome='" + nome + '\'' +
                ", ano=" + ano +
                ", ide='" + ide + '\'' +
                '}';
    }



    @Override
    public int compareTo(Linguagem Linguagem) {
        return this.nome.compareTo(Linguagem.nome);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Linguagem linguagem = (Linguagem) o;
        return nome.equals(linguagem.nome) && ano.equals(linguagem.ano) && ide.equals(linguagem.ide);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}

class ComparatorIde implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem l1, Linguagem l2) {
        return l1.ide.compareToIgnoreCase(l2.ide);
    }
}

class ComparatorAnoENome implements Comparator<Linguagem> {

    @Override
    public int compare(Linguagem l1, Linguagem l2) {
        int ano = Integer.compare(l1.ano, l2.ano);
        if (ano != 0) return ano;
        return l1.nome.compareToIgnoreCase(l2.nome);
    }
}

class ComparatorAnoEIde implements Comparator<Linguagem> {


    @Override
    public int compare(Linguagem l1, Linguagem l2) {
        int ano = Integer.compare(l1.ano, l2.ano);
        if (ano != 0) return ano;
        return l1.ide.compareToIgnoreCase(l2.ide);
    }
}