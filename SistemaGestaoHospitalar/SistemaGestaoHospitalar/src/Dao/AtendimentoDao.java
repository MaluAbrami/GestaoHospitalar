package Dao;

import java.util.List;
import sistemagestaohospitalar.Atendimento;
import sistemagestaohospitalar.Medico;
import sistemagestaohospitalar.Paciente;

public interface AtendimentoDao {
    boolean adicionar(Atendimento at, Medico m, Paciente p);
    boolean atualizar(int id, Atendimento at);
    boolean deletar(int id);
    List<Atendimento> listar();
    Atendimento buscar(int id);
}
