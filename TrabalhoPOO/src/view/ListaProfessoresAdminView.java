package view;

import java.util.*;
import model.*;

public class ListaProfessoresAdminView implements Observer{
    private Model model;
    private ListaProfessoresAdminController controller ;

    public ListaProfessoresAdminView(Model model) {
        this.model = model;
        controller = new ListaProfessoresAdminController();
        controller.init(model,this);
        model.attachObserver(this);
        ListarProfessores();
    }

    public void ListarProfessores() {
        String opcao[] = {"[1] - voltar para a tela anterior"};
        Scanner sc = new Scanner(System.in);
        System.out.println("Lista de professores cadastrados");
        System.out.println("================================");
        for(String professores : model.getProfessoresAdimin()){
            System.out.println("-"+professores);
        }
        System.out.println(opcao[0]);
        System.out.println("volte para atela anterior[1]:");
        String evento = sc.nextLine();
        controller.handleEvent(evento);
        model.detachObserver(this);
    }

    public String exibeMSG(String msg){
        return String.format(msg);
    }
    public void update() {

    }
}
