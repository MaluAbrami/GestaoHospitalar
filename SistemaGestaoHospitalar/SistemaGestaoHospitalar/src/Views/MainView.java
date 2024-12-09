package Views;

import java.util.Scanner;

public class MainView {
    private MedicoView medicoView;
    private PacienteView pacienteView;
    private AtendimentoView atendimentoView;
    private Scanner scanner;
    
    public MainView(MedicoView medicoView, PacienteView pacienteView, AtendimentoView atendimentoView, Scanner scanner){
        this.medicoView = medicoView;
        this.pacienteView = pacienteView;
        this.atendimentoView = atendimentoView;
        this.scanner = scanner;
    }
    
    public void menu(){
        int op;
        
        do{
            System.out.println("--==[Gestao Hospitalar]==--");
            System.out.println("1 - Gerenciar Medicos");
            System.out.println("2 - Gerenciar Pacientes");
            System.out.println("3 - Gereciar Atendimentos");
            System.out.println("4 - Sair");
            System.out.println("Opcao: ");
            
            op = scanner.nextInt();
            scanner.skip("\n");
            
            switch(op){
                case 1:{
                    medicoView.menu();
                    break;
                }
                case 2:{
                    pacienteView.menu();
                    break;
                }
                case 3:{
                    atendimentoView.menu();
                    break;
                }
                case 4:{
                    System.out.println("Saindo...");
                    break;
                }
                default:{
                    System.out.println("Opcao invalida, tente novemente");
                }
            }
        } while(op != 4);
    }
}
