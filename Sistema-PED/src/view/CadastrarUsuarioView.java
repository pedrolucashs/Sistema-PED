package view;
import java.util.*;
import java.util.Observer;

import model.*;

public class CadastrarUsuarioView implements Observer {
    private Model model;
    private CadastrarUsuarioController controller;
    private String nome;
    private String id;
    private String senha;
    private String login;

    public void init(Model model) {
        this.model = model;
        controller = new CadastrarUsuarioController();
        controller.init(model, this);
        model.attachObserver(this);
        cadastrarUsuario();
    }

    public void cadastrarUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("TELA CADASTRAR USUARIO");
        System.out.println("======================");
        System.out.println();
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("Login: ");
        login = sc.nextLine();
        System.out.print("ID: ");
        login = sc.nextLine();
        System.out.print("Senha: ");
        senha = sc.nextLine();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public String getNome() {
        return nome;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public String getId() {
        return id;
    }

    public void update() {

    }
}
