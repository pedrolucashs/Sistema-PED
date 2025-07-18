package model;

import java.util.HashMap;

public class Admin extends Usuario {
    private Campus unidade;
    private HashMap<String, Professor> professores;

    public Admin(String nome, String id, String login, String senha) {
        super(nome, id, login, senha);
    }

    public Campus getUnidade() {
        return unidade;
    }
    public void setUnidade(Campus unidade) {
        if (unidade != null) {
            this.unidade = unidade;
        }
    }

    public HashMap<String, Professor> getProfessores() {
        return professores;
    }
    public void setProfessores(HashMap<String, Professor> professores) {
        if (professores != null) {
            this.professores = professores;
        }
    }
}
