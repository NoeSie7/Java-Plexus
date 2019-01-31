package Exceptions;

public class UserCreateFailed extends Exception{
    public UserCreateFailed() {
        super("El usuario no pudo ser creado");
    }
}
