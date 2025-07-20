ackage model;

/**
 * Classe que representa um usuário genérico do sistema.
 * Pode ser estendida para representar diferentes tipos de usuários (como Professor, Admin).
 */
public class Usuario {
    // Nome completo do usuário
    private String nome;

    // Identificador único do usuário (pode ser matrícula, CPF, etc)
    private String id;

    // Login usado para autenticação
    private String login;

    // Senha usada para autenticação
    private String senha;

    // Construtor da classe Usuario
    
    public Usuario(String nome, String id, String login, String senha){
        setNome(nome);
        setId(id);
        setLogin(login);
        setSenha(senha);
    }

    //Retorna o nome do usuário

    public String getNome() {
        return nome;
    }

    // Define o nome do usuário (caso não seja nulo)

    public void setNome(String nome) {
        if (nome != null) {
            this.nome = nome;
        }
    }

    // Retorna o login do usuário

    public String getLogin() {
        return login;
    }

    // Define o login do usuário (caso não seja nulo)
    
    public void setLogin(String login) {
        if (login != null) {
            this.login = login;
        }
    }

    // Retorna a senha do usuário
     
    public String getSenha() {
        return senha;
    }

    // Define a senha do usuário (caso não seja nula)
    
    public void setSenha(String senha) {
        if (senha != null) {
            this.senha = senha;
        }
    }

    //Retorna o ID do usuário
    public String getId() {
        return id;
    }

    //Define o ID do usuário
    public void setId(String id) {
        this.id = id;
    }

    // Retorna uma representação textual simples do usuário
    
    public String toString() {
        return nome + " " + login;
    }
}
