package main;
import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Cliente> clientes;
    private List<Produto> produtos;

    public Loja() {
        this.clientes = new ArrayList<>();
        this.produtos = new ArrayList<>();
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
        double icms = 0;
        double municipal = 0;

        if (regiao == Regiao.DistritoFederal) {
            icms = valor * 0.18;
            municipal = 0;
        } else {
            icms = valor * 0.12;
            municipal = valor * 0.04;
        }

        List<Double> impostos = new ArrayList<>();
        impostos.add(icms);
        impostos.add(municipal);
        return impostos;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }
}
