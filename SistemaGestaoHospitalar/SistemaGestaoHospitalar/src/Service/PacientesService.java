package Service;

import DaoImpl.PacienteDaoImpl;
import java.util.Scanner;
import sistemagestaohospitalar.Paciente;

public class PacientesService {
    private AtendimentoService atendimentoService;
    private PacienteDaoImpl pacienteDao; 
    private Scanner scanner;
    
    public PacientesService(AtendimentoService atendimentoService, PacienteDaoImpl pacienteDao, Scanner scanner){
        this.atendimentoService = atendimentoService;
        this.pacienteDao = pacienteDao;
        this.scanner = scanner;
    }
    
    public void cadastrar(){
        String nome, id, cpf, end, tel, nomeConv, numConv, medicoCrm;

        System.out.println("--==[Cadastro de Pacientes]==--");
        System.out.println("Nome: ");
        nome = scanner.nextLine();
        System.out.println("Identidade: ");
        id = scanner.nextLine();
        System.out.println("C.P.F.: ");
        cpf = scanner.nextLine();
        System.out.println("Endereço: ");
        end = scanner.nextLine();
        System.out.println("Telefone: ");
        tel = scanner.nextLine();
        System.out.println("Nome Convenio: ");
        nomeConv = scanner.nextLine();
        System.out.println("Número Convenio: ");
        numConv = scanner.nextLine();
        
        Paciente novoPaciente = new Paciente(nome, id, cpf, end, tel, nomeConv, numConv);
        boolean retorno = pacienteDao.adicionar(novoPaciente);
        
        if(retorno){
            System.out.println("Paciente cadastrado com sucesso!");
            
            System.out.println("Deseja dar entrada no paciente? (1-sim/2-nao)");
            int resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("C.R.M do Medico ao qual sera designado: ");
                medicoCrm = scanner.nextLine();
                atendimentoService.cadastrar(medicoCrm, novoPaciente);
            } else{
                System.out.println("Paciente nao deu entrada no hospital");
            }
        } else{
            System.out.println("Erro: identidade, cpf ou numero de convenio ja cadastrados");
        }
    }
    
    public void alterar(){
        String nome = null, id = null, cpf, end = null, tel = null, nomeConv = null, numConv = null;
        int resp;
        
        System.out.println("--==[Alteracao de Pacientes]==--");
        System.out.println("Qual o cpf do paciente que deseja alterar? ");
        cpf = scanner.nextLine();
        
        Paciente procuraPaciente = pacienteDao.buscar(cpf);
        Paciente pacienteAtualizado;
        
        cpf = null; //caso o usuario nao queira alterar o cpf do paciente
        
        if(procuraPaciente != null){
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + procuraPaciente.getNome());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo nome: ");
                nome = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + procuraPaciente.getIdentidade());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova identidade: ");
                id = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + procuraPaciente.getCpf());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo C.P.F.: ");
                cpf = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Endereco atual: " + procuraPaciente.getEndereco());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Endereco: ");
                end = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Telefone atual: " + procuraPaciente.getTelefone());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Telefone: ");
                tel = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Nome do Convenio atual: " + procuraPaciente.getNomeConvenio());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Nome do Convenio: ");
                nomeConv = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Numero do Convenio atual: " + procuraPaciente.getNumeroConvenio());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Numero do Convenio: ");
                numConv = scanner.nextLine();
            }
            
            System.out.println("----------------------------------");

            pacienteAtualizado = new Paciente(nome, id, cpf, end, tel, nomeConv, numConv);
            boolean retorno = pacienteDao.atualizar(pacienteAtualizado);
            if(retorno){
                System.out.println("Paciente atualizado com sucesso.");
            } else{
                System.out.println("Erro: identidade, cpf ou numero do convenio ja cadastrados");
            }
        }
        else{
            System.out.println("Erro: paciente nao cadastrado");
        }
    }
    
    public void excluir(){
        String cpf;
        int resp;
        
        System.out.println("--==[Exclusao de Pacientes]==--");
        System.out.println("Qual o cpf do paciente que deseja excluir? ");
        cpf = scanner.nextLine();
        
        Paciente procuraPaciente = pacienteDao.buscar(cpf);

        System.out.println("-=[Dados do Paciente]=-");
        System.out.println(procuraPaciente.imprimir());
        System.out.println("\nConfirma exclusao? (1-sim/2-nao)");
        resp = scanner.nextInt();
        scanner.skip("\n");

        if (resp == 1) {
            boolean retorno = pacienteDao.deletar(cpf);
            if(retorno){
                System.out.println("Paciente deletado com sucesso.");
            } else{
                System.out.println("Erro: nao tem nenhum paciente cadastrado com esse cpf.");
            }
        } else {
            System.out.println("Exclusao nao efetuada.");
        }
    }
    
    public void consultar(){
        String cpf;
        
        System.out.println("--==[Consulta de Pacientes]==--");
        System.out.println("Qual o cpf do paciente que deseja consultar? ");
        cpf = scanner.nextLine();
        
        Paciente procuraPaciente = pacienteDao.buscar(cpf);
        
        if(procuraPaciente != null){
            System.out.println("-=[Dados do Paciente]=-");
            System.out.println(procuraPaciente.imprimir());
        }
        else{
            System.out.println("Paciente não existe.");
        }
    }
    
    public void relatorio(){
        System.out.println("--==[Relatorio de Pacientes]==--");
        pacienteDao.listar();
    }
}
