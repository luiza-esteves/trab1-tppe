package main;

import java.util.ArrayList;
import java.util.List;

public class CalculadoraImpostos {
    private double valor;
    private Regiao regiao;

    public CalculadoraImpostos(double valor, Regiao regiao) {
        this.valor = valor;
        this.regiao = regiao;
    }

    public List<Double> calcular() {
        double icms = 0;
        double municipal = 0;

        if (regiao == Regiao.DistritoFederal) {
            icms = valor * 0.18;
            municipal = 0;
        } else {
            icms = valor * 0.12;
            municipal = valor * 0.04;
        }

        List<Double> impostos = new ArrayList<>();
        impostos.add(icms);
        impostos.add(municipal);
        return impostos;
    }
}
