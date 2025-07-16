package view;

import model.Model;
import controller.VisualizarPEDController;

public class VisualizarPEDView implements Observer {
    Model model;
    VisualizarPEDController controller;

    public void init(Model model, String codigoTurma, String nomeUnidade) {
        this.model = model;
        this.controller = new VisualizarPEDController();
        controller.init(model, this, codigoTurma, nomeUnidade);
        model.attachObserver(this);
        visualizarPED();
    }

    public void visualizarPED(){

    }

    public void update() {
    }
}
