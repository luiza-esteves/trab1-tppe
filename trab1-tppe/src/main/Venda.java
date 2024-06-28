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

    public Venda(Date dataVenda, int idCliente, String nomeCliente, ItemVendido[] itensVendidos, String metodoPagamento, double valorTotal, double descontoTotal) {
        this.dataVenda = dataVenda;
        this.idCliente = idCliente;
        this.nomeCliente = nomeCliente;
        this.itensVendidos = itensVendidos;
        this.metodoPagamento = metodoPagamento;
        this.valorTotal = valorTotal;
        this.descontoTotal = descontoTotal;
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

class ItemVendido {
    private int id;
    private String descricao;
    private double icms;
    private double municipal;

    public ItemVendido(int id, String descricao, double icms, double municipal) {
        this.id = id;
        this.descricao = descricao;
        this.icms = icms;
        this.municipal = municipal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getIcms() {
        return icms;
    }

    public void setIcms(double icms) {
        this.icms = icms;
    }

    public double getMunicipal() {
        return municipal;
    }

    public void setMunicipal(double municipal) {
        this.municipal = municipal;
    }
}
