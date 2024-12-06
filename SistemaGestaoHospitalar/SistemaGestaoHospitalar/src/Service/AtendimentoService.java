package Service;

import DaoImpl.AtendimentoDaoImpl;
import DaoImpl.MedicoDaoImpl;
import DaoImpl.PacienteDaoImpl;
import java.util.List;
import sistemagestaohospitalar.Atendimento;
import sistemagestaohospitalar.Medico;
import sistemagestaohospitalar.Paciente;

public class AtendimentoService {
    private AtendimentoDaoImpl atendimentoDao;
    private MedicoDaoImpl medicoDao;
    private PacienteDaoImpl pacienteDao;
    
    public AtendimentoService(AtendimentoDaoImpl atendimentoDao, MedicoDaoImpl medicoDao, PacienteDaoImpl pacienteDao){
        this.atendimentoDao = atendimentoDao;
        this.medicoDao = medicoDao;
        this.pacienteDao = pacienteDao;
    }
    
    public void cadastrar(String crm, Paciente p){
        List<Medico> medicosExistentes = medicoDao.listar();
        Paciente procuraPaciente = pacienteDao.buscar(p.getCpf());
        
        if(medicosExistentes.isEmpty()){
            System.out.print("A lista de medicos cadastrados no sistema esta vazia");
        } else if(procuraPaciente == null){
            System.out.print("O paciente informado nao existe");
        } 
        
        for(Medico m: medicosExistentes){
            if(m.getCrm().equals(m.getCrm())){
                Atendimento at = new Atendimento();
                atendimentoDao.adicionar(at);
                at.adicionarMedico(m); //adiciona o medico ao atendimento
                at.adicionarPaciente(p); //adiciona o paciente ao atendimento
                System.out.println(at.getEstadoAtual().getDescricao());
                System.out.println("Paciente: " + p.getNome() + ", Medico designado: " + m.getNome() + ", Especialidade do medico: " + m.getEspecialidade());
            }
        }
        System.out.println("Erro: nao tem nenhum medico cadastrado com essa crm no sistema");
    }
}
