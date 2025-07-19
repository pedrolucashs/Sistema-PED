package view;

import model.Model;
import controller.EditarPEDController;
import java.util.Scanner;

public class EditarPEDView implements Observer {
    private Model model;
    private EditarPEDController controller;
    private boolean finalizar = false;

    public void finalizar() {
        finalizar = true;
    }

    public void init(Model model, String codigoTurma) {
        this.model = model;
        controller = new EditarPEDController();
        controller.init(model, this, codigoTurma);
        model.attachObserver(this);
        menuEditar();
    }

    public void menuEditar() {
        String opcoes[] = {"[1] - Editar Calendário de Atividades", "[2] - Editar Bibliografia", "[3] - Editar outras informações", "[0] - Voltar"};
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("========================");
            System.out.println("  MENU PLANO DE ENSINO");
            System.out.println("========================");
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println(opcoes[3]);
            System.out.println();
            System.out.print("Digite a opção desejada: ");
            String event = sc.nextLine();
            controller.handleEvent(event);
        }while(!finalizar);
    }

    public void update(){

    }
}