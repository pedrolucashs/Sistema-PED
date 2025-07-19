package view;

import java.util.*;
import model.Model;
import controller.AdminController;

public class AdminView implements Observer {
    private Model model;
    private AdminController controller;
    private boolean finalizar = false;

    public void finalizarSistema() {
        finalizar = true;
    }

    public void init(Model model) {
        if (model != null){
            this.model = model;
            controller = new AdminController();
            controller.init(model, this);
            model.attachObserver(this);
            menuAdmin();
        }
    }

    public void menuAdmin() {
        Scanner sc = new Scanner(System.in);
        String opcoes[] = {"[1] - Cadastrar Turma", "[2] - Cadastrar Professor", "[3] - Excluir Turma",
                           "[4] - Excluir Professor", "[5] - Listar Turmas", "[6] - Listar Professores", "[0] - Fazer Logout"};
        do {
            System.out.println();
            System.out.println("===========================");
            System.out.println("   MENU DO ADMINISTRADOR");
            System.out.println("===========================");
            System.out.println();
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
            System.out.println(opcoes[4]);
            System.out.println(opcoes[5]);
            System.out.println(opcoes[6]);
            System.out.println();
            System.out.print("Digite a opção desejada: ");
            String event = sc.nextLine();
            controller.handleEvent(event);
        } while (!finalizar);
    }

    public void update() {
    }
}