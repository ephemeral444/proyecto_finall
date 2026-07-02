package Paquete;

public class Cola {

    private Lista data;

    public Cola() {
        data = new Lista();
    }

    public void encolar(Cita cita) {
        data.insertar(cita);
    }

    public Cita desencolar() {
        if (estaVacia()) {
            return null;
        }
        return (Cita) data.eliminarPrimero();
    }

    public Cita top() {
        if (estaVacia()) {
            return null;
        }
        return (Cita) data.primero().getDato();
    }

    public void mostrar() {
        Nodo actual = data.getCabeza();
        int i = 1;
        while (actual != null) {
            Cita cita = (Cita) actual.getDato();
            System.out.println(i + ". " + cita);
            actual = actual.getSiguiente();
            i++;
        }
    }

    public boolean estaVacia() {
        return data.estaVacia();
    }
}
