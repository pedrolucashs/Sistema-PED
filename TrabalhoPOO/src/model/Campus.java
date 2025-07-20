package model;
import java.util.HashMap;

// Classe que representa um campus contendo professores e turmas
class Campus {
    private String nomeUnidade;
    private HashMap<String, Professor> professores;
    private HashMap<String, Turma> turmas;

    public Campus(String nomeUnidade, HashMap<String, Turma> turmas, HashMap<String, Professor> professores) {
        setNomeUnidade(nomeUnidade);
        setTurmas(turmas);
        setProfessores(professores);
    }

    public String getNomeUnidade() { return nomeUnidade; }
    public void setNomeUnidade(String nomeUnidade) { this.nomeUnidade = nomeUnidade; }

    public HashMap<String, Professor> getProfessores() { return professores; }
    public void setProfessores(HashMap<String, Professor> professores) {
        if (professores != null) {
            this.professores = professores; // Define os professores se não for nulo
        }
    }

    public HashMap<String, Turma> getTurmas() { return turmas; }
    public void setTurmas(HashMap<String, Turma> turmas) {
        if (turmas != null) {
            this.turmas = turmas; // Define as turmas se não for nulo
        }
    }
}
