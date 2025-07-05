package view;

import model.*;

public class CadastroTurmaController implements Observer {
    private Model model;
    private CadastroTurmaView view;

    public void iniciar(Model model, CadastroTurmaView view){
        if(model!=null && view!=null){
            this.model = model;
            this.view = view;
            model.attachObserver(this);
        }

    }

    public void tratarevento(String evento){

    }

    public void update(){

    }
}
