package tresenrayatdd;

import com.sun.org.apache.xpath.internal.operations.Bool;
import exceptions.CeldaOcupadaException;
import exceptions.FueraRangoException;
import exceptions.TableroOcupadoException;
import exceptions.TiradaRepetidaException;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Juego {

	Tablero tab = new Tablero();
	Integer nTirada = 0;
	Jugador ganador = null;
	ArrayList<Jugador> jugadores = new ArrayList<Jugador>();



	public String jugar(int x,int y) throws Exception{
	    checkTablero();
		Integer[] coords = comprobaciones(x,y);
		tab.insertar(coords[0],coords[1],nTirada%2);
		this.chekWinner();
		String j =this.jugadores.get(nTirada%2).getSimbolo();
		nTirada++;
		return j;
	}
    private void checkTablero() throws TableroOcupadoException{
	    if(nTirada == Math.pow(tab.getSize(),2)){
            throw new TableroOcupadoException();
        }
    }
	public String jugar(int x, int y,Jugador j) throws TableroOcupadoException,TiradaRepetidaException,FueraRangoException,CeldaOcupadaException {
	    checkTablero();
		Integer[] coords = comprobaciones(x,y);
		if(jugadores.indexOf(j)%2 == nTirada%2){
			tab.insertar(coords[0],coords[1],jugadores.indexOf(j));
		}else{
			throw new TiradaRepetidaException();
		}
		this.chekWinner();
		nTirada++;
		return j.getSimbolo();
	}
	public void setJugadores(Jugador j1,Jugador j2){
		jugadores.add(j1);
		jugadores.add(j2);
	}
	private Integer[] comprobaciones(int x,int y) throws  FueraRangoException{
		int x1 = x-1;
		int y1 = y-1;
		this.jugarMargenes(x1);
		this.jugarMargenes(y1);
		return new Integer[]{x1,y1};
	}

	public void jugarMargenes(int x) throws FueraRangoException {
		if ((x < 0 || x > 4)) {
			throw new FueraRangoException();
		}
	}

	public String printTablero(){
		StringBuilder resu = new StringBuilder();
		Integer[][] matrix = tab.getTablero();
			for(int i = 0 ; i < tab.getSize(); ++i){
				for( int j = 0; j < tab.getSize();++j ){
					int actual = matrix[i][j];
					if(actual == tab.getDefaultFicha()){
						resu.append("-");
					}else{
						resu.append(this.jugadores.get(actual).getSimbolo());
					}
					resu.append(" ");
				}
				resu.append("\n");
			}
		return resu.toString();
	}

	public Jugador getGanador(){
		return this.ganador;
	}

	public void chekWinner(){
		String[] methods = new String[]{"comprobar_vertical","comprobar_horizontal","comprobar_diagonal"};
		try {
			Integer i = 0;
			do{
				if( (Boolean) tab.getClass().getMethod(methods[i]).invoke(tab)){
					this.ganador = this.jugadores.get(tab.getWinner());
				}
				i++;
			}while(i < methods.length && this.ganador == null);
		}catch (Exception e){
			String fail = e.getMessage();
		}
	}
}
