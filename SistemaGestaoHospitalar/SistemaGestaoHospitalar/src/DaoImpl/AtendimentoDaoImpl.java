package DaoImpl;

import Dao.AtendimentoDao;
import java.util.ArrayList;
import java.util.List;
import sistemagestaohospitalar.Atendimento;

public class AtendimentoDaoImpl implements AtendimentoDao{
    private List<Atendimento> atendimentos;
    private static int contador = 1;
    
    public AtendimentoDaoImpl(){
        this.atendimentos = new ArrayList();
    }
    
    @Override
    public void adicionar(Atendimento at) {
        atendimentos.add(at);
        at.setId(contador++);
    }

    @Override
    public boolean atualizar(Atendimento at) {
        Atendimento atendimentoExistente = buscar(at.getId());
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
