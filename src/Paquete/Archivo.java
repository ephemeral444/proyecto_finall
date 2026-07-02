package Paquete;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Archivo {

    private String nombreArchivo;

    public Archivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void guardarEPS(Nodo nodo) {
        try (FileWriter fw = new FileWriter(nombreArchivo);
             PrintWriter escritor = new PrintWriter(fw)) {

            escritor.println("id,nombre,edad,telefono,EPS");

            Nodo actual = nodo;
            while (actual != null) {
                PacienteEPS p = (PacienteEPS) actual.getDato();
                escritor.println(p.toCSV());
                actual = actual.getSiguiente();
            }

            System.out.println("Archivo guardado correctamente: " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + nombreArchivo);
        }
    }

    public void guardarSISBEN(Nodo nodo) {
        try (FileWriter fw = new FileWriter(nombreArchivo);
             PrintWriter escritor = new PrintWriter(fw)) {

            escritor.println("id,nombre,apellido,edad,telefono,puntajeSISBEN");

            Nodo actual = nodo;
            while (actual != null) {
                PacienteSISBEN p = (PacienteSISBEN) actual.getDato();
                escritor.println(p.toCSV());
                actual = actual.getSiguiente();
            }

            System.out.println("Archivo guardado correctamente: " + nombreArchivo);

        } catch (IOException e) {
            System.out.println("Error al guardar el archivo: " + nombreArchivo);
        }
    }
}
