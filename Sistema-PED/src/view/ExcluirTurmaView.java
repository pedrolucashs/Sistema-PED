package view;

import model.Model;
import java.util.Scanner;
import controller.ExcluirTurmaController;

public class ExcluirTurmaView implements Observer {
    private Model model;
    private ExcluirTurmaController controller;
    private String codigoTurma;
    private boolean finalizar = false;

    public void finalizar() {
        finalizar = true;
    }

    public void init(Model model) {
        if (model != null) {
            this.model = model;
            controller = new ExcluirTurmaController();
            controller.init(model, this);
            model.attachObserver(this);
            excluirTurma();
        }
    }

    public void excluirTurma () {
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Digite o código da Turma: ");
            codigoTurma = sc.nextLine();
            controller.handleEvent("OK");
            model.detachObserver(this);
        } while(!finalizar);
    }

    public void exibeMsg (String msg){
        System.out.println(msg);
    }

    public void update () {
    }

    public String getCodigoTurma() {
        return codigoTurma;
    }
}