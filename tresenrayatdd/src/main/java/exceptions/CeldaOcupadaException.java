package exceptions;

public class CeldaOcupadaException extends Exception {
    public CeldaOcupadaException(Integer x, Integer y){
        super("Celda ocupada\n la celda "+x+","+y+"ya ha sido ocupada");
    }
}
