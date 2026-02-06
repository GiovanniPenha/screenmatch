package penha.giovanni.modelos;

import com.google.gson.annotations.SerializedName;
import penha.giovanni.excecao.ErroConversaoDeAnoException;

public class Titulo implements Comparable<Titulo> {

    //@SerializedName("Title")
    private String nome;
    //@SerializedName("Year")
    private int anoDeLancamento;
    private String genero;
    private int duracaoEmMinutos;

    private double somaAvaliacoes;
    private int totalAvaliacoes;

    public Titulo (String nome, int anoDeLancamento){
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {
        this.nome = meuTituloOmdb.title();

        if (meuTituloOmdb.year().length() > 4){
            throw new ErroConversaoDeAnoException("Não foi possível converter o ano");
        }
        this.anoDeLancamento = Integer.valueOf(meuTituloOmdb.year());
        this.duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0, 3));
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getGenero() {
        return genero;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setDuracaoEmMinutos(int duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }


    public int getTotalAvaliacoes(){

        return totalAvaliacoes;
    }

    public void exibeFichaTecnica(){

        System.out.println("Título: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
        System.out.println("Gênero: " + genero);
        //System.out.println("Duração: " + duracaoEmMinutos + " minutos");
        System.out.println("");
    }

    public void avalia(double nota){

        somaAvaliacoes += nota;
        totalAvaliacoes ++;
    }

    public double mediaAvaliacoes(){

        return somaAvaliacoes / totalAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return this.getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "(nome: " + nome +
                ", anoDeLancamento: " + anoDeLancamento +
                ", Duração: " + duracaoEmMinutos + " min.)";
    }
}
