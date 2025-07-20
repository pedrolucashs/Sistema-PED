package model;

// Classe que representa um administrador do sistema, herdando de Usuario
public class Admin extends Usuario {
    private Campus unidade; // Unidade (campus) associada ao administrador

    public Admin(String nome, String id, String login, String senha) {
        super(nome, id, login, senha); // Chamada ao construtor da superclasse
    }

    public Campus getUnidade() {
        return unidade; // Retorna o campus associado
    }

    public void setUnidade(Campus unidade) {
        if (unidade != null) {
            this.unidade = unidade; // Define o campus, se não for nulo
        }
    }
}
