
import java.util.*;

public class Rutinas {

    final static String[] PRODUCTOS = {
    "Ajo", "Brocoli", "Cebolla", "Lechuga", "Papas", "Pepino", "Tomate", "Arroz", "Azúcar",
    "Cereal", "Galletas", "Gelatina", "Pan", "Nueces", "Ketchup", "Miel", "Agua", "Café",
    "Cerveza", "Shampoo", "Desodorante", "Manzana", "Pera", "Leche", "Huevos", "Yogurth", "Pescado",
    "Atún", "Papel", "Mayonesa" };

    public static String nextProducto() {
        return PRODUCTOS[nextInt(PRODUCTOS.length)];
    }

    static public int nextInt(int Valor) {
        return new Random().nextInt(Valor);
    }

    static public int nextInt(int LimI, int LimS) {
        return new Random().nextInt(LimS - LimI + 1) + LimI;
    }

    static public String PonBlancos(String Texto, int Tamaño) {
        while (Texto.length() < Tamaño) {
            Texto += " ";
        }
        return Texto;
    }

    static public String PonCeros(int Numero, int Tamaño) {
        String Texto = Numero + "";

        while (Texto.length() < Tamaño) {
            Texto = "0" + Texto;
        }
        return Texto;

    }
}
