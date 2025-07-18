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

    public void handleEvent(String event) {
        switch (event) {
            case "1" :
                LoginView view1 = new LoginView();
                view1.init(model);
                break;
            case "2" :
                ConsultarPEDView view2 = new ConsultarPEDView();
                view2.init(model);
                break;
            case "0" : view.finalizarSistema(); break;
        }
    }

    public void update() {
    }
}