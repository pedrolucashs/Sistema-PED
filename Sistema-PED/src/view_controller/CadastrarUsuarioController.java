package view_controller;

import model.Model;

public class CadastrarUsuarioController implements Observer {
    private Model model;
    private CadastrarUsuarioView view;

    public void init(Model model, CadastrarUsuarioView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                model.setUsuario(view.getNome(), view.getLogin(),view.getSenha(), view.getId());
                model.detachObserver(this);
                break;
        }
    }

    public void update() {
    }
}
