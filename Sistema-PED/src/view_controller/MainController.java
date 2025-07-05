package view_controller;

import model.*;

public class MainController implements Observer{
    private Model model;
    private MainView view;

    public void init(Model model, MainView view) {
        if (model != null && view != null){
            this.model = model;
            this.view = view;
        }
    }

    public void update() {

    }

    public void handleEvent(String event) {
        switch (event) {
            case "1":
                if (model.getUsuarioAutenticado() == "") {
                    LoginView view1 = new LoginView();
                    view1.init(model);
                } else {
                    model.deslogarUsuario();
                }
                break;
            case "2":
                CadastrarUsuarioView view2 = new CadastrarUsuarioView();
                view2.init(model);
                break;
            case "3":
                break;
            case "4":
                view.finalizarSistema();
                break;
        }
    }
}