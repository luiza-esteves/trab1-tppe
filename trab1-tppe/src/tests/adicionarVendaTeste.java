package tests;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.ItemVendido;
import main.Loja;
import main.Venda;

@RunWith(Parameterized.class)
public class adicionarVendaTeste {

    private Loja loja;
    private Date dataVenda;
    private int idCliente;
    private String nomeCliente;
    private ItemVendido[] itensVendidos;
    private String metodoPagamento;
    private double valorTotal;
    private double descontoTotal;
    private double freteTotal;
    private double impostoTotal;

    @Before
    public void setup() {
        loja = new Loja();
    }

    public adicionarVendaTeste(Date dataVenda, int idCliente, String nomeCliente, ItemVendido[] itensVendidos, String metodoPagamento, double valorTotal, double descontoTotal, double freteTotal, double impostoTotal) {
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.itensVendidos = itensVendidos;
        this.metodoPagamento = metodoPagamento;
        this.valorTotal = valorTotal;
        this.descontoTotal = descontoTotal;
        this.impostoTotal = impostoTotal;
    }

    @Parameters
    public static Iterable<Object[]> getParameters() {
        ItemVendido[] itens = {new ItemVendido(1, "Item1", 10.00, 12.00), new ItemVendido(2, "Item2", 20.0, 10.00)};

        Object[][] parametros = new Object[][] {
            {new Date(), 1, "Cliente A", itens, "Cartão", 30.0, 5.0, 10.00, 20.00},
            {new Date(), 2, "Cliente B", itens, "Dinheiro", 30.0, 0.0, 10.00, 20.00},
            {new Date(), 3, "Cliente C", itens, "Débito", 0.0, 0.0, 10.00, 20.00}
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void testeAdicionarVenda() {
        Venda venda = new Venda(dataVenda, idCliente, nomeCliente, itensVendidos, metodoPagamento, valorTotal, descontoTotal, freteTotal, impostoTotal);
        loja.adicionarVendas(venda);

        List<Venda> vendas = loja.getVendas();
        assertEquals(1, vendas.size());

        Venda vendaAnalisada = vendas.get(0);
        assertEquals(this.idCliente, vendaAnalisada.getIdCliente());
        assertEquals(this.nomeCliente, vendaAnalisada.getNomeCliente());
        assertEquals(this.metodoPagamento, vendaAnalisada.getMetodoPagamento());
        assertEquals(this.valorTotal, vendaAnalisada.getValorTotal(), 0.01);
        assertEquals(this.descontoTotal, vendaAnalisada.getDescontoTotal(), 0.01);
    }

    @Test
    public void testeAdicionarMultiplasVendas() {
        Venda venda = new Venda(dataVenda, idCliente, nomeCliente, itensVendidos, metodoPagamento, valorTotal, descontoTotal, freteTotal, impostoTotal);
        loja.adicionarVendas(venda);
        loja.adicionarVendas(venda);

        List<Venda> vendas = loja.getVendas();
        assertEquals(2, vendas.size());
        assertEquals(this.idCliente, vendas.get(0).getIdCliente());
        assertEquals(this.idCliente, vendas.get(1).getIdCliente());
    }
}
