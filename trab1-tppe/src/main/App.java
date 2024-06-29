package main;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    private static int contadorIdCliente = 1;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Loja loja = new Loja();

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
                        System.out.println((i + 1) + " - " + enderecos[i]);
                    }
                    System.out.print("Informe o número que identifica o tipo de endereço: ");
                    int tipoEndereco = scanner.nextInt();
                    scanner.nextLine();
                    Endereco endereco = enderecos[tipoEndereco - 1];

                    loja.adicionarClientes(nome, tipo, regiao, endereco);

                    break;

                case 2:
                    System.out.print("Digite a descrição do produto: ");
                    String descricao = scanner.nextLine();

                    System.out.print("Digite o preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Digite a unidade: ");
                    String unidade = scanner.nextLine();

                    loja.adicionarProdutos(descricao, preco, unidade);
                    break;

                case 3:
                    List<Cliente> clientes = loja.getClientes();
                    System.out.println("Clientes:");
                    for (int i = 0; i < clientes.size(); i++) {
                        System.out.println((i + 1) + " - " + clientes.get(i).getNome());
                    }
                    int clienteIndex;
                    while (true) {
                        System.out.print("Selecione o cliente: ");
                        clienteIndex = scanner.nextInt();
                        if (clienteIndex > 0 && clienteIndex <= clientes.size()) {
                            break;
                        }
                        System.out.println("Seleção inválida, tente novamente.");
                    }
                    Cliente cliente = clientes.get(clienteIndex - 1);
                    scanner.nextLine();

                    List<Produto> produtosSelecionados = new ArrayList<>();
                    List<Produto> produtos = loja.getProdutos();
                    double subtotal = 0.0;
                    while (true) {
                        //calcular valor total da compra
                        System.out.println("Produtos:");
                        for (int i = 0; i < produtos.size(); i++) {
                            System.out.println(i + 1 + " - " + produtos.get(i).getDescricao());
                        }
                        System.out.print("Selecione o produto (0 para terminar): ");
                        int produtoIndex = scanner.nextInt();
                        while (true) {
                            produtoIndex = scanner.nextInt();
                            if (produtoIndex == 0 || (produtoIndex > 0 && produtoIndex <= produtos.size())) {
                                break;
                            }
                            System.out.println("Seleção inválida, tente novamente.");
                        }
                        if (produtoIndex == 0) break;
                        Produto produtoSelecionado = produtos.get(produtoIndex - 1);
                        produtosSelecionados.add(produtos.get(produtoIndex - 1));
                        subtotal += produtoSelecionado.getPreco();
                        scanner.nextLine();
                    }

                    System.out.println("Formas de pagamento:");
                    FormaPagamento[] formasPagamento = FormaPagamento.values();
                    for (int i = 0; i < formasPagamento.length; i++) {
                        System.out.println((i + 1) + " - " + formasPagamento[i]);
                    }
                    System.out.print("Digite o número da forma de pagamento: ");
                    int pagamentoIndex = scanner.nextInt();
                    scanner.nextLine();
                    FormaPagamento formaPagamento = formasPagamento[pagamentoIndex - 1];

                    String numeroCartao = null;
                    boolean cartaoLoja = false;
                    if (formaPagamento == FormaPagamento.CREDITO || formaPagamento == FormaPagamento.DEBITO) {
                        do {
                            System.out.print("Digite o número do cartão (16 dígitos): ");
                            numeroCartao = scanner.nextLine();
                        } while (numeroCartao.length() < 16);
                        cartaoLoja = loja.verificarCartaoLoja(numeroCartao);
                    }

                    double frete = loja.calcularFrete(cliente.getRegiao(), cliente.getEndereco(), cliente.getTipo());
                    double desconto = loja.calcularDesconto(subtotal, cliente.getTipo(), cartaoLoja);
                    List<Double> impostos = loja.calcularImposto(subtotal, cliente.getRegiao());

                    double valorTotal = subtotal + frete - desconto + impostos.stream().mapToDouble(Double::doubleValue).sum();

                    // Criar lista de itens vendidos
                    List<ItemVendido> itensVendidos = new ArrayList<>();
                    for (Produto produto : produtosSelecionados) {
                        itensVendidos.add(new ItemVendido(produto.getId(), produto.getDescricao(), produto.getPreco() * 0.12, produto.getPreco() * 0.05));
                    }
                    boolean usarCashback = false;
                    if (cliente.getTipo() == Tipo.PRIME) {
                        System.out.println("Deseja usar cashback? (1 - Sim / 2 - Não)");
                        int opcaoCashback = scanner.nextInt();
                        if (opcaoCashback == 1) {
                            usarCashback = true;
                        } else if (opcaoCashback != 2) {
                            System.out.println("Opção inválida, não utilizará cashback.");
                        }
                    }

                    if (usarCashback) {
                        System.out.println("Utilizando cashback.");
                    } else {
                        System.out.println("Não utilizando cashback.");
                    }

                    Venda venda = new Venda(new Date(), cliente.getId(), cliente.getNome(), itensVendidos.toArray(new ItemVendido[0]), formaPagamento.name(), valorTotal, desconto);

                    System.out.println("Valor total"+venda.getValorTotal());
                    //calcular cashback
                    //verificar clientes especiais
                    break;
            }
        }

        scanner.close();
    }

}
