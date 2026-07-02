package Paquete;

public class Pila {

    private Lista data;

    public Pila() {
        data = new Lista();
    }

    public void apilar(Object e) {
        data.insertarAlInicio(e);
    }

    public Object desapilar() {
        if (estaVacia()) {
            return null;
        }
        return data.eliminarPrimero();
    }

    public Object top() {
        if (estaVacia()) {
            return null;
        }
        return data.primero().getDato();
    }

    public void mostrar() {
        Nodo actual = data.getCabeza();
        int i = 1;
        while (actual != null) {
            System.out.println(i + ". " + actual.getDato());
            actual = actual.getSiguiente();
            i++;
        }
    }

    public boolean estaVacia() {
        return data.estaVacia();
    }
}
