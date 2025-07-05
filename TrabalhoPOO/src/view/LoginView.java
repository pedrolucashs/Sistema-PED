package view;
import model.*;
import java.util.Scanner;

public class LoginView implements Observer {
    private  Model model;
    private LoginController controller;
    private String senha;
    private String login;

    public void iniciar(Model model){
        this.model = model;
        controller = new LoginController();
        controller.iniciar(model,this);
        model.attachObserver(this);
        logarUsuario();
    }

    public void logarUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("TELA DE LOGIN");
        System.out.println("====================");
        System.out.println();
        System.out.println("login: ");
        login = scanner.nextLine();
        System.out.println("senha: ");
        senha = scanner.nextLine();
        controller.tratarEvento("OK");
        model.detachObserver(this);
    }

    public String getLogin(){
        return login;
    }
    public String getSenha(){
        return senha ;
    }

    public void exibirMensagem(String msg){
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }


    public void update(){

    }

}
