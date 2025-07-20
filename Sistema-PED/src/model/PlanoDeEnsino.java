package model;

import java.util.HashMap;

public class PlanoDeEnsino {
    private String anoSemestre;
    private String justificativa;
    private String ementa;
    private String[] objetivos;
    private HashMap<String, AtividadeCalendario> calendarioAtividades;
    private String metodologia;
    private String[] atividades;
    private String sistemaAvaliacao;
    private HashMap<String, MaterialEstudo> bibliografia;
    private String nomeProfessor;

    public PlanoDeEnsino(String nomeProfessor) {
        super();
        setNomeProfessor(nomeProfessor);
        setCalendarioAtividades(new HashMap<String, AtividadeCalendario>());
        setBibliografia(new HashMap<String, MaterialEstudo>());
    }

    public void editarPlano(String anoSemestre, String justificativa, String ementa, String[] objetivos,
                            String metodologia, String[] atividades, String sistemaAvaliacao) {
        setAnoSemestre(anoSemestre);
        setJustificativa(justificativa);
        setEmenta(ementa);
        setObjetivos(objetivos);
        setMetodologia(metodologia);
        setAtividades(atividades);
        setSistemaAvaliacao(sistemaAvaliacao);
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
            s += "\n";
        }
        return s;
    }
    public void setObjetivos(String[] objetivos) {
        this.objetivos = objetivos;
    }


    public String getStringCalendarioAtividades() {
        if (calendarioAtividades == null || calendarioAtividades.isEmpty()) {
            return "";
        }
        String s = "";
        for (AtividadeCalendario atividade : calendarioAtividades.values()) {
            if (atividade != null) {
                s += atividade.toString();
                s += "\n";
            }
        }
        return s;
    }
    public HashMap<String, AtividadeCalendario> getCalendarioAtividades(){
        return calendarioAtividades;
    }
    public void setCalendarioAtividades(HashMap<String, AtividadeCalendario> calendarioAtividades) {
        this.calendarioAtividades = calendarioAtividades;
    }
    public void addAtividade(String idAtividadade, String data, String descricao, int cargaHoraria) {
        AtividadeCalendario atividade = new AtividadeCalendario(idAtividadade, data, descricao, cargaHoraria);
        getCalendarioAtividades().put(idAtividadade, atividade);
    }
    public void excluirAtividade(String idAtividadade) {
        getCalendarioAtividades().remove(idAtividadade);
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
            s += "\n";
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

    public String getStringBibliografia() {
        if (bibliografia == null || bibliografia.isEmpty()) {
            return "";
        }
        String s = "";
        for (MaterialEstudo material : bibliografia.values()) {
            if (material != null) {
                s += material.toString();
                s += "\n";
            }
        }
        return s;
    }
    public HashMap<String, MaterialEstudo> getBibliografia() {
        return bibliografia;
    }
    public void setBibliografia(HashMap<String, MaterialEstudo> bibliografia) {
        this.bibliografia = bibliografia;
    }
    public void addMaterial(String idMaterial, String titulo, String autor, String ano, String isbn) {
        MaterialEstudo material = new MaterialEstudo(idMaterial, titulo, autor, ano, isbn);
        getBibliografia().put(idMaterial, material);
    }
    public void excluirMaterial(String idMaterial) {
        getBibliografia().remove(idMaterial);
    }

    public String getNomeProfessor() {
        return nomeProfessor;
    }
    public void setNomeProfessor(String nomeProfessor) {
        this.nomeProfessor = nomeProfessor;
    }
}
