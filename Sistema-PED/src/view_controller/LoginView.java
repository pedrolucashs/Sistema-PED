package view_controller;

import model.Model;
import java.util.*;

public class LoginView implements Observer {
    private Model model;
    private LoginController controller;
    private String login;
    private String senha;

    public void init(Model model) {
        this.model = model;
        controller = new LoginController();
        controller.init(model, this);
        model.attachObserver(this);
        logarUsuario();
    }

    public void logarUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("======================");
        System.out.println("    TELA DE LOGIN     ");
        System.out.println("======================");
        System.out.println();
        System.out.print("Login: ");
        login = sc.nextLine();
        System.out.print("Senha: ");
        senha = sc.nextLine();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void update() {

    }

    public void exibeMSG(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }
}
