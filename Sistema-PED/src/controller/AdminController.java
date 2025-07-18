package controller;

import view.*;
import model.Model;

public class AdminController implements Observer {
    private Model model;
    private AdminView view;

    public void init(Model model, AdminView view) {
        this.model = model;
        this.view = view;
    }

    public void handleEvent(String event) {
        switch (event) {
            case "0":
                model.deslogarUsuario();
                view.finalizarSistema();
                break;
            case "1":
                CadastrarTurmaView view1 = new CadastrarTurmaView();
                view1.init(model);
                break;
            case "2":
                CadastrarProfView view2 = new CadastrarProfView();
                break;
            case "3":
                EditarTurmaView view3 = new EditarTurmaView();
                break;
            case "4":
                EditarProfView view4 = new EditarProfView();
                break;
            case "5":
                ListarTurmasView view5 = new ListarTurmasView();
                break;
            case "6":
                ListarProfView view6 = new ListarProfView();
                break;
        }
    }

    public void update(){
    }
}
