package exceptions;

public class TiradaRepetidaException extends Exception {
    public TiradaRepetidaException(){
        super("No puede tirar dos veces el mismo jugador");
    }
}
