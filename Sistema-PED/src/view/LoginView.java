package view;

import controller.LoginController;
import model.Model;

import java.util.Scanner;

public class LoginView implements Observer {
    Model model;
    LoginController controller;
    private String nome;
    private int id;
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
        System.out.println("=====================");
        System.out.println("   TELA DE LOGIN");
        System.out.println("=====================");
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

    public void exibeMSG(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }

    public void update(){

    }

    public String getNome() {return nome;}
    public int getId() {return id;}
    public String getLogin() {return login;}
    public String getSenha() {return senha;}
}
