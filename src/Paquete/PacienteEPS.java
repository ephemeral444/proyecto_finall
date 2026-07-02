package Paquete;

public class PacienteEPS extends Paciente {

    private String eps;

    public PacienteEPS(int id, String nombre, int edad, String telefono, String eps) {
        super(id, nombre, "", edad, telefono);
        this.eps = eps;
    }

    public String getEps() {
        return eps;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("Tipo     : EPS");
        System.out.println("ID       : " + getId());
        System.out.println("Nombre   : " + getNombre());
        System.out.println("Edad     : " + getEdad());
        System.out.println("Telefono : " + getTelefono());
        System.out.println("EPS      : " + eps);
    }

    @Override
    public String toCSV() {
        return getId() + "," + getNombre() + "," + getEdad() + "," + getTelefono() + "," + eps;
    }

    @Override
    public String toString() {
        return "EPS ID=" + getId() + " | " + getNombre() + " | Edad=" + getEdad()
                + " | Tel=" + getTelefono() + " | EPS=" + eps;
    }
}
