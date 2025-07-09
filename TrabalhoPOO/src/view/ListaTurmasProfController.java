package view;

import model.*;

public class ListaTurmasProfController implements Observer {
    private Model model;
    private ListaTurmasProfView view;

    public void init(Model model , ListaTurmasProfView view){
        if(model != null && view != null){
           this.model = model;
           this.view = view;
           model.attachObserver(this);
        }
    }

    public void handleEvent(String evento){
        switch(evento){
            case "1":CadastroTurmaView view10 = new CadastroTurmaView();
            view10.init(model);
            break;
            case "2": TelaProfessorView view11 = new TelaProfessorView();
            view11.init(model);
            break;
        }
        model.detachObserver(this);
    }


    public void update() {

    }
}
