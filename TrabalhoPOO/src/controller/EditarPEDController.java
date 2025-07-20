package controller;

import view.*;
import model.Model;

// Controller para editar o Plano de Ensino (PED)
public class EditarPEDController implements Observer {
    private Model model;
    private EditarPEDView view;
    private String codigoTurma;

    public void init(Model model, EditarPEDView view, String codigoTurma) {
        this.model = model;
        this.view = view;
        model.attachObserver(this);
        this.codigoTurma = codigoTurma;
    }

    // Reage aos eventos para abrir diferentes views de edição do PED ou finalizar
    public void handleEvent(String event) {
        switch (event) {
            case "1": // Calendário do PED
                CalendarioView view1 = new CalendarioView();
                view1.init(model, codigoTurma);
                break;
            case "2": // Bibliografia do PED
                BibliografiaView view2 = new BibliografiaView();
                view2.init(model, codigoTurma);
                break;
            case "3": // Ementa do PED (parece não abrir view, pode estar incompleto)
                EmentaView view3 = new EmentaView();
                break;
            case "0": // Finalizar edição e sair
                view.finalizar();
                model.detachObserver(this);
                break;
        }
    }

    public void update(){

    }
}
