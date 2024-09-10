package br.lpm.business;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DistanceMeasureTest {

    private Dataset dataset;
    private DistanceMeasure distanceMeasure;
    private Pessoa p1;
    private Pessoa p2;
    private Pessoa p3;

    @BeforeEach
    void setUp() {
        dataset = new Dataset();
        distanceMeasure = new DistanceMeasure(); 

        p1 = new Pessoa();
        p1.setNome("Pessoa1");
        p1.setAltura(1.80f);
        p1.setPeso(70);
        p1.setRenda(3000f);
        p1.setGenero(Genero.MASCULINO);
        p1.setEstadoCivil(EstadoCivil.CASADO);
        p1.setHobby(Hobby.ARTE);
        p1.setMoradia(Moradia.ALUGUEL);
        p1.setEscolaridade(Escolaridade.FUNDAMENTAL);
        p1.setProfissao(Profissao.AUTONOMO);
        p1.setFeliz(true);

        p2 = new Pessoa();
        p2.setNome("Pessoa2");
        p2.setAltura(1.70f);
        p2.setPeso(65);
        p2.setRenda(2800f);
        p2.setGenero(Genero.FEMININO);
        p2.setEstadoCivil(EstadoCivil.SOLTEIRO);
        p2.setHobby(Hobby.ARTE);
        p2.setMoradia(Moradia.ALUGUEL);
        p2.setEscolaridade(Escolaridade.FUNDAMENTAL);
        p2.setProfissao(Profissao.DENTISTA);
        p2.setFeliz(false);

        p3 = new Pessoa();
        p3.setNome("Pessoa3");
        p3.setAltura(1.75f);
        p3.setPeso(80);
        p3.setRenda(3200f);
        p3.setGenero(Genero.MASCULINO);
        p3.setEstadoCivil(EstadoCivil.CASADO);
        p3.setHobby(Hobby.CINEMA);
        p3.setMoradia(Moradia.ALUGUEL);
        p3.setEscolaridade(Escolaridade.FUNDAMENTAL);
        p3.setProfissao(Profissao.AUTONOMO);
        p3.setFeliz(true);

        dataset.addPessoa(p1);
        dataset.addPessoa(p2);
        dataset.addPessoa(p3);
    }

    @Test
    void testCalcDistanceBetweenP1AndP2() {
        double distance = distanceMeasure.calcDistance(p1, p2);
        distance = Math.round(distance * 100.0) / 100.0;
        assertEquals(63.27, distance); 
    }

    @Test
    void testCalcDistanceBetweenP1AndP3() {
        double distance = distanceMeasure.calcDistance(p1, p3);
        distance = Math.round(distance * 100.0) / 100.0;
        assertEquals(63.33, distance);
    }

    @Test
    void testCalcDistanceBetweenP2AndP3() {
        double distance = distanceMeasure.calcDistance(p2, p3);
        distance = Math.round(distance * 100.0) / 100.0;
        assertEquals(126.58, distance); 
    }

    @Test
    void testDistanceBetweenSamePerson() {
        double distance = distanceMeasure.calcDistance(p1, p1);
        assertEquals(0.0, distance);
    }
    
}
