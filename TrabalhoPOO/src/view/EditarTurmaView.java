package view;

import model.*;

public class EditarTurmaView implements Observer {
    private Model model;
    private EditarTurmaController controller;
    private Turma turma;

    public void iniciar(Model model){
        this.model=model;
        controller = new EditarTurmaController();
        controller.iniciar(model,this);
        model.attachObserver(this);
        editarTurma();
    }

    public void editarTurma(){

    }

    public void update(){

    }
}
