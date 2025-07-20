package controller;

import view.*;
import model.Model;

// Controller para cadastrar professor, responde a eventos da view
public class CadastrarProfController implements Observer {
    private Model model;
    private CadastrarProfView view;

    public void init(Model model, CadastrarProfView view) {
        this.model = model;
        this.view = view;
        model.attachObserver(this); // Se inscreve para receber updates do model
    }
    public void handleEvent(String event) {
        switch (event) {
            case "OK" : // Quando usuário confirma cadastro
                boolean cadastrado = model.setUsuario(view.getNome(), view.getId(), view.getLogin(),view.getSenha());
                if(cadastrado){
                    view.exibeMSG("SUCESSO: Professor cadastrado!");
                } else{
                    view.exibeMSG("ERRO: Esse nome de usuário já está sendo usado.");
                }
                model.detachObserver(this); // Para de ouvir o model depois do cadastro
                break;
        }
    }

    public void update() {
    }
}
