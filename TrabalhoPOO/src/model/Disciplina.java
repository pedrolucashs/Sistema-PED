package model;
// Classe que representa uma disciplina com todas suas informações

public class Disciplina {
    private String unidade;
    private String codigo;
    private String nomeDisciplina;
    private String caraterDisciplina;
    private String regimeOferta;
    private String estruturaCurricular;
    private int cargaHoraria;

    public Disciplina(String codigoDisciplina, String nomeUnidade, String nomeDisciplina,
                      String caraterDisciplina, String regimeOferta, String estruturaCurricular,
                      int cargaHoraria) {
        setUnidade(nomeUnidade);
        setCodigo(codigoDisciplina);
        setNomeDisciplina(nomeDisciplina);
        setCaraterDisciplina(caraterDisciplina);
        setRegimeOferta(regimeOferta);
        setEstruturaCurricular(estruturaCurricular);
        setCargaHoraria(cargaHoraria);
    }

    public String getUnidade() {
        return unidade;
    }
    public void setUnidade(String unidade) {
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

    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
