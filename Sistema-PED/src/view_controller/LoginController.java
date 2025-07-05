package view_controller;

import model.Model;

public class LoginController implements Observer {
    private Model model;
    private LoginView view;

    public void init(Model model, LoginView view) {
        if (model != null && view != null){
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                boolean autenticado = model.autenticarUsuario(view.getLogin(), view.getSenha());
                if (!autenticado) {
                    view.exibeMSG("ERRO: Usuario e/ou Senha invalidos!");
                } else {
                    view.exibeMSG("SUCESSO: Usuario autenticado!");
                }
                TelaProfessorView telaProfessor = new TelaProfessorView();
                telaProfessor.init(model);
                model.detachObserver(this);
                break;
        }
    }

    public void update() {
    }
}
