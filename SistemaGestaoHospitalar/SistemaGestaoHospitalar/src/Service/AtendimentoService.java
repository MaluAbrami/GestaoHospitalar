package Service;

import DaoImpl.AtendimentoDaoImpl;
import DaoImpl.MedicoDaoImpl;
import DaoImpl.PacienteDaoImpl;
import java.util.List;
import java.util.Scanner;
import sistemagestaohospitalar.Atendimento;
import sistemagestaohospitalar.Estado;
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
        int idAtendimento, resp;
        Estado estadoAtual, novoEstado = null;
        
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
            System.out.println("ID do atendimento: ");
            idAtendimento = scanner.nextInt();
            scanner.skip("\n");
            
            Atendimento at = atendimentoDao.buscar(idAtendimento);
            if(at != null){
                estadoAtual = at.getEstadoAtual();
                System.out.println("Estado atual do atendimento: " + estadoAtual);
                System.out.println("Opcoes: \n1- Entrada\n2- Tratamento Clinico Geral\n3- Preparacao Pre-Cirurgia\n4- Cirurgia\n5- Pos-Cirurgia\n6- Alta Clinica");
                System.out.println("Escolha uma opcao: ");
                resp = scanner.nextInt();
                scanner.skip("\n");
                
                switch(resp){
                    case 1:{
                        novoEstado = novoEstado.Entrada;
                        break;
                    }
                    case 2:{
                        novoEstado = novoEstado.Tratamento_Clinico_Geral;
                        break;
                    }
                    case 3:{
                        novoEstado = novoEstado.Preparacao_Pre_Cirurgia;
                        break;
                    }
                    case 4:{
                        novoEstado = novoEstado.Cirurgia;
                        break;
                    }
                    case 5:{
                        novoEstado = novoEstado.Pos_Cirurgia;
                        break;
                    }
                    case 6:{
                        novoEstado = novoEstado.Alta_Clinica;
                        break;
                    }
                    default:{
                        System.out.println("Erro: Opcao invalida");
                    }
                }
                
                Atendimento atAtualizado = new Atendimento(novoEstado);
                
                if(novoEstado.equals(estadoAtual)){
                    System.out.println("Erro: o estado escolhido eh o mesmo que o estado atual do atendimento.");
                } else{
                    retorno = atendimentoDao.atualizar(atAtualizado);
                    if(retorno)
                        System.out.println("Estado do Atendimento alterado com sucesso.");
                    else
                        System.out.println("Erro: nao foi possivel atualizar o atendimento");
                }
            } else{
                System.out.println("Atendimento nao cadastrado.");
            }
        } else{
            System.out.println("Erro: nao foi possivel realizar o login.\nVerifique se os dados informados estao corretos e tente novamente.");
        }
    }
    
    public void excluir(){
        int id, resp;
        
        System.out.println("--==[Exclusao de Atendimento]==--");
        System.out.println("Qual o ID do atendimento que deseja excluir? ");
        id = scanner.nextInt();
        scanner.skip("\n");
        
        Atendimento at = atendimentoDao.buscar(id);
        
        if(at != null){
            System.out.println("-=[Dados do Atendimento]=-");
            System.out.println(at.imprimir());
            System.out.println("\nConfirma exclusao? (1-sim/2-nao)");
            resp = scanner.nextInt();
            scanner.skip("\n");
            
            if(resp == 1){
                boolean retorno = atendimentoDao.deletar(id);
                if(retorno){
                    System.out.println("Atendimento deletado com sucesso.");
                } else{
                    System.out.println("Erro: nao tem nenhum atendimento cadastrado com esse id.");
                }
            } else{
                System.out.println("Exclusao nao efetuada.");
            }
        } else{
            System.out.println("Erro: nao tem nenhum atendimento cadastrado com esse id.");
        }
    }
}
