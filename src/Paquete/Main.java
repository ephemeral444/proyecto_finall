package Paquete;

import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        Lista pacientesEPS = new Lista();
        Lista pacientesSISBEN = new Lista();
        Arbol arbolPacientes = new Arbol();
        Cola colaCitas = new Cola();
        Pila historial = new Pila();

        int opcion = -1;
        while (opcion != 0) {
            mostrarMenu();
            opcion = leerEntero("Digite la opcion que desea elegir :) : ");
            switch (opcion) {
                case 1:
                    registrarPacienteEPS(pacientesEPS, arbolPacientes);
                    break;
                case 2:
                    registrarPacienteSISBEN(pacientesSISBEN, arbolPacientes);
                    break;
                case 3:
                    buscarPaciente(arbolPacientes);
                    break;
                case 4:
                    mostrarPacientesEPS(pacientesEPS);
                    break;
                case 5:
                    mostrarPacientesSISBEN(pacientesSISBEN);
                    break;
                case 6:
                    agendarCita(colaCitas, arbolPacientes);
                    break;
                case 7:
                    atenderCita(colaCitas, historial, arbolPacientes);
                    break;
                case 8:
                    mostrarCitasPendientes(colaCitas);
                    break;
                case 9:
                    verUltimaAtencion(historial);
                    break;
                case 10:
                    verHistorialCompleto(historial);
                    break;
                case 11:
                    guardarEPS(pacientesEPS);
                    break;
                case 12:
                    guardarSISBEN(pacientesSISBEN);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema. Hasta luego.");
                    break;
                default:
                    System.out.println("Opcion no valida. Intente de nuevo.");
            }
        }
    }

    static void mostrarMenu() {
        System.out.println("\n--- MENU PRINCIPAL ---");
        System.out.println("1.  Registrar paciente EPS");
        System.out.println("2.  Registrar paciente SISBEN");
        System.out.println("3.  Buscar paciente por ID");
        System.out.println("4.  Mostrar todos los pacientes EPS");
        System.out.println("5.  Mostrar todos los pacientes SISBEN");
        System.out.println("6.  Agendar cita medica");
        System.out.println("7.  Atender siguiente cita");
        System.out.println("8.  Mostrar citas pendientes");
        System.out.println("9.  Ver ultima atencion (historial)");
        System.out.println("10. Ver historial completo");
        System.out.println("11. Guardar pacientes EPS en CSV");
        System.out.println("12. Guardar pacientes SISBEN en CSV");
        System.out.println("0.  Salir");
    }

    static void registrarPacienteEPS(Lista pacientesEPS, Arbol arbol) {
        System.out.println("\n--- Registrar Paciente EPS ---");
        int id = leerEntero("ID: ");
        if (arbol.buscar(id) != null) {
            System.out.println("Ya existe un paciente con el ID: " + id);
            return;
        }
        System.out.print("Nombre   : ");
        String nombre = sc.nextLine().trim();
        int edad = leerEntero("Edad     : ");
        System.out.print("Telefono : ");
        String telefono = sc.nextLine().trim();
        System.out.print("EPS      : ");
        String eps = sc.nextLine().trim();

        PacienteEPS paciente = new PacienteEPS(id, nombre, edad, telefono, eps);
        pacientesEPS.insertar(paciente);
        arbol.insertar(paciente);
        System.out.println("Paciente EPS registrado correctamente.");
    }

    static void registrarPacienteSISBEN(Lista pacientesSISBEN, Arbol arbol) {
        System.out.println("\n--- Registrar Paciente SISBEN ---");
        int id = leerEntero("ID: ");
        if (arbol.buscar(id) != null) {
            System.out.println("Ya existe un paciente con el ID: " + id);
            return;
        }
        System.out.print("Nombre: ");
        String nombre = sc.nextLine().trim();
        System.out.print("Apellido: ");
        String apellido = sc.nextLine().trim();
        int edad = leerEntero("Edad: ");
        System.out.print("Telefono: ");
        String telefono = sc.nextLine().trim();
        double puntaje = leerDouble("Puntaje SISBEN: ");

        PacienteSISBEN paciente = new PacienteSISBEN(id, nombre, apellido, edad, telefono, puntaje);
        pacientesSISBEN.insertar(paciente);
        arbol.insertar(paciente);
        System.out.println("Paciente SISBEN registrado correctamente.");
    }

    static void buscarPaciente(Arbol arbol) {
        System.out.println("\n--- Buscar Paciente por ID ---");
        int id = leerEntero("ID a buscar: ");
        Paciente p = arbol.buscar(id);
        if (p != null) {
            System.out.println("Paciente encontrado:");
            System.out.println("-------------------");
            p.mostrarInformacion();
            System.out.println("-------------------");
        } else {
            System.out.println("No se encontro ningun paciente con el ID: " + id);
        }
    }

    static void mostrarPacientesEPS(Lista pacientesEPS) {
        System.out.println("\n--- Pacientes EPS ---");
        if (pacientesEPS.estaVacia()) {
            System.out.println("No hay pacientes EPS registrados.");
            return;
        }
        Nodo actual = pacientesEPS.getCabeza();
        int i = 1;
        while (actual != null) {
            System.out.println("Paciente #" + i);
            ((Paciente) actual.getDato()).mostrarInformacion();
            System.out.println("-------------------");
            actual = actual.getSiguiente();
            i++;
        }
    }

    static void mostrarPacientesSISBEN(Lista pacientesSISBEN) {
        System.out.println("\n--- Pacientes SISBEN ---");
        if (pacientesSISBEN.estaVacia()) {
            System.out.println("No hay pacientes SISBEN registrados.");
            return;
        }
        Nodo actual = pacientesSISBEN.getCabeza();
        int i = 1;
        while (actual != null) {
            System.out.println("Paciente #" + i);
            ((Paciente) actual.getDato()).mostrarInformacion();
            System.out.println("-------------------");
            actual = actual.getSiguiente();
            i++;
        }
    }

    static void agendarCita(Cola colaCitas, Arbol arbol) {
        System.out.println("\n--- Agendar Cita Medica ---");
        int id = leerEntero("ID del paciente: ");
        Paciente p = arbol.buscar(id);
        if (p == null) {
            System.out.println("No existe ningun paciente con el ID: " + id);
            return;
        }
        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine().trim();
        Cita cita = new Cita(id, especialidad);
        colaCitas.encolar(cita);
        System.out.println("Cita agendada correctamente para: " + p.getNombre());
    }

    static void atenderCita(Cola colaCitas, Pila historial, Arbol arbol) {
        System.out.println("\n--- Atender Siguiente Cita ---");
        if (colaCitas.estaVacia()) {
            System.out.println("No hay citas pendientes en la cola.");
            return;
        }
        Cita cita = colaCitas.desencolar();
        Paciente p = arbol.buscar(cita.getIdPaciente());

        String nombre = (p != null) ? p.getNombre() : "Desconocido";
        String tipo;
        if (p instanceof PacienteEPS) {
            tipo = "EPS";
        } else if (p instanceof PacienteSISBEN) {
            tipo = "SISBEN";
        } else {
            tipo = "Desconocido";
        }

        Atencion atencion = new Atencion(cita.getIdPaciente(), nombre, cita.getEspecialidad(), tipo);
        historial.apilar(atencion);
        System.out.println("Cita atendida exitosamente.");
        System.out.println(atencion);
    }

    static void mostrarCitasPendientes(Cola colaCitas) {
        System.out.println("\n--- Citas Pendientes ---");
        if (colaCitas.estaVacia()) {
            System.out.println("No hay citas pendientes.");
            return;
        }
        colaCitas.mostrar();
    }

    static void verUltimaAtencion(Pila historial) {
        System.out.println("\n--- Ultima Atencion ---");
        if (historial.estaVacia()) {
            System.out.println("El historial esta vacio.");
            return;
        }
        System.out.println(historial.top());
    }

    static void verHistorialCompleto(Pila historial) {
        System.out.println("\n--- Historial Completo de Atenciones ---");
        if (historial.estaVacia()) {
            System.out.println("El historial esta vacio.");
            return;
        }
        historial.mostrar();
    }

    static void guardarEPS(Lista pacientesEPS) {
        if (pacientesEPS.estaVacia()) {
            System.out.println("No hay pacientes EPS para guardar.");
            return;
        }
        Archivo archivo = new Archivo("pacientes_eps.csv");
        archivo.guardarEPS(pacientesEPS.getCabeza());
    }

    static void guardarSISBEN(Lista pacientesSISBEN) {
        if (pacientesSISBEN.estaVacia()) {
            System.out.println("No hay pacientes SISBEN para guardar.");
            return;
        }
        Archivo archivo = new Archivo("pacientes_sisben.csv");
        archivo.guardarSISBEN(pacientesSISBEN.getCabeza());
    }

    // Lee un entero validando la entrada para evitar errores con Scanner
    static int leerEntero(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                continue;
            }
            try {
                return Integer.parseInt(linea);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Ingrese un numero entero.");
            }
        }
    }

    // Lee un double validando la entrada
    static double leerDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                continue;
            }
            try {
                return Double.parseDouble(linea);
            } catch (NumberFormatException e) {
                System.out.println("Entrada invalida. Ingrese un numero decimal.");
            }
        }
    }
}
