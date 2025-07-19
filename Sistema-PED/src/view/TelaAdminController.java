package view_controller;

import model.Model;

import java.util.Observable;

public class TelaAdminController implements Observer {
    private Model model;
    private TelaAdminView view;

    public void init(Model model, TelaAdminView view) {
        if (model != null && view != null){
            this.model = model;
            this.view = view;
        }
    }
    public void handleEvent(String event) {

    }

    public void update() {

    }
}
