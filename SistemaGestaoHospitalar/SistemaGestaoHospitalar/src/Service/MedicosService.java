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
        
        System.out.println("--==[Cadastro de Médicos]==--");
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
        String nome, id, cpf, end, tel, crm, esp, ctps;
        int pos, resp;
        
        System.out.println("--==[Alteração de Médicos]==--");
        System.out.println("Qual posição deseja alterar? ");
        pos = ent.nextInt();
        ent.skip("\n");
        if(medicos[pos] != null){
            System.out.println("-=[Dados]=-");
            System.out.println("Nome atual: " + medicos[pos].getNome());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo nome: ");
                nome = ent.nextLine();
                medicos[pos].setNome(nome);
            }
            System.out.println("----------------------------------");
            System.out.println("Identidade atual: " + medicos[pos].getIdentidade());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova identidade: ");
                id = ent.nextLine();
                medicos[pos].setIdentidade(id);
            }
            System.out.println("----------------------------------");
            System.out.println("C.P.F. atual: " + medicos[pos].getCpf());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo C.P.F.: ");
                cpf = ent.nextLine();
                medicos[pos].setCpf(cpf);
            }
            System.out.println("----------------------------------");
            System.out.println("Endereço atual: " + medicos[pos].getEndereco());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Endereço: ");
                end = ent.nextLine();
                medicos[pos].setEndereco(end);
            }
            System.out.println("----------------------------------");
            System.out.println("Telefone atual: " + medicos[pos].getTelefone());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo Telefone: ");
                tel = ent.nextLine();
                medicos[pos].setTelefone(tel);
            }
            System.out.println("----------------------------------");
            System.out.println("C.R.M. atual: " + medicos[pos].getCrm());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite o novo C.R.M.: ");
                crm = ent.nextLine();
                medicos[pos].setCrm(crm);
            }
            System.out.println("----------------------------------");
            System.out.println("Especialidade atual: " + medicos[pos].getEspecialidade());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova Especialidade: ");
                esp = ent.nextLine();
                medicos[pos].setEspecialidade(esp);
            }
            System.out.println("----------------------------------");
            System.out.println("C.T.P.S. atual: " + medicos[pos].getCtps());
            System.out.println("Alterar? (1-sim/2-não");
            resp = ent.nextInt();
            ent.skip("\n");
            if(resp == 1){
                System.out.println("Digite a nova C.T.P.S.: ");
                ctps = ent.nextLine();
                medicos[pos].setCtps(ctps);
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
        
        System.out.println("--==[Exclusão de Médicos]==--");
        System.out.println("Qual posição deseja excluir? ");
        pos = ent.nextInt();
        ent.skip("\n");
        
        if(medicos[pos] != null){
            System.out.println("-=[Dados do Paciente]=-");
            medicos[pos].imprimir();
            System.out.println("\nConfirma exclusão? (1-sim/2-não)");
            resp = ent.nextInt();
            ent.skip("\n");
            
            if(resp == 1){
                medicos[pos] = null;
                System.out.println("Exclusão efetuada com sucesso.");
            }
            else{
                System.out.println("Exclusão não efetuada.");
            }
        }
        else{
            System.out.println("Médico não existe.");
        }
    }
    
    public void consultar(){
        int pos;
        
        System.out.println("--==[Consulta de Médicos]==--");
        System.out.println("Qual posição deseja consultar? ");
        pos = ent.nextInt();
        ent.skip("\n");
        
        if(medicos[pos] != null){
            System.out.println("-=[Dados do Médico]=-");
            medicos[pos].imprimir();
        }
        else{
            System.out.println("Médico não existe.");
        }
    }
    
    public void relatorio(){
        int pos = 0;
        
        System.out.println("--==[Relatório de Médicos]==--");
        
        while(pos < medicos.length){
            if(medicos[pos] != null){
                medicos[pos].imprimir();
                System.out.println("\n-----------------------------------\n");
            }
            
            pos++;
        }
    }
}
