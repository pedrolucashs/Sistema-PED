package model;

public class Turma {
    private String codigoTurma;
    private Disciplina disciplina;
    private Professor professor;

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

    public Professor getProfessor() {return professor;}

    public void setProfessor(Professor professor) {this.professor = professor;}
}
