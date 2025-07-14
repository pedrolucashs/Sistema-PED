package model;

public class Turma {
    private String codigoTurma;
    private Disciplina disciplina;
    private PlanoDeEnsino plano = new PlanoDeEnsino();


    public void setPlano(PlanoDeEnsino plano){
        this.plano = plano;
    }
    public PlanoDeEnsino getPlano(){return plano;}

    public String getCodigoTurma() {return codigoTurma;}

    public void setCodigoTurma(String codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public Disciplina getDisciplina() {return disciplina;}

    public void setDisciplina(Disciplina disciplina) {
        if(disciplina != null) {
            this.disciplina = disciplina;
        }
    }

    public boolean isPlanodeEnsino() {
        if(this.plano != null) {
            return true;
        }
        return false;
    }

    public String toString() {
        return String.format("Codigo da Turma: %s\nDisciplina: %s", codigoTurma, disciplina.getNomeDisciplina());
    }
}
