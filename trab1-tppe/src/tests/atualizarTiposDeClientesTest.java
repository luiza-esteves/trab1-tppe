package tests;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

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
import main.ItemVendido;
import main.Venda;

@RunWith(Parameterized.class)
public class atualizarTiposDeClientesTest {

    private Loja loja;
    private int idCliente;
    private Tipo tipoInicial;
    private double valorTotalUltimoMes;
    private Tipo tipoEsperado;

    @Before
    public void setup() {
        loja = new Loja();
        loja.adicionarClientes("Cliente A", tipoInicial, Regiao.Sudeste, Endereco.CAPITAL);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -1);
        Date umMesAtras = cal.getTime();

        ItemVendido[] itensVendidos = { new ItemVendido(1, "Produto 1", valorTotalUltimoMes, 0) };
        Venda venda = new Venda(umMesAtras, idCliente, "Cliente A", itensVendidos, "Cartão", valorTotalUltimoMes, 0.0,
                0.0, 0.0);
        loja.adicionarVendas(venda);
    }

    public atualizarTiposDeClientesTest(int idCliente, Tipo tipoInicial, double valorTotalUltimoMes,
            Tipo tipoEsperado) {
        this.idCliente = idCliente;
        this.tipoInicial = tipoInicial;
        this.valorTotalUltimoMes = valorTotalUltimoMes;
        this.tipoEsperado = tipoEsperado;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        return Arrays.asList(new Object[][] {
                { 1, Tipo.PADRAO, 100.0, Tipo.ESPECIAL },
                { 1, Tipo.PADRAO, 50.0, Tipo.PADRAO },
                { 1, Tipo.ESPECIAL, 50.0, Tipo.PADRAO },
                { 1, Tipo.ESPECIAL, 100.0, Tipo.ESPECIAL },
                { 1, Tipo.PRIME, 100.0, Tipo.PRIME },
        });
    }

    @Test
    public void testeAtualizarTiposDeClientes() {
        loja.atualizarTiposDeClientes();

        Cliente cliente = loja.getClientes().get(idCliente-1);
        assertEquals(tipoEsperado, cliente.getTipo());
    }
}
