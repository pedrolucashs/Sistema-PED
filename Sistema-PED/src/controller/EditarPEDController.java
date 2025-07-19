package controller;

import view.*;
import model.Model;

public class EditarPEDController implements Observer {
    private Model model;
    private EditarPEDView view;

    public void init(Model model, EditarPEDView view, String codigoTurma) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(String event) {
        switch (event) {
            case "1":
                break;
            case "2":
                break;
            case "3":
                break;
            case "0":
                view.finalizar();
                model.detachObserver(this);
                break;
        }
    }

    public void update(){

    }
}
