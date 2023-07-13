package unlam.edu.ar.pb2;

import java.util.Set;
import java.util.TreeSet;

public class Sistema {

	private String nombre;
	private Set<Usuario> usuarios;
	private Integer intentos = 0;

	public Sistema(String nombre) {
		this.nombre = nombre;
		this.usuarios = new TreeSet<>();
	}
	
	public void registrarUsuario(Usuario usuario) throws UsuarioDuplicadoException {
		if (!this.usuarios.add(usuario) && !(usuario.getContraseña().contains("123")) ) {
			throw new UsuarioDuplicadoException();
		}
	}

	Boolean eliminarUsuario(String nombre) {
			for (Usuario usuario : usuarios) {
				if (usuario.getNombre().equals(nombre) && usuario instanceof Eliminable) {
					usuario.setNombre("Usuario eliminado");
					return true;
				}
			}
			throw new java.lang.ClassCastException();
	}

	public Boolean ingresar(String nombreUsuario, String pass) throws unlampb2UserNotFound, UsuarioBloqueado {
		intentos += 1;
		Usuario intentoDeIngreso = buscarUsuario(nombreUsuario);
		
		if(intentoDeIngreso.getContraseña().equals(pass) && intentos<3 ) {
			return true;
		}else{
			throw new UsuarioBloqueado();
		}
		
	}
	
	private Usuario buscarUsuario(String nombre) throws unlampb2UserNotFound {
		for (Usuario usuario : usuarios) {
			if (usuario.getNombre().equals(nombre)) {
				return usuario;
			}
		}
		throw new unlampb2UserNotFound();
	}
	
}
