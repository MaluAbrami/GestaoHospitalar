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
        
    }
}
