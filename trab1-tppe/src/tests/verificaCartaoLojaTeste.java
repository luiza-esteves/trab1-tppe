package tests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import static org.junit.Assert.*;

import java.util.Arrays;

import main.Loja;


@RunWith(Parameterized.class)
public class verificaCartaoLojaTeste {

    private Loja loja;
    private String numeroCartao;
    private boolean resultadoEsperado;

    @Before
    public void setup() {
        loja = new Loja();
    }

    public verificaCartaoLojaTeste(String numeroCartao, boolean resultadoEsperado) {
        this.numeroCartao = numeroCartao;
        this.resultadoEsperado = resultadoEsperado;
    }

    @Parameters
    public static Iterable getParameters() {
        Object[][] parametros = new Object[][] {
            {"4296136584257158", true},
            {"5487963524879645", false},
            {"souengracadinho", false}
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void testeVerificaCartaoLoja() {
        boolean resultado = loja.verificarCartaoLoja(numeroCartao);

        assertEquals(resultado, resultadoEsperado);
    }
}
