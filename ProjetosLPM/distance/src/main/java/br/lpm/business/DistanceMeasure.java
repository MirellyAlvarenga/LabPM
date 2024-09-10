package br.lpm.business;

public class DistanceMeasure {

    public float calcDistance(Pessoa first, Pessoa second) {
        float sum = 0;
        int numAttributes = 0;

        float alturaDiff = (float) Math.pow(first.getAltura() - second.getAltura(), 2);
        sum += alturaDiff;
        numAttributes++;

        float pesoDiff = (float) Math.pow(first.getPeso() - second.getPeso(), 2);
        sum += pesoDiff;
        numAttributes++;

        float rendaDiff = (float) Math.pow(first.getRenda() - second.getRenda(), 2);
        sum += rendaDiff;
        numAttributes++;

        float generoDiff = first.getGenero() == second.getGenero() ? 0 : 1;
        sum += generoDiff;
        numAttributes++;

        float estadoCivilDiff = first.getEstadoCivil() == second.getEstadoCivil() ? 0 : 1;
        sum += estadoCivilDiff;
        numAttributes++;

        float hobbyDiff = first.getHobby() == second.getHobby() ? 0 : 1;
        sum += hobbyDiff;
        numAttributes++;

        float moradiaDiff = first.getMoradia() == second.getMoradia() ? 0 : 1;
        sum += moradiaDiff;
        numAttributes++;

        float escolaridadeDiff = first.getEscolaridade() == second.getEscolaridade() ? 0 : 1;
        sum += escolaridadeDiff;
        numAttributes++;

        float profissaoDiff = first.getProfissao() == second.getProfissao() ? 0 : 1;
        sum += profissaoDiff;
        numAttributes++;

        float felizDiff = first.isFeliz() == second.isFeliz() ? 0 : 1;
        sum += felizDiff;
        numAttributes++;

        float distance = (float) Math.sqrt(sum / numAttributes);
        distance = (float) (Math.round(distance * 100.0) / 100.0);

        return distance;
    }
    
}
