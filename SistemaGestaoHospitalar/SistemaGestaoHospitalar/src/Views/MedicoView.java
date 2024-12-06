package Views;

import Service.MedicosService;
import java.util.Scanner;

public class MedicoView {
    private MedicosService medicoService;
    private Scanner scanner;
    
    public MedicoView(MedicosService medicoService, Scanner scanner){
        this.medicoService = medicoService;
        this.scanner = scanner;
    }
    
    public void menu(){
        int op;
        
        do{
            System.out.println("--==[Medicos]==--");
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
                    medicoService.cadastrar();
                    break;
                }
                case 2:{
                    medicoService.alterar();
                    break;
                }
                case 3:{
                    medicoService.excluir();
                    break;
                }
                case 4:{
                    medicoService.consultar();
                    break;
                }
                case 5:{
                    medicoService.relatorio();
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
