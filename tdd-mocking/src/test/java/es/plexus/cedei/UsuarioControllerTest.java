package es.plexus.cedei;

import static org.junit.Assert.*;
import static org.mockito.Mockito.times;


import org.junit.Before;
import org.junit.Test;

import org.mockito.Mockito;


import es.plexus.cedei.controller.UsuariosController;
import es.plexus.cedei.dao.UsuarioDAO;
import es.plexus.cedei.exception.UsuarioException;
import es.plexus.cedei.model.Mensaje;
import es.plexus.cedei.model.Usuario;
import es.plexus.cedei.service.MensajeriaService;
import org.mockito.*;
public class UsuarioControllerTest {
	
	UsuariosController usuarioController;
	MensajeriaService mensajeriaService;
	UsuarioDAO usuarioDao;
	
	@Before
	public void before() {
		
		usuarioDao = Mockito.mock(UsuarioDAO.class);
		mensajeriaService = Mockito.mock(MensajeriaService.class);
		usuarioController = new UsuariosController();
		usuarioController.setMensajeriaService(mensajeriaService);
		usuarioController.setUsuarioDAO(usuarioDao);
		
	}
	
	
	@Test
	public void loginUsuarionoExiste()  {
		try {
		Mockito.when(usuarioDao.obtenerUsuario("usuario")).thenReturn(null);
		usuarioController.login("usuario","contrasenia");
		fail();
		}catch(UsuarioException e){
			//e.printStackTrace();
			assertEquals( "El Usuario no existe", e.getMessage());

		}
		
	}



	@Test
	public void comprobarCorreo() throws UsuarioException {

		ArgumentCaptor<Mensaje> mensajeArgumentCaptor = ArgumentCaptor.forClass(Mensaje.class);
		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);

		String email = "mail@mail.com";

		Usuario usuario = new Usuario();
		usuario.setContrasenia("contrasenia");
		usuario.setEmail(email);
		usuario.setNombreUsuario("usuario");

		Mockito.when(usuarioDao.obtenerUsuario("usuario")).thenReturn(usuario);
		usuarioController.login("usuario", "contrasenia");

		Mockito.verify(mensajeriaService, Mockito.times(1)).enviarMensaje(stringArgumentCaptor.capture(), mensajeArgumentCaptor.capture());

		assertEquals(usuario.getEmail(), stringArgumentCaptor.getValue());

		assertEquals("Nuevo inicio de sesion", mensajeArgumentCaptor.getValue().getAsunto());

		assertEquals("Ha iniciado sesion desde la maquina...", mensajeArgumentCaptor.getValue().getCuerpo());

	}





//	@Test
//	public void loginUsuarioComprobarCorreo() throws UsuarioException {
//
//		ArgumentCaptor<Mensaje> mensajeArgumentCaptor = ArgumentCaptor.forClass(Mensaje.class);
//		ArgumentCaptor<String> stringArgumentCaptor = ArgumentCaptor.forClass(String.class);
//
//		String email = "mail@mail.com";
//		Usuario usuario = new Usuario();
//		usuario.setContrasenia("Contraseña");
//		usuario.setEmail(email);
//		usuario.setNombreUsuario("usuario");
//		Mockito.when(usuarioDao.obtenerUsuario("usuario")).thenReturn(usuario);
//		Mockito.verify(mensajeriaService , Mockito.times(1)).enviarMensaje(stringArgumentCaptor.capture(), mensajeArgumentCaptor.capture());
//
//		assertEquals(usuario.getEmail(),stringArgumentCaptor.getValue());
//		assertEquals("Nuevo inicio de sesion", mensajeArgumentCaptor.getValue().getAsunto());
//		assertEquals("Ha iniciado sesion desde la maquina...", mensajeArgumentCaptor.getValue().getCuerpo());
//		//assertFalse(usuarioController.login("usuario", "Contraseña"));
//
//
//
//	}
	
	
	@Test(expected = UsuarioException.class)
	public void loginNombreUsuarioNull() throws UsuarioException {
		try {
		usuarioController.login(null,null);
		fail();
		}catch(UsuarioException e){
			//e.printStackTrace();
			assertEquals( "El nombre de usuario es nulo o vacio", e.getMessage());
			throw e;
		}
		
	}
	
	@Test(expected = UsuarioException.class)
	public void loginContrasenaUsuarioNull() throws UsuarioException{
		try {
		usuarioController.login("usuario",null);
		fail();
		}catch(UsuarioException e){
			//e.printStackTrace();
			assertEquals( "La contrasenia de usuario es nulo o vacio", e.getMessage());
			throw e;
		}
		
	}
//
//	@Test(expected = UsuarioException.class)
//	public void loginNombreUsuarioVacio() {
//		fail("Not yet implemented");
//	}

}
