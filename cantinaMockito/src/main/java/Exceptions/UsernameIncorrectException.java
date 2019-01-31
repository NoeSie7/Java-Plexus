package Exceptions;

public class UsernameIncorrectException extends Exception{
    public UsernameIncorrectException() {
        super("Nombre de usuario incorrecto");
    }
}
