package br.lpm.business;

import java.util.ArrayList;
import java.util.List;

public class Dataset {
    Pessoa pessoas[] = new Pessoa[MAX_PESSOAS];
    static final int MAX_PESSOAS = 10;
    private int count = 0;
    private DistanceMeasure distanceMeasure = new DistanceMeasure();

    public void addPessoa(Pessoa pessoa) {
        if (count < MAX_PESSOAS) {
            pessoas[count++] = pessoa;
        } else {
            System.out.println("Não é possível adicionar mais pessoas!!");
        }
    }

    public void removePessoa(Pessoa pessoa) {
        for (int i = 0; i < count; i++) {
            if (pessoas[i].equals(pessoa)) {
                pessoas[i] = pessoas[count - 1];
                pessoas[count - 1] = null;
                count--;
                return;
            }
        }
    }

    public void removePessoaByName(String nome) {
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getNome().equals(nome)) {
                pessoas[i] = pessoas[count - 1];
                pessoas[count - 1] = null;
                count--;
                return;
            }
        }
    }

    public void replacePessoa(Pessoa oldPessoa, Pessoa newPessoa) {
        for (int i = 0; i < count; i++) {
            if (pessoas[i].equals(oldPessoa)) {
                pessoas[i] = newPessoa;
                return;
            }
        }
    }

    public Pessoa getPessoaByName(String nome) {
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getNome().equals(nome)) {
                return pessoas[i];
            }
        }
        return null;
    }

    public Pessoa[] getAll() {
        int pessoasNaoNulas = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                pessoasNaoNulas++;
            }
        }

        Pessoa[] retornoPessoas = new Pessoa[pessoasNaoNulas];
        int j = 0;
        for (int i = 0; i < pessoas.length; i++) {
            if (pessoas[i] != null) {
                retornoPessoas[j++] = pessoas[i];
                System.out.println("Nome: " + pessoas[i].getNome());
                System.out.println("Gênero: " + pessoas[i].getGenero());
                System.out.println("Hobby: " + pessoas[i].getHobby());
                System.out.println("Estado Civil: " + pessoas[i].getEstadoCivil());
                System.out.println("Moradia: " + pessoas[i].getMoradia());
                System.out.println("Escolaridade: " + pessoas[i].getEscolaridade());
                System.out.println("Data de Nascimento: " + pessoas[i].getDataNascimento());
                System.out.println("Altura: " + pessoas[i].getAltura());
                System.out.println("Peso: " + pessoas[i].getPeso());
                System.out.println("Renda: " + pessoas[i].getRenda());
                System.out.println("Naturalidade: " + pessoas[i].getNaturalidade());
                System.out.println("Feliz: " + pessoas[i].isFeliz());
                System.out.println("Profissão: " + pessoas[i].getProfissao());
                System.out.println("----------");

            }
        }

        return retornoPessoas;
    }

    public void removeAll() {
        for (int i = 0; i < count; i++) {
            pessoas[i] = null;
        }
        count = 0;
    }

    public int size() {
        return count;
    }

    public float maxAltura() {
        float max = Float.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getAltura() > max) {
                max = pessoas[i].getAltura();
            }
        }
        return max;
    }

    public float minAltura() {
        float min = Float.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getAltura() < min) {
                min = pessoas[i].getAltura();
            }
        }
        return min;
    }

    public float avgAltura() {
        float total = 0;
        for (int i = 0; i < count; i++) {
            total += pessoas[i].getAltura();
        }
        return total / count;
    }

    public int maxPeso() {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getPeso() > max) {
                max = pessoas[i].getPeso();
            }
        }
        return max;
    }

    public int minPeso() {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getPeso() < min) {
                min = pessoas[i].getPeso();
            }
        }
        return min;
    }

    public float avgPeso() {
        int total = 0;
        for (int i = 0; i < count; i++) {
            total += pessoas[i].getPeso();
        }
        return (float) total / count;
    }

    public float percentAdult() {
        int adults = 0;
        for (int i = 0; i < count; i++) {
            if (pessoas[i].isAdult()) {
                adults++;
            }
        }
        return (float) adults / count * 100;
    }

    public float percentEstadoCivil(EstadoCivil estadoCivil) {
        int matching = 0;
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getEstadoCivil() == estadoCivil) {
                matching++;
            }
        }
        return (float) matching / count * 100;
    }

    public EstadoCivil modeEstadoCivil() {
        if (count == 0) {
            return null;
        }

        EstadoCivil mostFrequentEstadoCivil = null;
        int maxCount = 0;

        for (int i = 0; i < count; i++) {
            EstadoCivil currentEstadoCivil = pessoas[i].getEstadoCivil();
            int currentCount = 0;

            for (int j = 0; j < count; j++) {
                if (pessoas[j].getEstadoCivil() == currentEstadoCivil) {
                    currentCount++;
                }
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentEstadoCivil = currentEstadoCivil;
            }
        }

        return mostFrequentEstadoCivil;
    }

    public float percentEscolaridade(Escolaridade escolaridade) {
        int matching = 0;
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getEscolaridade() == escolaridade) {
                matching++;
            }
        }
        return (float) matching / count * 100;
    }

    public Escolaridade modeEscolaridade() {
        if (count == 0) {
            return null;
        }

        Escolaridade mostFrequentEscolaridade = null;
        int maxCount = 0;

        for (int i = 0; i < count; i++) {
            Escolaridade currentEscolaridade = pessoas[i].getEscolaridade();
            int currentCount = 0;

            for (int j = 0; j < count; j++) {
                if (pessoas[j].getEscolaridade() == currentEscolaridade) {
                    currentCount++;
                }
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentEscolaridade = currentEscolaridade;
            }
        }

        return mostFrequentEscolaridade;
    }

    public float percentMoradia(Moradia moradia) {
        int matching = 0;
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getMoradia() == moradia) {
                matching++;
            }
        }
        return (float) matching / count * 100;
    }

    public Moradia modeMoradia() {
        if (count == 0) {
            return null;
        }

        Moradia mostFrequentMoradia = null;
        int maxCount = 0;

        for (int i = 0; i < count; i++) {
            Moradia currentMoradia = pessoas[i].getMoradia();
            int currentCount = 0;

            for (int j = 0; j < count; j++) {
                if (pessoas[j].getMoradia() == currentMoradia) {
                    currentCount++;
                }
            }

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentMoradia = currentMoradia;
            }
        }

        return mostFrequentMoradia;
    }

    public float percentHobby(Hobby hobby) {
        int matching = 0;
        for (int i = 0; i < count; i++) {
            if (pessoas[i].getHobby() == hobby) {
                matching++;
            }
        }
        return (float) matching / count * 100;
    }

    public float percentFeliz() {
        int happyPeople = 0;
        for (int i = 0; i < count; i++) {
            if (pessoas[i].isFeliz()) {
                happyPeople++;
            }
        }
        return (float) happyPeople / count * 100;
    }

    public float[] calcDistanceVector(Pessoa pessoa) {
        float[] distances = new float[count];
        for (int i = 0; i < count; i++) {
            distances[i] = distanceMeasure.calcDistance(pessoa, pessoas[i]);
        }
        return distances;
    }

    public float[][] calcDistanceMatrix() {
        float[][] matrix = new float[count][count];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < count; j++) {
                matrix[i][j] = distanceMeasure.calcDistance(pessoas[i], pessoas[j]);
            }
        }
        return matrix;
    }

    public List<Pessoa> getSimilar(Pessoa pessoa, int n) {
        List<Pessoa> similarPessoas = new ArrayList<>();
        float[] minDistances = new float[n];

        for (int i = 0; i < n; i++) {
            minDistances[i] = Float.MAX_VALUE;
        }

        for (int i = 0; i < count; i++) {
            float distance = distanceMeasure.calcDistance(pessoa, pessoas[i]);
            for (int j = 0; j < n; j++) {
                if (distance < minDistances[j]) {

                    minDistances[j] = distance;

                    if (similarPessoas.size() >= n) {
                        similarPessoas.set(j, pessoas[i]);
                    } else {

                        similarPessoas.add(pessoas[i]);
                    }

                    break;
                }
            }
        }

        return similarPessoas;
    }

    public void normalizeField(String fieldName) {
        float minValue = Float.MAX_VALUE;
        float maxValue = Float.MIN_VALUE;
        float[] values = new float[count];

        for (int i = 0; i < count; i++) {
            float value = getFieldValue(pessoas[i], fieldName);
            values[i] = value;
            if (value < minValue) {
                minValue = value;
            }
            if (value > maxValue) {
                maxValue = value;
            }
        }

        for (int i = 0; i < count; i++) {
            float normalizedValue = (values[i] - minValue) / (maxValue - minValue);
            setFieldValue(pessoas[i], fieldName, normalizedValue);
        }
    }

    private float getFieldValue(Pessoa pessoa, String fieldName) {
        switch (fieldName) {
            case "altura":
                return pessoa.getAltura();
            case "peso":
                return pessoa.getPeso();
            case "renda":
                return pessoa.getRenda();
            default:
                return 0;
        }
    }

    private void setFieldValue(Pessoa pessoa, String fieldName, float normalizedValue) {
        switch (fieldName) {
            case "altura":
                pessoa.setAltura((float) normalizedValue);
                break;
            case "peso":
                pessoa.setPeso((int) normalizedValue);
                break;
            case "renda":
                pessoa.setRenda((float) normalizedValue);
                break;
        }
    }
}
