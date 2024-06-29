package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;

import main.Endereco;
import main.Loja;
import main.Regiao;
import main.Tipo;

@RunWith(Parameterized.class)
public class calculoFrete {

    private Loja loja;
    private Regiao regiao;
    private Endereco endereco;
    private Tipo tipo;
    private double valorEsperado;

    @Before
    public void setup() {
        loja = new Loja();
    }

    public calculoFrete(Regiao regiao, Endereco endereco, Tipo tipo, double valorEsperado) {
        this.regiao = regiao;
        this.endereco = endereco;
        this.tipo = tipo;
        this.valorEsperado = valorEsperado;
    }

    @Parameters
    public static Iterable getParameters() {
        Object[][] parametros = new Object[][] {
            {Regiao.CentroOeste, Endereco.INTERIOR, Tipo.PADRAO, 13.00},
            {Regiao.DistritoFederal, Endereco.CAPITAL, Tipo.ESPECIAL, 3.50},
            {Regiao.Nordeste, Endereco.CAPITAL, Tipo.PRIME, 0}
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void testeCalcularFrete() {
        double frete = loja.calcularFrete(regiao, endereco, tipo);

        assertEquals(frete, valorEsperado, 0.009);
    }
}
