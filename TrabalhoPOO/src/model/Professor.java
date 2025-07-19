package model;

import java.util.HashMap;

public class Professor extends Usuario {
    private HashMap<String, Turma> turmas;
    private Campus campus;

    public Professor(String nome, String id, String login, String senha, Campus campus) {
        super(nome, id, login, senha);
        setTurmas(new HashMap<String,Turma>());
        setCampus(campus);
    }

    public HashMap<String, Turma> getTurmas() {
        return turmas;
    }
    public void setTurmas(HashMap<String, Turma> turmas) {
        if(turmas != null) {
            this.turmas = turmas;
        }
    }

    public Campus getCampus() {
        return campus;
    }
    public void setCampus(Campus campus) {
        if(campus != null) {
            this.campus = campus;
        }
    }

    public String toString(){
        return String.format("nome: %s\nLogin: %s\nId: %s",getNome(),getLogin(),getId());
    }
}