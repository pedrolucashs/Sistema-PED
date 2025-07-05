package view_controller;

import model.Model;
import java.util.*;

public class CadastrarUsuarioView implements Observer {
    private Model model;
    private CadastrarUsuarioController controller;
    private String nome;
    private String login;
    private String senha;
    private int id;

    public void init(Model model) {
        this.model = model;
        controller = new CadastrarUsuarioController();
        controller.init(model, this);
        model.attachObserver(this);
        cadastrarUsuario();
    }

    public void cadastrarUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("======================");
        System.out.println(" CADASTRAR PROFESSOR ");
        System.out.println("======================");
        System.out.println();
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("Número de Identificação: ");
        id = sc.nextInt();
        sc.nextLine();
        System.out.print("Login: ");
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

    public int getId() { return id; }

    public void update() {

    }
}
