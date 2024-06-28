package main;
public class App {
    public static void main(String[] args) throws Exception {
        Loja loja = new Loja();
        
        loja.adicionarProdutos("Corda", 23.24, "metros");
        loja.adicionarProdutos("Livro", 55.678, "unidades");

        System.out.println(loja.getProdutos().get(0).getPreco());
        System.out.println(loja.getProdutos().get(1).getPreco());

    }
}
