package model;

public class Turma {
    private String codigoTurma;
    private Disciplina disciplina;
    private PlanoDeEnsino plano;

    public Turma(String codigoTurma, Disciplina disciplina, String nomeProfessor) {
        setCodigoTurma(codigoTurma);
        setDisciplina(disciplina);
        setPlano(new PlanoDeEnsino(nomeProfessor));
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
        String retorno = String.format("Código da Turma: %s\nNome da Disciplina: %s\nNome do Professor: %s\nRegime de Oferta: %s\nCarga Horária: %d",
                getCodigoTurma(), getDisciplina().getNomeDisciplina(), getPlano().getNomeProfessor(),
                getDisciplina().getRegimeOferta(), getDisciplina().getCargaHoraria());
        return retorno;
    }
}
