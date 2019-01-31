package Controllers;

import Exceptions.*;
import Interfaces.UsuarioInterface;
import pojos.User;


public class CreateUsuario {
    UsuarioInterface db;

    public CreateUsuario() {

    }

    //El test fallará porque el mockito no es capaz de emular el nuevo usuario (debido a que al usar el new se coge un nuevo espacio en memoria y lo coge como un objeto distinto) USAR EL DE ABAJO
    public User crearUsuario(String username,String password, String email) throws UsernameIncorrectException, PasswordIncorrectException, EmailIncorrectException, UserCreateFailed{
        User x = new User(username,password,email);
        User aux = db.crearUsuario(x);
        if(aux == null){
            throw new UserCreateFailed();
        }
        return aux;
    }
    public User crearUsuario(User x) throws UserCreateFailed{
        User aux = db.crearUsuario(x);
        if(aux == null){
            throw new UserCreateFailed();
        }
        return aux;
    }

    public void eliminarUsuario(String Username){

    }

    public User buscarUsuario(String username) throws  UserNotFoundException{
        User aux = db.buscarUsuario(username);
        if(aux == null){
            throw  new UserNotFoundException();
        }
        return aux;

    }

    public void cargarUsuarios(){

    }

    public void setDb(UsuarioInterface db) {
        this.db = db;
    }
}
