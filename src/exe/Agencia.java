package exe;


import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import back.Cliente;
import back.Conta;
import back.Enderecos;


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
                    "5° Listar Contas Existentes \n" + //fazer função extrato
                    "6° Fechar \n"));


        switch(operacao){
        case 1:
            criarConta();
        case 2:
            sacar();      
        case 3:
            transferir();      
        case 4:
            deposito(); 
        case 5:
            listarContas();       
        case 6:
        JOptionPane.showMessageDialog(null, "OK. Obrigado por usar nossa plataforma!!!");
        System.exit(0);
        default:
            JOptionPane.showMessageDialog(null,"Opção Inválida!!! escolha alguma das existentes no menu.");
            operacoes();
            break;          
        }


    }

    private static void criarConta() {

        String nome = JOptionPane.showInputDialog("Qual o seu nome? ");
        
        String cpf = JOptionPane.showInputDialog("Qual o seu CPF? ");
        
        String data = JOptionPane.showInputDialog("Que dia você nasceu? ");
               
        String cidade = JOptionPane.showInputDialog("Em que cidade você reside atualmente? ");
        
        String logradouro = JOptionPane.showInputDialog("Qual o nome da sua rua (logradouro)?  ");
        
        String bairro = JOptionPane.showInputDialog("Qual o bairro: ");
        
        String numeroCasa = JOptionPane.showInputDialog("Qual o número da sua casa? ");
        
        int numeroEndereco = Integer.parseInt(numeroCasa);
        
        String uf = JOptionPane.showInputDialog("Estado :");
        
        
        Enderecos enderecos = new Enderecos(logradouro, numeroEndereco, bairro, cidade, uf);
        Cliente cliente = new Cliente(nome, cpf, data, enderecos);
        Conta conta = new Conta(cliente);
        contasBancarias.add(conta);

        JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");
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

        String numeroConta = (JOptionPane.showInputDialog(null, "Número da conta para depósito: "));
        int numeroContaDef = Integer.parseInt(numeroConta);
        Conta conta = encontrarConta(numeroContaDef);

        if(conta != null) {
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
            int numeroContaRemetente = 
                    Integer.parseInt(JOptionPane.showInputDialog("Numero da conta destino para realizar a transferencia: "));
            Conta contaRemetente = encontrarConta(numeroContaRemetente);

            if(contaRemetente != null) {
                int numeroContaDestino = 
                        Integer.parseInt(JOptionPane.showInputDialog("Numero da conta destino para realizar a transferencia: "));

                Conta contaDestino = encontrarConta(numeroContaDestino);

                if(contaDestino != null) {
                    Double valor = 
                            Double.parseDouble(JOptionPane.showInputDialog("Valor da transferência: "));

                    contaRemetente.transferir(contaDestino, valor);
                }else {
                    JOptionPane.showMessageDialog(null,"Conta para transferência não encontrada!!!");
                }
            
            }else {
                JOptionPane.showMessageDialog(null,"Conta para transferência não encontrada!!!");
            }
            operacoes();
        
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



