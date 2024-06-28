package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;

import main.Loja;
import main.Tipo;

@RunWith(Parameterized.class)
public class calculoDescontoTeste {

    private Loja loja;
    private Tipo tipo;
    private double valorCompra;
    private boolean cartaoLoja;
    private double valorEsperado;

    @Before
    public void setup() {
        loja = new Loja();
    }

    public calculoDescontoTeste(Tipo tipo, double valorCompra, boolean cartaoLoja, double valorEsperado) {
        this.tipo = tipo;
        this.valorEsperado = valorEsperado;
        this.cartaoLoja = cartaoLoja;
        this.valorCompra = valorCompra;
    }

    @Parameters
    public static Iterable getParameters() {
        Object[][] parametros = new Object[][] {
            {Tipo.PADRAO, 100, true, 0},
            {Tipo.PRIME, 100, true, 0},
            {Tipo.ESPECIAL, 100, false, 10},
            {Tipo.ESPECIAL, 100, true, 20},
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void testeCalcularDesconto() {
        double desconto = loja.calcularDesconto(valorCompra, tipo, cartaoLoja);

        assertEquals(desconto, valorEsperado, 0.009);
    }
}
