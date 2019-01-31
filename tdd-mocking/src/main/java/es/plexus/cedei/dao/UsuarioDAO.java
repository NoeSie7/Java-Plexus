package es.plexus.cedei.dao;

import es.plexus.cedei.model.Usuario;

public interface UsuarioDAO {
    void crearUsuario(Usuario usuario);

    Usuario obtenerUsuario(String nombreUsuario);
}
