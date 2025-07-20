package view;

import model.Model;
import controller.BibliografiaController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class BibliografiaView implements Observer {
    private Model model;
    private BibliografiaController controller;
    private String codigoTurma;
    private boolean finalizar = false;
    private String idMaterial;
    private String titulo;
    private String autor;
    private String ano;
    private String isbn;

    public void finalizar() {
        finalizar = true;
    }

    public void init(Model model, String codigoTurma) {
        this.model = model;
        controller = new BibliografiaController();
        this.codigoTurma = codigoTurma;
        controller.init(model, this);
        calendario();
    }

    public void calendario() {
        String opcoes[] = {"[1] - Adicionar Material", "[2] - Excluir Material", "[0] - Voltar"};
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println();
            System.out.print(model.getBibliografia(codigoTurma));
            System.out.println(opcoes[0]);
            System.out.println(opcoes[1]);
            System.out.println(opcoes[2]);
            System.out.println("Digite a opção desejada: ");
            String evento = sc.nextLine();

            if(evento.equals("1")){
                System.out.println("Digite o ID do Material: ");
                idMaterial = sc.nextLine();
                System.out.print("Digite o título: ");
                titulo = sc.nextLine();
                System.out.print("Digite o autor: ");
                autor = sc.nextLine();
                System.out.print("Digite o ano: ");
                ano = sc.nextLine();
                System.out.print("Digite o ISBN: ");
                isbn = sc.nextLine();
            } else if(evento.equals("2")){
                System.out.print("Digite o Id do Material que você quer excluir: ");
                idMaterial = sc.nextLine();
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
    public String getIdMaterial() {
        return idMaterial;
    }
    public String getTitulo() {
        return titulo;
    }
    public String getAutor() {
        return autor;
    }
    public String getAno() {
        return ano;
    }
    public String getIsbn() {
        return isbn;
    }
}
