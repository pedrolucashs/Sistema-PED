package view;

import model.Model;
import controller.CalendarioController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CalendarioView implements Observer {
    private Model model;
    private CalendarioController controller;
    private String codigoTurma;
    private boolean finalizar = false;
    private String idAtividade;
    private String data;
    private String descricao;
    private int cargaHoraria;

    public void finalizar() {
        finalizar = true;
    }

    public void init(Model model, String codigoTurma) {
        this.model = model;
        controller = new CalendarioController();
        this.codigoTurma = codigoTurma;
        controller.init(model, this);
        calendario();
    }

    public void calendario() {
        String opcoes[] = {"[1] - Adicionar Atividade", "[2] - Excluir Atividade", "[0] - Voltar"};
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println();
            System.out.print(model.getCalendario(codigoTurma));
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println("Digite a opção desejada: ");
            String evento = sc.nextLine();

            if(evento.equals("1")){
                System.out.println("Digite o ID da atividade: ");
                idAtividade = sc.nextLine();
                System.out.print("Digite a Data da Atividade: ");
                data = sc.nextLine();
                System.out.print("Digite a Descrição da Atividade: ");
                descricao = sc.nextLine();

                boolean inputValido = false;
                while (!inputValido) {
                    try {
                        System.out.print("Digite a Carga Horária da Atividade: ");
                        cargaHoraria = sc.nextInt();
                        sc.nextLine();
                        inputValido = true;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada inválida. Por favor, digite um número inteiro para a carga horária.");
                        sc.nextLine();
                    }
                }

            } else if(evento.equals("2")){
                System.out.print("Digite o Id da Atividade que você quer excluir: ");
                idAtividade = sc.nextLine();
            }

            controller.handleEvent(evento);
            model.detachObserver(this);
        } while(!finalizar);
    }

    public void exibeMSG(String msg){
        System.out.println();
        System.out.print(msg);
        System.out.println();
    }

    public void update(){

    }

    public String getCodigoTurma() {
        return codigoTurma;
    }
    public String getIdAtividade() {
        return idAtividade;
    }
    public String getData() {
        return data;
    }
    public String getDescricao() {
        return descricao;
    }
    public int getCargaHoraria() {
        return cargaHoraria;
    }
}
