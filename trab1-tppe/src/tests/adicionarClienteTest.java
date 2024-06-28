package tests;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

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
public class adicionarClienteTest {

    private Loja loja;
    private String nomeCliente;
    private Tipo tipoCliente;
    private Regiao regiaoCliente;
    private Endereco enderecoCliente;

    @Before
    public void setup() {
        loja = new Loja();
    }

    public adicionarClienteTest(String nomeCliente, Tipo tipoCliente, Regiao regiaoCliente, Endereco enderecoCliente) {
        this.nomeCliente = nomeCliente;
        this.tipoCliente = tipoCliente;
        this.regiaoCliente = regiaoCliente;
        this.enderecoCliente = enderecoCliente;
    }

    @Parameters
    public static Iterable getParameters() {
        Object[][] parametros = new Object[][] {
            {"Natan", Tipo.PADRAO, Regiao.CentroOeste, Endereco.INTERIOR},
            {"Clara", Tipo.ESPECIAL, Regiao.CentroOeste, Endereco.CAPITAL},
            {"Luíza", Tipo.PRIME, Regiao.DistritoFederal, Endereco.CAPITAL},
        };

        return Arrays.asList(parametros);
    }


    @Test
    public void testeAdicionarCliente() {
        loja.adicionarClientes(nomeCliente, tipoCliente, regiaoCliente, enderecoCliente);

        List<Cliente> clientes = loja.getClientes();
        assertEquals(1, clientes.size());

        Cliente cliente = clientes.get(0);
        assertEquals(1, cliente.getId());
        assertEquals(this.nomeCliente, cliente.getNome());
        assertEquals(this.tipoCliente, cliente.getTipo());
        assertEquals(this.regiaoCliente, cliente.getRegiao());
        assertEquals(this.enderecoCliente, cliente.getEndereco());
    }

    @Test
    public void testeAdicionarMultiplosClientes() {
        loja.adicionarClientes(nomeCliente, tipoCliente, regiaoCliente, enderecoCliente);
        loja.adicionarClientes(nomeCliente, tipoCliente, regiaoCliente, enderecoCliente);

        List<Cliente> clientes = loja.getClientes();
        assertEquals(2, clientes.size());
        assertEquals(1, clientes.get(0).getId());
        assertEquals(2, clientes.get(1).getId());
    }
}
