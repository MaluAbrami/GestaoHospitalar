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
        
    }
}
