package model;

public class Disciplina {
    private Campus unidade;
    private String codigo;
    private String nomeDisciplina;
    private String caraterDisciplina;
    private String regimeOferta;
    private String estruturaCurricular;
    private int chTotal;
    private int chTeorica;
    private int chPratica;
    private int chEAD;
    private int chExtensao;
    private String[] preRequisitos;
    private String[] coRequisitos;
    private String[] equivalencias;
    private String[] cursos;

    public Campus getUnidade() {return unidade;}

    public void setUnidade(Campus unidade) {
        this.unidade = unidade;
    }

    public String getCodigo() {return codigo;}

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeDisciplina() {return nomeDisciplina;}

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public String getCaraterDisciplina() {return caraterDisciplina;}

    public void setCaraterDisciplina(String caraterDisciplina) {
        this.caraterDisciplina = caraterDisciplina;
    }

    public String getRegimeOferta() {return regimeOferta;}

    public void setRegimeOferta(String regimeOferta) {
        this.regimeOferta = regimeOferta;
    }

    public String getEstruturaCurricular() {return estruturaCurricular;}

    public void setEstruturaCurricular(String estruturaCurricular) {
        this.estruturaCurricular = estruturaCurricular;
    }

    public int getChTotal() {return chTotal;}

    public void setChTotal(int chTotal) {
        this.chTotal = chTotal;
    }

    public int getChTeorica() {return chTeorica;}

    public void setChTeorica(int chTeorica) {
        this.chTeorica = chTeorica;
    }

    public int getChPratica() {return chPratica;}

    public void setChPratica(int chPratica) {
        this.chPratica = chPratica;
    }

    public int getChEAD() {return chEAD;}

    public void setChEAD(int chEAD) {
        this.chEAD = chEAD;
    }

    public int getChExtensao() {return chExtensao;}

    public void setChExtensao(int chExtensao) {
        this.chExtensao = chExtensao;
    }

    public String getPreRequisitos() {
        String s = "";
        for(int i = 0; i < preRequisitos.length; i++){
            s += "- ";
            s+=preRequisitos[i];
            s += "/n";
        }
        return s;
    }

    public void setPreRequisitos(String[] preRequisitos) {
        this.preRequisitos = preRequisitos;
    }

    public String getCoRequisitos() {
        String s = "";
        for(int i = 0; i < coRequisitos.length; i++){
            s += "- ";
            s += coRequisitos[i];
            s += "/n";
        }
        return s;
    }

    public void setCoRequisitos(String[] coRequisitos) {
        this.coRequisitos = coRequisitos;
    }

    public String getEquivalencias() {
        String s = "";
        for(int i = 0; i < equivalencias.length; i++){
            s += "- ";
            s+=equivalencias[i];
            s += "/n";
        }
        return s;
    }

    public void setEquivalencias(String[] equivalencias) {
        this.equivalencias = equivalencias;
    }

    public String[] getCursos() {return cursos;}

    public void setCursos(String[] cursos) {
        this.cursos = cursos;
    }
}
