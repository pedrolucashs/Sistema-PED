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

        }
    }
}