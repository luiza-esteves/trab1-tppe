package main;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 *
 * Esta classe foi criada como parte de uma refatoração para isolar a lógica de atualização dos tipos de clientes
 *   da classe Loja
 * - A lógica de cálculo do período do último mês, cálculo do valor total das vendas e atualização do tipo de cliente
 *    foi movida para esta classe.
 * - O código agora é mais fácil de manter e testar, permitindo alterações na lógica sendo mais simples de implementar.
 */

public class AtualizaTipoCliente {

    private List<Cliente> clientes;
    private List<Venda> vendas;

    public AtualizaTipoCliente(List<Cliente> clientes, List<Venda> vendas) {
        this.clientes = clientes;
        this.vendas = vendas;
    }

    public void atualizarTiposDeClientes() {
        Date[] periodoUltimoMes = calcularPeriodoUltimoMes();
        Date inicioUltimoMes = periodoUltimoMes[0];
        Date fimUltimoMes = periodoUltimoMes[1];

        for (Cliente cliente : clientes) {
            if (cliente.getTipo() != Tipo.PRIME) {
                double valorTotalUltimoMes = calcularValorTotalUltimoMes(cliente, inicioUltimoMes, fimUltimoMes);
                atualizarTipoCliente(cliente, valorTotalUltimoMes);
            }
        }
    }

    private Date[] calcularPeriodoUltimoMes() {
        LocalDate agora = LocalDate.now();
        LocalDate primeiroDiaDoMesAtual = agora.withDayOfMonth(1);
        LocalDate primeiroDiaDoUltimoMes = primeiroDiaDoMesAtual.minusMonths(1);
        LocalDate ultimoDiaDoUltimoMes = primeiroDiaDoMesAtual.minusDays(1);

        Date inicioUltimoMes = Date.from(primeiroDiaDoUltimoMes.atStartOfDay(ZoneId.systemDefault()).toInstant());
        Date fimUltimoMes = Date.from(ultimoDiaDoUltimoMes.atStartOfDay(ZoneId.systemDefault()).toInstant());
        return new Date[]{inicioUltimoMes, fimUltimoMes};
    }

    private double calcularValorTotalUltimoMes(Cliente cliente, Date inicioUltimoMes, Date fimUltimoMes) {
        double valorTotalUltimoMes = 0.0;
        for (Venda venda : vendas) {
            if (venda.getIdCliente() == cliente.getId() &&
                    !venda.getDataVenda().before(inicioUltimoMes) &&
                    !venda.getDataVenda().after(fimUltimoMes)) {
                valorTotalUltimoMes += venda.getNotaFiscal().getValorTotal();
            }
        }
        return valorTotalUltimoMes;
    }

    private void atualizarTipoCliente(Cliente cliente, double valorTotalUltimoMes) {
        if (valorTotalUltimoMes >= 100.0 && cliente.getTipo() == Tipo.PADRAO) {
            cliente.setTipo(Tipo.ESPECIAL);
        } else if (valorTotalUltimoMes < 100.0 && cliente.getTipo() == Tipo.ESPECIAL) {
            cliente.setTipo(Tipo.PADRAO);
        }
    }
}

