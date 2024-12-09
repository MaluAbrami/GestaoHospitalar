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
        MedicosService medicoService = new MedicosService(atendimentoService, medicoDao, scanner);
        PacientesService pacienteService = new PacientesService(atendimentoService, pacienteDao, scanner);
        
        MedicoView medicoView = new MedicoView(medicoService, scanner);
        PacienteView pacienteView = new PacienteView(pacienteService, scanner);
        AtendimentoView atendimentoView = new AtendimentoView(atendimentoService, scanner);
        MainView mainView = new MainView(medicoView, pacienteView, atendimentoView, scanner);
        
        Medico m1 = new Medico("Doutor Joao", "123", "123.456.789-01", "rua xi de agosto", "1599384758", "123-01", "Clinico Geral", "1234-09", "senha123");
        medicoDao.adicionar(m1);
        Paciente p1 = new Paciente("Maria Luiza", "12340", "123.456.789-02", "avenida grande", "1599384758", "Unimed", "5435-234");
        pacienteDao.adicionar(p1);
        
        mainView.menu();
        
        scanner.close();
    }
}
