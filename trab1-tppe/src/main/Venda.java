package main;

import java.util.Date;

/**
 * A classe Venda estava fazendo o trabalho de duas classes, ficando muito longa e com vários atributos.
 * Tudo isso estava dificultando a leibilidade e interpreção da classe.
 * Como solução, foi criado uma nova classe e foi movido os campos e método relevantes da antiga classe para a nova.
 * A classe nova se chama NotaFiscal e possui os atributos referentes ao pagamento, valor e descontos da compra.
 * 
 * Efeitos da refatoração:
 * 1 - Maior facilidade de entendimento: Com a divisão das classes, fica mais fácil de entender a responsabilidade e atributos relevantes de cada uma das classes.
 * 
 * 2 - Diminuição de tamanho da classe: Classes menores e com menos métodos são mais fáceis de entender, assim dividir alguns atributos de Venda com a nova classe NotaFiscal fará com que a legibilidade dessas classes sejam maiores.
 */
public class Venda {
    private Date dataVenda;
    private int idCliente;
    private String nomeCliente;
    private ItemVendido[] itensVendidos;
    private NotaFiscal notaFiscal;

    public Venda(Date dataVenda, int idCliente, String nomeCliente, ItemVendido[] itensVendidos, String metodoPagamento, double valorTotal, double descontoTotal, double freteTotal, double impostoTotal) {
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.itensVendidos = itensVendidos;
        this.notaFiscal = new NotaFiscal(metodoPagamento, valorTotal, descontoTotal, freteTotal, impostoTotal);
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public ItemVendido[] getItensVendidos() {
        return itensVendidos;
    }

    public void setItensVendidos(ItemVendido[] itensVendidos) {
        this.itensVendidos = itensVendidos;
    }

    public NotaFiscal getNotaFiscal() {
        return notaFiscal;
    }


    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
}
