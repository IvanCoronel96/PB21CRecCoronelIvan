package unlam.edu.ar.pb2;

import java.util.Comparator;
import java.util.Objects;

public class Usuario implements Comparator<Usuario>{
	
	private String nombre;
	private String contraseña;
	
	public Usuario(String nombre, String contraseña) {
		this.nombre = nombre;
		this.contraseña = contraseña;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContraseña() {
		return contraseña;
	}

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(nombre, other.nombre);
	}

	@Override
	public int compare(Usuario o1, Usuario o2) {
		return o1.getNombre().compareTo(o2.getNombre());
	}

	
}
