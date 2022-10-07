package programa;


import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;


public class Agencia {
    
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    
    public static void main(String[] args){
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes(){

        int operacao = 
                Integer.parseInt(JOptionPane.showInputDialog("O que você deseja? \n" +
                    "1° Criar Conta \n" +
                    "2° Sacar \n" +
                    "3° Transferir \n" +
                    "4° Depositar \n" +
                    "5° Listar Contas Existentes \n" +
                    "6° Fechar \n"));


        switch(operacao){
        case 1:
            criarConta();
            break;
        case 2:
            sacar();
            break;        
        case 3:
            transferir();
            break;        
        case 4:
            deposito();
            break;       
        case 5:
            listarContas();
            break;        
        case 6:
        JOptionPane.showMessageDialog(null, "OK. Obrigado por usar nossa plataforma!!!");
        System.exit(0);
        default:
            JOptionPane.showMessageDialog(null,"Opção Inválida!");
            operacoes();
            break;          
        }


    }

    public static void criarConta() {
        Cliente cliente = new Cliente();
        
        cliente.setNome(JOptionPane.showInputDialog("Nome: "));
        
        cliente.setCpf(JOptionPane.showInputDialog("CPF: "));
        
        cliente.setData_de_nascimento(JOptionPane.showInputDialog("Data de Nascimento: "));
        
        cliente.setEndereco(JOptionPane.showInputDialog("Endereço: "));

        Conta conta = new Conta(cliente);

        contasBancarias.add(conta);
        JOptionPane.showMessageDialog(null,"Conta criada com sucesso! ");
        operacoes();
    }
    
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if(contasBancarias.size() > 0) {
            for(Conta c: contasBancarias) {
                if(c.getNumeroConta() == numeroConta);
                conta= c;
            }
        }
        return conta;
    }    
    
    public static void deposito() {

        int numeroConta = 
                Integer.parseInt(JOptionPane.showInputDialog(null, "Número da conta para depósito: "));

        Conta conta = encontrarConta(numeroConta);

        if(conta != null) {
            System.out.println("Quanto você deseja depositar? ");
            Double valorDeposito = 
                    Double.parseDouble((JOptionPane.showInputDialog(null, "Valor do depósito: ")));
            conta.deposito(valorDeposito);
        }else {
            JOptionPane.showMessageDialog(null,"Conta não encontrada, não foi possivel realizar o depósito!!!");
        }
        operacoes();
        }
        
    
    public static void sacar() {
        int numero_conta = 
                Integer.parseInt(JOptionPane.showInputDialog("Numero da conta para realizar o saque: "));

        Conta conta= encontrarConta(numero_conta);

        if(conta != null) {
            Double valorSaque = 
                    Double.parseDouble(JOptionPane.showInputDialog("Quanto você deseja sacar? "));
            conta.sacar(valorSaque);

        }else {
            JOptionPane.showMessageDialog(null,"Conta não encontrada, não foi possivel realizar o saque!!!");
        }
        operacoes();
    }

    public static void transferir() {
            int numero_contaRemetente = 
                    Integer.parseInt(JOptionPane.showInputDialog("Numero da conta destino para realizar a transferencia: "));
            Conta contaRemetente = encontrarConta(numero_contaRemetente);

            if(contaRemetente != null) {
                int numero_contaDestino = 
                Integer.parseInt(JOptionPane.showInputDialog("Numero da conta destino para realizar a transferencia: "));

                Conta contaDestino = encontrarConta(numero_contaDestino);

                if(contaDestino != null) {
                    Double valor = Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência: "));

                    contaRemetente.transferir(contaDestino, valor);
                }else {
                    JOptionPane.showMessageDialog(null,"Conta para transferência não encontrada!!!");
                }
            
            }else {
                JOptionPane.showMessageDialog(null,"Conta para transferência não encontrada!!!");
            }

        
    }    

    public static void listarContas() {
        if(contasBancarias.size() > 0) {
            for (Conta conta : contasBancarias) {
                JOptionPane.showMessageDialog(null, conta);
            }
        }else {
            JOptionPane.showMessageDialog(null,"Não existem contas cadastradas ainda.");
            
        }
        operacoes();
    }

            

}



