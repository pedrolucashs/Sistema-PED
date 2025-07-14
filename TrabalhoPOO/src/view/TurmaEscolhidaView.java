package view;
import java.util.*;
import model.*;

public class TurmaEscolhidaView implements Observer {
    private Model model;
    private TurmaEscolhidaController controller;

    public void init(Model model) {
        this.model = model;
        controller = new TurmaEscolhidaController();
        controller.init(model,this);
        model.attachObserver(this);
        turmaEscolhida();
    }

    public void turmaEscolhida() {
        Scanner sc = new Scanner(System.in);
        String opcao[] = {"[1] editar plano de ensino" , "[2]visualizar plano de ensino"};
        System.out.printf("               TURMA %s               ",model.getTurmaEscolhida().getCodigoTurma());
        System.out.println("-------------------------------------------------");
        System.out.println(model.getTurmaEscolhida().getDisciplina());
        System.out.println();
        System.out.printf("Plano de Ensino:",model.getTurmaEscolhida().isPlanodeEnsino());
        if(!model.getTurmaEscolhida().isPlanodeEnsino()) {
            opcao[0] = "[1] criar plano de ensino";
            opcao[1] = null;
        }
        System.out.println(opcao[0]);
        System.out.println(opcao[2]);
        System.out.println("escolha uma opção");
        String event = sc.nextLine();
        controller.handleEvent(event);
        model.detachObserver(this);
    }

    public String exibirMsg(String msg) {
        return String.format(msg);
    }
    public void update() {

    }
}
