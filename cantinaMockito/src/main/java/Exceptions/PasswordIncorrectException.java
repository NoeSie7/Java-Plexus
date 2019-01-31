package Exceptions;

public class PasswordIncorrectException extends Exception {
    public PasswordIncorrectException() {
        super("Contraseña incorrecta");
    }
}
