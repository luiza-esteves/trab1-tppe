package main;

public class ItemVendido {
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
