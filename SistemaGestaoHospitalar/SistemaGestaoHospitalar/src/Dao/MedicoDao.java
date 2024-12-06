package Dao;

import sistemagestaohospitalar.Medico;

public interface MedicoDao {
    boolean adicionar(Medico m);
    boolean atualizar(Medico m);
    boolean deletar(String cpf);
    void listar();
    Medico buscar(String cpf);
    boolean login(String crm, String senha);
}
