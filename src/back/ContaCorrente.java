package back;

import javax.swing.JOptionPane;

import utilidades.Utils;

public class ContaCorrente extends Conta {
    
    double chequeEspecial = 1000.0;

    Sms sms = new Sms();
    Email email = new Email();

    public ContaCorrente(Cliente cliente, int tipoConta) {
        super(cliente, tipoConta);
        
    }

    public double getChequeEspecial(){
        return chequeEspecial;
    }

    @Override    
    public void sacar (Double valor) {
        if (this.getSaldo() > 0) {
            String [] answer = {"Email", "Sms"};
            int option = JOptionPane.showOptionDialog(null, "Como você deseja ser notificado dessa transação? ", null, JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer);
            if(option == 0) {
            email.mandarNotificacao("Foi feito um saque ", valor);
            }
            if(option == 1){
                sms.mandarNotificacao("Foi feito um saque ", valor);
            }
            
            }
        }
    
    @Override
    public void transferir(Conta contaDeposito, Double valor) {
        if (valor > 0 && this.getSaldo() >= valor) {
            setSaldo(getSaldo() - valor);

            contaDeposito.saldo = contaDeposito.getSaldo() + valor;
            String [] answer = {"Email", "Sms"};
            int option = JOptionPane.showOptionDialog(null, "Como você deseja ser notificado dessa transação? ", null, JOptionPane.YES_OPTION, JOptionPane.INFORMATION_MESSAGE, null, answer, answer);
                if(option == 0) {
                email.mandarNotificacao("Foi feito uma transferência ", valor);
                }
                if(option == 1){
                    sms.mandarNotificacao("Foi feita uma transferência ", valor);
                }
            JOptionPane.showMessageDialog(null,"Transferência realizada com sucesso.");
        } else {
        }
    }
    
    @Override
    public String toString() {
        return "\nNúmero da conta: " + this.getNumeroConta() +
                "\nAgência: " +this.getAgencia() +
                "\nNome: " + this.cliente.getNome() +
                "\nTipo de conta: " + getContaTipo() +
                "\nEmail: " + this.cliente.getSenha() +
                "\nTelefone: " + this.cliente.getTelefone() +
                "\nSenha: " + this.cliente.getEmail() +
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