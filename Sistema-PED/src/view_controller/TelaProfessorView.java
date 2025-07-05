package view_controller;

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

    public void menuProfessor(){
        Scanner sc = new Scanner(System.in);
        String[] opcoes = {"[1] - Listar Turmas", "[2] - Adicionar Turma", "[3] - Editar Turma", "[4] - Fazer Logout"};
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
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
            System.out.println();
            System.out.println("Digite a opção desejada: ");
            String event = sc.nextLine();
            controller.handleEvent(event);
        } while(!finalizar);
        sc.close();
    }

    public void update() {

    }
}
