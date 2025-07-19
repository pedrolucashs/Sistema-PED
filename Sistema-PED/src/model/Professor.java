package model;

import java.util.HashMap;

public class Professor extends Usuario {
    private HashMap<String, Turma> turmas;

    public Professor(String nome, String id, String login, String senha) {
        super(nome, id, login, senha);
        setTurmas(new HashMap<String,Turma>());
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
