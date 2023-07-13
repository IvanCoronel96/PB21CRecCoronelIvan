package unlam.edu.ar.pb2;

import static org.junit.Assert.*;

import org.junit.Test;

public class test {

	@Test(expected = UsuarioDuplicadoException.class)
	public void testQueNoSePuedaRegistrarUnUsuarioRepetido() throws UsuarioDuplicadoException, unlampb2InvalidPassword {
		
		Sistema sistema = new Sistema("Miel");		
		Usuario user = new Bloqueable("Ivan","1111");
		sistema.registrarUsuario(user);
		
	}
	
	@Test
	public void testQueSePuedaEliminarUnUsuario() throws UsuarioDuplicadoException, NoSePuedeEliminar, unlampb2InvalidPassword {
		
		Sistema sistema = new Sistema("Miel");		
		Usuario user = new Eliminable("Ivan","1111");
		sistema.registrarUsuario(user);
		
		assertTrue(sistema.eliminarUsuario("Ivan"));
		
	}
	
	@Test(expected = UsuarioBloqueado.class)
	public void testQueSePuedaBloquearUnUsuario() throws UsuarioDuplicadoException, NoSePuedeEliminar, unlampb2UserNotFound, UsuarioBloqueado, unlampb2InvalidPassword {
		
		Sistema sistema = new Sistema("Miel");		
		Usuario user = new Eliminable("Ivan","1111");
		sistema.registrarUsuario(user);
				
		sistema.ingresar("Ivan","2222");
		
		assertTrue(sistema.eliminarUsuario("Ivan"));
		
	}
	
	@Test(expected = unlampb2InvalidPassword.class)
	public void testQueNoSePuedaPonerUnaPass1234() throws UsuarioDuplicadoException, NoSePuedeEliminar, unlampb2UserNotFound, UsuarioBloqueado, unlampb2InvalidPassword {
		
		Sistema sistema = new Sistema("Miel");		
		Usuario user = new Eliminable("Ivan","1234");
		sistema.registrarUsuario(user);
		
		
	}

}
