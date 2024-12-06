package Views;

import Service.PacientesService;
import java.util.Scanner;

public class PacienteView {
    private PacientesService pacienteService;
    private Scanner scanner;
    
    public PacienteView(PacientesService pacienteService, Scanner scanner){
        this.pacienteService = pacienteService;
        this.scanner = scanner;
    }
    
    public void menu(){
        int op;
        
        do{
            System.out.println("--==[Pacientes]==--");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Alterar");
            System.out.println("3 - Excluir");
            System.out.println("4 - Consultar");
            System.out.println("5 - Relatorio");
            System.out.println("6 - Voltar ao menu principal");
            System.out.println("Opcao: ");
            
            op = scanner.nextInt();
            scanner.skip("\n");
            
            switch(op){
                case 1:{
                    pacienteService.cadastrar();
                    break;
                }
                case 2:{
                    pacienteService.alterar();
                    break;
                }
                case 3:{
                    pacienteService.excluir();
                    break;
                }
                case 4:{
                    pacienteService.consultar();
                    break;
                }
                case 5:{
                    pacienteService.relatorio();
                    break;
                }
                case 6:{
                    System.out.println("Voltando para o menu principal...");
                    break;
                }
                default:{
                    System.out.println("Opcao invalida, tente novamente");
                }
            }
        } while(op != 6);
    }
}
