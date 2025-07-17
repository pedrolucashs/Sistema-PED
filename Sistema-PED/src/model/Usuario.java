package model;

import java.util.List;

public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private int id;
    private List<Turma> turmas;

    public Usuario(String nome, int id, String login, String senha){
        setNome(nome);
        setId(id);
        setLogin(login);
        setSenha(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        if (login != null) {
            this.login = login;
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        if (senha != null) {
            this.senha = senha;
        }
    }

    public int getId(){ return id; }
    public void setId(int id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public List<Turma> getTurmas(){return turmas;}
    public void setTurmas(List<Turma> turmas){
        if (turmas != null) {
            this.turmas = turmas;
        }
    }

    public String toString() {
        return nome + " " + login;
    }
}
