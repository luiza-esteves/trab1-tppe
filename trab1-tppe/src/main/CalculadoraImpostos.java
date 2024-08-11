package main;

import java.util.ArrayList;
import java.util.List;

/**
 * A classe CalculadoraImpostos foi criada como parte de uma refatoração  para encapsular a lógica de cálculo de impostos. 
 * Anteriormente, essa lógica estava diretamente no método calcularImposto da classe Loja, mas foi movida para essa nova classe para melhorar a organização 
 * e modularidade do código.
 * 
 * Efeitos da refatoração:
 * 1 - Separação de Responsabilidades: A refatoração moveu a lógica de cálculo de impostos da classe Loja para uma nova classe dedicada, CalculadoraImpostos.
 * Isso segue o princípio da responsabilidade única, onde cada classe tem uma única responsabilidade clara.
 * 
 * 2 - Modularidade: Agora, o código está melhor organizado, com a lógica específica de cálculo de impostos encapsulada em uma classe separada.
 * Isso torna o código mais modular, facilitando a leitura, manutenção e entendimento do que cada parte do sistema faz.
 * 
 * 3- Facilidade de Testes e Manutenção: Se houver necessidade de alterar a lógica de cálculo de impostos, isso pode ser feito diretamente na classe CalculadoraImpostos, sem a necessidade de modificar a classe Loja.
 * Isso isola o impacto de mudanças e facilita a criação e manutenção de testes unitários.
 */

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
