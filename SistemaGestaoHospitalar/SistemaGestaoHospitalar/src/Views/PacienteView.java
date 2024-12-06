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
        
    }
}
