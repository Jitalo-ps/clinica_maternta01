public class Pessoa {
    private static int contadorId = 0; 
    private int id;
    private String nomeBebe;
    private String nomeMae;
    private String endereco;
    private String telefone;
    private String dataNascimento;

    public Pessoa(String nomeBebe, String nomeMae, String endereco, String telefone, String dataNascimento) {
        this.id = ++contadorId;
        this.nomeBebe = nomeBebe;
        this.nomeMae = nomeMae;
        this.endereco = endereco;
        this.telefone = telefone;
        this.dataNascimento = dataNascimento;
    }

    public int getId() {
        return id;
    }

    public String getNomeBebe() {
        return nomeBebe;
    }

    public String getNomeMae() {
        return nomeMae;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setNomeBebe(String nomeBebe) {
        this.nomeBebe = nomeBebe;
    }

    public void setNomeMae(String nomeMae) {
        this.nomeMae = nomeMae;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
               "Nome do Bebê: " + nomeBebe + "\n" +
               "Nome da Mãe: " + nomeMae + "\n" +
               "Endereço: " + endereco + "\n" +
               "Telefone: " + telefone + "\n" +
               "Data de Nascimento: " + dataNascimento + "\n";
    }
}