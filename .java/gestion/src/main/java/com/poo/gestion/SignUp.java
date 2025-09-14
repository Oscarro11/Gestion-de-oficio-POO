package com.poo.gestion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SignUp {

    private String email;
    private String username;
    private String password;
    private String confirmPassword;

    public SignUp(String email, String username, String password, String confirmPassword) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.confirmPassword = confirmPassword;
    }

    private boolean isAccountCreated() {
        String csvFilePath = ".csv/DBUsuarios.csv"; // Replace with your CSV file path
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
                if (this.username.equals(data[1])) {
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

        if (!this.password.equals(this.confirmPassword)) {
            return "Las contraseñas no coinciden";
        }

        String[] data = { this.email, this.username, this.password };

        try (FileWriter fw = new FileWriter(".csv/DBUsuarios.csv", true); PrintWriter pw = new PrintWriter(fw)) {

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
