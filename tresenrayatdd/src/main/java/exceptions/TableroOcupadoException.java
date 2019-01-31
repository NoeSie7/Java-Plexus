package exceptions;

public class TableroOcupadoException extends Exception{
    public TableroOcupadoException(){
        super("El tablero esta completo");
    }
}
