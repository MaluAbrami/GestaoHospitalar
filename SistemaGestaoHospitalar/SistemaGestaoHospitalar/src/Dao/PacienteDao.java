package Dao;

import sistemagestaohospitalar.Paciente;

public interface PacienteDao {
    void adicionar(Paciente p);
    boolean atualizar(Paciente p);
    boolean deletar(String cpf);
    Paciente[] listar();
    Paciente buscar(String cpf);
}
