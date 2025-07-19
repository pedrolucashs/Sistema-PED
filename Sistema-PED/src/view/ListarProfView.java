package view;

import controller.ListarProfController;
import model.Model;
import java.util.*;

public class ListarProfView implements Observer {
    private Model model;
    private ListarProfController controller;

    public void init(Model model) {
        this.model = model;
        controller = new ListarProfController();
        controller.init(model,this);
        model.attachObserver(this);
        listarProf();
    }

    public void listarProf() {
        Scanner cs = new Scanner(System.in);
        System.out.println(model.getProfessores());
        System.out.println();
        System.out.println("Digite [1] para voltar para a tela anterior");
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