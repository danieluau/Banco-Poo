package back;

import javax.swing.JOptionPane;

public class ContaCorrente extends Conta {
    
    private double chequeEspecial = 1000;


    public ContaCorrente(Cliente cliente, String tipoConta) {
        super(cliente, tipoConta);
        
    }

    public double getChequeEspecial(){
        return chequeEspecial;
    }

    public void sacar(Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);
            JOptionPane.showMessageDialog(null,"Saque realizado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possivel realizar o saque!");
        }
    }

    public void transferir(Conta contaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            JOptionPane.showMessageDialog(null,"Tranferencia realizada com sucesso");
        } else {
        }
    }



} 