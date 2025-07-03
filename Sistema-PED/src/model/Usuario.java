package model;

public class Usuario {
    private String nome;
    private String login;
    private String id;
    private String senha;

    public Usuario(){
        super();
    }

    public Usuario(String nome, String login, String id, String senha){
        setNome(nome);
        setLogin(login);
        setId(id);
        setSenha(senha);
    }

    public String getId() {
        return id;
    }

    public void setId(String id){
        if (id != null) {
            this.id = id;
        }
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
