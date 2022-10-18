package programa;



public class Cliente {


    private String nome;
    private String cpf;
    private String data_de_nascimento;
   // private String endereco;






    public Cliente(){

    }
    
    
    public Cliente(Enderecos enderecos) {
        
    }

    public Cliente(String nome, String cpf, String data_de_nascimento, Enderecos enderecos) {
        this.nome = nome;
        this.cpf = cpf;
        this.data_de_nascimento = data_de_nascimento;
    //    this.endereco = endereco;
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
        return getEnderecos();
    }

//    public void setEnderecos(Enderecos string) {
//        this.endereco = string;
 //   }
         

    public String toString() {
        return 
        "\nNome: " + this.getNome() +       
        "\nCPF: " + this.getCpf() +        
        "\nEndereco: " + this.getEnderecos() +
        "\nData de Nascimento: " + this.getData_de_nascimento();
        }

          
}
