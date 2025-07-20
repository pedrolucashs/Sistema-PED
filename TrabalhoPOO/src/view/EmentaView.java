package view;
import controller.EmentaController;
import model.Model;
import java.util.Scanner;

public class EmentaView implements Observer {
    private Model model;
    private EmentaController controller;
    private String codigoTurma;
    private String anoSemestre;
    private String justificativa;
    private String ementa;
    private String[] objetivos;
    private String metodologia;
    private String[] atividades;
    private String sistemaAvaliacao;

    public void init(Model model, String codigoTurma){
        this.model = model;
        this.controller = new EmentaController();
        this.codigoTurma = codigoTurma;
        controller.init(model, this);
        model.attachObserver(this);
        ementa();
    }

    public void ementa(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("=========================");
        System.out.println("EDITAR INFORMAÇÕES EXTRAS");
        System.out.println("=========================");
        System.out.println();
        System.out.print("Digite o Ano/Semestre: ");
        anoSemestre = sc.nextLine();
        System.out.print("Digite a justificativa: ");
        justificativa = sc.nextLine();
        System.out.print("Digite a Ementa: ");
        ementa = sc.nextLine();
        System.out.print("Digite os objetivos (separados por vírgula, se houver mais de um): ");
        String objetivosStr = sc.nextLine();
        this.objetivos = objetivosStr.isEmpty() ? new String[0] : objetivosStr.split(",");
        System.out.print("Digite a metodologia: ");
        metodologia = sc.nextLine();
        System.out.print("Digite as atividades (separadas por vírgula, se houver mais de uma): ");
        String atividadesStr = sc.nextLine();
        this.atividades = atividadesStr.isEmpty() ? new String[0] : atividadesStr.split(",");
        System.out.print("Digite o método de avaliacao: ");
        sistemaAvaliacao = sc.nextLine();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public void exibeMSG(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }

    public void update() {

    }

    public String getCodigoTurma() {
        return codigoTurma;
    }
    public String getAnoSemestre() {
        return anoSemestre;
    }
    public String getJustificativa() {
        return justificativa;
    }
    public String getEmenta() {
        return ementa;
    }
    public String[] getObjetivos() {
        return objetivos;
    }
    public String getMetodologia() {
        return metodologia;
    }
    public String[] getAtividades() {
        return atividades;
    }
    public String getSistemaAvaliacao() {
        return sistemaAvaliacao;
    }
}
