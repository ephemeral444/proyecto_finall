package Paquete;

public class Cita {

    private int idPaciente;
    private String especialidad;

    public Cita(int idPaciente, String especialidad) {
        this.idPaciente = idPaciente;
        this.especialidad = especialidad;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String toString() {
        return "Cita | ID Paciente=" + idPaciente + " | Especialidad=" + especialidad;
    }
}
