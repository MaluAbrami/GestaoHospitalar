package DaoImpl;

import Dao.MedicoDao;
import java.util.ArrayList;
import java.util.List;
import sistemagestaohospitalar.Medico;

public class MedicoDaoImpl implements MedicoDao{
    private List<Medico> medicos;
    
    public MedicoDaoImpl(){
        this.medicos = new ArrayList();
    }
    
    @Override
    public void adicionar(Medico m) {
        medicos.add(m);
    }

    @Override
    public boolean atualizar(Medico m) {
        Medico medicoAlterar = buscar(m.getCpf());
        if(medicoAlterar != null){
            int posicao = medicos.indexOf(medicoAlterar);
            medicos.set(posicao, m);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean deletar(String cpf) {
        Medico medicoDeletar = buscar(cpf);
        if(medicoDeletar != null){
            medicos.remove(medicoDeletar);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public Medico[] listar() {
        Medico[] listaDeMedicos = null;
        for(int i = 0; i < medicos.size(); i++){
            listaDeMedicos[i] = medicos.get(i);
        }
        return listaDeMedicos;
    }

    @Override
    public Medico buscar(String cpf) {
        for(Medico m: medicos){
            if(m.getCpf().equals(cpf)){
                return m;
            }
        }
        return null;
    }

    @Override
    public boolean login(String crm, String senha) {
        for(Medico m: medicos){
            if(m.getCrm().equals(crm) && m.getSenha().equals(senha)){
                return true;
            }
        }
        return false;
    }
    
}
