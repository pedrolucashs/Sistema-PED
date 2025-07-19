package model;

public class Admin extends Usuario {
    private Campus unidade;

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
}
