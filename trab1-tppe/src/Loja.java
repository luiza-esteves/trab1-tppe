import java.util.ArrayList;
import java.util.List;

public class Loja {
    private List<Cliente> clientes;

    public Loja() {
        this.clientes = new ArrayList<>();
    }

    public void adicionarClientes(String nome, Tipo tipo, Regiao regiao, Endereco endereco) {
        int id = this.clientes.size() + 1;
        Cliente cliente = new Cliente(id, nome, tipo, regiao, endereco);
        this.clientes.add(cliente);
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

}
