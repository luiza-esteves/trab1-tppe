package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private static int contadorIdCliente = 1;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Cliente> clientes = new ArrayList<>();
        List<Produto> produtos = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1- Cadastro Cliente");
            System.out.println("2- Cadastro Produto");
            System.out.println("3- Cadastro Venda");
            System.out.println("4- Sair");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 4) break;

            switch (opcao) {
                case 1:
                    int id = contadorIdCliente++;
                    System.out.print("Digite o nome: ");
                    String nome = scanner.nextLine();

                    System.out.println("Tipos de cliente:");
                    Tipo[] tipos = Tipo.values();
                    for (int i = 0; i < tipos.length; i++) {
                        System.out.println((i + 1) + " - " + tipos[i]);
                    }
                    System.out.print("Digite o número do tipo de cliente: ");
                    int tipoIndex = scanner.nextInt();
                    scanner.nextLine();
                    Tipo tipo = tipos[tipoIndex - 1];

                    System.out.println("Regiões:");
                    Regiao[] regioes = Regiao.values();
                    for (int i = 0; i < regioes.length; i++) {
                        System.out.println((i + 1) + " - " + regioes[i]);
                    }
                    System.out.print("Digite o número da região: ");
                    int regiaoIndex = scanner.nextInt();
                    scanner.nextLine();
                    Regiao regiao = regioes[regiaoIndex - 1];

                    System.out.println("Endereços:");
                    Endereco[] enderecos = Endereco.values();
                    for (int i = 0; i < enderecos.length; i++) {
                        System.out.println((i + 1) + " - " + tipos[i]);
                    }
                    System.out.print("Informe o número que identifica o tipo de endereço: ");
                    int tipoEndereco = scanner.nextInt();
                    scanner.nextLine();
                    Endereco endereco = enderecos[tipoEndereco - 1];

                    clientes.add(new Cliente(id,nome, tipo, regiao, endereco)); //usar metodo de adicionar cliente da loja
                    break;

                case 2:
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Digite o preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite a unidade: ");
                    String unidade = scanner.nextLine();

                    produtos.add(new Produto(1,descricao, preco, unidade));//adicionar metodo da loja
                    break;

                case 3:
                    System.out.println("Clientes:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println(i + 1 + " - " + clientes.get(i));
                    }
                    System.out.print("Selecione o cliente: ");
                    Cliente cliente = clientes.get(scanner.nextInt() - 1);
                    scanner.nextLine();

                    List<Produto> produtosSelecionados = new ArrayList<>();
                    while (true) {
                        //calcular valor total da compra
                        System.out.println("Produtos:");
                        for (int i = 0; i < produtos.size(); i++) {
                            System.out.println(i + 1 + " - " + produtos.get(i));
                        }
                        System.out.print("Selecione o produto (0 para terminar): ");
                        int produtoIndex = scanner.nextInt();
                        if (produtoIndex == 0) break;
                        produtosSelecionados.add(produtos.get(produtoIndex - 1));
                        scanner.nextLine();
                    }

                    System.out.println("Formas de pagamento:");
                    FormaPagamento[] formasPagamento = FormaPagamento.values();
                    for (int i = 0; i < formasPagamento.length; i++) {
                        System.out.println((i + 1) + " - " + formasPagamento[i]);
                    }
                    System.out.print("Digite o número da forma de pagamento: ");
                    int pagamentoIndex = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    FormaPagamento formaPagamento = formasPagamento[pagamentoIndex - 1];

                    String numeroCartao = null;
                    if (formaPagamento == FormaPagamento.CREDITO) { //usar metodo de verificação do numero
                        System.out.print("Digite o número do cartão (16 dígitos): ");
                        numeroCartao = scanner.nextLine();
                    }//else pra retornar false

                    double frete = Loja.calcularFrete();
                    double desconto = Loja.calcularDesconto();
                    double imposto = Loja.calcularImposto();//fazer loop pra calcular pelos itens
                    //verificar prime e cashback


                    Venda venda = new Venda(cliente, produtosSelecionados, formaPagamento, numeroCartao);
                    System.out.println(venda);
                    //calcular cashback
                    //verificar clientes especiais
                    break;
            }
        }

        scanner.close();
    }
}
