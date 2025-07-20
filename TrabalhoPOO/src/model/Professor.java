package model;

import java.util.HashMap;

// Classe que representa um professor, herdando de Usuario
class Professor extends Usuario {
    private HashMap<String, Turma> turmas; // Mapeamento de turmas atribuídas ao professor (chave: ID ou código da turma)
    private Campus campus; // Campus onde o professor atua

    // Construtor da classe Professor
    public Professor(String nome, String id, String login, String senha, Campus campus) {
        super(nome, id, login, senha); // Chamada do construtor da superclasse Usuario
        setTurmas(new HashMap<String, Turma>()); // Inicializa o mapa de turmas como vazio
        setCampus(campus); // Define o campus
    }

    public HashMap<String, Turma> getTurmas() {
        return turmas;
    }
     // Define o mapa de turmas, se não for nulo
    public void setTurmas(HashMap<String, Turma> turmas) {
        if (turmas != null) {
            this.turmas = turmas;
        }
    }

    // Retorna o campus do professor
    public Campus getCampus() {
        return campus;
    }

    // Define o campus, se não for nulo
    public void setCampus(Campus campus) {
        if (campus != null) {
            this.campus = campus;
        }
    }

    // Representação textual do professor (nome, login e ID)
    public String toString() {
        return String.format("nome: %s\nLogin: %s\nId: %s", getNome(), getLogin(), getId());
    }
}
