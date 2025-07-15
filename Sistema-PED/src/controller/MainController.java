package controller;

import model.Model;
import view.*;

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
            case "1" :
                LoginView view2 = new LoginView();
                view2.init(model);
                break;
            case "2" :
                ConsultarPEDView view3 = new ConsultarPEDView();
                break;
            case "3" : view.finalizarSistema(); break;
        }
    }
}