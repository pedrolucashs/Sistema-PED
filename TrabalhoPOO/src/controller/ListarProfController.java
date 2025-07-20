package controller;
import view.*;
import model.Model;

// Controller para listar professores
public class ListarProfController implements Observer {
    private Model model;
    private ListarProfView view;

    public void init(Model model , ListarProfView view){
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    // Só reage ao evento "1" para voltar para a tela anterior
    public void handleEvent(String event) {
        switch (event){
            case "1": view.exibirMsg("Voltando para a tela anterior");
                break;
        }
        model.detachObserver(this);
    }

    public void update() {

    }
}
