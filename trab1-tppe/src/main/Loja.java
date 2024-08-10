package main;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Loja {
    private List<Cliente> clientes;
    private List<Produto> produtos;
    private List<Venda> vendas;

    public Loja() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    public void adicionarVendas(Venda venda) {
        // TO-DO: imprimir nota fiscal na tela
        System.out.println("Itens Vendidos:");
        for (ItemVendido item : venda.getItensVendidos()) {
            System.out.println("  Descrição: " + item.getDescricao());
            System.out.println("  ICMS: " + item.getIcms());
            System.out.println("  Municipal: " + item.getMunicipal());
            System.out.println();
        }
        System.out.println("Data da Venda: " + venda.getDataVenda());
        System.out.println("ID do Cliente: " + venda.getIdCliente());
        System.out.println("Nome do Cliente: " + venda.getNomeCliente());
        System.out.println("Método de Pagamento: " + venda.getMetodoPagamento());
        System.out.println("Valor Total: " + venda.getValorTotal());
        System.out.println("Desconto Total: " + venda.getDescontoTotal());
        System.out.println("Frete: " + venda.getFreteTotal());
        System.out.println("Imposto Total: " + venda.getImpostoTotal());
        this.vendas.add(venda);
    }

    public void calcularCashback(int idCliente, boolean cartaoLoja, double valorTotal) {
        Cliente cliente = this.getClientes().get(idCliente);

        if (cliente.getTipo() == Tipo.PRIME) {
            double taxa = cartaoLoja ? 0.05 : 0.03;
            double cashback = valorTotal * taxa;
            cliente.setCashback(cliente.getCashback() + cashback);
        }
    }

        /**
     * Refatoração: Extração do método atualizarTiposDeClientes() para a classe AtualizaTipoCliente.
     *
     * Efeitos da Refatoração:
     * 1. O método atualizarTiposDeClientes() na classe Loja agora chama a classe AtualizaTipoCliente
     * 2. Esta refatoração foi realizada para melhorar a coesão do código, separando as responsabilidades
     * 3. A mudança aumenta a modularidade e facilita a manutenção futura, permitindo que a lógica de atualização de tipos de clientes seja isolada e possa ser usada em outras classes
     */
    public void atualizarTiposDeClientes() {
        AtualizaTipoCliente atualizador = new AtualizaTipoCliente(this.clientes, this.vendas);
        atualizador.atualizarTiposDeClientes();
    }

    public void adicionarProdutos(String descricao, double preco, String medida) {
        int id = this.produtos.size() + 1;
        Produto produto = new Produto(id, descricao, preco, medida);
        this.produtos.add(produto);
    }

    public void adicionarClientes(String nome, Tipo tipo, Regiao regiao, Endereco endereco) {
        int id = this.clientes.size() + 1;
        Cliente cliente = new Cliente(id, nome, tipo, regiao, endereco);
        this.clientes.add(cliente);
    }

    public double calcularFrete(Regiao regiao, Endereco endereco, Tipo tipo) {
        double frete = 0.0;

        if (tipo == Tipo.PRIME) {
            return 0.00;
        }

        switch (regiao) {
            case DistritoFederal:
                frete = 5.00;
                break;
            case CentroOeste:
                frete = (endereco == Endereco.CAPITAL) ? 10.00 : 13.00;
                break;
            case Nordeste:
                frete = (endereco == Endereco.CAPITAL) ? 15.00 : 18.00;
                break;
            case Norte:
                frete = (endereco == Endereco.CAPITAL) ? 20.00 : 25.00;
                break;
            case Sudeste:
                frete = (endereco == Endereco.CAPITAL) ? 7.00 : 10.00;
                break;
            case Sul:
                frete = (endereco == Endereco.CAPITAL) ? 10.00 : 13.00;
                break;
            default:
                throw new IllegalArgumentException("Região desconhecida: " + regiao);
        }

        if (tipo == Tipo.ESPECIAL) {
            frete = frete - (frete * 0.3);
        }

        return frete;
    }

    public boolean verificarCartaoLoja(String numeroCartao) {
        if (numeroCartao == null || numeroCartao.length() < 6) {
            return false;
        }
        return numeroCartao.startsWith("429613");
    }

    public double calcularDesconto(double valor, Tipo tipo, boolean cartaoLoja) {
        if (tipo != Tipo.ESPECIAL) {
            return 0.00;
        }

        double desconto = cartaoLoja ? 0.2 : 0.1;
        return valor * desconto;
    }

    public List<Double> calcularImposto(double valor, Regiao regiao) {
        CalculadoraImpostos calculadora = new CalculadoraImpostos(valor, regiao);
        return calculadora.calcular();
    }    

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public List<Venda> getVendas() {
        return vendas;
    }

}
