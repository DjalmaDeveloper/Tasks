package controller;

import dao.TarefaDAO;
import model.Tarefa;
import service.TarefaService;

import java.sql.SQLException;
import java.util.List;

public class TarefaController {

    private TarefaService service = new TarefaService();

    public void adiciondarTarefa(String descricao){
        try {
            service.salvar(descricao);
            System.out.println(">> Tarefa adicionada com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao adicionar: " + e.getMessage());
        }
    }

    public void listarTarefas(){
        try {
            List<Tarefa> tarefas = service.buscarTodas();
            if (tarefas.isEmpty()){
                System.out.println(">> Nenhuma tarefa encontrada");
            }
            else {
                System.out.println("\n--- Lista de Tarefas ---");
                for (Tarefa t : tarefas){
                    String status = t.isConcluida() ? "[V]" : "[ ]";
                    System.out.println(t.getId() + " - " + status + " " + t.getDescricao());
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao listar: " + e.getMessage());
        }
    }

    public void concluirTarefa(int id){
        try {
            service.marcarConcluida(id);
            System.out.println(">> Tarefa marcada como concluída!");
        }
        catch (Exception e){
            System.err.println("Erro ao concluir: " + e.getMessage());
        }
    }

    public void deletarTarefa(int id){
        try{
            service.deletar(id);
            System.out.println(">> Tarefa deletada.");
        }
        catch (Exception e){
            System.err.println("Erro ao deletar: " + e.getMessage());
        }
    }
}
