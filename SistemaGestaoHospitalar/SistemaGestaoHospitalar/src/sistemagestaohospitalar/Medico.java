package sistemagestaohospitalar;

public class Medico extends Pessoa {
    private String crm;
    private String especialidade;
    private String ctps;
    private String senha;
    
    public Medico(String nome, String identidade, String cpf, String endereco, String telefone, String crm, String esp, String ctps, String senha) {
        super(nome, identidade, cpf, endereco, telefone);
        this.crm = crm;
        this.especialidade = esp;
        this.ctps = ctps;
        this.senha = senha;
    }

    public String getCrm() {
        return crm;
    }

    public void setCrm(String crm) {
        this.crm = crm;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getCtps() {
        return ctps;
    }

    public void setCtps(String ctps) {
        this.ctps = ctps;
    }
    
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    @Override
    public String imprimir(){
        StringBuilder report = new StringBuilder();
        
        report.append(super.imprimir())
                .append("\nC.R.M. : ").append(crm)
                .append("\nEspecialidade : ").append(especialidade)
                .append("\nC.T.P.S. : ").append(ctps);
        
        return report.toString();
    }
}
