package programa;

import java.time.LocalDate;

public class Cliente {


    private String nome;
    private String cpf;
    private final LocalDate dataDeNascimento;
    private Enderecos enderecos;
    

    public Cliente(String nome, String cpf, LocalDate dataDeNascimento, Enderecos enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.enderecos = enderecos;
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

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataDeNascimento() {
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
    

    public void setEnderecos(String showInputDialog) {
    }

          
}
