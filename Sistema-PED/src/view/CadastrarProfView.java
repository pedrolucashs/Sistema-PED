package view;

import model.Model;
import controller.CadastrarProfController;
import java.util.Scanner;

public class CadastrarProfView implements Observer{
    private Model model;
    private CadastrarProfController controller;
    private String nome;
    private String id;
    private String login;
    private String senha;

    public void init(Model model) {
        this.model = model;
        controller = new CadastrarProfController();
        controller.init(model, this);
        model.attachObserver(this);
        cadastrarUsuario();
    }

    public void cadastrarUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("=======================");
        System.out.println("  CADASTRAR PROFESSOR");
        System.out.println("=======================");
        System.out.println();
        System.out.print("Nome: ");
        nome = sc.nextLine();
        System.out.print("Número de Identificação: ");
        id = sc.nextLine();
        System.out.print("Nome de Usuário: ");
        login = sc.nextLine();
        System.out.print("Senha: ");
        senha = sc.nextLine();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public String getNome() {
        return nome;
    }
    public String getId() {
        return id;
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
