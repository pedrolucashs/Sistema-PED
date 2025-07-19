package controller;

import model.Model;
import view.*;
import java.util.Scanner;

public class ExcluirTurmaController implements Observer {
    private Model model;
    private ExcluirTurmaView view;

    public void init(Model model, ExcluirTurmaView view) {
        this.model = model;
        this.view = view;
    }

    public void handleEvent(String event) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            view.exibeMsg("=== Exclusão de Turma ===");
            view.exibeMsg("Digite o código da turma que deseja excluir:");
            String codigoTurma = scanner.nextLine();

            try {
                boolean sucesso = model.excluirTurma(codigoTurma);
                if (sucesso) {
                    view.exibeMsg("Turma excluída com sucesso.");
                } else {
                    view.exibeMsg("Não foi possível excluir. Código da turma inválido ou inexistente.");
                }
            } catch (Exception e) {
                view.exibeMsg("Erro ao excluir turma: " + e.getMessage());
            }

            view.exibeMsg("\nDeseja excluir outra turma? (s/n):");
            String resposta = scanner.nextLine();
            continuar = resposta.equalsIgnoreCase("s");
        }

        view.exibeMsg("Encerrando exclusão de turmas.");
    }

    public void update(){

    }
}