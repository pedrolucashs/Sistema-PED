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

    }

    public void update() {

    }
}
