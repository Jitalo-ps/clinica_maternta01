import javax.swing.JOptionPane;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CadastroPessoas cadastro = new CadastroPessoas();
        CadastroAgendamentos cadastroAgendamentos = new CadastroAgendamentos();
        
        // Lista de médicos
        List<Medico> medicos = Arrays.asList(
            new Medico(1, "Dr. João"),
            new Medico(2, "Dra. Maria")
        );

        while (true) {
            String opcaoStr = JOptionPane.showInputDialog(
                null,
                "Escolha uma opção:\n1. Adicionar Pessoa\n2. Listar Pessoas\n3. Editar Pessoa\n4. Excluir Pessoa\n5. Agendar Consulta\n6. Listar Agendamentos\n7. Cancelar Consulta\n8. Sair",
                "Sistema de Cadastro",
                JOptionPane.QUESTION_MESSAGE
            );

            if (opcaoStr == null) {
                JOptionPane.showMessageDialog(null, "Saindo...");
                break;
            }

            int opcao;
            try {
                opcao = Integer.parseInt(opcaoStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                continue;
            }

            switch (opcao) {
                case 1:
                    adicionarPessoa(cadastro);
                    break;
                case 2:
                    listarPessoas(cadastro);
                    break;
                case 3:
                    editarPessoa(cadastro);
                    break;
                case 4:
                    excluirPessoa(cadastro);
                    break;
                case 5:
                    agendarConsulta(cadastro, cadastroAgendamentos, medicos);
                    break;
                case 6:
                    listarAgendamentos(cadastroAgendamentos);
                    break;
                case 7:
                    cancelarConsulta(cadastroAgendamentos);
                    break;
                case 8:
                    JOptionPane.showMessageDialog(null, "Saindo...");
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!", "Erro", JOptionPane.ERROR_MESSAGE);
                    break;
            }
        }
    }

    private static void adicionarPessoa(CadastroPessoas cadastro) {
        String nomeBebe = JOptionPane.showInputDialog("Nome do Bebê:");
        String nomeMae = JOptionPane.showInputDialog("Nome da Mãe:");
        String endereco = JOptionPane.showInputDialog("Endereço:");
        String telefone = JOptionPane.showInputDialog("Telefone:");
        String dataNascimento = JOptionPane.showInputDialog("Data de Nascimento (dd/MM/yyyy):");

        if (nomeBebe != null && nomeMae != null && endereco != null && telefone != null && dataNascimento != null) {
            Pessoa pessoa = new Pessoa(nomeBebe, nomeMae, endereco, telefone, dataNascimento);
            cadastro.adicionarPessoa(pessoa);
            JOptionPane.showMessageDialog(null, "Paciente adicionado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Operação cancelada.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void listarPessoas(CadastroPessoas cadastro) {
        String listaPessoas = cadastro.listarPessoas();
        JOptionPane.showMessageDialog(null, listaPessoas.length() > 0 ? listaPessoas : "Nenhum paciente cadastrado.");
    }

    private static void editarPessoa(CadastroPessoas cadastro) {
        String idEditarStr = JOptionPane.showInputDialog("Digite o ID doo(a) paciente que deseja editar:");
        try {
            int idEditar = Integer.parseInt(idEditarStr);
            EditarCadastro.editarPessoa(cadastro, idEditar);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void excluirPessoa(CadastroPessoas cadastro) {
        String idExcluirStr = JOptionPane.showInputDialog("Digite o ID do(a) paciente que deseja excluir:");
        try {
            int idExcluir = Integer.parseInt(idExcluirStr);
            ExcluirCadastro.excluirPessoa(cadastro, idExcluir);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void agendarConsulta(CadastroPessoas cadastro, CadastroAgendamentos cadastroAgendamentos, List<Medico> medicos) {
        String idPessoaStr = JOptionPane.showInputDialog("Digite o ID do(a) paciente:");
        try {
            int idPessoa = Integer.parseInt(idPessoaStr);
            Pessoa pessoa = cadastro.encontrarPessoaPorId(idPessoa);
            if (pessoa == null) {
                JOptionPane.showMessageDialog(null, "Paciente não encontrado(a)!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String medicoStr = "Escolha um médico:\n";
            for (Medico medico : medicos) {
                medicoStr += medico.getId() + ". " + medico.getNome() + "\n";
            }

            String idMedicoStr = JOptionPane.showInputDialog(medicoStr);
            int idMedico = Integer.parseInt(idMedicoStr);
            Medico medico = medicos.stream().filter(m -> m.getId() == idMedico).findFirst().orElse(null);

            if (medico == null) {
                JOptionPane.showMessageDialog(null, "Médico não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String data = JOptionPane.showInputDialog("Data da consulta (dd/MM/yyyy):");
            String hora = JOptionPane.showInputDialog("Hora da consulta (HH:mm):");

            if (data != null && hora != null) {
                Agendamento agendamento = new Agendamento(pessoa, medico, data, hora);
                cadastroAgendamentos.adicionarAgendamento(agendamento);
                JOptionPane.showMessageDialog(null, "Consulta agendada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Operação cancelada.", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private static void listarAgendamentos(CadastroAgendamentos cadastroAgendamentos) {
        String listaAgendamentos = cadastroAgendamentos.listarAgendamentos();
        JOptionPane.showMessageDialog(null, listaAgendamentos.length() > 0 ? listaAgendamentos : "Nenhum agendamento cadastrado.");
    }

    private static void cancelarConsulta(CadastroAgendamentos cadastroAgendamentos) {
        String idAgendamentoStr = JOptionPane.showInputDialog("Digite o ID do agendamento que deseja cancelar:");
        try {
            int idAgendamento = Integer.parseInt(idAgendamentoStr);
            boolean removido = cadastroAgendamentos.removerAgendamento(idAgendamento);
            if (removido) {
                JOptionPane.showMessageDialog(null, "Agendamento cancelado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Agendamento não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "ID inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
}