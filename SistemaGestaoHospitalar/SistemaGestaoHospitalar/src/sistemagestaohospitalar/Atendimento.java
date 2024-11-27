package sistemagestaohospitalar;

//PERMITIR QUE APENAS O MÉDICO ALTERE O STATUS DO ATENDIMENTO DO PACIENTE
//ALGUM MEDICO SERA DESIGNADO PARA ATENDER ESSE PACIENTE E DEPOIS SERA APENAS ELE QUE ATENDERA
//POSSÍVEIS VALIDAÇÕES
    //solicitar crm do médico e verificar se está cadastrado no sistema. ("LOGIN")
    //Talvez atribuir o método de alterar status no controller de medicos
public class Atendimento {
    private String status;
    private Paciente paciente;
    private Medico medico;
    
    public Atendimento(){ //Construtor inicial, define o valor inicial de entrada assim que o pacinte entra no hospital
        this.status = "Entrada";
    }

    public Atendimento(Paciente paciente, Medico medico) {
        this.paciente = paciente;
        this.medico = medico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) { 
        this.status = status;
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
    
    
}
