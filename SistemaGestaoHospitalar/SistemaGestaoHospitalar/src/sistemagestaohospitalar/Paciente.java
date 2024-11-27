package sistemagestaohospitalar;

public class Paciente extends Pessoa {
    private String nomeConvenio;
    private String numeroConvenio;
    
    public Paciente(String nome, String identidade, String cpf, String endereco, String telefone, String nomeConv, String numConv) {
        super(nome, identidade, cpf, endereco, telefone);
        
        this.nomeConvenio = nomeConv;
        this.numeroConvenio = numConv;
    }

    public String getNomeConvenio() {
        return nomeConvenio;
    }

    public void setNomeConvenio(String nomeConvenio) {
        this.nomeConvenio = nomeConvenio;
    }

    public String getNumeroConvenio() {
        return numeroConvenio;
    }

    public void setNumeroConvenio(String numeroConvenio) {
        this.numeroConvenio = numeroConvenio;
    }
    
    @Override
    public String imprimir(){
        StringBuilder report = new StringBuilder();
        
        report.append(super.imprimir())
                .append("\nNome convenio : ").append(nomeConvenio)
                .append("\nNumero convenio : ").append(numeroConvenio);
        
        return report.toString(); 
    }
}
