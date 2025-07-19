package controller;

import model.Model;
import view.*;

public class ListarTurmasController implements Observer {
    private Model model;
    private ListarTurmasView view;

    public void init(Model model , ListarTurmasView view){
        if(model != null && view != null){
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }
    }

    public void handleEvent(String evento){
        switch(evento){
            case "1":
                TurmaEscolhidaView view1 = new TurmaEscolhidaView();
                model.detachObserver(this);
                break;
            case "2":
                view.finalizar();
                model.detachObserver(this);
                break;
        }
        model.detachObserver(this);
    }


    public void update() {

    }
}
