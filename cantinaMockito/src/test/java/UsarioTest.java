import Controllers.CreateUsuario;
import Exceptions.EmailIncorrectException;
import Exceptions.PasswordIncorrectException;
import Exceptions.UserNotFoundException;
import Exceptions.UsernameIncorrectException;
import Interfaces.UsuarioInterface;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pojos.User;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UsarioTest {

    private User usuario_completo;
    private User usuario_incompleto;
    private CreateUsuario controladorUsuario;

    @Mock
    private UsuarioInterface db = mock(UsuarioInterface.class);


    @Before
    public void metodobefore() throws UsernameIncorrectException, PasswordIncorrectException, EmailIncorrectException {
        controladorUsuario = new CreateUsuario();
        controladorUsuario.setDb(db);
        usuario_completo = new User("Juanito", "juanito123", "juanitokoyack@gmail.com");
    }

    @Test
    public void comprobarCrearUsuario() {
        try {
            when(db.crearUsuario(usuario_completo)).thenReturn(usuario_completo);
            User acrear = controladorUsuario.crearUsuario(usuario_completo);
            assertEquals(usuario_completo.getUsername(), acrear.getUsername());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            fail();
        }
    }

    @Test
    public void comprobarCrearUsuarioIncorrectoUsername_nulo() {
        try {
            controladorUsuario.crearUsuario(null, "Juanito123", "juanito@gmail.com");
            fail();
        } catch (Exception e) {
            assertEquals(UsernameIncorrectException.class, e.getClass());
        }
    }

    @Test
    public void comprobarCrearUsuarioIncorrectoUsername_vacio() {
        try {
            controladorUsuario.crearUsuario("", "Juanito123", "juanito@gmail.com");
            fail();
        } catch (Exception e) {
            assertEquals(UsernameIncorrectException.class, e.getClass());
        }
    }

    @Test
    public void comprobarCrearUsuarioIncorrectoPassword_nulo() {
        try {
            controladorUsuario.crearUsuario("Juanito", null, "juanito@gmail.com");
            fail();
        } catch (Exception e) {
            assertEquals(PasswordIncorrectException.class, e.getClass());
        }
    }

    @Test
    public void comprobarCrearUsuarioIncorrectoPassword_vacio() {
        try {
            controladorUsuario.crearUsuario("Juanito", "", "juanito@gmail.com");
            fail();
        } catch (Exception e) {
            assertEquals(PasswordIncorrectException.class, e.getClass());
        }
    }

    @Test
    public void comprobarCrearUsuarioIncorrectoEmail_nulo() {
        try {
            controladorUsuario.crearUsuario("Juanito", "Juanito123", null);
            fail();
        } catch (Exception e) {
            assertEquals(EmailIncorrectException.class, e.getClass());
        }
    }

    @Test
    public void comprobarCrearUsuarioIncorrectoEmail_vacio() {
        try {
            controladorUsuario.crearUsuario("Juanito", "Juanito123", "");
            fail();
        } catch (Exception e) {
            assertEquals(EmailIncorrectException.class, e.getClass());
        }
    }

    @Test
    public void comprobarCrearUsuarioIncorrectoEmail_noValido() {
        try {
            controladorUsuario.crearUsuario("Juanito", "Juanito123", "susolandia");
            fail();
        } catch (Exception e) {
            assertEquals(EmailIncorrectException.class, e.getClass());
        }
    }

    @Test
    public void comprobarBuscarUsuario_correcto() {
        try {
            when(db.buscarUsuario("Juanito")).thenReturn(usuario_completo);
            User abuscar = controladorUsuario.buscarUsuario("Juanito");
            assertEquals(usuario_completo, abuscar);
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    public void comprobarBuscarUsuario_incorrecto() {
        try {
            //when(db.buscarUsuario("Juanito")).thenReturn(null);
            controladorUsuario.buscarUsuario("suso");
            fail();
        } catch (Exception e) {
            assertEquals(UserNotFoundException.class, e.getClass());
        }
    }


}
