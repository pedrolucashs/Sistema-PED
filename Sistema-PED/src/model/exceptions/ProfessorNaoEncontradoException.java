package model.exceptions;

public class ProfessorNaoEncontradoException extends RuntimeException {
    public ProfessorNaoEncontradoException(String message) {
        super(message);
    }
}