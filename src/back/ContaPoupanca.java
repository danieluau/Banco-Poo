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



