package view;

import java.util.*;
import model.*;

public class ListaTurmasProfView implements Observer {
    private Model model;
    private ListaTurmasProfController controller;

    public void iniciar(Model model){
        this.model = model;
        controller = new ListaTurmasProfController();
        controller.iniciar(model, this);//fazer o controller dessa view
        model.attachObserver(this);
        listarTurmas();
    }

    public void listarTurmas(){
        model.getTurmasProf();
    }


    public void update(){

    }
}
