package view_controller;

import model.*;
import java.util.Scanner;

public class PlanoDeEnsinoView implements Observer {
    private Model model;
    private PlanoDeEnsinoController controller;
    private boolean finalizar = false;

    public void init(Model model){
        if (model != null){
            this.model = model;
            controller = new PlanoDeEnsinoController();
            controller.init(model, this);
            model.attachObserver(this);
            planoDeEnsino();
        }
    }

    public void planoDeEnsino(){
        Scanner sc = new Scanner(System.in);

        controller.exibirPlanoDeEnsino(String codigoTurma);

        System.out.println("[1] FINALIZAR [2] GERAR PDF: ");
        String event = sc.nextLine();

        controller.handleEvent(event);
        while(!finalizar);
        sc.close();
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void update() {}
}
