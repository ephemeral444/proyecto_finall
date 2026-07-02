package Paquete;

public abstract class Paciente {

    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private String telefono;

    public Paciente(int id, String nombre, String apellido, int edad, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.telefono = telefono;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getTelefono() {
        return telefono;
    }

    public abstract void mostrarInformacion();

    public abstract String toCSV();
}
