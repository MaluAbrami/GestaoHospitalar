package Dao;

import java.util.List;
import sistemagestaohospitalar.Atendimento;

public interface AtendimentoDao {
    void adicionar(Atendimento at);
    boolean atualizar(Atendimento at);
    boolean deletar(int id);
    List<Atendimento> listar();
    Atendimento buscar(int id);
}
