package ordenamientoexterno;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @titulo Ordenamiento Externo
 * @materia Estructura de Datos
 * @author Carlos Contreras
 * @facilitador Dr. Clemente García Gerardo
 */
public class AplOrdenamientoExterno {

    final static int VALOR_RENGLON = 40; // int + String + int = 4 + 30+2 + 4 = 40

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        File archivo1 = null;
        File archivo2 = null;
        File archivo3 = null;
        RandomAccessFile archivoIntercambio = null;
        RandomAccessFile archivoQuicksort = null;
        RandomAccessFile archivoBurbuja = null;

        int opcion = 0, opcion2 = 0, opcion3 = 0, numeroRegistros = 0;

        try {
            archivo1 = new File("./archivos/archivoIntercambio.dat");
            archivoIntercambio = new RandomAccessFile(archivo1, "rw");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo " + archivo1.getName() + "  no se pudo abrir.");
            return;
        }
        try {
            archivo2 = new File("./archivos/archivoQuicksort.dat");
            archivoQuicksort = new RandomAccessFile(archivo2, "rw");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo " + archivo2.getName() + "  no se pudo abrir.");
            return;
        }
        try {
            archivo3 = new File("./archivos/archivoBurbuja.dat");
            archivoBurbuja = new RandomAccessFile(archivo3, "rw");
        } catch (FileNotFoundException e) {
            System.out.println("El archivo " + archivo3.getName() + "  no se pudo abrir.");
            return;
        }

