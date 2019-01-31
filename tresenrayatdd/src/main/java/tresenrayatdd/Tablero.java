package tresenrayatdd;

import exceptions.CeldaOcupadaException;

public class Tablero {
	private final Integer tableroSize = 3;
	private  final Integer defaultFicha = 17;
	private Integer[][] tablero = new Integer[tableroSize][tableroSize];
	private Integer winner;

	public Tablero() {
		for(int i = 0; i < tablero.length; ++i){
			for(int j = 0; j < tablero.length; ++j){
				this.tablero[i][j] = this.defaultFicha;

			}
		}
	}

	public Integer getValue(int x, int y) {
		return tablero[x][y];
	}


	public Boolean isPosOcupada(int x, int y){
		return getValue(x,y) == this.defaultFicha?false:true;

	}
	public void insertar(int x,int y, Integer valor) throws CeldaOcupadaException {
		if(!isPosOcupada(x,y)){
			this.tablero[x][y] = valor;
		}else{
			throw new CeldaOcupadaException(x,y);
		}
	}

	public Integer[][] getTablero(){
		return this.tablero;
	}
	
	public Integer getSize(){
		return tablero.length;
	}
	public Integer getDefaultFicha(){
		return this.defaultFicha;
	}

	public Boolean comprobar_vertical() {
		Integer i = 0;
		Boolean ganador = false;
		do{
			Integer counter = 0;
			for(int j = 0; j < tableroSize; j++){
				counter += this.tablero[j][i];
			}
			ganador = checker(counter);
			i++;
		}while(i < this.tableroSize && this.winner == null);
		return ganador;
	}

	public Boolean comprobar_horizontal() {
		Integer i = 0;
		Boolean ganador = false;
		do{
			Integer counter = 0;
			for(int j = 0; j < tableroSize; j++){
				counter += this.tablero[i][j];
			}

			ganador = checker(counter);
			i++;
		}while(i < this.tableroSize && this.winner == null);
		return ganador;
	}

	public Boolean comprobar_diagonal(){
        Integer counter = 0;
		for(int i = 0; i < tableroSize; i++){
			counter += this.tablero[i][i];
		}
		return checker(counter);
	}

	private Boolean checker(Integer counter){
		Boolean ganador = false;
		if(counter == 0 || counter == this.tableroSize){
			this.winner = counter == this.tableroSize ? 1: 0;
			ganador = true;
		}
		return ganador;
	}
	public Integer getWinner() {
		return winner;
	}
}
