package controller;

import view.*;
import model.Model;

public class CadastrarProfController implements Observer {
    private Model model;
    private CadastrarProfView view;

    public void init(Model model, CadastrarProfView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                model.setUsuario(view.getNome(), view.getId(), view.getLogin(),view.getSenha());
                model.detachObserver(this);
                break;
        }
    }

    public void update() {
    }
}
