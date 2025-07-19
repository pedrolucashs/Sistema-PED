package model;

public class Turma {
    private String codigoTurma;
    private Disciplina disciplina;
    private PlanoDeEnsino plano;

    public Turma(String codigoTurma, Disciplina disciplina) {
        setCodigoTurma(codigoTurma);
        setDisciplina(disciplina);
    }

    public String getCodigoTurma() {return codigoTurma;}

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        if(disciplina != null) {
            this.disciplina = disciplina;
        }
    }

    public PlanoDeEnsino getPlano() {
        return plano;
    }

    public void setPlano(PlanoDeEnsino plano) {
        if(plano != null) {
            this.plano = plano;
        }
    }

    public String toString() {
        String retorno = String.format("Código da Turma: %s\nCampus: %s\nNome da Disciplina: %s\nCaráter da Disciplina: %s\nRegime de Oferta: %s\nCarga Horária: %d",
                getCodigoTurma(), getDisciplina().getUnidade(), getDisciplina().getNomeDisciplina(), getDisciplina().getCaraterDisciplina(),
                getDisciplina().getRegimeOferta(), getDisciplina().getCargaHoraria());
        return retorno;
    }
}
