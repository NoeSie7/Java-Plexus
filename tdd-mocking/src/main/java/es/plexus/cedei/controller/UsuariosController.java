package es.plexus.cedei.controller;

import es.plexus.cedei.dao.UsuarioDAO;
import es.plexus.cedei.model.Mensaje;
import es.plexus.cedei.model.Usuario;
import es.plexus.cedei.exception.UsuarioException;
import es.plexus.cedei.service.MensajeriaService;

public class UsuariosController {
  private MensajeriaService mensajeriaService;
  private UsuarioDAO usuarioDAO;

  public void crearUsuario(Usuario usuario) throws UsuarioException {
  }

  public boolean login(String nombreUsuario, String contrasenia) throws UsuarioException {
	  if(nombreUsuario == null || nombreUsuario.length() == 0) {
		  throw new UsuarioException("El nombre de usuario es nulo o vacio");
	  }
	  if(contrasenia == null || contrasenia.length() == 0) {
		  throw new UsuarioException("La contrasenia de usuario es nulo o vacio");
	  }

	  Usuario usuario = usuarioDAO.obtenerUsuario(nombreUsuario);

	  if(usuario == null) {
		  throw new UsuarioException("El Usuario no existe");
	  }
	 
	  if(usuario.getContrasenia().equals(contrasenia)) {
		  Mensaje mensaje = new Mensaje();
		  mensaje.setAsunto("Nuevo inicio de sesion");
		  mensaje.setCuerpo("Ha iniciado sesion desde la maquina...");
		  mensajeriaService.enviarMensaje(usuario.getEmail(), mensaje);
		  return true;
	  }
	  return false;
   //return true;
  }

  public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
    this.usuarioDAO = usuarioDAO;
  }

  public void setMensajeriaService(MensajeriaService mensajeriaService) {
    this.mensajeriaService = mensajeriaService;
  }
}
