package penha.giovanni.principal;

import penha.giovanni.modelos.Episodios;
import penha.giovanni.modelos.Filme;
import penha.giovanni.modelos.Serie;
import penha.giovanni.calculos.CalculadoraDeTempo;
import penha.giovanni.calculos.FiltroRecomendacao;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Filme meuFilme = new Filme("Harry Potter e a Pedra Filosofal", 2001);
        //meuFilme.setNome("Harry Potter e a Pedra Filosofal");
        //meuFilme.setAnoDeLancamento(2001);
        meuFilme.setGenero("Fantasia");
        meuFilme.setDuracaoEmMinutos(152);

        Filme pokemon = new Filme("Pokémon: O Filme", 1999);
        //pokemon.setAnoDeLancamento(1999);
        pokemon.setGenero("Animação");
        pokemon.setDuracaoEmMinutos(116);

        Filme ninjaAssassino = new Filme("Ninja Assassino", 2009);
        //ninjaAssassino.setAnoDeLancamento(2009);
        ninjaAssassino.setGenero("Ação");
        ninjaAssassino.setDuracaoEmMinutos(99);

        meuFilme.exibeFichaTecnica();
        meuFilme.avalia(9);
        meuFilme.avalia(9.2);
        meuFilme.avalia(8.5);
        meuFilme.avalia(9.5);

        pokemon.exibeFichaTecnica();
        pokemon.avalia(9);
        pokemon.avalia(9.5);
        pokemon.avalia(10);
        pokemon.avalia(9.8);

        ninjaAssassino.exibeFichaTecnica();
        ninjaAssassino.avalia(8);
        ninjaAssassino.avalia(6);
        ninjaAssassino.avalia(5.5);
        ninjaAssassino.avalia(5);


        System.out.println("\nA média de avaliações de " + meuFilme.getNome() + " é " + meuFilme.mediaAvaliacoes());
        System.out.println(meuFilme.getTotalAvaliacoes());

        Serie smallville = new Serie("Smallville", 2005);
        //smallville.setNome("Smallville");
        //smallville.setAnoDeLancamento(2005);
        smallville.setGenero("Aventura");
        smallville.setTemporadas(10);
        smallville.setEpisodiosPorTemporada(21);
        smallville.setMinutosPorEpisodio(40);
        smallville.exibeFichaTecnica();
        System.out.println("Para maratonar: " + smallville.getDuracaoEmMinutos() + " minutos");

        CalculadoraDeTempo calculadoraDeTempo = new CalculadoraDeTempo();

        calculadoraDeTempo.inclui(meuFilme);
        calculadoraDeTempo.inclui(pokemon);
        calculadoraDeTempo.inclui(smallville);
        System.out.println(calculadoraDeTempo.getTempoTotal() + " minutos");

        FiltroRecomendacao filtro = new FiltroRecomendacao();
        Episodios episodio = new Episodios();

        episodio.setNumero(1);
        episodio.setSerie(smallville);
        episodio.setTotalVisualiacoes(5000);
        filtro.filtra(episodio);

        ArrayList <Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(pokemon);
        listaDeFilmes.add(ninjaAssassino);

        System.out.println("Tamanho da lista: " + listaDeFilmes.size());
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());

        System.out.println("Lista de Filmes: ");
            for (Filme filme : listaDeFilmes){
                System.out.println(filme);
            }

    }
}
