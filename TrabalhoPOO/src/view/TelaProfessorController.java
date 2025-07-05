package view;

import model.*;

import java.util.Observable;

public class TelaProfessorController implements Observer {
    private Model model;
    private TelaProfessorView view;


    public void iniciar(Model model, TelaProfessorView view) {
        if (model != null && view != null){
            this.model = model;
            this.view = view;
            model.attachObserver(this);
            String l = model.getUsuarioAutenticado();
        }
    }

    public void tratarEvento(String event) {
        switch (event){
            case "1":
                if(model.getTurmasProf() != null){
                    ListaTurmasProfView view6 = new ListaTurmasProfView();
                    view6.iniciar(model);}
                else{
                    view.exibirMensagem("nao possui turmas cadastradas ");
                }
                break;
            case "2": CadastroTurmaView view9 = new CadastroTurmaView();
                view9.iniciar(model);
                break;
            case "3":EditarTurmaView view8 = new EditarTurmaView();
                view8.iniciar(model);
                break;
            case "4":view.finalizarSistema();
                break;
        }
    }

    public void update() {

    }
}