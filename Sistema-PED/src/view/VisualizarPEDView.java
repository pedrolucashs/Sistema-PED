package view;

import model.Model;
import controller.VisualizarPEDController;
import java.util.Scanner;

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
        Scanner sc = new Scanner(System.in);
        controller.exibirPlanoDeEnsino();
        System.out.println("[1] - Gerar PDF/n[2] - Voltar");
        String event = sc.nextLine();
        controller.handleEvent(event);
    }

    public void exibeMSG(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }

    public void update() {
    }
}
