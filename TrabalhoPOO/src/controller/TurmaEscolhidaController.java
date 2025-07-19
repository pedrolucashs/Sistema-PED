package controller;
import view.*;
import model.Model;

public class TurmaEscolhidaController implements Observer{
    private Model model;
    private TurmaEscolhidaView view;

    public void init(Model model, TurmaEscolhidaView view){
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    public void handleEvent(String event){
        String codigoTurma = view.getCodigoTurma();
        switch(event){
            case "1":
                EditarPEDView view1 = new EditarPEDView();
                view1.init(model, codigoTurma);
                break;
            case "2":
                VisualizarPEDView view2 = new VisualizarPEDView();
                view2.init(model, codigoTurma, model.getCampus());
                break;
            case "0":
                view.finalizar();
                model.detachObserver(this);
                break;
        }
    }

    public void update(){

    }
}