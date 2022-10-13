package programa;


public class Cliente {

    private static int counter =1;

    private String nome;
    private String cpf;
    private String data_de_nascimento;
    private Enderecos enderecos;
    
    
    public Cliente(Enderecos enderecos) {
        
    }

    public Cliente(String nome, String cpf, String data_de_nascimento, Enderecos enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_de_nascimento = data_de_nascimento;
        this.enderecos = enderecos;
        
    }    

    public Cliente() {
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

    public String getData_de_nascimento() {
        return data_de_nascimento;
    }

    public void setData_de_nascimento(String string) {
        this.data_de_nascimento = string;
    }

    public Enderecos getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(Enderecos string) {
        this.enderecos = string;
    }
         

    public String toString() {
        return 
        "\nNome: " + this.getNome() +       
        "\nCPF: " + this.getCpf() +        
        "\nEndereco: " + this.getEnderecos() +
        "\nData de Nascimento: " + this.getData_de_nascimento();
        }

    public void setEnderecos(String showInputDialog) {
    }


}
