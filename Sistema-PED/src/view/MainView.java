package view;

import java.util.*;
import model.Model;
import controller.MainController;

public class MainView implements Observer {
    private Model model;
    private MainController controller;
    private int totalUsuarios;
    private boolean finalizar = false;

    public void finalizarSistema() {
        finalizar = true;
    }

    public void init(Model model) {
        if (model != null){
            this.model = model;
            controller = new MainController();
            controller.init(model, this);
            model.attachObserver(this);
            model.sistemaIniciado();
            menuPrincipal();
        }
    }

    public void update() {
        totalUsuarios = model.getTotalUsuarios();
    }

    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        String opcoes[] = { "[1] - Fazer Login", "[2] - Consultar Planos de Ensino", "[0] - Finalizar Programa" };
        do {
            System.out.println();
            System.out.println("===============================================");
            System.out.println("  SISTEMA DE GERENCIAMENTO DE PLANO DE ENSINO");
            System.out.println("===============================================");
            System.out.println();
            System.out.println("Total de Usuários: " + totalUsuarios);
            System.out.println();
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println();
            System.out.print("Digite a opção desejada: ");
            String event = sc.nextLine();
            controller.handleEvent(event);
        } while (!finalizar);
        sc.close();
    }
}