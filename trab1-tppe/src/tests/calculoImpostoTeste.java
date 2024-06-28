package tests;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.Loja;
import main.Regiao;

@RunWith(Parameterized.class)
public class calculoImpostoTeste {

    private Loja loja;
    private Regiao regiao;
    private double valorCompra;
    private List<Double> valorEsperado;

    @Before
    public void setup() {
        loja = new Loja();
    }

    public calculoImpostoTeste(Regiao regiao, double valorCompra, List<Double> valorEsperado) {
        this.regiao = regiao;
        this.valorCompra = valorCompra;
        this.valorEsperado = valorEsperado;
    }

    @Parameters
    public static Iterable getParameters() {
        Object[][] parametros = new Object[][] {
            {Regiao.DistritoFederal, 100, Arrays.asList(18.0, 0.0)},
            {Regiao.CentroOeste, 100, Arrays.asList(12.0, 4.0)},
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void testeCalcularImposto() {
        List<Double> impostos = loja.calcularImposto(valorCompra, regiao);

        assertArrayEquals(impostos.toArray(), valorEsperado.toArray());
    }
}
