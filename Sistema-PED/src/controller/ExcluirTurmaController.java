package controller;

import model.Model;
import view.*;

public class ExcluirTurmaController implements Observer {
    private Model model;
    private ExcluirTurmaView view;

    public void init(Model model, ExcluirTurmaView view) {
        this.model = model;
        this.view = view;
    }

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