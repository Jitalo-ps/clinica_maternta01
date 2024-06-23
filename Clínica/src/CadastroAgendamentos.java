import java.util.ArrayList;
import java.util.List;

public class CadastroAgendamentos {
    private List<Agendamento> agendamentos;

    public CadastroAgendamentos() {
        this.agendamentos = new ArrayList<>();
    }

    public void adicionarAgendamento(Agendamento agendamento) {
        agendamentos.add(agendamento);
    }

    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public Agendamento encontrarAgendamentoPorId(int id) {
        for (Agendamento agendamento : agendamentos) {
            if (agendamento.getId() == id) {
                return agendamento;
            }
        }
        return null;
    }

    public boolean removerAgendamento(int id) {
        Agendamento agendamento = encontrarAgendamentoPorId(id);
        if (agendamento != null) {
            agendamentos.remove(agendamento);
            return true;
        }
        return false;
    }

    public String listarAgendamentos() {
        StringBuilder listaAgendamentos = new StringBuilder();
        for (Agendamento agendamento : agendamentos) {
            listaAgendamentos.append(agendamento).append("\n");
        }
        return listaAgendamentos.toString();
    }
}