package penha.giovanni.principal;

import penha.giovanni.modelos.Filme;
import penha.giovanni.modelos.Serie;
import penha.giovanni.modelos.Titulo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class PrincipalComListas {

    public static void main(String[] args) {

        Filme meuFilme = new Filme("Harry Potter e a Pedra Filosofal", 2001);
        Filme pokemon = new Filme("Pokémon: O Filme", 1999);
        Filme ninjaAssassino = new Filme("Ninja Assassino", 2009);

        Serie smallville = new Serie("Smallville", 2005);

        meuFilme.avalia(9.5);
        pokemon.avalia(9);
        ninjaAssassino.avalia(6);

        ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(meuFilme);
        lista.add(pokemon);
        lista.add(ninjaAssassino);
        lista.add(smallville);

        for (Titulo item : lista){
            System.out.println(item);

            if (item instanceof Filme filme){
                System.out.println("Classificação: " + filme.getClassificacao());
            }
        }

        //Filme harry = meuFilme;

        //System.out.println(harry); variável de referência

        Collections.sort(lista);
        System.out.println(lista);

        lista.sort(Comparator.comparing(Titulo::getAnoDeLancamento));
        System.out.println(lista);

    }
}
