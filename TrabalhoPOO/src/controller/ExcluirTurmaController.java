package controller;

import model.Model;
import view.*;

// Controller para excluir turmas
public class ExcluirTurmaController implements Observer {
    private Model model;
    private ExcluirTurmaView view;

    public void init(Model model, ExcluirTurmaView view) {
        this.model = model;
        this.view = view;
    }

    // Evento para excluir a turma pelo código informado na view
    public void handleEvent(String event) {
        String codigoTurma = view.getCodigoTurma();
        try {
            boolean sucesso = model.excluirTurma(codigoTurma);
            if (sucesso) {
                view.exibeMsg("Turma excluída com sucesso.");
                view.finalizar();
            } else {
                view.exibeMsg("Não foi possível excluir. Código da turma inválido ou inexistente.");
            }
        } catch (Exception e) {
            view.exibeMsg("Erro ao excluir turma: " + e.getMessage());
        }
    }


    public void update(){

    }
}
