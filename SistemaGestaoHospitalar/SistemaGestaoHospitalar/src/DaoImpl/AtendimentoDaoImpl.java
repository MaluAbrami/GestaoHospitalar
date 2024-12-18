package DaoImpl;

import Dao.AtendimentoDao;
import java.util.ArrayList;
import java.util.List;
import sistemagestaohospitalar.Atendimento;
import sistemagestaohospitalar.Medico;
import sistemagestaohospitalar.Paciente;

public class AtendimentoDaoImpl implements AtendimentoDao{
    private List<Atendimento> atendimentos;
    private static int contador = 1;
    
    public AtendimentoDaoImpl(){
        this.atendimentos = new ArrayList();
    }
    
    @Override
    public boolean adicionar(Atendimento at, Medico m, Paciente p) {
        for(Atendimento atendimento: atendimentos){
            if(atendimento.getPaciente().getCpf().equals(p.getCpf())){ //verifica se o paciente ja esta em um atendimento
                return false;
            }
        } 
        atendimentos.add(at);
        at.adicionarMedico(m);
        at.adicionarPaciente(p);
        at.setId(contador++);
        return true;
    }

    @Override
    public boolean atualizar(int id, Atendimento at) {
        Atendimento atendimentoExistente = buscar(id);
        if(atendimentoExistente != null){
            int posicao = atendimentos.indexOf(atendimentoExistente);
            atendimentos.set(posicao, at);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean deletar(int id) {
        Atendimento at = buscar(id);
        if(at != null){
            atendimentos.remove(at);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public List<Atendimento> listar() {
        return atendimentos;
    }

    @Override
    public Atendimento buscar(int id) {
        for(Atendimento at: atendimentos){
            if(at.getId() == id)
                return at;
        }
        return null;
    }
    
}
