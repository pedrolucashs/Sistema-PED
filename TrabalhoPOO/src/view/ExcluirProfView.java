package view;

import model.Model;
import java.util.Scanner;
import controller.ExcluirProfController;

public class ExcluirProfView implements Observer {
    private Model model;
    private ExcluirProfController controller;
    private Scanner scanner;

    public void init(Model model) {
        if (model != null) {
            this.model = model;
            this.scanner = new Scanner(System.in);
            this.controller = new ExcluirProfController();
            this.controller.init(this.model, this);
            this.controller.iniciarExclusaoProfessor();
        } else {
            System.err.println(String.format("Erro: O modelo não pode ser nulo para inicializar a View."));
        }
    }

    public void exibirMensagem(String msg) {
        System.out.println(String.format(msg));
    }

    public String lerEntrada() {
        return scanner.nextLine();
    }

    public void update() {

    }
}