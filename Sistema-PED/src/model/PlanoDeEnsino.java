package model;

import java.util.List;

public class PlanoDeEnsino {
    private AnoSemestre anoSemestre;
    private String justificativa;
    private String ementa;
    private String[] objetivosGerais;
    private String[] objetivosEspecificos;
    private List<AtividadeCalendario> calendarioAtividades;
    private String metodologia;
    private String[] atividades;
    private String sistemaAvaliacao;
    private List<MaterialEstudo> bibliografiaBasica;
    private List<MaterialEstudo> bibliografiaComplementar;
    private Professor professor;

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

    public String getObjetivosGerais() {
        String s = "";
        for(int i = 0; i < objetivosGerais.length; i++) {
            s += "- ";
            s += objetivosGerais[i];
            s += "/n";
        }
        return s;
    }

    public void setObjetivosGerais(String[] objetivosGerais) {
        this.objetivosGerais = objetivosGerais;
    }

    public String getObjetivosEspecificos() {
        String s = "";
        for(int i = 0; i < objetivosEspecificos.length; i++) {
            s += "- ";
            s += objetivosEspecificos[i];
            s += "/n";
        }
        return s;
    }

    public void setObjetivosEspecificos(String[] objetivosEspecificos) {
        this.objetivosEspecificos = objetivosEspecificos;
    }

    public List<AtividadeCalendario> getCalendarioAtividades() {return calendarioAtividades;}

    public void setCalendarioAtividades(List<AtividadeCalendario> calendarioAtividades) {
        this.calendarioAtividades = calendarioAtividades;
    }

    public String getMetodologia() {return metodologia;}

    public void setMetodologia(String metodologia) {
        this.metodologia = metodologia;
    }

    public String getAtividades() {
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

    public String getSistemaAvaliacao() {return sistemaAvaliacao;}

    public void setSistemaAvaliacao(String sistemaAvaliacao) {
        this.sistemaAvaliacao = sistemaAvaliacao;
    }

    public String getBibliografiaBasica() {
        String s = "";
        for(int i = 0; i < bibliografiaBasica.size(); i++) {
            s += bibliografiaBasica.get(i).toString();
            s += "/n";
        }
        return s;
    }

    public void setBibliografiaBasica(List<MaterialEstudo> bibliografiaBasica) {
        this.bibliografiaBasica = bibliografiaBasica;
    }

    public String getBibliografiaComplementar() {
        String s = "";
        for(int i = 0; i < bibliografiaComplementar.size(); i++) {
            s += bibliografiaComplementar.get(i).toString();
            s += "/n";
        }
        return s;
    }

    public void setBibliografiaComplementar(List<MaterialEstudo> bibliografiaComplementar) {
        this.bibliografiaComplementar = bibliografiaComplementar;
    }

    public Professor getProfessor() {return professor;}

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public boolean finalizarPlanoDeEnsino() {
        return true;
    }
}
