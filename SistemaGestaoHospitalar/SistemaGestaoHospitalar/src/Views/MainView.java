package Views;

import java.util.Scanner;

public class MainView {
    private MedicoView medicoView;
    private PacienteView pacienteView;
    private Scanner scanner;
    
    public MainView(MedicoView medicoView, PacienteView pacienteView, Scanner scanner){
        this.medicoView = medicoView;
        this.pacienteView = pacienteView;
        this.scanner = scanner;
    }
    
    public void menu(){
        int op;
        
        do{
            System.out.println("--==[Gestao Hospitalar]==--");
            System.out.println("1 - Gerenciar Medicos");
            System.out.println("2 - Gerenciar Pacientes");
            System.out.println("3 - Alterar Atendimento de Paciente");
            System.out.println("4 - Sair");
            System.out.println("Opção: ");
            
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
                    //IMPLENTAR LOGIN DE MEDICO PARA IMPEDIR OUTROS ACESSOS
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
