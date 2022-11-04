package back;

import java.util.ArrayList;
import java.util.List;

public class Cliente {


    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private Enderecos enderecos;
    private String email;
    private String senha;
    private List<Conta> contas = new ArrayList<>();
    private List<ContaCorrente> contaCorrentes = new ArrayList<>();
    private List<ContaPoupanca> contaPoupancas = new ArrayList<>();
    

    public Cliente(String nome, String cpf, String dataDeNascimento, Enderecos enderecos, String senha, String email) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.enderecos = enderecos;
        this.email= email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public String getCpf() {
        return cpf;
    }
    
    public String getSenha() {
        return senha;
    }

    public String getEmail() {
        return email;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }
    
    public Enderecos getEnderecos() {
        return getEnderecos();
    }

    public String getLogradouro() {
        return this.enderecos.getLogradouro();
    }
    
    public int getNumeroCasa() {
        return this.enderecos.getNumeroCasa();
    }
    
    public String getBairro() {
        return this.enderecos.getBairro();
    }
    
    public String getCidade() {
        return this.enderecos.getCidade();
    }
    
    public String getUf() {
        return this.enderecos.getUf();
    }

    public List<Conta> getConta() {
        return contas;
    }
    
    public List<ContaCorrente> getContaCorrentes() {
        return contaCorrentes;
    }
    
    public List<ContaPoupanca> getContaPoupancas() {
        return contaPoupancas;
    }

    public void addConta(Conta conta){
        this.contas.add(conta);
    }
    public void addContaCorrente(ContaCorrente contaCorrente){
        this.contas.add(contaCorrente);
    }
    public void addConta(ContaPoupanca contaPoupanca){
        this.contas.add(contaPoupanca);
    }

}
