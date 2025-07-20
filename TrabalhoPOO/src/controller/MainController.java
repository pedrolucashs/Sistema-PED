package controller;

import model.Model;
import view.*;

// Controller principal do sistema, que abre as views iniciais (login, consultar PED)
public class MainController implements Observer{
    private Model model;
    private MainView view;

    public void init(Model model, MainView view) {
        if (model != null && view != null){
            this.model = model;
            this.view = view;
        }
    }

    // Trata evento da tela principal (menu inicial)
    public void handleEvent(String event) {
        switch (event) {
            case "1" : // Abre a tela de login
                LoginView view1 = new LoginView();
                view1.init(model);
                break;
            case "2" : // Abre a tela de consulta do PED
                ConsultarPEDView view2 = new ConsultarPEDView();
                view2.init(model);
                break;
            case "0" : view.finalizarSistema(); break; // Sai do sistema
        }
    }

    public void update() {
    }
}
