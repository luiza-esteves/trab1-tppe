public class Cliente {

    private int id;
    private String nome;
    private Tipo tipo;
    private Regiao regiao;
    private Endereco endereco;
    private int cashback = 0;

    public Cliente(int id, String nome, Tipo tipo, Regiao regiao, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.regiao = regiao;
        this.endereco = endereco;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getCashback() {
        return cashback;
    }

    public void setCashback(int cashback) {
        this.cashback = cashback;
    }
    
    
    
}
