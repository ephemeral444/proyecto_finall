package Paquete;

public class PacienteSISBEN extends Paciente {

    private double puntajeSISBEN;

    public PacienteSISBEN(int id, String nombre, String apellido, int edad, String telefono, double puntajeSISBEN) {
        super(id, nombre, apellido, edad, telefono);
        this.puntajeSISBEN = puntajeSISBEN;
    }

    public double getPuntajeSISBEN() {
        return puntajeSISBEN;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo          : SISBEN");
        System.out.println("ID            : " + getId());
        System.out.println("Nombre        : " + getNombre() + " " + getApellido());
        System.out.println("Edad          : " + getEdad());
        System.out.println("Telefono      : " + getTelefono());
        System.out.println("Puntaje SISBEN: " + puntajeSISBEN);
    }

    @Override
    public String toCSV() {
        return getId() + "," + getNombre() + "," + getApellido() + "," + getEdad()
                + "," + getTelefono() + "," + puntajeSISBEN;
    }

    @Override
    public String toString() {
        return "[SISBEN] ID=" + getId() + " | " + getNombre() + " " + getApellido()
                + " | Edad=" + getEdad() + " | Tel=" + getTelefono()
                + " | Puntaje=" + puntajeSISBEN;
    }
}
