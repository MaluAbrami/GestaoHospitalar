package Service;

import DaoImpl.MedicoDaoImpl;
import java.util.List;
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
        System.out.println("--==[Alteracao de Medicos]==--");
        System.out.println("Qual o cpf do medico que deseja alterar? ");
        String cpf = scanner.nextLine();
        
        Medico procuraMedico = medicoDao.buscar(cpf);
        
        if (procuraMedico != null) {
            System.out.println("-=[Dados Atuais]=-");

            String nome = capturaAlteracao("Nome", procuraMedico.getNome());
            String id = capturaAlteracao("Identidade", procuraMedico.getIdentidade());
            String novoCpf = capturaAlteracao("CPF", procuraMedico.getCpf());
            String end = capturaAlteracao("Endereço", procuraMedico.getEndereco());
            String tel = capturaAlteracao("Telefone", procuraMedico.getTelefone());
            String crm = capturaAlteracao("CRM", procuraMedico.getCrm());
            String esp = capturaAlteracao("Especialidade", procuraMedico.getEspecialidade());
            String ctps = capturaAlteracao("CTPS", procuraMedico.getCtps());
            String senha = capturaAlteracao("Senha", procuraMedico.getSenha());

            Medico medicoAtualizado = new Medico(
                    nome, id, novoCpf, end, tel, crm, esp, ctps, senha
            );
            
            System.out.println("----------------------------------");
            
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
        
        System.out.println("--==[Exclusao de Medicos]==--");
        System.out.println("Qual o cpf do medico que deseja excluir? ");
        cpf = scanner.nextLine();
        
        Medico procuraMedico = medicoDao.buscar(cpf);
        
        if (procuraMedico != null) {
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
        } else{
            System.out.println("Erro: nao tem nenhum medico cadastrado com esse cpf.");
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
        List<Medico> medicos = medicoDao.listar();
        
        for(Medico m: medicos){
            System.out.println(m.imprimir());
            System.out.println("\n");
        }
    }
}
