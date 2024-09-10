package br.lpm.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class PessoaTest {

   public static Pessoa pessoa;
     @BeforeEach
     public void setUp() throws Exception {
       pessoa = new Pessoa();
     }
     
     @Test
     void testSetNome() {
         pessoa.setNome("Maria Silva");
         assertEquals("Maria Silva", pessoa.getNome(), "Nome válido!");

         pessoa.setNome("Maria123");
         assertEquals("Maria Silva",pessoa.getNome(), "Nome inválido não deve ser aceito!");
     }
 
     @Test
     void testSetAltura() {
         pessoa.setAltura(1.75f);
         assertEquals(1.75f, pessoa.getAltura(), "Altura válida!");
 
         pessoa.setAltura(2.80f);
         assertEquals(1.75f, pessoa.getAltura(), "Altura inválida não deve ser aceita!");
     }
 
     @Test
     void testSetPeso() {
         pessoa.setPeso(70);
         assertEquals(70, pessoa.getPeso(), "Peso válido!");
 
         pessoa.setPeso(650);
         assertEquals(70, pessoa.getPeso(), "Peso inválido não deve ser aceito!");
     }
 
     @Test
     void testSetRenda() {
         pessoa.setRenda(5000.0f);
         assertEquals(5000.0f, pessoa.getRenda(), "Renda válida!");
 
         pessoa.setRenda(-100.0f);
         assertEquals(5000.0f, pessoa.getRenda(), "Renda inválida não deve ser aceita!");
     }
 
     @Test
     void testSetDataNascimento() {
         pessoa.setDataNascimento(LocalDate.of(2000, 1, 1));
         assertEquals(LocalDate.of(2000, 1, 1), pessoa.getDataNascimento(), "Data de nascimento válida!");
 
         pessoa.setDataNascimento(LocalDate.of(2025, 1, 1));
         assertEquals(LocalDate.of(2000, 1, 1), pessoa.getDataNascimento(), "Data de nascimento inválida não deve ser aceita!");
     }
 
     @Test
     void testIsAdult() {
         pessoa.setDataNascimento(LocalDate.of(2000, 1, 1));
         assertTrue(pessoa.isAdult(), "Pessoa deve ser considerada adulta!");
 
         pessoa.setDataNascimento(LocalDate.of(2010, 1, 1));
         assertFalse(pessoa.isAdult(), "Pessoa não deve ser considerada adulta!");
     }
 
     @Test
     void testSetFeliz() {
         pessoa.setFeliz(true);
         assertTrue(pessoa.isFeliz(), "Felicidade deve ser configurada corretamente!");
     }
 
     @Test
     void testSetGenero() {
         pessoa.setGenero(Genero.FEMININO);
         assertEquals(Genero.FEMININO, pessoa.getGenero(), "Gênero deve ser configurado corretamente!");
     }
 
     @Test
     void testSetHobby() {
         pessoa.setHobby(Hobby.CINEMA);
         assertEquals(Hobby.CINEMA, pessoa.getHobby(), "Hobby deve ser configurado corretamente!");
     }
 
     @Test
     void testSetEstadoCivil() {
         pessoa.setEstadoCivil(EstadoCivil.CASADO);
         assertEquals(EstadoCivil.CASADO, pessoa.getEstadoCivil(), "Estado civil deve ser configurado corretamente!");
     }
 
     @Test
     void testSetMoradia() {
         pessoa.setMoradia(Moradia.CASA_PROPRIA);
         assertEquals(Moradia.CASA_PROPRIA, pessoa.getMoradia(), "Moradia deve ser configurada corretamente!");
     }
 
     @Test
     void testSetEscolaridade() {
         pessoa.setEscolaridade(Escolaridade.SUPERIOR);
         assertEquals(Escolaridade.SUPERIOR, pessoa.getEscolaridade(), "Escolaridade deve ser configurada corretamente!");
     }
 
     @Test
     void testSetNaturalidade() {
       pessoa.setNaturalidade("Brasileiro");
       assertEquals("Brasileiro", pessoa.getNaturalidade(), "Naturalidade deve ser configurada corretamente!");
     }

     @Test
     void testSetProfissao() {
       pessoa.setProfissao(Profissao.AUTONOMO);
       assertEquals(Profissao.AUTONOMO, pessoa.getProfissao(), "Profissão deve ser configurada corretamente!");
     }
     
     
 }