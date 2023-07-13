package unlam.edu.ar.pb2;

public class Administrador extends Usuario {

	public Administrador(String nombre, String contraseña) throws unlampb2InvalidPassword {
		super(nombre, contraseña);
		if(contraseña == "1234" || contraseña == "abcd") {
			throw new unlampb2InvalidPassword();
		}
	}

}
