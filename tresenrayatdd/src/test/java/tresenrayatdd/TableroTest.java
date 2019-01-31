package tresenrayatdd;

import exceptions.CeldaOcupadaException;
import exceptions.FueraRangoException;
import exceptions.TableroOcupadoException;
import exceptions.TiradaRepetidaException;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

public class TableroTest {

    private Juego j;
    private Jugador jugador1;
    private Jugador jugador2;
    private ArrayList<Integer[]> partidaEmpatada, ganadorAh, ganadorBh, ganadorAv, ganadorBv, ganadorAd, ganadorBd, ganadorAdi, ganadorBdi;


    @Before
    public void metodoBefore() {
        j = null;
        j = new Juego();
        jugador1 = new Jugador("suso", "x");
        jugador2 = new Jugador("mamel", "o");
        j.setJugadores(jugador1, jugador2);
        initPartidas();
    }


    public void initPartidas() {
        partidaEmpatada = new ArrayList<Integer[]>();
        ganadorAh = new ArrayList<Integer[]>();
        ganadorBh = new ArrayList<Integer[]>();
        ganadorAv = new ArrayList<Integer[]>();
        ganadorBv = new ArrayList<Integer[]>();
        ganadorAd = new ArrayList<Integer[]>();
        ganadorBd = new ArrayList<Integer[]>();
        ganadorAdi = new ArrayList<Integer[]>();
        ganadorBdi = new ArrayList<Integer[]>();

        partidaEmpate();
        ganadorAHorizontal();
        ganadorBHorizontal();
        ganadorAvertical();
        ganadorBvertical();
        ganadorAdiagonal();
        ganadorBdiagonal();
        ganadorAdi();
        ganadorBdi();
    }

    private void partidaEmpate() {
        partidaEmpatada.add(new Integer[]{0, 0});//x
        partidaEmpatada.add(new Integer[]{0, 1});//o

        partidaEmpatada.add(new Integer[]{0, 2});//x
        partidaEmpatada.add(new Integer[]{1, 0});//o

        partidaEmpatada.add(new Integer[]{1, 1});//x
        partidaEmpatada.add(new Integer[]{2, 1});//o

        partidaEmpatada.add(new Integer[]{1, 2});//x
        partidaEmpatada.add(new Integer[]{2, 2});//o

        partidaEmpatada.add(new Integer[]{2, 0});//x
    }

    private void ganadorAHorizontal() {
        ganadorAh.add(new Integer[]{1, 0});//x
        ganadorAh.add(new Integer[]{0, 0});//o

        ganadorAh.add(new Integer[]{1, 1});//x
        ganadorAh.add(new Integer[]{0, 2});//o

        ganadorAh.add(new Integer[]{1, 2});//x

    }

    private void ganadorBHorizontal() {
        ganadorBh.add(new Integer[]{0, 0});//x
        ganadorBh.add(new Integer[]{1, 0});//o

        ganadorBh.add(new Integer[]{0, 2});//x
        ganadorBh.add(new Integer[]{1, 1});//o

        ganadorBh.add(new Integer[]{2, 2});//x
        ganadorBh.add(new Integer[]{1, 2});//o

    }

    private void ganadorAvertical() {
        ganadorAv.add(new Integer[]{0, 0});//x
        ganadorAv.add(new Integer[]{0, 1});//o

        ganadorAv.add(new Integer[]{1, 0});//x
        ganadorAv.add(new Integer[]{0, 2});//o

        ganadorAv.add(new Integer[]{2, 0});//x
    }

    private void ganadorBvertical() {
        ganadorBv.add(new Integer[]{0, 1});//x
        ganadorBv.add(new Integer[]{0, 0});//o

        ganadorBv.add(new Integer[]{0, 2});//x
        ganadorBv.add(new Integer[]{1, 0});//o

        ganadorBv.add(new Integer[]{2, 2});//x
        ganadorBv.add(new Integer[]{2, 0});//o
    }

    private void ganadorAdiagonal() {
        ganadorAd.add(new Integer[]{0, 0});//x
        ganadorAd.add(new Integer[]{1, 2});//o

        ganadorAd.add(new Integer[]{1, 1});//x
        ganadorAd.add(new Integer[]{0, 1});//o

        ganadorAd.add(new Integer[]{2, 2});//x
        ganadorAd.add(new Integer[]{2, 0});//o
    }

    private void ganadorBdiagonal() {
        ganadorBd.add(new Integer[]{0, 2});//x
        ganadorBd.add(new Integer[]{0, 0});//o

        ganadorBd.add(new Integer[]{0, 1});//x
        ganadorBd.add(new Integer[]{1, 1});//o

        ganadorBd.add(new Integer[]{1, 0});//x
        ganadorBd.add(new Integer[]{2, 2});//o
    }

