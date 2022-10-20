package back;


import javax.swing.JOptionPane;

import utilidades.Utils;


public class Conta {

    private static int counterContas = 1;

    private static int counterAgencia = 1001;

    private int agencia;
    private int numeroConta;
    private Cliente cliente;
    private double saldo = 0.0;

    public Conta(Cliente cliente) {
        this.agencia = counterAgencia;
        this.cliente = cliente;
        this.numeroConta = counterContas;
        counterContas += 1;
        counterAgencia += 1;
    }

    public static int getCounterContas() {
        return counterContas;
    }
    
    public static int getCounterAgencia() {
        return counterAgencia;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }
    
    public Cliente getCliente() {
        return cliente;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getClienteEnderecocidade() {
        return this.cliente.getCidade();
    }

    public String getClienteEnderecoUf() {
        return this.cliente.getUf();
    }

    public String getClienteLogradouroEndereco() {
        return this.cliente.getLogradouro();
    }
    public int getClienteNumeroEndereco(){
        return this.cliente.getNumeroCasa();
    }
    public String getClienteBairroEndereco(){
        return this.cliente.getBairro();
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
    public void deposito(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor);
            JOptionPane.showMessageDialog(null,"Seu depósito foi realizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Não foi possível realizar o seu depósito");
        }
    }



    public String toString() {
        return "\nNumero da conta: " + this.getNumeroConta() +
                "\nAgencia: " +this.getAgencia() +
                "\nNome: " + this.cliente.getNome() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nData de Nascimento: " + this.cliente.getDataDeNascimento() +
                "\nSaldo: " + Utils.doubletoString(this.getSaldo()) +
                "\nLogradouro: " + this.cliente.getLogradouro() +
                "\nNumero: " + this.cliente.getNumeroCasa() +
                "\nBairro: " + this.cliente.getBairro() +
                "\nCidade: " + this.cliente.getCidade() +
                "\nUF : " + this.cliente.getUf() +
                "\n";
    }






}
