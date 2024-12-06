package Dao;

import sistemagestaohospitalar.Paciente;

public interface PacienteDao {
    boolean adicionar(Paciente p);
    boolean atualizar(Paciente p);
    boolean deletar(String cpf);
    void listar();
    Paciente buscar(String cpf);
}
