package exceptions;

public class FueraRangoException extends Exception {
    public FueraRangoException(){
        super("Tirada fuera de rango");
    }
}
