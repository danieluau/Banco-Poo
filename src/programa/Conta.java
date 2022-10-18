package programa;


import javax.swing.JOptionPane;

import utilidades.Utils;


public class Conta {

    private static int counterContas = 1;

    private int agencia;
    private int numeroConta;
    private Cliente cliente;
    private double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.cliente = cliente;
        this.numeroConta = counterContas;
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

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(int numeroConta) {
        this.numeroConta = numeroConta;
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
        return "\nNumero da conta: " + this.getNumeroConta() +
                "\nAgencia: " +this.getAgencia() +
                "\nNome: " + this.cliente.getNome() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nEndereço: " + this.cliente.getEndereco() +
                "\nData de Nascimento: " + this.cliente.getData_de_nascimento() +
                "\nSaldo: " + Utils.doubletoString(this.getSaldo()) +
                "\n";
    }

    public void deposito(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null,"Seu depósito foi realizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Não foi possível realizar o seu depósito");
        }
    }

    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
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
            JOptionPane.showMessageDialog(null,"Não foi possivel realizar a transferencia!");
        }
    }


}
