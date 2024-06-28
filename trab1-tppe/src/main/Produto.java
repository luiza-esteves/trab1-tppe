package main;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Produto {

    private int id;
    private String descricao;
    private double preco;
    private String medida;

    public Produto(int id, String descricao, double preco, String medida) {
        this.id = id;
        this.descricao = descricao;
        this.preco = setPreco(preco);
        this.medida = medida;
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

    public double getPreco() {
        return preco;
    }

    public double setPreco(double preco) {
        BigDecimal precoBD = new BigDecimal(Double.toString(preco));
        precoBD = precoBD.setScale(2, RoundingMode.HALF_UP);
        return precoBD.doubleValue();
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }
    
}
