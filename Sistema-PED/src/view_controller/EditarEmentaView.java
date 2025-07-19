package view_controller;

import controller.EditarPEDController;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import model.Model;

public class EditarEmentaView implements Observer{
    Model model;
    private EditarEmentaController controller;
    private String justificativa;
    private String ano;
    private String objetivosGerais;
    private String objetivosEspecificos;
    private String regimeOferta;
    private String estruturaCurricular;
    private int cargaHoraria;


    public void init(){
        this.model = model;
        controller = new EditarEmentaController();
        controller.init(model,this);
        model.attachObserver(this);
        editarEmenta(); // criar model
    }

    public void editarEmenta() {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("\n--- Edição do Plano de Ensino ---");
            System.out.println("1. Editar Ano/Semestre");
            System.out.println("2. Editar Justificativa");
            System.out.println("3. Editar Ementa");
            System.out.println("4. Editar Objetivo Geral");
            System.out.println("5. Editar Objetivos Específicos");
            System.out.println("6. Editar Conteúdos");
            System.out.println("0. Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = Integer.parseInt(scanner.nextLine());

            switch (opcao) {
                case 1 -> {
                    System.out.print("Digite o novo Ano/Semestre: ");
                    String novoAno = scanner.nextLine();
                    controller.atualizarAnoSemestre(novoAno);
                }
                case 2 -> {
                    System.out.print("Digite a nova Justificativa: ");
                    String justificativa = scanner.nextLine();
                    controller.atualizarJustificativa(justificativa);
                }
                case 3 -> {
                    System.out.print("Digite a nova Ementa: ");
                    String ementa = scanner.nextLine();
                    controller.atualizarEmenta(ementa);
                }
                case 4 -> {
                    System.out.print("Digite o novo Objetivo Geral: ");
                    String objetivoGeral = scanner.nextLine();
                    controller.atualizarObjetivoGeral(objetivoGeral);
                }
                case 5 -> {
                    List<String> objetivos = new ArrayList<>();
                    System.out.println("Digite os objetivos específicos (digite 'fim' para encerrar):");
                    while (true) {
                        String linha = scanner.nextLine();
                        if (linha.equalsIgnoreCase("fim")) break;
                        objetivos.add(linha);
                    }
                    controller.atualizarObjetivosEspecificos(objetivos);
                }
                case 6 -> {
                    List<String> conteudos = new ArrayList<>();
                    System.out.println("Digite os conteúdos (digite 'fim' para encerrar):");
                    while (true) {
                        String linha = scanner.nextLine();
                        if (linha.equalsIgnoreCase("fim")) break;
                        conteudos.add(linha);
                    }
                    controller.atualizarConteudos(conteudos);
                }
                case 0 -> continuar = false;
                default -> System.out.println("Opção inválida.");
            }
        }
        System.out.println("\nEdição finalizada.");
    }
}
