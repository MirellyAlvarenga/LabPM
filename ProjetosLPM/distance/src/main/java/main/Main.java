package main;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import br.lpm.business.Dataset;
import br.lpm.business.Escolaridade;
import br.lpm.business.EstadoCivil;
import br.lpm.business.Genero;
import br.lpm.business.Hobby;
import br.lpm.business.Moradia;
import br.lpm.business.Pessoa;
import br.lpm.business.Profissao;

import javax.swing.JFrame;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static Dataset dataset = new Dataset();

    public static void main(String[] args) {
        Pessoa pessoa1 = new Pessoa();
        pessoa1.setNome("Mirelly Silva");
        pessoa1.setGenero(Genero.FEMININO);
        pessoa1.setHobby(Hobby.ARTE);
        pessoa1.setEstadoCivil(EstadoCivil.SOLTEIRO);
        pessoa1.setMoradia(Moradia.ALUGUEL);
        pessoa1.setEscolaridade(Escolaridade.SUPERIOR);
        pessoa1.setDataNascimento(LocalDate.of(2000, 1, 1));
        pessoa1.setAltura(1.65f);
        pessoa1.setPeso(55);
        pessoa1.setRenda(2000.0f);
        pessoa1.setNaturalidade("Brasileira");
        pessoa1.setFeliz(true);
        pessoa1.setProfissao(Profissao.AUTONOMO);

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setNome("Hugo Pereira");
        pessoa2.setGenero(Genero.MASCULINO);
        pessoa2.setHobby(Hobby.CINEMA);
        pessoa2.setEstadoCivil(EstadoCivil.CASADO);
        pessoa2.setMoradia(Moradia.CASA_PROPRIA);
        pessoa2.setEscolaridade(Escolaridade.FUNDAMENTAL);
        pessoa2.setDataNascimento(LocalDate.of(1995, 6, 15));
        pessoa2.setAltura(1.80f);
        pessoa2.setPeso(75);
        pessoa2.setRenda(3500.0f);
        pessoa2.setNaturalidade("Brasileiro");
        pessoa2.setFeliz(false);
        pessoa2.setProfissao(Profissao.DENTISTA);

        dataset.addPessoa(pessoa1);
        dataset.addPessoa(pessoa2);

        for (Pessoa p : dataset.getAll()) {
            if (p != null) {
                System.out.println("Nome: " + p.getNome());
                System.out.println("Gênero: " + p.getGenero());
                System.out.println("Hobby: " + p.getHobby());
                System.out.println("Estado Civil: " + p.getEstadoCivil());
                System.out.println("Moradia: " + p.getMoradia());
                System.out.println("Escolaridade: " + p.getEscolaridade());
                System.out.println("Data de Nascimento: " + p.getDataNascimento());
                System.out.println("Altura: " + p.getAltura());
                System.out.println("Peso: " + p.getPeso());
                System.out.println("Renda: " + p.getRenda());
                System.out.println("Naturalidade: " + p.getNaturalidade());
                System.out.println("Feliz: " + p.isFeliz());
                System.out.println("Profissão: " + p.getProfissao());
                System.out.println();
            }
        }

        histogramFormacaoAcademica();
        pieProfissao();
    }


    public static void histogramFormacaoAcademica() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        Map<Escolaridade, Integer> formacaoCount = new HashMap<>();
        for (Pessoa pessoa : Main.dataset.getAll()) {
            if (pessoa != null) {
                Escolaridade escolaridade = pessoa.getEscolaridade();
                formacaoCount.put(escolaridade, formacaoCount.getOrDefault(escolaridade, 0) + 1);
            }
        }

        for (Map.Entry<Escolaridade, Integer> entry : formacaoCount.entrySet()) {
            dataset.addValue(entry.getValue(), "Formação Acadêmica", entry.getKey().toString());
        }

        JFreeChart chart = ChartFactory.createBarChart(
                "Distribuição das Formações Acadêmicas",
                "Formação Acadêmica",
                "Quantidade",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame("Histograma de Formação Acadêmica");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    @SuppressWarnings("unchecked")
    public static void pieProfissao() {
        @SuppressWarnings("rawtypes")
        DefaultPieDataset pieDataset = new DefaultPieDataset();

        Map<String, Integer> profissaoCount = new HashMap<>();
        for (Pessoa pessoa : Main.dataset.getAll()) {
            if (pessoa != null) {
           
                String profissao = pessoa.getProfissao().name();
                profissaoCount.put(profissao, profissaoCount.getOrDefault(profissao, 0) + 1);
            }
        }

   
        for (Map.Entry<String, Integer> entry : profissaoCount.entrySet()) {
            pieDataset.setValue(entry.getKey(), entry.getValue());
        }

        JFreeChart pieChart = ChartFactory.createPieChart(
                "Distribuição das Profissões", 
                pieDataset, 
                true, 
                true,
                false 
        );

        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new java.awt.Dimension(800, 600));

        JFrame frame = new JFrame("Gráfico de Pizza - Profissões");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

}
