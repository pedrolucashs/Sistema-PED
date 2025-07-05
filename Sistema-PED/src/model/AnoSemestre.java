package model;

public class AnoSemestre {
    private int ano;
    private int semestre;

    public int getAno() {return ano;}

    public void setAno(int ano) {
        if(ano > 0){
            this.ano = ano;
        }
    }

    public int getSemestre() {return semestre;}

    public void setSemestre(int semestre) {
        if(semestre == 1 || semestre == 2) {
            this.semestre = semestre;
        }
    }
}