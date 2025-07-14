package model;
import java.util.HashMap;

public class Campus {
    private String nomeUnidade;
    private HashMap<Integer, String> cursos;

    public String getNomeUnidade() {return nomeUnidade;}

    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public HashMap<Integer, String> getCursos() {return cursos;}

    public void setCursos(HashMap<Integer, String> cursos) {
        if (cursos != null) {
            this.cursos = cursos;
        }
    }
}
