package sistemagestaohospitalar;

import DaoImpl.MedicoDaoImpl;
import DaoImpl.PacienteDaoImpl;
import Service.MedicosService;
import Service.PacientesService;
import java.util.Scanner;

public class SistemaGestaoHospitalar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MedicoDaoImpl medicoDao = new MedicoDaoImpl();
        PacienteDaoImpl pacienteDao = new PacienteDaoImpl();
        
        // Vetores.
        Paciente pacientes[] = new Paciente[100];
        Medico medicos[] = new Medico[100];

        MedicosService gm = new MedicosService(medicoDao, scanner);
        PacientesService gp = new PacientesService(pacienteDao, scanner);

        int op1, op2;

        do {
            System.out.println("--==[Gestão Hospitalar]==--");
            System.out.println("1 - Médicos");
            System.out.println("2 - Pacientes");
            System.out.println("3 - Sair");
            System.out.println("Opção: ");
            op1 = scanner.nextInt();
            scanner.skip("\n");

            switch (op1) {
                case 1:
                    do {
                        System.out.println("--==[Médicos]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatório");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.println("Opção: ");
                        op2 = scanner.nextInt();
                        scanner.skip("\n");

                        switch (op2) {
                            case 1:
                                gm.cadastrar();
                                break;
                            case 2:
                                gm.alterar();
                                break;
                            case 3:
                                gm.excluir();
                                break;
                            case 4:
                                gm.consultar();
                                break;
                            case 5:
                                gm.relatorio();
                        }
                    } while (op2 != 6);
                    break;
                case 2:
                    do {
                        System.out.println("--==[Pacientes]==--");
                        System.out.println("1 - Cadastrar");
                        System.out.println("2 - Alterar");
                        System.out.println("3 - Excluir");
                        System.out.println("4 - Consultar");
                        System.out.println("5 - Relatório");
                        System.out.println("6 - Voltar ao menu principal");
                        System.out.println("Opção: ");
                        op2 = scanner.nextInt();
                        scanner.skip("\n");

                        switch (op2) {
                            case 1:
                                gp.cadastrar();
                                break;
                            case 2:
                                gp.alterar();
                                break;
                            case 3:
                                gp.excluir();
                                break;
                            case 4:
                                gp.consultar();
                                break;
                            case 5:
                                gp.relatorio();
                        }
                    } while (op2 != 6);
            }
        } while (op1 != 3);
    }
    
}
