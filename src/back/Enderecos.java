package back;

public class Enderecos {
    
    private String logradouro;
    private int numeroCasa;
    private String bairro;
    private String cidade;
    private String uf;
    
    
    public Enderecos(String logradouro, int numeroCasa, String bairro, String cidade, String uf) {
        this.logradouro = logradouro;
        this.numeroCasa = numeroCasa;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
    }
    
    public String getLogradouro() {
        return logradouro;
    }
    public int getNumeroCasa() {
        return numeroCasa;
    }
    public String getBairro() {
        return bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public String getUf() {
        return uf;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public void setNumeroCasa(int numeroCasa) {
        this.numeroCasa = numeroCasa;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public void setUf(String uf) {
        this.uf = uf;
    }

}