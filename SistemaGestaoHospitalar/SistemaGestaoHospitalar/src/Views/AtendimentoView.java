package Views;

import Service.AtendimentoService;
import java.util.Scanner;

public class AtendimentoView {
    private AtendimentoService atendimentoService;
    private Scanner scanner;
    
    public AtendimentoView(AtendimentoService atendimentoService, Scanner scanner){
        this.atendimentoService = atendimentoService;
        this.scanner = scanner;
    }
    
    public void menu(){
        int op;
        
        do{
            System.out.println("--==[Atendimentos]==--");
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
                    atendimentoService.cadastrar();
                    break;
                }
                case 2:{
                    break;
                }
                case 3:{
                    break;
                }
                case 4:{
                    break;
                }
                case 5:{
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
