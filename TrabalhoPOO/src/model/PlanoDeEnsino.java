package model;

import java.util.List;
// Classe que representa um plano de ensino com todas as informações relevantes para uma disciplina
public class PlanoDeEnsino {
  private AnoSemestre anoSemestre; // Ano e semestre em que o plano se aplica
    private String justificativa; // Justificativa do conteúdo proposto
    private String ementa; // Ementa da disciplina
    private String[] objetivos; // Lista de objetivos da disciplina
    private List<AtividadeCalendario> calendarioAtividades; // Lista de atividades organizadas no calendário
    private String metodologia; // Metodologia de ensino utilizada
    private String[] atividades; // Atividades que serão realizadas
    private String sistemaAvaliacao; // Sistema de avaliação utilizado
    private List<MaterialEstudo> bibliografia; // Lista de materiais de estudo (bibliografia)
    private String nomeProfessor; // Nome do professor responsável

    // Construtor recebendo o nome do professor
    public PlanoDeEnsino(String nomeProfessor) {
        super();
        setNomeProfessor(nomeProfessor);
    }

    // Método para editar o plano (ainda não implementado)
    public void editarPlano() {
        // Implementação futura
    }

    public AnoSemestre getAnoSemestre() {return anoSemestre;}
    public void setAnoSemestre(AnoSemestre anoSemestre) {
        this.anoSemestre = anoSemestre;
    }

    public String getJustificativa() {return justificativa;}
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getEmenta() {return ementa;}
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    // Retorna os objetivos formatados como string
    public String getObjetivos() {
        String s = "";
        for (int i = 0; i < objetivos.length; i++) {
            s += "- ";
            s += objetivos[i];
            s += "\n"; // Corrigido: era "/n" (errado), agora está como quebra de linha verdadeira
        }
        return s;
    }
    public void setObjetivos(String[] objetivos) {
        this.objetivos = objetivos;
    }


    public List<AtividadeCalendario> getCalendarioAtividades() {return calendarioAtividades;}
    public void setCalendarioAtividades(List<AtividadeCalendario> calendarioAtividades) {
        this.calendarioAtividades = calendarioAtividades;
    }

    public String getMetodologia() {return metodologia;}
    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    // Retorna as atividades formatadas como string
    public String getAtividades() {
        String s = "";
        for (int i = 0; i < atividades.length; i++) {
            s += "- ";
            s += atividades[i];
            s += "\n"; // Corrigido: era "/n"
        }
        return s;
    }
    public void setAtividades(String[] atividades) {
        this.atividades = atividades;
    }

    public String getSistemaAvaliacao() {return sistemaAvaliacao;}
    public void setSistemaAvaliacao(String sistemaAvaliacao) {
        this.sistemaAvaliacao = sistemaAvaliacao;
    }

    // Retorna a bibliografia formatada como string
    public String getBibliografia() {
        String s = "";
        for (int i = 0; i < bibliografia.size(); i++) {
            s += bibliografia.get(i).toString();
            s += "\n"; // Corrigido: era "/n"
        }
        return s;
    }
    public void setBibliografia(List<MaterialEstudo> bibliografia) {
        this.bibliografia = bibliografia;
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }
    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
}
