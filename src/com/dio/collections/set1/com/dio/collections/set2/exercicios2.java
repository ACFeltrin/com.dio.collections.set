package com.dio.collections.set1.com.dio.collections.set2;

import java.util.*;

public class exercicios2 {
    public static void main(String[] args) {
        System.out.println("--\tOrdem Aleatória\t--");
        Set<Serie> minhasSeries = new HashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};
        for (Serie serie: minhasSeries) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEp()); {

        }
        System.out.println("--\tOrdem de Inserção\t--");
        Set<Serie> minhasSeries1 = new HashSet<>() {{
            add(new Serie("got", "fantasia", 60));
            add(new Serie("dark", "drama", 60));
            add(new Serie("that '70s show", "comedia", 25));
        }};
        for (Serie serie: minhasSeries1) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEp()); {

        }
        System.out.println("--\tTempo Episodio\t--");
        Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
        for (Serie serie: minhasSeries2) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEp()); {

        }

        System.out.println("--\tOrdem Nome/genero/Tempo Episodio\t--");
        Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroETempoEp());
        minhasSeries3.addAll(minhasSeries);
        for (Serie serie: minhasSeries3) System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEp()); {

        }


    }
}
class Serie implements Comparable<Serie> {
    private String nome;
    private String genero;
    private Integer tempoEp;

    public Serie(String nome, String genero, Integer tempoEp) {
        this.nome = nome;
        this.genero = genero;
        this.tempoEp = tempoEp;
    }

    public String getNome() {
        return nome;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getTempoEp() {
        return tempoEp;
    }

    @Override
    public String toString() {
        return "Serie{" +
                "nome='" + nome + '\'' +
                ", genero='" + genero + '\'' +
                ", tempoEp=" + tempoEp +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Serie serie = (Serie) o;
        return nome.equals(serie.nome) && genero.equals(serie.genero) && tempoEp.equals(serie.tempoEp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, genero, tempoEp);
    }

    @Override
    public int compareTo(Serie serie) {
        int tempoEp = Integer.compare(this.getTempoEp(), serie.getTempoEp());
        if (tempoEp != 0) return tempoEp;

        return this.getGenero().compareTo(serie.getGenero());

    }
}

class ComparatorNomeGeneroETempoEp implements Comparator<Serie>{




    @Override
    public int compare(Serie s1, Serie s2) {
        int nome = s1.getNome().compareTo(s2.getNome());
        if (nome != 0) return nome;

        int genero = s1.getGenero().compareTo(s2.getGenero());
        if (genero != 0) return genero;

        return Integer.compare(s1.getTempoEp(), s2.getTempoEp());

    }
}