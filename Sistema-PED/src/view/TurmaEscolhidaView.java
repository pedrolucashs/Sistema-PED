package view;
import model.Model;
import controller.TurmaEscolhidaController;
import java.util.Scanner;

public class TurmaEscolhidaView implements Observer{
    private Model model;
    private TurmaEscolhidaController controller;
    private String codigoTurma;
    private boolean finalizar = false;

    public void finalizar(){
        finalizar = true;
    }

    public void init(Model model, String codigoTurma){
        this.model = model;
        this.codigoTurma = codigoTurma;
        controller = new TurmaEscolhidaController();
        controller.init(model, this);
        model.attachObserver(this);
        turmaEscolhida();
    }

    public void turmaEscolhida(){
        Scanner sc = new Scanner(System.in);
        String opcoes[] = {"[1] - Editar Plano de Ensino da turma" , "[2] - Visualizar Plano de Ensino da turma", "[0] - Voltar"};
        do{
            System.out.println(model.getTurmaEscolhida(codigoTurma));
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.print("Digite a opção desejada: ");
            String event = sc.nextLine();
            controller.handleEvent(event);
        } while(!finalizar);
        model.detachObserver(this);
    }

    public void update(){

    }

    public String getCodigoTurma() {
        return codigoTurma;
    }
}
