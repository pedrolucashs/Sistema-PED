package view;

import java.util.*;
import model.*;

public class ListaTurmasProfView implements Observer {
    private Model model;
    private ListaTurmasProfController controller;

    public void init(Model model){
        this.model = model;
        controller = new ListaTurmasProfController();
        controller.init(model, this);//fazer o controller dessa view
        model.attachObserver(this);
        listarTurmas();
    }

    public void listarTurmas(){
        String opcao[] = {"[1] - voltar para a tela anterior"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Lista de Turmas");
        for( Turma turma: model.getTurmasProf().values()){
            System.out.println("- " + turma);}
        System.out.println(opcao[0]);
        System.out.println("escolha uma turma ou volte para atela anterior[1]:");
        String evento = sc.nextLine();
        controller.handleEvent(evento);
        model.detachObserver(this);
    }

    public String exibeMSG(String msg){
        return String.format(msg);
    }


    public void update(){

    }
}
