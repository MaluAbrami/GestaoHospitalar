package sistemagestaohospitalar;

public enum Estado {
    Entrada("Recebeu entrada no Hospital."),
    Tratamento_Clinico_Geral("Encaminhado para consulta com Clinico Geral."),
    Preparacao_Pre_Cirurgia("Encaminhado para a pre-cirurgia."),
    Cirurgia("Encaminhado para a Cirurgia."),
    Pos_Cirurgia("Encaminhado para a pos-cirurgia."),
    Alta_Clinica("Encaminhado para a Alta Clinica.");
    
    private final String descricao;
    
    Estado(String descricao){
        this.descricao = descricao;
    }
    
    public String getDescricao(){
        return descricao;
    }
}
