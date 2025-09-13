import java.security.InvalidParameterException;

public class AuthenticationController {
    

    public static Usuario autenticarUsuario(ListaUsuarios lista_Usuarios, String nombre_usuario, String contrasena_usuario){

        if (nombre_usuario.equals("") || contrasena_usuario.equals("")) {
            throw new InvalidParameterException("El nombre de usuario o contrasena no pueden ser vacios");
        }

        if (lista_Usuarios.contrasenaUsuarioCorrecta(nombre_usuario, contrasena_usuario)) {
            return lista_Usuarios.buscarUsuario(nombre_usuario);    
        }
        else{
            return null;
        }
    }
}
