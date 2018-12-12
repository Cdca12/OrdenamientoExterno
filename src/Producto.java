
/**
 *
 * @author Carlos Contreras
 */
public class Producto {

    public int idProducto;
    public String nombreProducto;
    public int existencia;

    public Producto(int idProducto, String nombreProducto, int existencia) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.existencia = existencia;
    }
    
//    public String toString() {
//        return Rutinas.PonBlancos(nombreProducto, 20); // Longitud fija, 20.
//    }
    
    // nombreProducto para ordenarlo por nombre primero
    public String toString() {
        return Rutinas.PonBlancos(nombreProducto, 20) + Rutinas.PonCeros(idProducto, 10) + Rutinas.PonCeros(existencia, 10); 
        // Longitud fija, 20.
    }
    
    
    public String mostrarInformacion() {
        return idProducto + "\t\t" + nombreProducto + "\t\t" + existencia;
    }

}
