import java.util.ArrayList;

public class Usuario {
    private final String nombre;
    private String contrasena;
    // private ArrayList<Actividad> lista_Actividades = new ArrayList<Actividad>();
    // private ArrayList<Rutina> lista_Rutinas = new ArrayList<Rutina>();
    // private ArrayList<Premio> lista_disenos_Premio = new ArrayList<Premio>();
    // private ArrayList<Premio> lista_Premio_canjeables = new ArrayList<Premio>();
    // private EspacioDeTrabajo Espacio_Trabajo_propio;
    // private ArrayList<EspacioDeTrabajo> lista_Espacio_Trabajo_ajeno = new ArrayList<EspacioDeTrabajo>();

    public Usuario(String nombre, String contrasena){
        this.nombre = nombre;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
}
