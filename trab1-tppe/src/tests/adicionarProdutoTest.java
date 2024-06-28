package tests;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import main.Loja;
import main.Produto;

@RunWith(Parameterized.class)
public class adicionarProdutoTest {

    private Loja loja;
    private String descricaoProduto;
    private double precoProduto;
    private String medidaProduto;

    @Before
    public void setup() {
        loja = new Loja();
    }

    public adicionarProdutoTest(String descricaoProduto, double precoProduto, String medidaProduto) {
        this.descricaoProduto = descricaoProduto;
        this.precoProduto = precoProduto;
        this.medidaProduto = medidaProduto;
    }

    @Parameters
    public static Iterable getParameters() {
        Object[][] parametros = new Object[][] {
            {"Livro", 45.50, "unidade"},
            {"Corda", 10.569, "1 metro"},
        };

        return Arrays.asList(parametros);
    }

    @Test
    public void testeAdicionarProduto() {
        loja.adicionarProdutos(descricaoProduto, precoProduto, medidaProduto);

        List<Produto> produtos = loja.getProdutos();
        assertEquals(1, produtos.size());

        Produto produto = produtos.get(0);
        assertEquals(1, produto.getId());
        assertEquals(this.descricaoProduto, produto.getDescricao());
        assertEquals(this.precoProduto, produto.getPreco(), 0.009);
        assertEquals(this.medidaProduto, produto.getMedida());
    }

    @Test
    public void testeAdicionarMultiplosProdutos() {
        loja.adicionarProdutos(descricaoProduto, precoProduto, medidaProduto);
        loja.adicionarProdutos(descricaoProduto, precoProduto, medidaProduto);

        List<Produto> produtos = loja.getProdutos();
        assertEquals(2, produtos.size());
        assertEquals(1, produtos.get(0).getId());
        assertEquals(2, produtos.get(1).getId());
    }
}
