package Dao;

import java.util.List;
import sistemagestaohospitalar.Paciente;

public interface PacienteDao {
    boolean adicionar(Paciente p);
    boolean atualizar(Paciente p);
    boolean deletar(String cpf);
    List<Paciente> listar();
    Paciente buscar(String cpf);
}
