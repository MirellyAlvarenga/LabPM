package test;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import business.Escolaridade;
import business.EstadoCivil;
import business.Genero;
import business.Hobby;
import business.Moradia;
import business.Pessoa;

public class PessoaTest {

    public static Pessoa pessoa;
     @BeforeEach
     public void setUp() throws Exception{
        pessoa = new Pessoa();
     }

    @Test
    void testSetAltura() {
        pessoa.setAltura(1.5f);
        assertEquals(1.5f, pessoa.getAltura(), "Altura válida!");
        pessoa.setAltura(5f);
        assertEquals(1.5f, pessoa.getAltura(), "Altura inválida!");
    }

    @Test
    void testSetDataNascimento() {

    }

    @Test
    void testSetEscolaridade() {
        pessoa.setEscolaridade(Escolaridade.FUNDAMENTAL);
        assertEquals(Escolaridade.FUNDAMENTAL, pessoa.getEscolaridade());

    }

    @Test
    void testSetEstadoCivil() {
        pessoa.setEstadoCivil(EstadoCivil.CASADO);
        assertEquals(EstadoCivil.CASADO, pessoa.getEstadoCivil());
    }

    @Test
    void testSetGenero() {
        pessoa.setGenero(Genero.MASCULINO);
        assertEquals(Genero.MASCULINO, pessoa.getGenero());
    }

    @Test
    void testSetHobby() {
        pessoa.setHobby(Hobby.ARTE);
        assertEquals(Hobby.ARTE, pessoa.getHobby());
    }

    @Test
    void testSetMoradia() {
    pessoa.setMoradia(Moradia.ALUGUEL);
    assertEquals(Moradia.ALUGUEL, pessoa.getMoradia());

    }

    @Test
    void testSetNaturalidade() {
        pessoa.setNaturalidade("BH");
        assertEquals("BH", pessoa.getNaturalidade(), "Atribuição de naturalidade válida!");
        pessoa.setNaturalidade("BH123");
        assertEquals("BH", pessoa.getNaturalidade(), "Atribuição de naturalidade inválida!");
    }

    @Test
    void testSetNome() {
        pessoa.setNome("Hugo");
        assertEquals("Hugo", pessoa.getNome(), "Atribuição de nome válido!");
        pessoa.setNome("Hugo123");
        assertEquals("Hugo", pessoa.getNome(), "Atribuição de nome inválido!");
    }

    @Test
    void testSetPeso() {
        pessoa.setPeso(53);
        assertEquals(53, pessoa.getPeso(), "Peso válido!");
        pessoa.setPeso(1000);
        assertEquals(53, pessoa.getPeso(), "Peso inválido!");
    }

    @Test
    void testSetRenda() {
        pessoa.setRenda(2356.60f);
        assertEquals(2356.60f, pessoa.getRenda(), "Renda válida!");
        pessoa.setRenda(-34f);
        assertEquals(2356.60f, pessoa.getRenda(), "Renda Inválida");


    }
}
