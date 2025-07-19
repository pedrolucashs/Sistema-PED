package view;

import controller.CadastrarTurmaController;
import model.Model;
import java.util.InputMismatchException;

import java.util.Scanner;

public class CadastrarTurmaView implements Observer {
    Model model;
    CadastrarTurmaController controller;
    private String codigoTurma;
    private String codigoDisciplina;
    private String nomeDisciplina;
    private String caraterDisciplina;
    private String regimeOferta;
    private String estruturaCurricular;
    private int cargaHoraria;

    public void init(Model model) {
        this.model = model;
        controller = new CadastrarTurmaController();
        controller.init(model, this);
        model.attachObserver(this);
        cadastroTurma();
    }

    public void cadastroTurma() {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("=======================");
        System.out.println("   CADASTRO DE TURMA");
        System.out.println("=======================");
        System.out.println();
        System.out.print("Código da Turma: ");
        codigoTurma = sc.nextLine();
        System.out.print("Código da Disciplina: ");
        codigoDisciplina = sc.nextLine();
        System.out.print("Nome da Disciplina: ");
        nomeDisciplina = sc.nextLine();
        System.out.print("Caráter da Disciplina (Obrigatória/Optativa): ");
        caraterDisciplina = sc.nextLine();
        System.out.print("Regime de Oferta da Disciplina (Semestral/Anual/Modular): ");
        regimeOferta = sc.nextLine();
        System.out.print("Estrutura Curricular (Ano-Período): ");
        estruturaCurricular = sc.nextLine();

        boolean inputValido = false;
        while (!inputValido) {
            try {
                System.out.print("Carga Horária da Disciplina: ");
                cargaHoraria = sc.nextInt();
                sc.nextLine();
                inputValido = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro para a carga horária.");
                sc.nextLine();
            }
        }
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
    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }
    public String getNomeDisciplina() {
        return nomeDisciplina;
    }
    public String getCaraterDisciplina() {
        return caraterDisciplina;
    }
    public String getRegimeOferta() {
        return regimeOferta;
    }
    public String getEstruturaCurricular() {
        return estruturaCurricular;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
}
