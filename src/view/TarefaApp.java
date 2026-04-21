package view;

import controller.TarefaController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Tarefa;

public class TarefaApp extends Application {

    private TarefaController controller = new TarefaController();
    private ListView<Tarefa> listView = new ListView<>();

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Campos de entrada
        TextField inputTarefa = new TextField();
        inputTarefa.setPromptText("Digite uma nova tarefa...");

        Button btnAdicionar = new Button("Adicionar");
        Button btnConcluir = new Button("Concluir Selecionada");
        Button btnDeletar = new Button("Excluir");

        // Ação: Adicionar
        btnAdicionar.setOnAction(e -> {
            controller.adiciondarTarefa(inputTarefa.getText());
            atualizarLista();
            inputTarefa.clear();
        });

        // Ação: Concluir
        btnConcluir.setOnAction(e -> {
            Tarefa selecionada = listView.getSelectionModel().getSelectedItem();
            if (selecionada != null) {
                controller.concluirTarefa(selecionada.getId());
                atualizarLista();
            }
        });

        // Ação: Deletar
        btnDeletar.setOnAction(e -> {
            Tarefa selecionada = listView.getSelectionModel().getSelectedItem();
            if (selecionada != null){
                controller.deletarTarefa(selecionada.getId());
                atualizarLista();
            }
        });

        // Layout
        HBox botoes = new HBox(10, btnAdicionar, btnConcluir, btnDeletar);
        VBox root = new VBox(10, inputTarefa, botoes, listView);

        primaryStage.setScene(new Scene(root, 400, 500));
        primaryStage.setTitle("Gerenciador de Tarefas PRO");
        primaryStage.show();

        atualizarLista();
    }

    private void atualizarLista(){
        // Busca os dados atualizados e coloca na lista
        listView.setItems(FXCollections.observableArrayList(controller.listarTarefasParaExibir()));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
