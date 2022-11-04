package exe;

import java.util.ArrayList;
//import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import back.Cliente;
import back.Conta;
//import back.ContaCorrente;
//import back.ContaPoupanca;
import back.Enderecos;


public class Agencia {
    
    static Scanner input = new Scanner(System.in);
    static ArrayList<Conta> contasBancarias;
    
    

    /*public static void main (String[] args) throws Exception {
        List<Integer> menu = new ArrayList<>();
        contasBancarias = new ArrayList<Conta>();
        operacoes();

        menu.add(1);
        menu.add(2);
        menu.add(3);

        int menuEscolhido = 1;
        while (menu.get(menuEscolhido) != 3) {
            menuEscolhido = seeMenu(menu);
            if (menu.get(menuEscolhido)==1) {
                criarConta();
            }
            else if (menu.get(menuEscolhido) == 2) {
                //logar();
            }
        }
    }
    
    
    public int seeMenu(List<Integer> menu){
        Object[] menusArray = menu.toArray();
        int opcaoEscolhida = JOptionPane.showOptionDialog(null,"1. Não tenho conta \n. Login \n. Sair", "Menu", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE, null, menusArray, null);
        return opcaoEscolhida;
    }*/
    
    public static void main(String[] args) {
        contasBancarias = new ArrayList<Conta>();
        operacoes();
    }

    public static void operacoes() {

        int operacao = 
                Integer.parseInt(JOptionPane.showInputDialog("O que você deseja? \n" +
                    " 1°| Criar Conta \n" +
                    " 2°| Depositar \n" +
                    " 3°| Sacar \n " +
                    "4°| Transferir \n" +
                    " 5°| Listar Contas \n" + //fazer função extrato
                    " 6°| Sair \n"));


        switch(operacao){
        case 1:
            criarConta();
        case 2:
            deposito();      
        case 3:
            sacar();      
        case 4:
            transferir();
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



    private static void criarConta()  {


        //int tipoConta = JOptionPane.showOptionDialog(null, "1. Conta Corrente \n. 2. Conta Poupança \n.","Qual tipo de conta você deseja criar?", JOptionPane.OK_CANCEL_OPTION , JOptionPane.PLAIN_MESSAGE, null, null, null, null);

        String nome = JOptionPane.showInputDialog("Qual o seu nome? ");
        
        String cpf = JOptionPane.showInputDialog("Qual o seu CPF? ");
        
        String email = JOptionPane.showInputDialog("Qual o seu e-mail?");

        String dataNascimento = JOptionPane.showInputDialog("Qual a sua data de nascimento? ");
          
        String logradouro = JOptionPane.showInputDialog("Qual o nome da sua rua (logradouro)?  ");
        
        String bairro = JOptionPane.showInputDialog("Qual o seu bairro? ");

        String numeroCasa = JOptionPane.showInputDialog("Qual o número da sua casa? ");

        int numeroCasaDef = Integer.parseInt(numeroCasa);
        
        String cidade = JOptionPane.showInputDialog("Em que cidade você reside atualmente? ");
        
        String uf = JOptionPane.showInputDialog("Em que estado você reside atualmente? ");
        
        String senha = JOptionPane.showInputDialog("Digite uma senha para sua conta: ");
        
        Enderecos enderecos = new Enderecos(logradouro, numeroCasaDef, bairro, cidade, uf);
        

        /*if (tipoContaDef == 0){
            ContaCorrente conta = new ContaCorrente();
            contasBancarias.add(conta);
            JOptionPane.showMessageDialog(null, "Sua conta de tipo Corrente foi criada com sucesso!!!");

        }else if(tipoContaDef == 1){
            ContaPoupanca conta = new ContaPoupanca();
            contasBancarias.add(conta);
            JOptionPane.showMessageDialog(null, "Sua conta de tipo Corrente foi criada com sucesso!!!");
        }/* */

        Cliente cliente = new Cliente(nome, cpf, dataNascimento, enderecos, email, senha);    
        Conta conta = new Conta(cliente);
        contasBancarias.add(conta);

        JOptionPane.showMessageDialog(null, "Sua conta foi criada com sucesso!");
        operacoes();
    }
    
    
    
    private static Conta encontrarConta(int numeroConta) {
        Conta conta = null;
        if (contasBancarias.size() > 0) {
            for (Conta c : contasBancarias) {
                if (c.getNumeroConta() == numeroConta) {
                    conta = c;
                }
            }
        }
        return conta;
    }    


    public static void deposito() {

        String numeroConta = (JOptionPane.showInputDialog(null, "Número da conta para depósito: "));
        
        int numeroContaDef = Integer.parseInt(numeroConta);
        
        Conta conta = encontrarConta(numeroContaDef);

        if(conta != null) {
            Double valor = 
                Double.parseDouble((JOptionPane.showInputDialog(null, "Valor do depósito: ")));

                conta.deposito(valor);
            
        }else {
            JOptionPane.showMessageDialog(null,"Conta não encontrada, não foi possivel realizar o depósito!!!");
        }
        operacoes();
        }
        
    

    public static void sacar()  {
        String numeroConta = (JOptionPane.showInputDialog("Número da conta para realizar o saque: "));
        int numeroContaDef = Integer.parseInt(numeroConta);
        Conta conta= encontrarConta(numeroContaDef);

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
            String numeroContaRemetente = 
                (JOptionPane.showInputDialog("Número da sua conta para realizar a transferencia: "));
            int numeroContaRemetenteDef = 
                Integer.parseInt(numeroContaRemetente);
            Conta contaRemetente = encontrarConta(numeroContaRemetenteDef);

            if(contaRemetente != null) {
                String numeroContaDestino = 
                        (JOptionPane.showInputDialog("Número da conta destino para realizar a transferencia: "));
                int numeroContaDestinoDef = 
                        Integer.parseInt(numeroContaDestino);
                Conta contaDestino = encontrarConta(numeroContaDestinoDef);

                if(contaDestino != null) {
                    String valor = 
                            JOptionPane.showInputDialog("Quanto você deseja transferir? ");
                    double valorDef = Integer.parseInt(valor);
                    contaDestino.transferir(contaRemetente, valorDef);

                    contaRemetente.transferir(contaDestino, valorDef);
                }else {
                    JOptionPane.showMessageDialog(null,"Conta para transferência não encontrada!!!");
                }

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


        /*List<Integer> menu = new ArrayList<>();
        menu.add(1);
        menu.add(2);

        Object[] menuLogin = menu.toArray();
        int opcaoEscolhida = JOptionPane.showOptionDialog(null, "1. Conta Corrente \n. 2. Conta Poupança \n.","Qual tipo de conta você deseja criar?", JOptionPane.OK_CANCEL_OPTION , JOptionPane.PLAIN_MESSAGE, null, menuLogin, null);     

        if (opcaoEscolhida == 0){
            tipoConta = "Corrente";
        } 

        else if (opcaoEscolhida == 1){
            tipoConta = "Poupança";
        }   
        */
