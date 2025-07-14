package view;

import model.Model;

import java.util.Scanner;

public class TelaProfessorView implements Observer {
    private Model model;
    private TelaProfessorController controller;
    private boolean finalizar = false;

    public void init(Model model){
        if (model != null){
            this.model = model;
            controller = new TelaProfessorController();
            controller.init(model, this);
            model.attachObserver(this);
            menuProfessor();
        }
    }
    public void finalizarSistema() {this.finalizar = true;}


    public void menuProfessor(){
        Scanner sc = new Scanner(System.in);
        String[] opcoes = {"[1] - Listar Turmas", "[2] - Fazer logout"};
        do {
            System.out.println();
            System.out.println("=============================");
            System.out.println("      MENU DO PROFESSOR      ");
            System.out.println("=============================");
            System.out.println();
            System.out.println("Usuario Logado: " + model.getUsuarioLogin());
            System.out.println();
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println();
            System.out.println("Digite a opção desejada: ");
            String event = sc.nextLine();
            controller.handleEvent(event);
        } while(!finalizar);
        sc.close();
        model.detachObserver(this);
    }
    public void exibirMensagem(String msg){
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }
    public void update() {

    }
}