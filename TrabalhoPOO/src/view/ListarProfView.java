package view;

import controller.*;
import model.Model;

import java.util.Observable;
import java.util.*;
public class ListarProfView implements Observer {
    private Model model;
    private ListarProfController controller;

    public void init(Model model) {
        this.model = model;
        ListarProfController controller = new ListarProfController();
        controller.init(model,this);
        model.attachObserver(this);
        listarProf();
    }

    public void listarProf() {
        Scanner cs = new Scanner(System.in);
        System.out.println("LISTA DE PROFESSORES");
        System.out.println(model.getProfessores());
        System.out.println();
        System.out.println("digite [1] para voltar para a tela anterior");
        String evento = cs.nextLine();
        controller.handleEvent(evento);
        model.detachObserver(this);

    }
    public void exibirMsg(String Msg){
        System.out.println(Msg);
        System.out.println();
    }

    public void update() {

    }
}
