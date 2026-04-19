package view;

import controller.TarefaController;

import java.util.Scanner;

public class MainView {

    private static TarefaController controller = new TarefaController();
    private static Scanner sc = new Scanner(System.in);

    public static void ViewMenu(){
        int opcao = 0;

        while (opcao != 5){
            System.out.println("\n--- GERENCIADOR DE TAREFAS ---");
            System.out.println("1. Listar Tarefas");
            System.out.println("2. Adicionar Tarefa");
            System.out.println("3. Marcar como Concluída");
            System.out.println("4. Deletar Tarefa");
            System.out.println("5. Sair");
            System.out.println("Escolha uma opção");
            opcao = Integer.parseInt(sc.nextLine());

            switch (opcao){
                case 1 -> controller.listarTarefas();
                case 2 -> {
                    System.out.print("Descrição da tarefa: ");
                    controller.adiciondarTarefa(sc.nextLine());
                }
                case 3 -> {
                    System.out.print("ID da tarefa para concluir: ");
                    controller.concluirTarefa(Integer.parseInt(sc.nextLine()));
                }
                case 4 -> {
                    System.out.print("ID da tarefa para deletar: ");
                    controller.deletarTarefa(Integer.parseInt(sc.nextLine()));
                }
                case 5 -> System.out.println("Saindo...");
            }
        }
    }
}
