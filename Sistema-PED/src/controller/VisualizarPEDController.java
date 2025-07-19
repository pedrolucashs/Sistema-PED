package controller;

import view.*;
import model.Model;

public class VisualizarPEDController implements Observer {
    private Model model;
    private VisualizarPEDView view;
    private String codigoTurma;
    private String nomeUnidade;

    public void init(Model model, VisualizarPEDView view, String codigoTurma, String nomeUnidade) {
        this.model = model;
        this.view = view;
        this.codigoTurma = codigoTurma;
        this.nomeUnidade = nomeUnidade;
    }

    public void handleEvent(String event) {
        switch (event) {
            case "1":
                view.exibeMSG("Gerando PDF");
                break;
            case "2":
                view.exibeMSG("Plano de Ensino finalizado com sucesso!");
                break;
        }
    }

    public void exibirPlanoDeEnsino() {
        String plano = model.getPlanoDeEnsino(codigoTurma, nomeUnidade);
        view.exibeMSG(plano);
    }

    public void update() {

    }
}
