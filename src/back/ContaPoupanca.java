package back;

import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta {

    public ContaPoupanca(Cliente cliente, String tipoConta) {
        super(cliente, tipoConta);
        //TODO Auto-generated constructor stub
    }

    private double rendimento;


    public double getRendimento() {
        this.rendimento = this.getSaldo() * 0.10;
        return this.rendimento;
    }

    public void deposito(Double valor) {
        if (valor > 0) {
            setSaldo(getSaldo() + valor * 0.10);
            JOptionPane.showMessageDialog(null,"Seu depósito foi realizado com sucesso");
        } else {
            JOptionPane.showMessageDialog(null,"Não foi possível realizar o seu depósito");
        }
    }
    
    @Override
    public String toString() {
        return "[" + this.getAgencia() + ", " 
                   + this.getNumeroConta() + ", "
                   + this.getSaldo() + ", "
                   + this.getCliente() + ", "
                   + this.getRendimento() + "]";
    }
}
