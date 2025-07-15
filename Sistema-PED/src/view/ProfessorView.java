package view;

import controller.ProfessorController;
import model.Model;
import java.util.Scanner;

public class ProfessorView implements Observer {
    Model model;
    ProfessorController controller;
    private boolean finalizar = false;

    public void finalizarSistema() {
        finalizar = true;
    }

    public void init(Model model) {
        this.model = model;
        controller = new ProfessorController();
        controller.init(model, this);
        model.attachObserver(this);
        menuProfessor();
    }

    public void menuProfessor(){

    }

    public void update(){

    }
}
