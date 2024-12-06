package sistemagestaohospitalar;

import DaoImpl.AtendimentoDaoImpl;
import DaoImpl.MedicoDaoImpl;
import DaoImpl.PacienteDaoImpl;
import Service.AtendimentoService;
import Service.MedicosService;
import Service.PacientesService;
import Views.AtendimentoView;
import Views.MainView;
import Views.MedicoView;
import Views.PacienteView;
import java.util.Scanner;

public class SistemaGestaoHospitalar {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        MedicoDaoImpl medicoDao = new MedicoDaoImpl();
        PacienteDaoImpl pacienteDao = new PacienteDaoImpl();
        AtendimentoDaoImpl atendimentoDao = new AtendimentoDaoImpl();

        AtendimentoService atendimentoService = new AtendimentoService(atendimentoDao, medicoDao, pacienteDao, scanner);
        MedicosService medicoService = new MedicosService(medicoDao, scanner);
        PacientesService pacienteService = new PacientesService(atendimentoService, pacienteDao, scanner);
        
        MedicoView medicoView = new MedicoView(medicoService, scanner);
        PacienteView pacienteView = new PacienteView(pacienteService, scanner);
        AtendimentoView atendimentoView = new AtendimentoView(atendimentoService, scanner);
        MainView mainView = new MainView(medicoView, pacienteView, atendimentoView, scanner);
        
        mainView.menu();
        
        scanner.close();
    }
}
