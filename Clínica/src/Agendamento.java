public class Agendamento {
    private static int contadorId = 0;
    private int id;
    private Pessoa pessoa;
    private Medico medico;
    private String data;
    private String hora;

    public Agendamento(Pessoa pessoa, Medico medico, String data, String hora) {
        this.id = ++contadorId;
        this.pessoa = pessoa;
        this.medico = medico;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public Medico getMedico() {
        return medico;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    @Override
    public String toString() {
        return "ID: " + id + "\n" +
               "Pessoa: " + pessoa.getNomeBebe() + "\n" +
               "Médico: " + medico.getNome() + "\n" +
               "Data: " + data + "\n" +
               "Hora: " + hora + "\n";
    }
}