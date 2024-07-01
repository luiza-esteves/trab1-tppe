package tests;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.Cliente;
import main.Endereco;
import main.Loja;
import main.Regiao;
import main.Tipo;

@RunWith(Parameterized.class)
public class calcularCashbackTest {

    private Loja loja;
    private int idCliente;
    private boolean cartaoLoja;
    private double valorTotal;
    private double cashbackEsperado;

    @Before
    public void setup() {
        loja = new Loja();
        loja.adicionarClientes("Natan", Tipo.PADRAO, Regiao.CentroOeste, Endereco.CAPITAL);
        loja.adicionarClientes("Clara", Tipo.PRIME, Regiao.CentroOeste, Endereco.CAPITAL);
        loja.adicionarClientes("Luíza", Tipo.PRIME, Regiao.CentroOeste, Endereco.CAPITAL);
    }

    public calcularCashbackTest(int idCliente, boolean cartaoLoja, double valorTotal, double cashbackEsperado) {
        this.idCliente = idCliente;
        this.cartaoLoja = cartaoLoja;
        this.valorTotal = valorTotal;
        this.cashbackEsperado = cashbackEsperado;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
            {0, false, 100.0, 0},    
            {1, false, 100.0, 3.0},
            {2, true, 100.0, 5.0}
        });
    }

    @Test
    public void testeCalcularCashback() {
        loja.calcularCashback(idCliente, cartaoLoja, valorTotal);

        Cliente cliente = loja.getClientes().get(idCliente);
        assertEquals(cashbackEsperado, cliente.getCashback(), 0.01);
    }
}
