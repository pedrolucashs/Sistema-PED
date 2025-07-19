package view_controller;

import model.Model;
import java.util.Scanner;

public class ExcluirTurmaView implements Observer {
    private Model model;
    ExcluirTurmaController controller;
    private String codigoTurma;

    public void init(Model model) {
        if (model != null) {
            this.model = model;
            controller = new ExcluirTurmaController();
            controller.init(model, this);
            model.attachObserver(this);
            excluirTurma();
        }
    }

    public void excluirTurma() {
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public void exibeMsg(String msg){
            System.out.println(msg);
    }

    public void update(){}
}