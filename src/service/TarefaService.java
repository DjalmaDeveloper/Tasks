package service;

import dao.TarefaDAO;
import model.Tarefa;

import java.sql.SQLException;
import java.util.List;

public class TarefaService {

    private TarefaDAO dao = new TarefaDAO();

    public void salvar(String descricao) throws Exception {
        if (descricao == null || descricao.trim().isEmpty()){
            throw new Exception("A descrição da tarefa não pode estar vazia");
        }
        dao.adicionar(descricao);
    }

    public List<Tarefa> buscarTodas() throws SQLException {
        List<Tarefa> lista = dao.listar();
        if (lista.isEmpty()){
            throw new SQLException("Não há tarefas!");
        }
        return lista;
    }

    public void marcarConcluida(int id) throws Exception {
        List<Tarefa> tarefas = buscarTodas();
        for (Tarefa t : tarefas){
            if (t.getId() == id){
                if (t.isConcluida()){
                    throw new Exception("A Tarefa já foi concluída");
                }
                dao.concluir(id);
                return;
            }
        }
        throw new Exception("Não foi encontrada tarefa com tal ID");
    }

    public void deletar(int id) throws Exception {
        List<Tarefa> tarefas = buscarTodas();
        for (Tarefa t : tarefas){
            if (t.getId() == id){
                dao.deletar(id);
                return;
            }
        }
        throw new Exception("Não foi encontrada tarefa com tal ID");
    }
}
