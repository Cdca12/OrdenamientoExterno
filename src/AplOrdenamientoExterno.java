
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Carlos Contreras
 */
public class AplOrdenamientoExterno {

    final static int VALOR_RENGLON = 30; // int + String + int = 4 + 20+2 + 4 = 30
    static int numeroRenglones;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File archivo1 = null;
        File archivo2 = null;
        RandomAccessFile archivoIntercambio = null;
        RandomAccessFile archivoQuicksort = null;

        int opcion = 0, opcion2 = 0, opcion3 = 0, numeroRegistros = 0;

        while (opcion != 4) {
            System.out.println("\nProyecto: Ordenamiento Externo"
                    + "\n\n1. Generar archivo"
                    + "\n2. Ordenar archivo"
                    + "\n3. Imprimir archivo"
                    + "\n4. Salir"
                    + "\n\nIngrese una opción del menú: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // 1. Generar archivo
                    System.out.println("\n¿Qué archivo desea generar?"
                            + "\n1. Archivo 1 (Intercambio)"
                            + "\n2. Archivo 2 (Quicksort)");
                    opcion2 = scanner.nextInt();
                    switch (opcion2) {
                        case 1: // 1. Archivo 1 (Intercambio)
                            try {
                                archivo1 = new File("./archivos/archivoIntercambio.txt"); // TODO: Cambiar a .dat
                                archivoIntercambio = new RandomAccessFile(archivo1, "rw");
                            } catch (FileNotFoundException e) {
                                System.out.println("El archivo " + archivo1.getName() + "  no se pudo abrir.");
                                return;
                            }
                            System.out.println("¿Cuántos registros desea generar?");
                            numeroRegistros = scanner.nextInt();
                            if (generarArchivo(archivoIntercambio, numeroRegistros)) {
                                System.out.println("¡El archivo de ha generado exitosamente!");
                            } else {
                                System.out.println("ERROR: Archivo no generado.");
                            }
                            break;
                        case 2: // 2. Archivo 2 (Quicksort)
                            try {
                                archivo2 = new File("./archivos/archivoQuicksort.txt"); // TODO: Cambiar a .dat
                                archivoQuicksort = new RandomAccessFile(archivo2, "rw");
                            } catch (FileNotFoundException e) {
                                System.out.println("El archivo " + archivo2.getName() + "  no se pudo abrir.");
                                return;
                            }
                            System.out.println("¿Cuántos registros desea generar?");
                            numeroRegistros = scanner.nextInt();
                            if (generarArchivo(archivoQuicksort, numeroRegistros)) {
                                System.out.println("¡El archivo de ha generado exitosamente!");
                            } else {
                                System.out.println("ERROR: Archivo no generado.");
                            }
                            break;
                        default:
                            System.out.println("\nFavor de ingresar una opción del menú.");
                            break;
                    }
                    break;
                case 2: // TODO: 2. Ordenar archivo
                    System.out.println("\n¿Qué archivo desea ordenar?"
                            + "\n1. Archivo 1 (Intercambio)"
                            + "\n2. Archivo 2 (Quicksort)");
                    opcion2 = scanner.nextInt();
                    switch (opcion2) {
                        case 1: // 1. Archivo 1 (Intercambio)

                            break;
                        case 2: // 2. Archivo 2 (Quicksort)

                            break;
                        default:
                            System.out.println("\nFavor de ingresar una opción del menú.");
                            break;
                    }
                    break;
                case 3: // TODO: 3. Imprimir archivo
                    System.out.println("\n¿Qué archivo desea imprimir?"
                            + "\n1. Archivo 1 (Intercambio)"
                            + "\n2. Archivo 2 (Quicksort)");
                    opcion2 = scanner.nextInt();
                    switch (opcion2) {
                        case 1: // 1. Archivo 1 (Intercambio)

                            break;
                        case 2: // 2. Archivo 2 (Quicksort)

                            break;
                        default:
                            System.out.println("\nFavor de ingresar una opción del menú.");
                            break;
                    }

                    break;
                case 4: // Salir
                    System.out.println("\nHa finalizado el programa correctamente.");
                    break;
                default:
                    System.out.println("\nFavor de ingresar una opción del menú.");
                    break;
            }
        }

        // Imprimimos archivos para comprobar datos
        System.out.println(archivo1.getName());
        imprimirArchivo(archivoIntercambio);
        System.out.println("\n" + archivo2.getName());
        imprimirArchivo(archivoQuicksort);

    }

    public static boolean generarArchivo(RandomAccessFile archivo, int numeroRegistros) {
        try {
            archivo.seek(0);
        } catch (IOException ex) {
            System.out.println("No se pudo posicionar al principio del archivo.");
            return false;
        }

        int idProducto;
        String nombreProducto;
        int existencia;

        for (int i = 0; i < numeroRegistros; i++) {
            idProducto = i + 1;
            nombreProducto = Rutinas.PonBlancos(Rutinas.nextProducto(), 20);
            existencia = Rutinas.nextInt(1, 100);
            try {
                archivo.writeInt(idProducto);
                archivo.writeUTF(nombreProducto);
                archivo.writeInt(existencia);
            } catch (IOException ex) {
                System.out.println("El archivo no se pudo generar.");
                return false;
            }
        }
        return true;
    }

    public static void imprimirArchivo(RandomAccessFile archivo) {
        int idProducto;
        String nombreProducto;
        int existencia;

        try {
            archivo.seek(0);
            numeroRenglones = (int) archivo.length() / VALOR_RENGLON;
        } catch (IOException ex) {
            System.out.println("No se pudo posicionar al principio del archivo.");
            return;
        }
        System.out.println("idProducto\tnombreProducto\t\t\texistencia");
        // Empezar a imprimir
        for (int i = 0; i < numeroRenglones; i++) {
            try {
                idProducto = archivo.readInt();
                nombreProducto = archivo.readUTF();
                existencia = archivo.readInt();
            } catch (IOException e) {
                System.out.println("No se pudo leer el archivo.");
                return;
            }
            System.out.println(new Producto(idProducto, nombreProducto, existencia).mostrarInformacion());
        }

    }

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
}
