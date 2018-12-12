
/**
 *
 * @author Carlos Contreras
 */
public class Ordenamiento {

    public static void Intercambio(int[] V) {
        int aux;
        for (int i = 0; i < V.length - 1; i++) {
            for (int j = i + 1; j < V.length; j++) {
                if (V[i] > V[j]) {
                    aux = V[i];
                    V[i] = V[j];
                    V[j] = aux;
                }
            }
        }
    }
    
    public static void Burbuja(int[] V) {
        int superior = V.length, aux, i;
        boolean bandera = true;
        while (bandera) {
            bandera = false;
            superior--;
            for (i = 0; i < superior; i++) {
                if (V[i] > V[i + 1]) {
                    aux = V[i];
                    V[i] = V[i + 1];
                    V[i + 1] = aux;
                    bandera = true;
                }
            }
        }
    }

    public static void Insercion(int[] V) {
        int i, j, aux;
        for (i = 1; i < V.length; i++) { // Inicia considerando el elemento 0 ordenado
            j = i; // Para explorar los elementos V[j-1]... V[0] buscando la posición correcta del dato V[i]
            aux = V[i];
            while (j > 0 && aux < V[j - 1]) {
                // Deplaza el elemento hacia arriba una posición
                V[j] = V[j - 1];
                j--;
            }
            V[j] = aux;
        }
    }

    public static void Quicksort(int V[], int izq, int der) {

        int pivote = V[izq]; // Tomamos primer elemento como pivote
        int i = izq; // i realiza la búsqueda de izquierda a derecha
        int j = der; // j realiza la búsqueda de derecha a izquierda
        int aux;

        while (i < j) { // Mientras no se crucen las búsquedas
            while (V[i] <= pivote && i < j) { // Busca elemento mayor que pivote
                i++; 
            }
            while (V[j] > pivote) { // Busca elemento menor que pivote
                j--;         
            }
            if (i < j) { // Si no se han cruzado                      
                aux = V[i]; // Los intercambia
                V[i] = V[j];
                V[j] = aux;
            }
        }
        // Se coloca el pivote en su lugar de forma que tendremos los menores a su izquierda y los mayores a su derecha
        V[izq] = V[j]; 
        V[j] = pivote;
        if (izq < j - 1) {
            Quicksort(V, izq, j - 1); // Ordenamos subarray izquierdo
        }
        if (j + 1 < der) {
            Quicksort(V, j + 1, der); // Ordenamos subarray derecho
        }
    }

}
