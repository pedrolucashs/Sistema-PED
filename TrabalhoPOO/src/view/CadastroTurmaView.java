package view;

import model.*;

public class CadastroTurmaView implements Observer {
    private Model model;
    private CadastroTurmaController controller;
    private Turma turma;

    public void iniciar(Model model){
        if(model!=null){
            this.model = model;
            controller = new CadastroTurmaController();
            controller.iniciar(model,this);
            model.attachObserver(this);
            cadastrarTurma();
        }
    }

    public void cadastrarTurma(){
        
    }

    public void update(){

    }

}
