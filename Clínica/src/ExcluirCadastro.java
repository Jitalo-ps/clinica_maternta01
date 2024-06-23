import javax.swing.JOptionPane;

public class ExcluirCadastro {
    public static void excluirPessoa(CadastroPessoas cadastro, int id) {
        boolean removida = cadastro.removerPessoa(id);
        if (removida) {
            JOptionPane.showMessageDialog(null, "Paciente removido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}
