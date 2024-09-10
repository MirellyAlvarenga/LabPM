package br.lpm.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatasetTest {

    private Dataset dataset = new Dataset();


    @BeforeEach
    void setUp() {
        dataset = new Dataset();

        Pessoa p1 = new Pessoa();
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

        Pessoa p2 = new Pessoa();
        p2.setNome("Pessoa2");
        p2.setAltura(1.70f);
        p2.setPeso(65);
        p2.setRenda(2800f);
        p2.setGenero(Genero.FEMININO);
        p2.setEstadoCivil(EstadoCivil.SOLTEIRO);
        p2.setHobby(Hobby.ARTE);
        p2.setMoradia(Moradia.ALUGUEL);
        p2.setEscolaridade(Escolaridade.MEDIO);
        p2.setProfissao(Profissao.DENTISTA);
        p2.setFeliz(false);

        Pessoa p3 = new Pessoa();
        p3.setNome("Pessoa3");
        p3.setAltura(1.75f);
        p3.setPeso(80);
        p3.setRenda(3200f);
        p3.setGenero(Genero.MASCULINO);
        p3.setEstadoCivil(EstadoCivil.CASADO);
        p3.setHobby(Hobby.CINEMA);
        p3.setMoradia(Moradia.CASA_PROPRIA);
        p3.setEscolaridade(Escolaridade.FUNDAMENTAL);
        p3.setProfissao(Profissao.AUTONOMO);
        p3.setFeliz(true);

    //    dataset.addPessoa(p1);
    //    dataset.addPessoa(p2);
    //    dataset.addPessoa(p3);
    }

    @Test
    void testAddPessoa() {
        Pessoa pessoa = new Pessoa();
        dataset.addPessoa(pessoa);
        assertEquals(1, dataset.size(), "Pessoa adicionada corretamente!");
    }

    @Test
    void testRemovePessoa() {
        Pessoa pessoa = new Pessoa();
        dataset.addPessoa(pessoa);
        dataset.removePessoa(pessoa);
        assertEquals(0, dataset.size(), "Pessoa removida corretamente!");
    }

    @Test
    void testRemovePessoaByName() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        dataset.addPessoa(pessoa);
        dataset.removePessoaByName("Maria");
        assertEquals(0, dataset.size(), "Pessoa removida pelo nome corretamente!");
    }

    @Test
    void testReplacePessoa() {
        Pessoa pessoa1 = new Pessoa();
        Pessoa pessoa2 = new Pessoa();

        dataset.addPessoa(pessoa1);
        dataset.replacePessoa(pessoa1, pessoa2);

        Pessoa[] allPessoas = dataset.getAll();
        assertEquals(1, allPessoas.length, "O dataset deve conter exatamente 1 pessoa.");
        assertEquals(pessoa2, allPessoas[0], "Pessoa substituída corretamente!");
    }

    @Test
    void testGetPessoaByName() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Maria");
        dataset.addPessoa(pessoa);
        Pessoa found = dataset.getPessoaByName("Maria");
        assertEquals("Maria", found.getNome(), "Pessoa encontrada pelo nome corretamente!");
    }

    @Test
    void testGetAll() {
        Pessoa pessoa = new Pessoa();
        dataset.addPessoa(pessoa);
        Pessoa[] all = dataset.getAll();
        assertEquals(1, all.length, "Todas as pessoas recuperadas corretamente!");
    }

    @Test
    void testRemoveAll() {
        Pessoa pessoa = new Pessoa();
        dataset.addPessoa(pessoa);
        dataset.removeAll();
        assertEquals(0, dataset.size(), "Todas as pessoas removidas corretamente!");
    }

    @Test
    void testMaxAltura() {
        Pessoa pessoa = new Pessoa();
        pessoa.setAltura(1.65f);
        dataset.addPessoa(pessoa);
        assertEquals(1.65f, dataset.maxAltura(), "Altura máxima calculada corretamente!");
    }

    @Test
    void testMinAltura() {
        Pessoa pessoa = new Pessoa();
        pessoa.setAltura(1.65f);
        dataset.addPessoa(pessoa);
        assertEquals(1.65f, dataset.minAltura(), "Altura mínima calculada corretamente!");
    }

    @Test
    void testAvgAltura() {
        Pessoa pessoa = new Pessoa();
        pessoa.setAltura(1.65f);
        dataset.addPessoa(pessoa);
        assertEquals(1.65f, dataset.avgAltura(), "Altura média calculada corretamente!");
    }

    @Test
    void testMaxPeso() {
        Pessoa pessoa = new Pessoa();
        pessoa.setPeso(55);
        dataset.addPessoa(pessoa);
        assertEquals(55, dataset.maxPeso(), "Peso máximo calculado corretamente!");
    }

    @Test
    void testMinPeso() {
        Pessoa pessoa = new Pessoa();
        pessoa.setPeso(55);
        dataset.addPessoa(pessoa);
        assertEquals(55, dataset.minPeso(), "Peso mínimo calculado corretamente!");
    }

    @Test
    void testAvgPeso() {
        Pessoa pessoa = new Pessoa();
        pessoa.setPeso(55);
        dataset.addPessoa(pessoa);
        assertEquals(55, dataset.avgPeso(), "Peso médio calculado corretamente!");
    }

    @Test
    void testPercentAdult() {
        Pessoa pessoa = new Pessoa();
        pessoa.setDataNascimento(LocalDate.of(2000, 1, 1));
        dataset.addPessoa(pessoa);
        assertEquals(100, dataset.percentAdult(), 0.01f, "Percentual de adultos calculado corretamente!");
    }

    @Test
    void testPercentEstadoCivil() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEstadoCivil(EstadoCivil.SOLTEIRO);
        dataset.addPessoa(pessoa);
        assertEquals(100, dataset.percentEstadoCivil(EstadoCivil.SOLTEIRO), 0.01f,
                "Percentual de estado civil calculado corretamente!");
    }

    @Test
    void testModeEstadoCivil() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEstadoCivil(EstadoCivil.SOLTEIRO);
        dataset.addPessoa(pessoa);
        assertEquals(EstadoCivil.SOLTEIRO, dataset.modeEstadoCivil(), "Moda de estado civil calculada corretamente!");
    }

    @Test
    void testPercentEscolaridade() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEscolaridade(Escolaridade.SUPERIOR);
        dataset.addPessoa(pessoa);
        assertEquals(100, dataset.percentEscolaridade(Escolaridade.SUPERIOR), 0.01f,
                "Percentual de escolaridade calculado corretamente!");
    }

    @Test
    void testModeEscolaridade() {
        Pessoa pessoa = new Pessoa();
        pessoa.setEscolaridade(Escolaridade.SUPERIOR);
        dataset.addPessoa(pessoa);
        assertEquals(Escolaridade.SUPERIOR, dataset.modeEscolaridade(), "Moda de escolaridade calculada corretamente!");
    }

    @Test
    void testPercentMoradia() {
        Pessoa pessoa = new Pessoa();
        pessoa.setMoradia(Moradia.ALUGUEL);
        dataset.addPessoa(pessoa);
        assertEquals(100, dataset.percentMoradia(Moradia.ALUGUEL), 0.01f,
                "Percentual de moradia calculado corretamente!");
    }

    @Test
    void testModeMoradia() {
        Pessoa pessoa = new Pessoa();
        pessoa.setMoradia(Moradia.ALUGUEL);
        dataset.addPessoa(pessoa);
        assertEquals(Moradia.ALUGUEL, dataset.modeMoradia(), "Moda de moradia calculada corretamente!");
    }

    @Test
    void testPercentHobby() {
        Pessoa pessoa = new Pessoa();
        pessoa.setHobby(Hobby.ARTE);
        dataset.addPessoa(pessoa);
        assertEquals(100, dataset.percentHobby(Hobby.ARTE), 0.01f, "Percentual de hobby calculado corretamente!");
    }

    @Test
    void testPercentFeliz() {
        Pessoa pessoa = new Pessoa();
        pessoa.setFeliz(true);
        dataset.addPessoa(pessoa);
        assertEquals(100, dataset.percentFeliz(), 0.01f, "Percentual de felicidade calculado corretamente!");
    }

    @Test
    void testGetSimilar() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("PessoaTest");
        pessoa.setAltura(1.75f);
        pessoa.setPeso(70);
        pessoa.setRenda(3000f);
        pessoa.setGenero(Genero.MASCULINO);
        pessoa.setEstadoCivil(EstadoCivil.CASADO);
        pessoa.setHobby(Hobby.CINEMA);
        pessoa.setMoradia(Moradia.CASA_PROPRIA);
        pessoa.setEscolaridade(Escolaridade.FUNDAMENTAL);
        pessoa.setProfissao(Profissao.AUTONOMO);
        pessoa.setFeliz(true);
    
        dataset.addPessoa(pessoa);
    
        List<Pessoa> similarPessoas = dataset.getSimilar(pessoa, 2);
    
        assertNotNull(similarPessoas, "A lista de pessoas similares não deve ser nula.");
        assertTrue(similarPessoas.size() <= 2, "A lista de pessoas similares deve conter no máximo 2 pessoas.");
    
    
        assertTrue(similarPessoas.contains(pessoa), "A pessoa adicionada deve estar na lista de similares.");
    }
    
    @Test
    void testCalcDistanceVector() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("PessoaTest");
        pessoa.setAltura(1.75f);
        pessoa.setPeso(70);
        pessoa.setRenda(3000f);
        pessoa.setGenero(Genero.MASCULINO);
        pessoa.setEstadoCivil(EstadoCivil.CASADO);
        pessoa.setHobby(Hobby.CINEMA);
        pessoa.setMoradia(Moradia.CASA_PROPRIA);
        pessoa.setEscolaridade(Escolaridade.FUNDAMENTAL);
        pessoa.setProfissao(Profissao.AUTONOMO);
        pessoa.setFeliz(true);
    
        dataset.addPessoa(pessoa);
    
        float[] distances = dataset.calcDistanceVector(pessoa);
    
        assertNotNull(distances, "O vetor de distâncias não deve ser nulo.");
        assertEquals(dataset.size(), distances.length, "O vetor de distâncias deve ter o mesmo tamanho que o número de pessoas no dataset.");
    
      
    }
    
    @Test
    void testCalcDistanceMatrix() {
        float[][] matrix = dataset.calcDistanceMatrix();
    
        assertNotNull(matrix, "A matriz de distâncias não deve ser nula.");
        assertEquals(dataset.size(), matrix.length, "A matriz de distâncias deve ter o mesmo número de linhas que o número de pessoas no dataset.");
    
        for (float[] row : matrix) {
            assertEquals(dataset.size(), row.length, "Cada linha da matriz deve ter o mesmo número de colunas.");
        }
    }
    

    
}
