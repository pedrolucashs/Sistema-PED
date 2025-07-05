package view_controller;
import model.*;

import java.util.Scanner;

public class PlanoDeEnsinoView {
    private Model model;
    private PlanoDeEnsinoController controller;
    private boolean finalizar = false;
    private Campus campus;
    private Disciplina disciplina;
    private Turma turma;
    private PlanoDeEnsino planoDeEnsino;
    private MaterialEstudo materialEstudo;

    public void init(Model model){
        if (model != null){
            this.model = model;
            controller = new PlanoDeEnsinoController();
            controller.init(model, this);
            model.attachObserver(this);
            planoDeEnsino();
        }
    }

    public void planoDeEnsino(){
        Scanner sc = new Scanner(System.in);
        String[] opcoes = {"[1] - Listar Turmas", "[2] - Adicionar Turma", "[3] - Editar Turma", "[4] - Fazer Logout"};
        do {
            System.out.println();
            System.out.println("=============================");
            System.out.println("      PLANO DE ENSINO      ");
            System.out.println("=============================");
            System.out.println();
            System.out.println("1.IDENTIFICAÇÃO");
            System.out.println("1.1 UNIDADE: " + campus.getNomeUnidade());
            System.out.println("1.2 CURSOS: " + campus.getCursos());
            System.out.println("1.3 ESTRUTURA CURRICULAR: " + disciplina.getEstruturaCurricular());
            System.out.println("1.4 NOME DA DISCIPLINA: " + disciplina.getNomeDisciplina());
            System.out.println("1.5 CÓDIGO DA DISCIPLINA: " + disciplina.getCodigo());
            System.out.println("1.6 CARÁTER DA DISCIPLINA: " + disciplina.getCaraterDisciplina());
            System.out.println("1.7 REGIME DE OFERTA DA DISCIPLINA: " + disciplina.getRegimeOferta());
            System.out.println(String.format("1.8 CARGA HORÁRIA: %d | CH TEÓRICA: %d | CH PRÁTICA: %d | CH EAD: %d | CH EXTENSÃO: %d" + disciplina.getChTotal(), disciplina.getChTeorica(), disciplina.getChPratica(), disciplina.getChEAD(), disciplina.getChExtensao()));
            System.out.println("1.9 PRÉ-REQUISITOS: " + disciplina.getPreRequisitos());
            System.out.println("1.10 CO-REQUISITOS: " + disciplina.getCoRequisitos());
            System.out.println("1.11 EQUIVALÊNCIAS: " + disciplina.getEquivalencias());
            System.out.println("1.12 PROFESSOR: " + turma.getProfessor());
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
            System.out.println("2. JUSTIFICATIVA");
            System.out.println(planoDeEnsino.getJustificativa());
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
            System.out.println("3. EMENTA");
            System.out.println(planoDeEnsino.getEmenta());
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
            System.out.println("4. OBJETIVOS - GERAL E ESPECÍFICOS");
            System.out.println("OBJETIVOS GERAIS:");
            System.out.println(planoDeEnsino.getObjetivosGerais());
            System.out.println();
            System.out.println("OBJETIVOS ESPECÍFICOS:");
            System.out.println(planoDeEnsino.getObjetivosEspecificos());
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
            System.out.println("5. CALENDÁRIO DE ATIVIDADES");
            System.out.println(planoDeEnsino.getCalendarioAtividades());
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
            System.out.println("6. METODOLOGIA DE ENSINO");
            System.out.println(planoDeEnsino.getMetodologia());
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
            System.out.println("7. ATIVIDADES DISCENTES");
            System.out.println(planoDeEnsino.getAtividades());
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
            System.out.println("8. SISTEMA DE AVALIAÇÃO");
            System.out.println(planoDeEnsino.getSistemaAvaliacao());
            System.out.println();
            System.out.println("-------------------------------------------------");
            System.out.println();
            System.out.println("9. BIBLIOGRAFIA BÁSICA E COMPLEMENTAR");
            System.out.println("BIBLIOGRAFIA BÁSICA:");
            System.out.println(planoDeEnsino.getBibliografiaBasica());
            System.out.println();
            System.out.println("BIBLIOGRAFIA COMPLEMENTAR:");
            System.out.println(planoDeEnsino.getBibliografiaComplementar());
            System.out.println();
            System.out.println("-------------------------------------------------");

            String event = sc.nextLine();
            controller.handleEvent(event);
        } while(!finalizar);
        sc.close();
    }

    public void update() {}
}
