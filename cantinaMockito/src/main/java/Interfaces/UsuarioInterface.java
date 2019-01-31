package Interfaces;

import Exceptions.EmailIncorrectException;
import Exceptions.PasswordIncorrectException;
import Exceptions.UsernameIncorrectException;
import pojos.User;

public interface UsuarioInterface{

    public User crearUsuario(User toAdd);
    public User buscarUsuario(String username);
    public User eliminarUsuario(String username);
    public void cargarUsuarios();
}
