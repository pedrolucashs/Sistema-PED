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

    }

    public void update() {

    }
}
