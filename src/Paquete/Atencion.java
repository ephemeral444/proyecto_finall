package Paquete;

public class Atencion {

    private int idPaciente;
    private String nombrePaciente;
    private String especialidad;
    private String tipoPaciente;

    public Atencion(int idPaciente, String nombrePaciente, String especialidad, String tipoPaciente) {
        this.idPaciente = idPaciente;
        this.nombrePaciente = nombrePaciente;
        this.especialidad = especialidad;
        this.tipoPaciente = tipoPaciente;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public String getTipoPaciente() {
        return tipoPaciente;
    }

    @Override
    public String toString() {
        return "Atencion | ID=" + idPaciente + " | Paciente=" + nombrePaciente
                + " | Especialidad=" + especialidad + " | Tipo=" + tipoPaciente;
    }
}
