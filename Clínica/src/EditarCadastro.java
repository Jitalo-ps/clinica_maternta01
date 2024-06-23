import javax.swing.JOptionPane;

public class EditarCadastro {
    public static void editarPessoa(CadastroPessoas cadastro, int id) {
        Pessoa pessoa = cadastro.encontrarPessoaPorId(id);
        if (pessoa == null) {
            JOptionPane.showMessageDialog(null, "Paciente não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nomeBebe = JOptionPane.showInputDialog("Nome do Bebê:", pessoa.getNomeBebe());
        String nomeMae = JOptionPane.showInputDialog("Nome da Mãe:", pessoa.getNomeMae());
        String endereco = JOptionPane.showInputDialog("Endereço:", pessoa.getEndereco());
        String telefone = JOptionPane.showInputDialog("Telefone:", pessoa.getTelefone());
        String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy):", pessoa.getDataNascimento());

        if (nomeBebe != null && nomeMae != null && endereco != null && telefone != null && dataNascimento != null) {
            pessoa.setNomeBebe(nomeBebe);
            pessoa.setNomeMae(nomeMae);
            pessoa.setEndereco(endereco);
            pessoa.setTelefone(telefone);
            pessoa.setDataNascimento(dataNascimento);
            JOptionPane.showMessageDialog(null, "Paciente editado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}