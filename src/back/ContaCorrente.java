package back;

import javax.swing.JOptionPane;

import utilidades.Utils;

public class ContaCorrente extends Conta {
    
    private double chequeEspecial = 1000.0;
    private int counterTransfer;

    Sms sms = new Sms();
    Email email = new Email();

    public ContaCorrente(Cliente cliente, int tipoConta) {
        super(cliente, tipoConta);
        this.chequeEspecial = (double) 1000;
        this.counterTransfer= 0;
        
    }

    public double getChequeEspecial(){
        return chequeEspecial;
    }






    @Override
    public void sacar(Double valor) {
        double cheque = valor - this.getSaldo();
        if (valor > this.getSaldo());
        this.setSaldo(this.getSaldo() - valor);
        this.setSaldo(this.getChequeEspecial() - cheque);
        JOptionPane.showMessageDialog(null, "Valor sacado com sucesso.");
    }



    @Override
    public void deposito(Double valor) {
        super.deposito(valor);
    }



 
    @Override
    public void transferir(Conta contaDeposito, Double valor) {

        this.counterTransfer += 1;
        if(this.counterTransfer < 2){
        super.transferir(contaDeposito, valor);
    }else {
        if (this.getSaldo() >= valor && valor > 0) {
            Double taxa = valor * 5/100;
            contaDeposito.setSaldo((contaDeposito.getSaldo() - taxa));
            setSaldo(getSaldo() - valor - taxa);

            contaDeposito.saldo = contaDeposito.getSaldo() + valor + taxa;
        }
    }

    }

        


    @Override
    public String toString() {
        return "\nNúmero da conta: " + this.getNumeroConta() +
                "\nAgência: " +this.getAgencia() +
                "\nNome: " + this.cliente.getNome() +
                "\nTipo de conta: " + getContaTipo() +
                "\nTelefone: " + this.cliente.getTelefone() +
                "\nEmail: " + this.cliente.getEmail() +
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