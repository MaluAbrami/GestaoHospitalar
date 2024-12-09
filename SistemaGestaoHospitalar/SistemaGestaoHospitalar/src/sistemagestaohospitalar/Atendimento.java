package sistemagestaohospitalar;

public class Atendimento {
    private int id;
    private Paciente paciente;
    private Medico medico;
    private Estado estadoAtual;
    
    public Atendimento(){
        this.estadoAtual = Estado.Entrada;
    }
    
    public Atendimento(Estado estadoAtual){
        this.estadoAtual = estadoAtual;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    
    public void adicionarPaciente(Paciente p){
        paciente = p;
    }
    
    public void adicionarMedico(Medico m){
        medico = m;
    }

    public Estado getEstadoAtual() {
        return estadoAtual;
    }

    public void setEstadoAtual(Estado estadoAtual) {
        this.estadoAtual = estadoAtual;
    }
    
    public String imprimir(){
        StringBuilder report = new StringBuilder();
        
        report.append("ID: ").append(id)
                .append("\nPaciente: ").append(paciente.getNome())
                .append(", Medico: ").append(medico.getNome())
                .append(", Estado do Atendimento: ").append(estadoAtual);
        
        return report.toString();
    }
}
