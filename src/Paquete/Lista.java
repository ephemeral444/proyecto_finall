package Paquete;

public class Lista {

    private Nodo head;
    private Nodo tail;
    private int size;

    public Lista() {
        head = null;
        tail = null;
        size = 0;
    }

    // Inserta al final (usado por Cola y lista de pacientes)
    public void insertar(Object dato) {
        Nodo nuevo = new Nodo(dato);
        if (head == null) {
            head = nuevo;
            tail = nuevo;
        } else {
            tail.setSiguiente(nuevo);
            tail = nuevo;
        }
        size++;
    }

    // Inserta al inicio (usado por Pila)
    public void insertarAlInicio(Object dato) {
        Nodo nuevo = new Nodo(dato);
        nuevo.setSiguiente(head);
        head = nuevo;
        if (tail == null) {
            tail = nuevo;
        }
        size++;
    }

    // Elimina y retorna el primero (usado por Cola y Pila)
    public Object eliminarPrimero() {
        if (estaVacia()) {
            return null;
        }
        Object dato = head.getDato();
        head = head.getSiguiente();
        if (head == null) {
            tail = null;
        }
        size--;
        return dato;
    }

    public Nodo primero() {
        return head;
    }

    public Nodo ultimo() {
        return tail;
    }

    public Nodo getCabeza() {
        return head;
    }

    public boolean estaVacia() {
        return head == null;
    }

    public int size() {
        return size;
    }

    public void mostrar() {
        Nodo actual = head;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }
}