    private void ganadorAdi() {
        ganadorAdi.add(new Integer[]{0, 2});//x
        ganadorAdi.add(new Integer[]{0, 0});//o

        ganadorAdi.add(new Integer[]{1, 1});//x
        ganadorAdi.add(new Integer[]{1, 2});//o

        ganadorAdi.add(new Integer[]{2, 0});//x
    }

    private void ganadorBdi() {
        ganadorBdi.add(new Integer[]{0, 0});//x
        ganadorBdi.add(new Integer[]{0, 2});//o

        ganadorBdi.add(new Integer[]{1, 2});//x
        ganadorBdi.add(new Integer[]{1, 1});//o

        ganadorBdi.add(new Integer[]{1, 0});//x
        ganadorBdi.add(new Integer[]{2, 0});//o
    }

    @Test
    public void jugarFueraTablero(){
        try {
            j.jugar(1, 7);
            fail();
        }catch (FueraRangoException e){
            assertEquals(FueraRangoException.class, e.getClass());
        }catch (Exception e){
            fail();
        }
    }


    @Test
    public void jugarFueraTablero1() {
        try {
            j.jugar(1, 7);
            fail("fallo porque no hay sino 3 casillas");
        } catch (FueraRangoException e) {
            assertEquals(FueraRangoException.class, e.getClass());
        } catch (Exception e){
            fail();
        }
    }


    @Test
    public void celdaOcupada() {
        try {
            j.jugar(1, 3);
            j.jugar(1, 3);
            fail("no deberia llegar a aqui");
        } catch (CeldaOcupadaException e) {
            assertEquals(e.getClass(), CeldaOcupadaException.class);
        } catch (Exception e){
            fail();
        }
    }

    @Test
    public void turnoJugadaCorrecto() throws Exception {
        String t1 = j.jugar(1, 1, jugador1);
        String t2 = j.jugar(2, 2, jugador2);
    }

    @Test
    public void turnoJugadaIncorrecto() {
        try {
            String t1 = j.jugar(1, 1, jugador1);
            String t2 = j.jugar(2, 2, jugador1);
            fail("No debe llegar porque tiro dos veces el jugador 1");
        } catch (Exception e) {
            assertEquals(TiradaRepetidaException.class, e.getClass());
        }
    }

    @Test
    public void comprobarGanadorVerticalA() throws Exception {
        try {
            for (Integer[] aux:ganadorAv) {
                j.jugar(aux[0]+1,aux[1]+1);
            }
            assertEquals(jugador1,j.getGanador());
        }catch (Exception e){
            fail("no debe fallar");
        }
    }

    @Test
    public  void comprobarGanadorHorizontalA(){
        try {
            for(Integer[] aux:ganadorAh){
                j.jugar(aux[0]+1,aux[1]+1);
            }
            assertEquals(jugador1,j.getGanador());
        }catch (Exception e){
            fail("no debe fallar");
        }
    }

    @Test
    public  void comprobarGanadorVerticalB(){
        try {
            for (Integer[] aux:ganadorBv) {
                j.jugar(aux[0]+1,aux[1]+1);
            }
            assertEquals(jugador2,j.getGanador());
        }catch (Exception e){
            fail("no debe fallar");
        }
    }

    @Test
    public  void comprobarGanadorHorizontalB(){
        try {
            for(Integer[] aux:ganadorBh){
                j.jugar(aux[0]+1,aux[1]+1);
            }
            assertEquals(jugador2,j.getGanador());
        }catch (Exception e){
            fail("no debe fallar");
        }
    }

    @Test
    public  void comprobarGanadorDiagonalA(){
        try {
            for(Integer[] aux:ganadorAd){
                j.jugar(aux[0]+1,aux[1]+1);
            }
            assertEquals(jugador1,j.getGanador());
        }catch (Exception e){
            fail("no debe fallar");
        }
    }

    @Test
    public  void comprobarGanadorDiagonalB(){
        try {
            for(Integer[] aux:ganadorBd){
                j.jugar(aux[0]+1,aux[1]+1);
            }
            assertEquals(jugador2,j.getGanador());
        }catch (Exception e){
            fail("no debe fallar");
        }
    }

    @Test
    public void compruebaTableroLleno(){
        try {
            for(Integer[] aux:partidaEmpatada){
                j.jugar(aux[0]+1,aux[1]+1);
            }
            j.jugar(0,0);
            fail();
        }catch (TableroOcupadoException e){
            assertEquals(e.getClass(),TableroOcupadoException.class);
        }catch (Exception e){
            fail(e.getMessage());
        }
    }



//	@Test
//	public void testeo() {
//		//IsInstanceOf
//		Tablero tab = new Tablero();
//		//assertEquals( "Es la misma clase",tab, Tablero.class);
//	}
//	
//	@Test
//	public void testeo1() {
//		Tablero tab = new Tablero();
//		System.out.println(tab instanceof Tablero);
//	}
}
