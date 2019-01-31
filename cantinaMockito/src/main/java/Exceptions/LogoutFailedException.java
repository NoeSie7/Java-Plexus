package Exceptions;

public class LogoutFailedException extends Exception {
    public LogoutFailedException() {
        super("Logout ha fallado");
    }
}
