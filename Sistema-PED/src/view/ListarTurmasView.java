package view;

import model.Model;
import controller.ListarTurmasController;
import java.util.Scanner;

public class ListarTurmasView implements Observer {
    private Model model;
    private ListarTurmasController controller;
    private boolean finalizar = false;
    private String codigoTurma;

    public void finalizar() {
        finalizar = true;
    }

    public void init(Model model){
        this.model = model;
        controller = new ListarTurmasController();
        controller.init(model, this);
        model.attachObserver(this);
        listarTurmas();
    }

    public void listarTurmas(){
        String opcoes[] = {"[1] - Escolher Turma", "[2] - Voltar"};
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println();
            System.out.print(model.getTurmas());
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println("Digite a opção desejada: ");
            String evento = sc.nextLine();
            if(evento.equals("1")){
                System.out.print("Digite o código da turma: ");
                codigoTurma = sc.nextLine();
            }
            controller.handleEvent(evento);
            model.detachObserver(this);
        } while(!finalizar);
    }

    public String exibeMSG(String msg){
        return String.format(msg);
    }


    public void update(){

    }

    public String getCodigoTurma() {
        return codigoTurma;
    }
}
