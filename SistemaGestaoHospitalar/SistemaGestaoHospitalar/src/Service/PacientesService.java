package Service;

import DaoImpl.PacienteDaoImpl;
import java.util.List;
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
        System.out.println("Endereco: ");
        end = scanner.nextLine();
        System.out.println("Telefone: ");
        tel = scanner.nextLine();
        System.out.println("Nome Convenio: ");
        nomeConv = scanner.nextLine();
        System.out.println("Numero Convenio: ");
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
        System.out.println("--==[Alteracao de Pacientes]==--");
        System.out.println("Qual o cpf do paciente que deseja alterar? ");
        String cpf = scanner.nextLine();
        
        Paciente procuraPaciente = pacienteDao.buscar(cpf);
        
        if(procuraPaciente != null){
            System.out.println("-=[Dados Atuais]=-");
            
            String nome = capturaAlteracao("Nome", procuraPaciente.getNome());
            String id = capturaAlteracao("Identidade", procuraPaciente.getIdentidade());
            String novoCpf = capturaAlteracao("CPF", procuraPaciente.getCpf());
            String end = capturaAlteracao("Endereço", procuraPaciente.getEndereco());
            String tel = capturaAlteracao("Telefone", procuraPaciente.getTelefone());
            String nomeConv = capturaAlteracao("Nome do Convenio", procuraPaciente.getNomeConvenio());
            String numConv = capturaAlteracao("Numero do Convenio", procuraPaciente.getNumeroConvenio());
            
            Paciente pacienteAtualizado = new Paciente(
                    nome, id, novoCpf, end, tel, nomeConv, numConv
            );
            
            System.out.println("----------------------------------");

            boolean retorno = pacienteDao.atualizar(cpf, pacienteAtualizado);
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
    
    private String capturaAlteracao(String campo, String valorAtual) {
        System.out.println(campo + " atual: " + valorAtual);
        System.out.println("Alterar? (1-sim / 2-nao)");
        int resp = scanner.nextInt();
        scanner.nextLine(); // Consome a quebra de linha
        if (resp == 1) {
            System.out.println("Digite o novo " + campo + ":");
            return scanner.nextLine();
        }
        return valorAtual; // Retorna o valor atual caso o usuario nao deseje alterar
    }
    
    public void excluir(){
        String cpf;
        int resp;
        
        System.out.println("--==[Exclusao de Pacientes]==--");
        System.out.println("Qual o cpf do paciente que deseja excluir? ");
        cpf = scanner.nextLine();
        
        Paciente procuraPaciente = pacienteDao.buscar(cpf);

        if(procuraPaciente != null){
            System.out.println("-=[Dados do Paciente]=-");
            System.out.println(procuraPaciente.imprimir());
            System.out.println("\nConfirma exclusao? (1-sim/2-nao)");
            resp = scanner.nextInt();
            scanner.skip("\n");

            if (resp == 1) {
                boolean retorno = atendimentoService.contemPaciente(procuraPaciente);
                
                if (retorno) {
                    System.out.println("Erro: paciente esta ligado a um atendimento, portanto nao pode ser deletado.");
                } else{
                    retorno = pacienteDao.deletar(cpf);
                    if (retorno) {
                        System.out.println("Paciente deletado com sucesso.");
                    } else {
                        System.out.println("Erro: nao foi possivel deletar o paciente");
                    }
                }
            } else {
                System.out.println("Exclusao nao efetuada.");
            }
        } else{
            System.out.println("Erro: paciente nao existe");
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
            System.out.println("Paciente nao existe.");
        }
    }
    
    public void relatorio(){
        System.out.println("--==[Relatorio de Pacientes]==--");
        List<Paciente> pacientes = pacienteDao.listar();
        
        if(pacientes.isEmpty())
            System.out.println("Nao tem nenhum paciente cadastrado.");
        
        for(Paciente p: pacientes){
            System.out.println(p.imprimir());
            System.out.println("\n");
        }
    }
}
