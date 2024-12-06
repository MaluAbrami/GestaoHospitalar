package Service;

import DaoImpl.PacienteDaoImpl;
import java.util.Scanner;
import sistemagestaohospitalar.Paciente;

public class PacientesService {
    private PacienteDaoImpl pacienteDao;
    private Scanner scanner;
    
    public PacientesService(PacienteDaoImpl pacienteDao, Scanner scanner){
        this.pacienteDao = pacienteDao;
        this.scanner = scanner;
    }
    
    public void cadastrar(){
        String nome, id, cpf, end, tel, nomeConv, numConv;

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
        System.out.println("Nome Convênio: ");
        nomeConv = scanner.nextLine();
        System.out.println("Número Convênio: ");
        numConv = scanner.nextLine();
        
        Paciente novoPaciente = new Paciente(nome, id, cpf, end, tel, nomeConv, numConv);
        boolean retorno = pacienteDao.adicionar(novoPaciente);
        
        if(retorno){
            System.out.println("Paciente adicionado com sucesso!");
        } else{
            System.out.println("Erro: identidade, cpf ou numero de convenio ja cadastrados");
        }
    }
    
    public void alterar(){
        String nome = null, id = null, cpf = null, end = null, tel = null, nomeConv = null, numConv = null;
        int resp;
        
        System.out.println("--==[Alteração de Pacientes]==--");
        System.out.println("Qual o cpf do paciente que deseja alterar? ");
        cpf = scanner.nextLine();
        
        Paciente procuraPaciente = pacienteDao.buscar(cpf);
        Paciente pacienteAtualizado;
        
        cpf = null; //caso o usuario nao queira alterar o cpf do paciente
        
        if(procuraPaciente != null){
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + procuraPaciente.getNome());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo nome: ");
                nome = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + procuraPaciente.getIdentidade());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova identidade: ");
                id = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + procuraPaciente.getCpf());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo C.P.F.: ");
                cpf = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Endereço atual: " + procuraPaciente.getEndereco());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Endereço: ");
                end = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Telefone atual: " + procuraPaciente.getTelefone());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Telefone: ");
                tel = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Nome do Convêncio atual: " + procuraPaciente.getNomeConvenio());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Nome do Convênio: ");
                nomeConv = scanner.nextLine();
            }
            System.out.println("----------------------------------");
            System.out.println("Número do Convêncio atual: " + procuraPaciente.getNumeroConvenio());
            System.out.println("Alterar? (1-sim/2-não");
            resp = scanner.nextInt();
            scanner.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Número do Convênio: ");
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
        int pos, resp;
        
        System.out.println("--==[Exclusão de Pacientes]==--");
        System.out.println("Qual posição deseja excluir? ");
        pos = scanner.nextInt();
        scanner.skip("\n");
        
        if(pacientes[pos] != null){
            System.out.println("-=[Dados do Paciente]=-");
            pacientes[pos].imprimir();
            System.out.println("\nConfirma exclusão? (1-sim/2-não)");
            resp = scanner.nextInt();
            scanner.skip("\n");
            
            if(resp == 1){
                pacientes[pos] = null;
                System.out.println("Exclusão efetuada com sucesso.");
            }
            else{
                System.out.println("Exclusão não efetuada.");
            }
        }
        else{
            System.out.println("Paciente não existe.");
        }
    }
    
    public void consultar(){
        int pos;
        
        System.out.println("--==[Consulta de Pacientes]==--");
        System.out.println("Qual posição deseja consultar? ");
        pos = scanner.nextInt();
        scanner.skip("\n");
        
        if(pacientes[pos] != null){
            System.out.println("-=[Dados do Paciente]=-");
            pacientes[pos].imprimir();
        }
        else{
            System.out.println("Paciente não existe.");
        }
    }
    
    public void relatorio(){
        int pos = 0;
        
        System.out.println("--==[Relatório de Pacientes]==--");
        
        while(pos < pacientes.length){
            if(pacientes[pos] != null){
                pacientes[pos].imprimir();
                System.out.println("\n-----------------------------------\n");
            }
            
            pos++;
        }
    }
}
