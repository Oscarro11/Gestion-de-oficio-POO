public class PruebaDeClases {

    public static void main(String[] args){
        try{
            ListaUsuarios ejemplo = new ListaUsuarios("C:\\Users\\oscar\\OneDrive\\Documents\\2025\\progra orientada a objetos\\App organizate\\.csv\\BaseDeDatos.csv", ";");
            System.out.println(ejemplo.getNombreUsuarios());
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
    }

}
