package Service;

import DaoImpl.AtendimentoDaoImpl;
import DaoImpl.MedicoDaoImpl;
import DaoImpl.PacienteDaoImpl;
import java.util.List;
import java.util.Scanner;
import sistemagestaohospitalar.Atendimento;
import sistemagestaohospitalar.Medico;
import sistemagestaohospitalar.Paciente;

public class AtendimentoService {
    private AtendimentoDaoImpl atendimentoDao;
    private MedicoDaoImpl medicoDao;
    private PacienteDaoImpl pacienteDao;
    private Scanner scanner;
    
    public AtendimentoService(AtendimentoDaoImpl atendimentoDao, MedicoDaoImpl medicoDao, PacienteDaoImpl pacienteDao, Scanner scanner){
        this.atendimentoDao = atendimentoDao;
        this.medicoDao = medicoDao;
        this.pacienteDao = pacienteDao;
        this.scanner = scanner;
    }
    
    public void cadastrar(String crm, Paciente p){ //sera usado quando o atendimento for realizado junto ao cadastro do paciente
        List<Medico> medicosExistentes = medicoDao.listar();
        Paciente procuraPaciente = pacienteDao.buscar(p.getCpf());
        
        if(medicosExistentes.isEmpty()){
            System.out.print("A lista de medicos cadastrados no sistema esta vazia");
        } 
        
        for(Medico m: medicosExistentes){
            if(m.getCrm().equals(crm)){
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
    
    public void cadastrar(){
        List<Medico> medicosExistentes = medicoDao.listar();
        String crmMedico, cpfPaciente;
        
        if(medicosExistentes.isEmpty()){
            System.out.print("A lista de medicos cadastrados no sistema esta vazia");
        } else{
            System.out.println("Informe o cpf do paciente: ");
            cpfPaciente = scanner.nextLine();
            Paciente pacienteExistente = pacienteDao.buscar(cpfPaciente);
            
            if(pacienteExistente != null){
                System.out.println("Informe o C.R.M. do medico que sera designado: ");
                crmMedico = scanner.nextLine();

                for (Medico m : medicosExistentes) {
                    if (m.getCrm().equals(m.getCrm())) {
                        Atendimento at = new Atendimento();
                        atendimentoDao.adicionar(at);
                        at.adicionarMedico(m); //adiciona o medico ao atendimento
                        at.adicionarPaciente(pacienteExistente); //adiciona o paciente ao atendimento
                        System.out.println(at.getEstadoAtual().getDescricao());
                        System.out.println("Paciente: " + pacienteExistente.getNome() + ", Medico designado: " + m.getNome() + ", Especialidade do medico: " + m.getEspecialidade());
                    }
                }
                System.out.println("Erro: nao tem nenhum medico cadastrado com essa crm no sistema");
            } else{
                System.out.println("Erro: nao tem nenhum paciente cadastrado com o cpf informado");
            }
        }
    }
    
    public void alterarEstado(){
        String medicoCrm, medicoSenha;
        
        System.out.println("--==[Alteracao de Estado do Atendimento]==--");
        System.out.println("'Somente medicos podem realizar a alteracao do estado de um atendimento'");
        
        System.out.println("--==[LOGIN]==--");
        System.out.println("Informe seu C.R.M.: ");
        medicoCrm = scanner.nextLine();
        scanner.skip("\n");
        System.out.println("Informe sua Senha: ");
        medicoSenha = scanner.nextLine();
        scanner.skip("\n");
        
        boolean retorno = medicoDao.login(medicoCrm, medicoSenha);
        
        if(retorno){
            
        } else{
            System.out.println("Erro: nao foi possivel realizar o login.\nVerifique se os dados informados estao corretos e tente novamente.");
        }
    }
}
