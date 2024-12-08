package sistemagestaohospitalar;

public class Atendimento {
    private int id;
    private int contadorId = 1;
    private Paciente paciente;
    private Medico medico;
    private Estado estadoAtual;
    
    public Atendimento(){
        this.id = contadorId++;
        this.estadoAtual = Estado.Entrada;
    }
    
    public Atendimento(Estado estadoAtual){
        this.estadoAtual = estadoAtual;
    }
    
    public int getId(){
        return id;
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

}
