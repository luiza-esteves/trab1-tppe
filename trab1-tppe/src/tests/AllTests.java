package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ adicionarClienteTest.class, adicionarProdutoTest.class, adicionarVendaTeste.class, atualizarTiposDeClientesTest.class, calcularCashbackTest.class, calculoDescontoTeste.class, calculoFrete.class, calculoImpostoTeste.class, verificaCartaoLojaTeste.class})
public class AllTests {

}
