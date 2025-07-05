package view;
import model.*;
import java.util.*;
public class CadastroUserView implements Observer {
    private Model model;
    private CadastroUserController controller;
    private Usuario professor;
    private String nome;
    private String login;
    private String senha;
    private int id;

    public void iniciar(Model model){
        professor = new Usuario();
        this.model = model;
        controller.iniciar(model,this);
        model.attachObserver(this);
        cadastrarUsuario();
    }

    public void cadastrarUsuario(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("TELA DE CADASTRO");
        System.out.println("======================");
        System.out.println();
        System.out.println("nome: ");
        nome = scanner.nextLine();
        professor.setNome(nome);
        System.out.println();
        System.out.println("login: ");
        login = scanner.nextLine();
        professor.setLogin(login);
        System.out.println();
        System.out.println("senha: ");
        senha = scanner.nextLine();
        professor.setSenha(senha);
        System.out.println();
        System.out.println("id: ");
        id = scanner.nextInt();
        professor.setId(id);
        controller.tratarEvento("OK");
        model.detachObserver(this);
    }
    public String getNome(){return nome;}
    public String getLogin(){return login;}
    public String getSenha(){return senha;}
    public int getId(){return id;}
    public Usuario getProfessor(){return professor;}

    public void update(){}


}
