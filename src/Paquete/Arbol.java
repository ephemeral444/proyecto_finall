package Paquete;

public class Arbol {

    private NodoArbol raiz;

    public Arbol() {
        raiz = null;
    }

    public boolean estaVacio() {
        return raiz == null;
    }

    public void insertar(Paciente paciente) {
        raiz = insertar(paciente, raiz);
    }

    private NodoArbol insertar(Paciente paciente, NodoArbol nodoPtr) {
        if (nodoPtr == null) {
            return new NodoArbol(paciente);
        }

        int idNuevo = paciente.getId();
        int idActual = ((Paciente) nodoPtr.getDato()).getId();

        if (idNuevo < idActual) {
            nodoPtr.setIzquierdo(insertar(paciente, nodoPtr.getIzquierdo()));
        } else if (idNuevo > idActual) {
            nodoPtr.setDerecho(insertar(paciente, nodoPtr.getDerecho()));
        } else {
            System.out.println("Ya existe un paciente con el ID: " + idNuevo);
        }

        return nodoPtr;
    }

    public Paciente buscar(int id) {
        return buscar(id, raiz);
    }

    private Paciente buscar(int id, NodoArbol nodoPtr) {
        if (nodoPtr == null) {
            return null;
        }

        int idActual = ((Paciente) nodoPtr.getDato()).getId();

        if (id == idActual) {
            return (Paciente) nodoPtr.getDato();
        } else if (id < idActual) {
            return buscar(id, nodoPtr.getIzquierdo());
        } else {
            return buscar(id, nodoPtr.getDerecho());
        }
    }

    // Recorre el arbol en InOrden: izquierda - raiz - derecha
    public void inOrden() {
        inOrden(raiz);
    }

    private void inOrden(NodoArbol nodoPtr) {
        if (nodoPtr == null) {
            return;
        }
        inOrden(nodoPtr.getIzquierdo());
        ((Paciente) nodoPtr.getDato()).mostrarInformacion();
        System.out.println("-------------------");
        inOrden(nodoPtr.getDerecho());
    }

    // Muestra el arbol de forma grafica (acostado)
    public void mostrarAcostado() {
        mostrarAcostado(0, raiz);
    }

    private void mostrarAcostado(int nivel, NodoArbol nodoPtr) {
        if (nodoPtr == null) {
            return;
        }
        mostrarAcostado(nivel + 1, nodoPtr.getDerecho());
        for (int i = 0; i < nivel; i++) {
            System.out.print("    ");
        }
        Paciente p = (Paciente) nodoPtr.getDato();
        System.out.println("[" + p.getId() + "] " + p.getNombre());
        mostrarAcostado(nivel + 1, nodoPtr.getIzquierdo());
    }
}
