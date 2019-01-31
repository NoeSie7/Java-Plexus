package Exceptions;

public class LoginFailedException extends Exception {
    public LoginFailedException() {
        super("El login ha fallado");
    }
}
