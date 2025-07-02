package model;

public class Campus {
    private String nomeUnidade;
    private String[] cursos;

    public String getNomeUnidade() {return nomeUnidade;}

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String[] getCursos() {return cursos;}

    public void setCursos(String[] cursos) {
        if (cursos != null) {
            this.cursos = cursos;
        }
    }
}
