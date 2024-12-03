package sistemagestaohospitalar;

//PERMITIR QUE APENAS O MÉDICO ALTERE O STATUS DO ATENDIMENTO DO PACIENTE
//ALGUM MEDICO SERA DESIGNADO PARA ATENDER ESSE PACIENTE E DEPOIS SERA APENAS ELE QUE ATENDERA
//POSSÍVEIS VALIDAÇÕES
    //solicitar crm do médico e verificar se está cadastrado no sistema. ("LOGIN")
    //Talvez atribuir o método de alterar status no controller de medicos
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
