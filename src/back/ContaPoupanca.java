package back;

import javax.swing.JOptionPane;

import utilidades.Utils;

public class ContaPoupanca extends Conta {
    
    private double rendimento;
    
    Sms sms = new Sms();
    Email email = new Email();

    public ContaPoupanca(Cliente cliente, int tipoConta) {
        super(cliente, tipoConta);
        this.rendimento = 0.10;
        
    }


    public double getRendimento(){
        return rendimento;
    }
    
    public void setRendimento(Double rendimento){
        this.rendimento = rendimento;
    }



    @Override
    public void deposito(Double valor) {
        valor += (valor * 10) /100;
        super.deposito(valor);
    }

    @Override
    public void sacar(Double valor) {
        super.sacar(valor);
    }

    @Override
    public void transferir(Conta contaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            Double taxa = valor * 5/100;
            setSaldo(getSaldo() - valor + taxa);


            contaDeposito.saldo = contaDeposito.getSaldo() + valor - taxa;
            JOptionPane.showMessageDialog(null,"Transferência realizada com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null,"Não foi possível realizar sua transferência.");
        }
    }
        
        
    
    @Override
    public String toString() {
        return "\nNúmero da conta: " + this.getNumeroConta() +
                "\nAgência: " +this.getAgencia() +
                "\nNome: " + this.cliente.getNome() +
                "\nTipo de conta: " + getContaTipo() +
                "\nEmail: " + this.cliente.getEmail() +
                "\nTelefone: " + this.cliente.getTelefone() +
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