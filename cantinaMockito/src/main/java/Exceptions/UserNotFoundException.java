package Exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {
        super("Usuario no encontrado");
    }
}
