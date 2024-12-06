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
    public boolean atualizar(Paciente p) {
        Paciente pacienteAlterar = buscar(p.getCpf());
        if(pacienteAlterar != null){
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
    public Paciente[] listar() {
        Paciente[] listaDePacientes = null;
        for(int i = 0; i < pacientes.size(); i++){
            listaDePacientes[i] = pacientes.get(i);
        }
        return listaDePacientes;
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
