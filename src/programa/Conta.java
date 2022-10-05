package programa;


import javax.swing.JOptionPane;

import utilidades.Utils;


public class Conta {

    private static int counterContas = 1;

    private int agencia;
    private int numero_conta;
    private Cliente cliente;
    private double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.agencia = counterContas;
        this.numero_conta = counterContas;
        counterContas += 1;
    }

    public static int getCounterContas() {
        return counterContas;
    }

    public static void setCounterContas(int counterContas) {
        Conta.counterContas = counterContas;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }

    public int getNumero_conta() {
        return numero_conta;
    }

    public void setNumero_conta(int numero_conta) {
        this.numero_conta = numero_conta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String toString() {
        return "\nNumero da conta: " + this.getNumero_conta() +
                "\nNome: " + this.cliente.getNome() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nEndereço: " + this.cliente.getEndereco() +
                "\nData de Nascimento: " + this.cliente.getData_de_nascimento() +
                "\nSaldo: " + Utils.doubleToString(this.getSaldo()) +
                "\n";
    }

    public void deposito(Double valor) {
        if (valor > 0.0) {
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null,"Seu depósito foi realizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Não foi possível realizar o seu depósito");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            JOptionPane.showMessageDialog(null,"Saque realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o saque!");
        }
    }

    public void transferir(Conta contaParaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaParaDeposito.saldo = contaParaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null,"Tranferencia realizada com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Não foi possivel realizar o saque!");
        }
    }
}
