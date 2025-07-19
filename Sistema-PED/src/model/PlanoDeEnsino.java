package model;

import java.util.List;

public class PlanoDeEnsino {
    private String anoSemestre;
    private String justificativa;
    private String ementa;
    private String[] objetivos;
    private List<AtividadeCalendario> calendarioAtividades;
    private String metodologia;
    private String[] atividades;
    private String sistemaAvaliacao;
    private List<MaterialEstudo> bibliografia;
    private String nomeProfessor;

    public PlanoDeEnsino(String nomeProfessor) {
        super();
        setNomeProfessor(nomeProfessor);
    }

    public void editarPlano(){

    }

    public String getAnoSemestre() {
        if (anoSemestre == null) {
            anoSemestre = "";
        }
        return anoSemestre;
    }
    public void setAnoSemestre(String anoSemestre) {
        this.anoSemestre = anoSemestre;
    }

    public String getJustificativa() {
        if(justificativa == null){
            return "";
        }
        return justificativa;
    }
    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getEmenta() {
        if(ementa == null){
            return "";
        }
        return ementa;
    }
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getObjetivos() {
        if(objetivos == null){
            return "";
        }
        String s = "";
        for(int i = 0; i < objetivos.length; i++) {
            s += "- ";
            s += objetivos[i];
            s += "/n";
        }
        return s;
    }
    public void setObjetivos(String[] objetivos) {
        this.objetivos = objetivos;
    }


    public String getCalendarioAtividades() {
        if(calendarioAtividades == null){
            return "";
        }
        String s = "";
        for(int i = 0; i < calendarioAtividades.size(); i++) {
            s += calendarioAtividades.get(i).toString();
            s += "/n";
        }
        return s;
    }
    public void setCalendarioAtividades(List<AtividadeCalendario> calendarioAtividades) {
        this.calendarioAtividades = calendarioAtividades;
    }

    public String getMetodologia() {
        if(metodologia == null){
            return "";
        }
        return metodologia;
    }
    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getAtividades() {
        if(atividades == null){
            return "";
        }
        String s = "";
        for(int i = 0; i < atividades.length; i++) {
            s += "- ";
            s += atividades[i];
            s += "/n";
        }
        return s;
    }
    public void setAtividades(String[] atividades) {
        this.atividades = atividades;
    }

    public String getSistemaAvaliacao() {
        if(sistemaAvaliacao == null){
            return "";
        }
        return sistemaAvaliacao;
    }
    public void setSistemaAvaliacao(String sistemaAvaliacao) {
        this.sistemaAvaliacao = sistemaAvaliacao;
    }

    public String getBibliografia() {
        if(bibliografia == null){
            return "";
        }
        String s = "";
        for(int i = 0; i < bibliografia.size(); i++) {
            s += bibliografia.get(i).toString();
            s += "/n";
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
