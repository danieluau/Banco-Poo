package back;

import javax.swing.JOptionPane;

import utilidades.Utils;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, int tipoConta) {
        super(cliente, tipoConta);
        
    }

    private double rendimento;


    public double getRendimento() {
        this.rendimento = this.getSaldo();
        return this.rendimento;
    }

    @Override
    public void deposito(Double valor) {
        if (valor > 0) {
            setSaldo((getSaldo() + valor));
            JOptionPane.showMessageDialog(null,"Seu depósito foi realizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Não foi possível realizar o seu depósito");
        }
    }

    @Override
    public void transferir(Conta contaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null,"Tranferencia realizada com sucesso");
        } else {
        }
    }
    
    @Override
    public String toString() {
        return "\nNúmero da conta: " + this.getNumeroConta() +
                "\nAgência: " +this.getAgencia() +
                "\nTipo de conta: " + getContaTipo() +
                "\nNome: " + this.cliente.getNome() +
                "\nEmail: " + this.cliente.getSenha() +
                "\nSenha : " + this.cliente.getEmail() +
                "\nCPF: " + this.cliente.getCpf() +
                "\nData de Nascimento: " + this.cliente.getDataDeNascimento() +
                "\nSaldo: " + Utils.doubletoString(this.getSaldo()) +
                "\nLogradouro: " + this.cliente.getLogradouro() +
                "\nNúmero da casa: " + this.cliente.getNumeroCasa() +
                "\nBairro: " + this.cliente.getBairro() +
                "\nCidade: " + this.cliente.getCidade() +
                "\nUF : " + this.cliente.getUf() +
                "\n";
    }

    }
