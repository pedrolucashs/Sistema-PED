package view_controller;

import model.Model;

import java.util.Observable;

public class TelaProfessorController implements Observer {
    private Model model;
    private TelaProfessorView view;

    public void init(Model model, TelaProfessorView view) {
        if (model != null && view != null){
            this.model = model;
            this.view = view;
        }
    }

    public void handleEvent(String event) {

    }

    public void update() {

    }
}