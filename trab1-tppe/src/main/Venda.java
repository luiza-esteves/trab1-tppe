package main;

import java.util.Date;

public class Venda {
    private Date dataVenda;
    private int idCliente;
    private String nomeCliente;
    private ItemVendido[] itensVendidos;
    private String metodoPagamento;
    private double valorTotal;
    private double descontoTotal;
    private double freteTotal;
    private double impostoTotal;

    public Venda(Date dataVenda, int idCliente, String nomeCliente, ItemVendido[] itensVendidos, String metodoPagamento, double valorTotal, double descontoTotal, double freteTotal, double impostoTotal) {
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.itensVendidos = itensVendidos;
        this.metodoPagamento = metodoPagamento;
        this.valorTotal = valorTotal;
        this.descontoTotal = descontoTotal;
        this.impostoTotal = impostoTotal;
    }

    public double getFreteTotal() {
        return freteTotal;
    }

    public void setFreteTotal(double freteTotal) {
        this.freteTotal = freteTotal;
    }

    public double getImpostoTotal() {
        return impostoTotal;
    }

    public void setImpostoTotal(double impostoTotal) {
        this.impostoTotal = impostoTotal;
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

    public String getMetodoPagamento() {
        return metodoPagamento;
    }

    public void setMetodoPagamento(String metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getDescontoTotal() {
        return descontoTotal;
    }

    public void setDescontoTotal(double descontoTotal) {
        this.descontoTotal = descontoTotal;
    }
}
