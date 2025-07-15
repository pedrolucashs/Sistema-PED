package controller;

import model.Model;
import view.*;

public class LoginController implements Observer {
    Model model;
    LoginView view;

    public void init(Model model, LoginView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                boolean autenticado = model.autenticarUsuario(view.getLogin(), view.getSenha());
                if (!autenticado) {
                    view.exibeMSG("ERRO: Usuário e/ou senha inválidos!");
                } else {
                    view.exibeMSG("SUCESSO: Usuário autenticado!");
                    ProfessorView view2 = new ProfessorView();
                    view2.init(model);
                }
                model.detachObserver(this);
                break;
        }
    }

    public void update(){
    }
}
