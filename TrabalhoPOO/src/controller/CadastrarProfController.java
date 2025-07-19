package controller;

import view.*;
import model.Model;

public class CadastrarProfController implements Observer {
    private Model model;
    private CadastrarProfView view;

    public void init(Model model, CadastrarProfView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" :
                boolean cadastrado = model.setUsuario(view.getNome(), view.getId(), view.getLogin(),view.getSenha());
                if(cadastrado){
                    view.exibeMSG("SUCESSO: Professor cadastrado!");
                } else{
                    view.exibeMSG("ERRO: Esse nome de usuário já está sendo usado.");
                }
                model.detachObserver(this);
                break;
        }
    }

    public void update() {
    }
}