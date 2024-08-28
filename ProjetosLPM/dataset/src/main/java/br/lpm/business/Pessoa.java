package br.lpm.business;
import java.time.LocalDate;

public class Pessoa {
    private String nome;
    private Genero genero;
    private Hobby hobby;
    private EstadoCivil estadoCivil;
    private Moradia moradia;
    private Escolaridade escolaridade;
    private LocalDate dataNascimento;
    private float altura;
    private int peso;
    private float renda;
    private String naturalidade;
    private boolean feliz;

    public boolean isFeliz() {
        return feliz;
    }
    public void setFeliz(boolean feliz) {
        this.feliz = feliz;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        if (nome != null && nome.matches("[a-zA-Z ]+")) {
            this.nome = nome;
        }
    }
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Hobby getHobby() {
        return hobby;
    }
    public void setHobby(Hobby hobby) {
        this.hobby = hobby;
    }
    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }
    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    public Moradia getMoradia() {
        return moradia;
    }
    public void setMoradia(Moradia moradia) {
        this.moradia = moradia;
    }
    public Escolaridade getEscolaridade() {
        return escolaridade;
    }
    public void setEscolaridade(Escolaridade escolaridade) {
        this.escolaridade = escolaridade;
    }
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento != null && dataNascimento.isBefore(LocalDate.now())) {
            this.dataNascimento = dataNascimento;
        }
    }
    public float getAltura() {
        return altura;
    }
    public void setAltura(float altura) {
        if(altura>0 && altura<2.60){
         this.altura = altura;
        }
    }
    public int getPeso() {
        return peso;
    }
    public void setPeso(int peso) {
        if(peso>0 && peso<600){
            this.peso = peso;
        }
    }
    public float getRenda() {
        return renda;
    }
    public void setRenda(float renda) {
        if(renda>=0){
            this.renda = renda;
        }
     
    }
    public String getNaturalidade() {
        return naturalidade;
    }
    public void setNaturalidade(String naturalidade) {
        this.naturalidade = naturalidade;
    }
    

}