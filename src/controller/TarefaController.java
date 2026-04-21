package controller;

import model.Tarefa;
import service.TarefaService;

import java.util.ArrayList;
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

    //Retorna a lista para o JavaFX exibir
    public List<Tarefa> listarTarefasParaExibir(){
        try {
            return service.buscarTodas();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    // Método para concluir
    public void concluirTarefa(int id){
        try {
            service.marcarConcluida(id);
        }
        catch (Exception e){
            System.out.println("Erro ao concluir: " + e.getMessage());
        }
    }

    // Método para deletar
    public void deletarTarefa(int id){
        try{
            service.deletar(id);
        }
        catch (Exception e){
            System.out.println("Erro ao deletar: " + e.getMessage());
        }
    }
}
