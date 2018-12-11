
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Carlos Contreras
 */
public class AplOrdenamientoExterno {

    static File archivo;
    static RandomAccessFile Arch;
    static int Reg;
    final static String[] PRODUCTOS = {"Agua", "Manzana", "Zucaritas"};

    public static void main(String[] args) throws IOException {
        archivo = new File("./archivos/archivo.dat");
        Arch = new RandomAccessFile(archivo, "rw");
        Reg = (int) Arch.length() / 42;

        // Generar datos aleatorios y escribirlos en el archivo
        int IdProducto, Existencia;
        String NombreProducto;
        for (int i = 0; i < 10; i++) {
            IdProducto = Rutinas.nextInt(50);
            NombreProducto = Rutinas.PonBlancos(PRODUCTOS[Rutinas.nextInt(0, PRODUCTOS.length - 1)], 10);
            Existencia = Rutinas.nextInt(100);
            Arch.writeInt(IdProducto);
            Arch.writeUTF(NombreProducto);
            Arch.writeInt(Existencia);
        }
        

    }
}
