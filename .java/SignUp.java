
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUp {

    private String correo;
    private String usuario;
    private String contraseña;
    private String confirmacionContraseña;

    public SignUp(String correo, String usuario, String contraseña, String confirmacionContraseña) {
        this.correo = correo;
        this.usuario = usuario;
        this.contraseña = contraseña;
        this.confirmacionContraseña = confirmacionContraseña;
    }

    private boolean isAccountCreated() {
        String csvFilePath = "./DBUsuarios.csv"; // Replace with your CSV file path
        String line;
        String cvsSplitBy = ","; // Delimiter for CSV
        boolean accountExists = false;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
            while ((line = br.readLine()) != null) {
                if (line.trim().isEmpty()) { // Skip empty lines
                    continue;
                }
                String[] data = line.split(cvsSplitBy);
                // Process the 'data' array (e.g., print elements, store in a list)
                String usernameData = data[1];
                if (this.usuario.equals(data[1])) {
                    accountExists = true;
                    break; // Exit the loop if a match is found
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return accountExists;
    }

// funcion para crear, funcion que existe
    public String crearCuenta() {
        if (isAccountCreated()) {
            return "El usuario ya existe";
        }

        String[] data = {this.correo, this.usuario, this.contraseña};

        try (FileWriter fw = new FileWriter("./DBUsuarios.csv", true); PrintWriter pw = new PrintWriter(fw)) {

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                sb.append(data[i]);
                if (i < data.length - 1) {
                    sb.append(","); // Add comma as delimiter
                }
            }
            pw.println(sb.toString()); // Write the new line to the CSV

        } catch (IOException e) {
            e.printStackTrace();
        }

        return "Cuenta creada exitosamente";
    }
}
