package view;

import model.Model;
import java.util.*;

public class ListaProfessoresAdminController implements Observer {
    private Model model;
    private ListaProfessoresAdminView view;
    public void init(Model model, ListaProfessoresAdminView view) {
        if(model != null && view != null) {
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }
    }

    public void handleEvent(String event) {
        switch (event){
            case "1":
                MainView view1 = new MainView();
                view1.init(model);
                break;
            default:
                view.exibeMSG("opção invalida");
                break;
        }
        model.detachObserver(this);
    }

    public void update() {

    }
}
