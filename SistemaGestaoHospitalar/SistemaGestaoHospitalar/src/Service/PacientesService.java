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
        String nome, id, cpf, end, tel, nomeConv, numConv;
        int pos, resp;
        
        System.out.println("--==[Alteração de Pacientes]==--");
        System.out.println("Qual posição deseja alterar? ");
        pos = ent.nextInt();
        ent.skip("\n");
        if(pacientes[pos] != null){
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + pacientes[pos].getNome());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo nome: ");
                nome = ent.nextLine();
                pacientes[pos].setNome(nome);
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + pacientes[pos].getIdentidade());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova identidade: ");
                id = ent.nextLine();
                pacientes[pos].setIdentidade(id);
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + pacientes[pos].getCpf());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo C.P.F.: ");
                cpf = ent.nextLine();
                pacientes[pos].setCpf(cpf);
            }
            System.out.println("----------------------------------");
            System.out.println("Endereço atual: " + pacientes[pos].getEndereco());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Endereço: ");
                end = ent.nextLine();
                pacientes[pos].setEndereco(end);
            }
            System.out.println("----------------------------------");
            System.out.println("Telefone atual: " + pacientes[pos].getTelefone());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Telefone: ");
                tel = ent.nextLine();
                pacientes[pos].setTelefone(tel);
            }
            System.out.println("----------------------------------");
            System.out.println("Nome do Convêncio atual: " + pacientes[pos].getNomeConvenio());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Nome do Convênio: ");
                nomeConv = ent.nextLine();
                pacientes[pos].setNomeConvenio(nomeConv);
            }
            System.out.println("----------------------------------");
            System.out.println("Número do Convêncio atual: " + pacientes[pos].getNumeroConvenio());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Número do Convênio: ");
                numConv = ent.nextLine();
                pacientes[pos].setNumeroConvenio(numConv);
            }
            System.out.println("----------------------------------");

            System.out.println("Atualização realizada com sucesso.");
        }
        else{
            System.out.println("Vetor cheio.");
        }
    }
    
    public void excluir(){
        int pos, resp;
        
        System.out.println("--==[Exclusão de Pacientes]==--");
        System.out.println("Qual posição deseja excluir? ");
        pos = ent.nextInt();
        ent.skip("\n");
        
        if(pacientes[pos] != null){
            System.out.println("-=[Dados do Paciente]=-");
            pacientes[pos].imprimir();
            System.out.println("\nConfirma exclusão? (1-sim/2-não)");
            resp = ent.nextInt();
            ent.skip("\n");
            
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
        pos = ent.nextInt();
        ent.skip("\n");
        
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
