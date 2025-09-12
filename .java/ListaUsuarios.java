import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ListaUsuarios{
    private final String csvFilePath;
    private ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();

    public ListaUsuarios(String csvFilePath, String delimiter) throws Exception{
        this.csvFilePath = csvFilePath;

        try{
            crearUsuarios(csvFilePath, delimiter);
        }
        catch (Exception e){
            throw e;
        }
    }

    private void crearUsuarios (String filepath, String delimiter) throws Exception{
        String current_line;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))){
            while ((current_line = br.readLine()) != null) {

                String[] data_usuario = current_line.split(delimiter);
                if (data_usuario.length != 2){
                    throw new Exception("The .csv file doesn't have the correct size of a User type object");
                }
                else{
                    listaUsuarios.add(new Usuario(data_usuario[0], data_usuario[1]));
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getNombreUsuarios(){
        if (listaUsuarios.size() == 0){
            return "No hay usuarios en el sistema";
        }
        else{
            String mensaje_Usuarios = "Estos son los usuarios que hay en el sistema: ";
            for (Usuario usuario : listaUsuarios) {
                mensaje_Usuarios = mensaje_Usuarios.concat("\n- " + usuario.getNombre());
            }
            return mensaje_Usuarios;
        }
    }
}