package view;

import model.*;

import java.util.Observable;

public class TelaProfessorController implements Observer {
    private Model model;
    private TelaProfessorView view;


    public void init(Model model, TelaProfessorView view) {
        if (model != null && view != null){
            this.model = model;
            this.view = view;
            model.attachObserver(this);
            String l = model.getUsuarioAutenticado();
        }
    }

    public void handleEvent(String event) {
        switch (event){
            case "1":
                if(model.getTurmasProf() != null){
                    ListaTurmasProfView view6 = new ListaTurmasProfView();
                    view6.init(model);}
                else{
                    view.exibirMensagem("nao possui turmas cadastradas ");
                }
                break;
            case "2":view.finalizarSistema();
                break;
        }
        model.detachObserver(this);
    }

    public void update() {

    }
}