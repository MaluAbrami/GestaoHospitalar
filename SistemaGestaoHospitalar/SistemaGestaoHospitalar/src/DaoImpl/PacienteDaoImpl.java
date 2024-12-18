package DaoImpl;

import Dao.PacienteDao;
import java.util.ArrayList;
import java.util.List;
import sistemagestaohospitalar.Paciente;

public class PacienteDaoImpl implements PacienteDao{
    private List<Paciente> pacientes;
    
    public PacienteDaoImpl(){
        this.pacientes = new ArrayList();
    }
    
    @Override
    public boolean adicionar(Paciente p) {
        for(Paciente pacienteExistente: pacientes){
            if(pacienteExistente.getIdentidade().equals(p.getIdentidade()) ||
                    pacienteExistente.getCpf().equals(p.getCpf()) ||
                    pacienteExistente.getNumeroConvenio().equals(p.getNumeroConvenio())){
                return false;
            }
        }
        pacientes.add(p);
        return true;
    }

    @Override
    public boolean atualizar(String cpf, Paciente p) {
        Paciente pacienteAlterar = buscar(cpf);
        if(pacienteAlterar != null){
            for(Paciente pacienteExistente: pacientes){
                if(!pacienteExistente.getCpf().equals(cpf)){ //Exclui o paciente que esta sendo alterado para evitar erro de duplicidade
                    if (pacienteExistente.getIdentidade().equals(p.getIdentidade())
                            || pacienteExistente.getCpf().equals(p.getCpf())
                            || pacienteExistente.getNumeroConvenio().equals(p.getNumeroConvenio())) {
                        return false;
                    }
                }
            }
            int posicao = pacientes.indexOf(pacienteAlterar);
            pacientes.set(posicao, p);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public boolean deletar(String cpf) {
        Paciente pacienteDeletar = buscar(cpf);
        if(pacienteDeletar != null){
            pacientes.remove(pacienteDeletar);
            return true;
        } else{
            return false;
        }
    }

    @Override
    public List<Paciente> listar() {
        return pacientes;
    }

    @Override
    public Paciente buscar(String cpf) {
        for(Paciente p: pacientes){
            if(p.getCpf().equals(cpf)){
                return p;
            }
        }
        return null;
    }
    
}
