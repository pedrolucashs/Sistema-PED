package controller;

import view.*;
import model.Model;

public class EditarPEDController implements Observer {
    private Model model;
    private EditarPEDView view;
    private String codigoTurma;

    public void init(Model model, EditarPEDView view, String codigoTurma) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
        this.codigoTurma = codigoTurma;
    }

    public void handleEvent(String event) {
        switch (event) {
            case "1":
                CalendarioView view1 = new CalendarioView();
                view1.init(model, codigoTurma);
                break;
            case "2":
                BibliografiaView view2 = new BibliografiaView();
                view2.init(model, codigoTurma);
                break;
            case "3":
                EmentaView view3 = new EmentaView();
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
