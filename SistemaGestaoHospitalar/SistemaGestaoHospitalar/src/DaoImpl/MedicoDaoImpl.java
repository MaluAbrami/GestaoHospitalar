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
    public boolean adicionar(Medico m) {
        for (Medico medicoExistente : medicos) {
            if (medicoExistente.getIdentidade().equals(m.getIdentidade())
                    || medicoExistente.getCrm().equals(m.getCrm())
                    || medicoExistente.getCtps().equals(m.getCtps())) {
                return false; // Impede o cadastro por duplicidade de dados
            }
        }
        medicos.add(m);
        return true;
    }

    @Override
    public boolean atualizar(Medico m) {
        Medico medicoAlterar = buscar(m.getCpf());
        if(medicoAlterar != null){
            for (Medico medicoExistente : medicos) {
                if (medicoExistente.getIdentidade().equals(m.getIdentidade())
                        || medicoExistente.getCrm().equals(m.getCrm())
                        || medicoExistente.getCtps().equals(m.getCtps())) {
                    return false; // Impede a atualizacao por duplicidade de dados
                }
            }
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
    public void listar() {
        for(Medico m: medicos){
            System.out.println(m.imprimir());
        }
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
