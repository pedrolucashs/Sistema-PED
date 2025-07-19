package view;
//importando a classe model e outras coisas necessarias
import model.Model;
import controller.ProfessorController;
import java.util.Scanner;
// essa classe é a tela inicial do professor, representa a interfasse de texto que o professor ver.
public class ProfessorView implements Observer {
    private Model model;
    private ProfessorController controller;
    private boolean finalizar = false;
    // inicializa a tela do professor
    public void init(Model model){
        if (model != null){
            this.model = model;
            controller = new ProfessorController();
            controller.init(model, this);
            model.attachObserver(this);
            menuProfessor();
        }
    }
    //metodo para encerrar o menu
    public void finalizar() {this.finalizar = true;}


    public void menuProfessor(){
        Scanner sc = new Scanner(System.in);
        String[] opcoes = {"[1] - Listar Turmas", "[2] - Fazer logout"};
        do {
            System.out.println();
            System.out.println("=============================");
            System.out.println("      MENU DO PROFESSOR      ");
            System.out.println("=============================");
            System.out.println();
            System.out.println("Usuario Logado: " + model.getUsuarioLogin());
            System.out.println();
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println();
            System.out.println("Digite a opção desejada: ");
            String event = sc.nextLine();
            //envia o evento para o controller tratar
            controller.handleEvent(event);
        } while(!finalizar);
        //remove o observador
        model.detachObserver(this);
    }
    //metodo para exibir mensagens
    public void exibirMensagem(String msg){
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }
    //metodo obrigatório da interface Observer
    public void update() {

    }
}