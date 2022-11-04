/*package back;

import javax.swing.JOptionPane;

public class ContaPoupanca extends Conta {

    private double rendimento;

    public ContaPoupanca() {
        super(numeroAgencia, numeroConta, saldo, cliente);
        this.rendimento = this.getSaldo() * 0.10;

    }

    public double getRendimento() {
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


/* */