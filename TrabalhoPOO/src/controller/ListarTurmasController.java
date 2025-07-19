package controller;

import model.Model;
import view.*;

public class ListarTurmasController implements Observer {
    private Model model;
    private ListarTurmasView view;

    public void init(Model model , ListarTurmasView view){
        if(model != null && view != null){
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }
    }

    public void handleEvent(String evento){
        String codigoTurma = view.getCodigoTurma();
        switch(evento){
            case "1":
                if(model.existeTurmaProf(codigoTurma)){
                    view.exibeMSG("SUCESSO: Turma encontrada!");
                    TurmaEscolhidaView view2 = new TurmaEscolhidaView();
                    view2.init(model, codigoTurma);
                } else{
                    view.exibeMSG("ERRO: Turma não encontrada");
                }
                model.detachObserver(this);
                break;
            case "0":
                view.finalizar();
                model.detachObserver(this);
                break;
        }
        model.detachObserver(this);
    }


    public void update() {

    }
}