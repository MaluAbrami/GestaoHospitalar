package Service;

import DaoImpl.MedicoDaoImpl;
import java.util.Scanner;
import sistemagestaohospitalar.Medico;

public class MedicosService {
    private MedicoDaoImpl medicoDao;
    private Scanner scanner;
    
    public MedicosService(MedicoDaoImpl medicoDao, Scanner scanner){
        this.medicoDao = medicoDao;
        this.scanner = scanner;
    }
    
    public void cadastrar(){
        String nome, id, cpf, end, tel, crm, esp, ctps, senha;
        
        System.out.println("--==[Cadastro de Medicos]==--");
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
        System.out.println("C.R.M.: ");
        crm = scanner.nextLine();
        System.out.println("Especialidade: ");
        esp = scanner.nextLine();
        System.out.println("C.T.P.S.: ");
        ctps = scanner.nextLine();
        System.out.println("Senha de acesso: ");
        senha = scanner.nextLine();

        Medico novoMedico = new Medico(nome, id, cpf, end, tel, crm, esp, ctps, senha);
        boolean retorno = medicoDao.adicionar(novoMedico);
        
        if(retorno)
            System.out.println("Medico adicionado com sucesso!");
        else
            System.out.println("Erro: identidade, crm ou ctps ja cadastrados");
    }
    
    public void alterar(){
        String nome = null, id = null, cpf, end = null, tel = null, crm = null, esp = null, ctps = null, senha = null;
        int resp;
        
        System.out.println("--==[Alteracao de Medicos]==--");
        System.out.println("Qual o cpf do medico que deseja alterar? ");
        cpf = scanner.nextLine();
        
        Medico procuraMedico = medicoDao.buscar(cpf);
        Medico medicoAtualizado;
        
        cpf = null; //caso o usuario nao queira alterar o cpf do medico
        
        if(procuraMedico != null){
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + procuraMedico.getNome());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo nome: ");
                nome = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + procuraMedico.getIdentidade());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova identidade: ");
                id = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + procuraMedico.getCpf());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo C.P.F.: ");
                cpf = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Endereco atual: " + procuraMedico.getEndereco());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Endereco: ");
                end = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Telefone atual: " + procuraMedico.getTelefone());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Telefone: ");
                tel = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("C.R.M. atual: " + procuraMedico.getCrm());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo C.R.M.: ");
                crm = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Especialidade atual: " + procuraMedico.getEspecialidade());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova Especialidade: ");
                esp = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("C.T.P.S. atual: " + procuraMedico.getCtps());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova C.T.P.S.: ");
                ctps = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Senha atual: " + procuraMedico.getSenha());
            System.out.println("Alterar? (1-sim/2-nao");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova senha: ");
                senha = scanner.nextLine();
            }
            
            System.out.println("----------------------------------");
            
            medicoAtualizado = new Medico(nome, id, cpf, end, tel, crm, esp, ctps, senha);
            boolean retorno = medicoDao.atualizar(medicoAtualizado);
            if(retorno){
                System.out.println("Medico atualizado com sucesso.");
            } else{
                System.out.println("Erro: identidade, cpf, crm ou ctps ja cadastrados");
            }
        } else{
            System.out.println("Erro: medico nao cadastrado");
        }
    }
    
    public void excluir(){
        String cpf;
        int resp;
        
        System.out.println("--==[Exclusao de Medicos]==--");
        System.out.println("Qual o cpf do medico que deseja excluir? ");
        cpf = scanner.nextLine();
        
        Medico procuraMedico = medicoDao.buscar(cpf);
        
        System.out.println("-=[Dados do Medico]=-");
        System.out.println(procuraMedico.imprimir());
        System.out.println("\nConfirma exclusao? (1-sim/2-nao)");
        resp = scanner.nextInt();
        scanner.skip("\n");

        if (resp == 1) {
            boolean retorno = medicoDao.deletar(cpf);
            if (retorno) {
                System.out.println("Medico deletado com sucesso.");
            } else {
                System.out.println("Erro: nao tem nenhum medico cadastrado com esse cpf.");
            }
        } else {
            System.out.println("Exclusao nao efetuada.");
        }
    }
    
    public void consultar(){
        String cpf;
        
        System.out.println("--==[Consulta de Medicos]==--");
        System.out.println("Qual o cpf do medico que deseja consultar? ");
        cpf = scanner.nextLine();
        
        Medico procuraMedico = medicoDao.buscar(cpf);
        
        if(procuraMedico != null){
            System.out.println("-=[Dados do Medico]=-");
            System.out.println(procuraMedico.imprimir());
        }
        else{
            System.out.println("Medico nao existe.");
        }
    }
    
    public void relatorio(){
        System.out.println("--==[Relatorio de Medicos]==--");
        medicoDao.listar();
    }
}
