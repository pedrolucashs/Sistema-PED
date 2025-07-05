package model;

import java.util.List;

public class Usuario {
    private String nome;
    private String login;
    private String senha;
    private int id;
    private List<Turma> turmas;

    public Usuario(){
        super();
    }

    public Usuario(String nome, String login, String senha){
        setNome(nome);
        setLogin(login);
        setSenha(senha);
    }

    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public  void setTurmas(List<Turma> turmas){
        this.turmas = turmas;
    }
    public List<Turma> getTurmas(){
        return turmas;
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

    public String toString() {
        return nome + " " + login;
    }
}
