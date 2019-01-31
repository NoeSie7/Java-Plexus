package Controllers;

        import Exceptions.EmailIncorrectException;
        import Exceptions.PasswordIncorrectException;
        import Exceptions.UsernameIncorrectException;
        import Interfaces.UsuarioInterface;
        import pojos.User;

public class BDDService implements UsuarioInterface {
    public User crearUsuario(User toAdd){
        return  null;
    }

    public User buscarUsuario(String username) {
        return null;
    }

    public User eliminarUsuario(String username) {
        return null;
    }

    public void cargarUsuarios() {

    }
}
