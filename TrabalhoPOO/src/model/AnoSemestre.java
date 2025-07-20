package model;

class AnoSemestre {
    private int ano;
    private int semestre;

    public int getAno() { return ano; }

    public void setAno(int ano) {
        if (ano > 1900) {
            this.ano = ano; // Define o ano se for válido
        }
    }

    public int getSemestre() { return semestre; }

    public void setSemestre(int semestre) {
        if (semestre == 1 || semestre == 2) {
            this.semestre = semestre; // Define o semestre como 1 ou 2
        }
    }
}
