package controller;

import model.Model;
import view.*;

public class ProfessorController implements Observer{
    private Model model;
    private ProfessorView view;

    public void init(Model model, ProfessorView view) {
        this.model = model;
        this.view = view;
    }

    public void handleEvent(String event) {
        switch (event) {
            case "1" :
                break;
            case "2" :
                break;
            case "3" : view.finalizarSistema(); break;
        }
    }

    public void update() {
    }
}