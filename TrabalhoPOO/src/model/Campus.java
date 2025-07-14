package model;

import java.util.List;

public class Campus {
    private String nomeUnidade;
    private List<String> cursos ;

    public List<String> getCursos() {
        return cursos;
    }
    public void setCursos(List<String> cursos) {
        this.cursos = cursos;
    }
    public String getNomeUnidade() {return nomeUnidade;}

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public String toString() {
        return String.format("%s",getNomeUnidade());
    }

}
