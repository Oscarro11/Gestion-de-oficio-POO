public class PruebaDeClases {
    private static Usuario usuario_activo;

    public static void main(String[] args){
        try{

            ListaUsuarios ejemplo = new ListaUsuarios("C:\\Users\\oscar\\OneDrive\\Documents\\2025\\progra orientada a objetos\\App organizate\\.csv\\BaseDeDatos.csv", ";");
            usuario_activo = AuthenticationController.autenticarUsuario(ejemplo, "oscar", "hola12345");

            if (usuario_activo == null){
                System.out.println("El usuario o contrasena ingresados no existen en el sistema. Intentelo de nuevo");
            } 
            else{
                System.out.println("Redirigiendo a la pagina principal");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
    }

}
