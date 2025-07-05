package view;
import model.*;
import java.util.*;
public class MainView implements Observer {
    private Model model;
    private MainController controller;
    private String usuarioLogado;
    private boolean finalizar = false;
    private int totalUsuarios;


    public void finalizarSistema() {this.finalizar = true;}

    public void iniciar(Model model) {
        if(model != null){
            this.model = model;
            controller = new MainController();
            controller.iniciar(model,this);
            model.attachObserver(this);
            menuPrincipal();
        }
    }


    public void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        String opcoes[] = {"[1] - Fazer Login", "[2] - Fazer Cadastro " , "[3] - Sair"};
        do{
            System.out.println("BEM VINDO AO SISTEMA DE PLANO DE ENSINO");
            System.out.println("========================================");
            System.out.println();
            if (model.getUsuarioAutenticado() != "") {
                System.out.println("Usuario Logado: " + model.getUsuarioLogin());
                opcoes[0] = "[1] - Fazer Logout";
            } else {
                opcoes[0] = "[1] - Fazer Login";
            }
            System.out.println();
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println();
            System.out.println("oque deseja fazer? escolha uma opção: ");
            String evento = scanner.nextLine();
            controller.tratarEvento(evento);
        }while (!finalizar);
        scanner.close();
    }

    public void update() {
        totalUsuarios  = model.getTotalUsuarios();
        usuarioLogado = model.getUsuarioLogin();

    }
}
