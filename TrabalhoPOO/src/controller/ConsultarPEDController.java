package controller;

import view.*;
import model.Model;

// Controller para consultar o Plano de Ensino (PED)
public class ConsultarPEDController implements Observer{
    Model model;
    ConsultarPEDView view;

    public void init(Model model, ConsultarPEDView view){
        this.model = model;
        this.view = view;
        model.attachObserver(this);
    }

    // Quando o usuário confirma, verifica se o PED existe para a turma e unidade
    public void handleEvent(String event) {
        switch(event){
            case "OK":
                boolean existePED = model.existePED(view.getCodigoTurma(), view.getNomeUnidade());
                if(!existePED){
                    view.exibeMSG("ERRO: Talvez Campus e/ou turma estejam errados! Ou esse Plano de Ensino ainda não existe.");
                } else{
                    view.exibeMSG("SUCESSO: Plano de Ensino encontrado!");
                    // Abre a view para visualizar o PED
                    VisualizarPEDView view2 = new VisualizarPEDView();
                    view2.init(model, view.getCodigoTurma(), view.getNomeUnidade());
                }
                model.detachObserver(this);
                break;
        }
    }

    public void update(){

    }
}
