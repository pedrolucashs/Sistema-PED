package view;

import model.Model;
import controller.ConsultarPEDController;
import java.util.Scanner;

public class ConsultarPEDView implements Observer{
    Model model;
    ConsultarPEDController controller;
    private String codigoTurma;
    private String nomeUnidade;

    public void init(Model model) {
        this.model = model;
        this.controller = new ConsultarPEDController();
        controller.init(model, this);
        model.attachObserver(this);
        consulta();
    }

    public void consulta(){
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("==============================");
        System.out.println("  Consultar Planos de Ensino");
        System.out.println("===============================");
        System.out.println();
        System.out.print("Digite o nome do Campus: ");
        nomeUnidade = sc.nextLine();
        System.out.print("Digite o código da turma: ");
        codigoTurma = sc.nextLine();
        controller.handleEvent("OK");
        model.detachObserver(this);
    }

    public void exibeMSG(String msg) {
        System.out.println();
        System.out.println(msg);
        System.out.println();
    }

    public void update(){

    }

    public String getCodigoTurma() {
        return codigoTurma;
    }
    public String getNomeUnidade() {
        return nomeUnidade;
    }
}
