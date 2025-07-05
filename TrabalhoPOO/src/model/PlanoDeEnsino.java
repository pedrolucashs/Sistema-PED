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

    public String[] getObjetivosGerais() {return objetivosGerais;}

    public void setObjetivosGerais(String[] objetivosGerais) {
        this.objetivosGerais = objetivosGerais;
    }

    public String[] getObjetivosEspecificos() {return objetivosEspecificos;}

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

    public String[] getAtividades() {return atividades;}

    public void setAtividades(String[] atividades) {
        this.atividades = atividades;
    }

    public String getSistemaAvaliacao() {return sistemaAvaliacao;}

    public void setSistemaAvaliacao(String sistemaAvaliacao) {
        this.sistemaAvaliacao = sistemaAvaliacao;
    }

    public List<MaterialEstudo> getBibliografiaBasica() {return bibliografiaBasica;}

    public void setBibliografiaBasica(List<MaterialEstudo> bibliografiaBasica) {
        this.bibliografiaBasica = bibliografiaBasica;
    }

    public List<MaterialEstudo> getBibliografiaComplementar() {return bibliografiaComplementar;}

    public void setBibliografiaComplementar(List<MaterialEstudo> bibliografiaComplementar) {
        this.bibliografiaComplementar = bibliografiaComplementar;
    }


}