import java.util.HashMap;
import java.util.Map;

public class CadastroPessoas {
    private Map<Integer, Pessoa> pessoas;

    public CadastroPessoas() {
        this.pessoas = new HashMap<>();
    }

    public void adicionarPessoa(Pessoa pessoa) {
        pessoas.put(pessoa.getId(), pessoa);
    }

    public Pessoa encontrarPessoaPorId(int id) {
        return pessoas.get(id);
    }

    public boolean removerPessoa(int id) {
        return pessoas.remove(id) != null;
    }

    public String listarPessoas() {
        StringBuilder listaPessoas = new StringBuilder();
        for (Pessoa pessoa : pessoas.values()) {
            listaPessoas.append(pessoa).append("\n");
        }
        return listaPessoas.toString();
    }
}