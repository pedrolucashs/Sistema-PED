package view_controller;

import java.util.*;
import model.*;

public class MainView implements Observer {
    private Model model;
    private MainController controller;
    private int totalUsuarios;
    private String usuarioLogado;
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
            menuPrincipal();
        }
    }

    public void menuPrincipal() {
        Scanner sc = new Scanner(System.in);
        String opcoes[] = { "[1] - Fazer Login", "[2] - Fazer Cadastro", "[3] - Buscar Plano de Ensino", "[4] - Sair"};
        do {
            System.out.println();
            System.out.println(" SISTEMA DE PLANO DE ENSINO  ");
            System.out.println("=============================");
            System.out.println("       MENU PRINCIPAL        ");
            System.out.println("=============================");
            System.out.println();
            System.out.println("Total de Usuarios: " + totalUsuarios);
            System.out.println();
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
            System.out.println();
            System.out.print("Digite a opção desejada: ");
            String event = sc.nextLine();
            controller.handleEvent(event);
        } while (!finalizar);
        sc.close();
    }

    public void update() {
        totalUsuarios = model.getTotalUsuarios();
        usuarioLogado = model.getUsuarioLogin();
    }
}