package model;
import java.util.HashMap;

public class Campus {
    private String nomeUnidade;
    private HashMap<Integer, Professor> professores;
    private HashMap<String, Turma> turmas;

    public Campus(String nomeUnidade, HashMap<String, Turma> turmas, HashMap<Integer, Professor> professores) {
        setNomeUnidade(nomeUnidade);
        setTurmas(turmas);
        setProfessores(professores);
    }

    public String getNomeUnidade() {return nomeUnidade;}
    public void setNomeUnidade(String nomeUnidade) {
        this.nomeUnidade = nomeUnidade;
    }

    public HashMap<Integer, Professor> getProfessores() {
        return professores;
    }
    public void setProfessores(HashMap<Integer, Professor> professores) {
        if (professores != null) {
            this.professores = professores;
        }
    }

    public HashMap<String, Turma> getTurmas() {
        return turmas;
    }
    public void setTurmas(HashMap<String, Turma> turmas) {
        if(turmas != null) {
            this.turmas = turmas;
        }
    }
}