package main;

public class NotaFiscal {
    private String metodoPagamento;
    private double valorTotal;
    private double descontoTotal;
    private double freteTotal;
    private double impostoTotal;

    public NotaFiscal(String metodoPagamento, double valorTotal, double descontoTotal, double freteTotal,
            double impostoTotal) {
        this.metodoPagamento = metodoPagamento;
        this.valorTotal = valorTotal;
        this.descontoTotal = descontoTotal;
        this.freteTotal = freteTotal;
        this.impostoTotal = impostoTotal;
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

    
    
}
