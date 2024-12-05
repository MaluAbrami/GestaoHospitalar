package Dao;

import sistemagestaohospitalar.Medico;

public interface MedicoDao {
    void adicionar(Medico m);
    boolean atualizar(Medico m);
    boolean deletar(String cpf);
    Medico[] listar();
    Medico buscar(String cpf);
    boolean login(String crm, String senha);
}
