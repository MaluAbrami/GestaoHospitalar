package Dao;

import java.util.List;
import sistemagestaohospitalar.Medico;

public interface MedicoDao {
    boolean adicionar(Medico m);
    boolean atualizar(String cpf, Medico m);
    boolean deletar(String cpf);
    List<Medico> listar();
    Medico buscar(String cpf);
    boolean login(String crm, String senha);
}