        while (opcion != 5) {
            System.out.println("\nProyecto: Ordenamiento Externo"
                    + "\n\n1. Generar archivo"
                    + "\n2. Ordenar archivo"
                    + "\n3. Imprimir archivo"
                    + "\n4. Limpiar registros"
                    + "\n5. Salir"
                    + "\n\nIngrese una opción del menú: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // 1. Generar archivo
                    System.out.println("\n¿Qué archivo desea generar?"
                            + "\n1. Archivo 1 (Intercambio)"
                            + "\n2. Archivo 2 (Quicksort)"
                            + "\n3. Archivo 3 (Burbuja)");
                    opcion2 = scanner.nextInt();

                    switch (opcion2) {
                        case 1: // 1. Archivo 1 (Intercambio)
                            System.out.println("¿Cuántos registros desea generar?");
                            numeroRegistros = scanner.nextInt();
                            if (generarArchivo(archivoIntercambio, numeroRegistros)) {
                                System.out.println("\n¡El archivo de ha generado exitosamente!");
                            } else {
                                System.out.println("ERROR: Archivo no generado.");
                            }
                            break;
                        case 2: // 2. Archivo 2 (Quicksort)
                            System.out.println("¿Cuántos registros desea generar?");
                            numeroRegistros = scanner.nextInt();
                            if (generarArchivo(archivoQuicksort, numeroRegistros)) {
                                System.out.println("\n¡El archivo de ha generado exitosamente!");
                            } else {
                                System.out.println("ERROR: Archivo no generado.");
                            }
                            break;
                        case 3: // 3. Archivo 3 (Burbuja)
                            System.out.println("¿Cuántos registros desea generar?");
                            numeroRegistros = scanner.nextInt();
                            if (generarArchivo(archivoBurbuja, numeroRegistros)) {
                                System.out.println("\n¡El archivo se ha generado exitosamente!");
                            } else {
                                System.out.println("ERROR: Archivo no generado.");
                            }
                            break;
                        default:
                            System.out.println("\nFavor de ingresar una opción del menú.");
                            break;
                    }
                    break;
                case 2: // 2. Ordenar archivo
                    System.out.println("\n¿Qué archivo desea ordenar?"
                            + "\n1. Archivo 1 (Intercambio)"
                            + "\n2. Archivo 2 (Quicksort)"
                            + "\n3. Archivo 3 (Burbuja)");
                    opcion2 = scanner.nextInt();
                    System.out.println();
                    switch (opcion2) {
                        case 1: // 1. Archivo 1 (Intercambio)
                            if (lengthArchivo(archivoIntercambio) == 0) {
                                System.out.println("El archivo se encuentra vacío. Primero genere registros e intentelo de nuevo.");
                                break;
                            }
                            ordenamientoIntercambio(archivoIntercambio);
                            System.out.println("¡El archivo ha sido ordenado por el método de Intercambio exitosamente!");
                            break;
                        case 2: // 2. Archivo 2 (Quicksort)
                            if (lengthArchivo(archivoQuicksort) == 0) {
                                System.out.println("El archivo se encuentra vacío. Primero genere registros e intentelo de nuevo.");
                                break;
                            }
                            ordenamientoQuicksort(archivoQuicksort, 0, lengthArchivo(archivoQuicksort) - 1);
                            System.out.println("¡El archivo ha sido ordenado por el método de Quicksort exitosamente!");
                            break;
                        case 3: // 3. Archivo 3 (Burbuja)
                            if (lengthArchivo(archivoBurbuja) == 0) {
                                System.out.println("El archivo se encuentra vacío. Primero genere registros e intentelo de nuevo.");
                                break;
                            }
                            ordenamientoBurbuja(archivoBurbuja);
                            System.out.println("¡El archivo ha sido ordenado por el método de Burbuja exitosamente!");
                            break;
                        default:
                            System.out.println("\nFavor de ingresar una opción del menú.");
                            break;
                    }
                    break;
                case 3: // 3. Imprimir archivo
                    System.out.println("\n¿Qué archivo desea imprimir?"
                            + "\n1. Archivo 1 (Intercambio)"
                            + "\n2. Archivo 2 (Quicksort)"
                            + "\n3. Archivo 3 (Burbuja)");
                    opcion2 = scanner.nextInt();
                    System.out.println();
                    switch (opcion2) {
                        case 1: // 1. Archivo 1 (Intercambio)
                            if (lengthArchivo(archivoIntercambio) == 0) {
                                System.out.println("El archivo está vacío. No contiene ningún registro.");
                                break;
                            }
                            imprimirArchivo(archivoIntercambio);
                            break;
                        case 2: // 2. Archivo 2 (Quicksort)
                            if (lengthArchivo(archivoQuicksort) == 0) {
                                System.out.println("El archivo está vacío. No contiene ningún registro.");
                                break;
                            }
                            imprimirArchivo(archivoQuicksort);
                            break;
                        case 3: // 3. Archivo 3 (Burbuja)
                            if (lengthArchivo(archivoBurbuja) == 0) {
                                System.out.println("El archivo está vacío. No contiene ningún registro.");
                                break;
                            }
                            imprimirArchivo(archivoBurbuja);
                            break;
                        default:
                            System.out.println("\nFavor de ingresar una opción del menú.");
                            break;
                    }
                    break;
                case 4: // 4. Limpiar registros
                    System.out.println("\n¿Qué archivo desea limpiar?"
                            + "\n1. Archivo 1 (Intercambio)"
                            + "\n2. Archivo 2 (Quicksort)"
                            + "\n3. Archivo 3 (Burbuja)");
                    opcion2 = scanner.nextInt();
                    System.out.println();
                    switch (opcion2) {
                        case 1: // 1. Archivo 1 (Intercambio)
                            archivoIntercambio.setLength(0);
                            System.out.println("Se han limpiado los registros del archivo " + archivo1.getName() + " correctamente.");
                            break;
                        case 2: // 2. Archivo 2 (Quicksort)
                            archivoQuicksort.setLength(0);
                            System.out.println("Se han limpiado los registros del archivo " + archivo2.getName() + " correctamente.");
                            break;
                        case 3: // 3. Archivo 3 (Burbuja)
                            archivoBurbuja.setLength(0);
                            System.out.println("Se han limpiado los registros del archivo " + archivo3.getName() + " correctamente.");
                            break;
                        default:
                            System.out.println("\nFavor de ingresar una opción del menú.");
                            break;
                    }
                    break;
                case 5: // 5. Salir
                    System.out.println("\nHa finalizado el programa correctamente.");
                    break;
                default:
                    System.out.println("\nFavor de ingresar una opción del menú.");
                    break;
            }
        }
    }

    public static int lengthArchivo(RandomAccessFile archivo) throws IOException {
        return (int) archivo.length() / VALOR_RENGLON;
    }

    public static boolean generarArchivo(RandomAccessFile archivo, int numeroRegistros) {
        int idProducto;
        String nombreProducto;
        int existencia;
        try {
            archivo.seek(0);
            for (int i = 0; i < numeroRegistros; i++) {
                idProducto = i + 1;
                nombreProducto = Rutinas.PonBlancos(Rutinas.nextProducto(), 30);
                existencia = Rutinas.nextInt(1, 99);

                archivo.writeInt(idProducto);
                archivo.writeUTF(nombreProducto);
                archivo.writeInt(existencia);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static void imprimirArchivo(RandomAccessFile archivo) throws IOException {
        int idProducto;
        String nombreProducto;
        int existencia;
        try {
            archivo.seek(0);
            System.out.println("idProducto\tnombreProducto\t\t\texistencia");
            // Empezar a imprimir
            for (int i = 0; i < lengthArchivo(archivo); i++) {
                idProducto = archivo.readInt();
                nombreProducto = archivo.readUTF();
                existencia = archivo.readInt();
                System.out.println(new Producto(idProducto, nombreProducto, existencia).mostrarInformacion());
                // Crea un objeto para acceder al método de mostrar información formateada. No importa conservarlo.
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("No se pudo posicionar al principio del archivo.");
            return;
        }
    }

    public static void ordenamientoIntercambio(RandomAccessFile archivo) throws IOException {
        Producto productoI, productoJ;
        try {
            archivo.seek(0);
            for (int i = 0; i < lengthArchivo(archivo); i++) {
                for (int j = i + 1; j < lengthArchivo(archivo); j++) {
                    archivo.seek(i * VALOR_RENGLON); // Me posiciono en el i
                    productoI = new Producto(archivo.readInt(), archivo.readUTF(), archivo.readInt());
                    archivo.seek(j * VALOR_RENGLON); // Me posiciono en el j
                    productoJ = new Producto(archivo.readInt(), archivo.readUTF(), archivo.readInt());

                    if (productoI.toString().compareTo(productoJ.toString()) > 0) {
                        // Inserto j en i
                        // Me posiciono en i
                        archivo.seek(i * VALOR_RENGLON);
                        archivo.writeInt(productoJ.idProducto);
                        archivo.writeUTF(productoJ.nombreProducto);
                        archivo.writeInt(productoJ.existencia);

                        // Inserto i en j
                        // Me posiciono en j
                        archivo.seek(j * VALOR_RENGLON);
                        archivo.writeInt(productoI.idProducto);
                        archivo.writeUTF(productoI.nombreProducto);
                        archivo.writeInt(productoI.existencia);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error castroso");
            return;
        }

    }

    public static void ordenamientoQuicksort(RandomAccessFile archivo, int izq, int der) {
        int i = izq, j = der;
        Producto productoPivote, productoIzq, productoDer;
        try {
            // Guardamos pivote
            archivo.seek(((izq + der) / 2) * VALOR_RENGLON);
            productoPivote = new Producto(archivo.readInt(), archivo.readUTF(), archivo.readInt());

            do {
                // Accedemos al elemento de la posición i
                archivo.seek(i * VALOR_RENGLON);
                productoIzq = new Producto(archivo.readInt(), archivo.readUTF(), archivo.readInt());
                while ((productoIzq.toString().compareTo(productoPivote.toString()) < 0) && (i < der)) {
                    i++;
                    archivo.seek(i * VALOR_RENGLON);
                    productoIzq = new Producto(archivo.readInt(), archivo.readUTF(), archivo.readInt());
                }

                // Accedemos al elemento de la posición j
                archivo.seek(j * VALOR_RENGLON);
                productoDer = new Producto(archivo.readInt(), archivo.readUTF(), archivo.readInt());
                while ((productoDer.toString().compareTo(productoPivote.toString()) > 0) && (j > izq)) {
                    j--;
                    archivo.seek(j * VALOR_RENGLON);
                    productoDer = new Producto(archivo.readInt(), archivo.readUTF(), archivo.readInt());
                }

                if (i <= j) {
                    // Guardamos j en i
                    archivo.seek(i * VALOR_RENGLON);
                    archivo.writeInt(productoDer.idProducto);
                    archivo.writeUTF(productoDer.nombreProducto);
                    archivo.writeInt(productoDer.existencia);

                    // Guardamos i en j
                    archivo.seek(j * VALOR_RENGLON);
                    archivo.writeInt(productoIzq.idProducto);
                    archivo.writeUTF(productoIzq.nombreProducto);
                    archivo.writeInt(productoIzq.existencia);

                    i++;
                    j--;
                }
            } while (i <= j);

            if (izq < j) {
                ordenamientoQuicksort(archivo, izq, j);
            }
            if (der > i) {
                ordenamientoQuicksort(archivo, i, der);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }

    public static void ordenamientoBurbuja(RandomAccessFile archivo) {
        Producto productoI, productoJ;
        try {
            int i;
            int superior = lengthArchivo(archivo);
            boolean bandera = true;
            while (bandera) {
                bandera = false;
                superior--;
                for (i = 0; i < superior; i++) {
                    archivo.seek(i * VALOR_RENGLON);
                    productoI = new Producto(archivo.readInt(), archivo.readUTF(), archivo.readInt());
                    // Como aplicar i+1, ya que como leí se quedo apuntando al inicio del siguiente
                    productoJ = new Producto(archivo.readInt(), archivo.readUTF(), archivo.readInt());
                    if (productoI.toString().compareTo(productoJ.toString()) > 0) {
                        // Me posiciono en i
                        archivo.seek(i * VALOR_RENGLON);
                        archivo.writeInt(productoJ.idProducto);
                        archivo.writeUTF((productoJ.nombreProducto));
                        archivo.writeInt(productoJ.existencia);

                        // Ya escribió en todo i, entonces este apuntador será la siguiente línea (i+1)
                        archivo.writeInt(productoI.idProducto);
                        archivo.writeUTF(productoI.nombreProducto);
                        archivo.writeInt(productoI.existencia);

                        bandera = true;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

    }
}
