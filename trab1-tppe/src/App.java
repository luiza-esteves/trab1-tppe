public class App {
    public static void main(String[] args) throws Exception {
        Loja loja = new Loja();
        loja.adicionarClientes("Natan", Tipo.PADRAO, Regiao.CentroOeste, Endereco.INTERIOR);
        loja.adicionarClientes("Clara", Tipo.PRIME, Regiao.CentroOeste, Endereco.CAPITAL);
        for (Cliente cliente : loja.getClientes()) {
            System.out.println(cliente.getNome());
        }
    }
}
