package ecci.dal;

import ecci.entidades.Etiqueta;
import ecci.database.ConexionMySQL;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author
 */
public class EtiquetaDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Etiqueta que se desea persistir en base de datos
     */
    private Etiqueta etiqueta;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de las
     * etiquetas
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public EtiquetaDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae la etiqueta que actualmente se está persistiendo
     *
     * @return Etiqueta que actualmente se está persistiendo
     */
    public Etiqueta getEtiqueta() {
        return this.etiqueta;
    }

    /**
     * Cambia la etiqueta que actualmente se está persistiendo
     *
     * @param etiqueta Nueva etiqueta que actualmente se está persistiendo
     */
    public void setEtiqueta(Etiqueta etiqueta) {
        this.etiqueta = etiqueta;
    }

    /**
     * Trae el listado de etiquetas desde la base de datos
     *
     * @return Listado de etiquetas desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Etiqueta> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idetiqueta, nombre "
                + "FROM etiqueta");
        ArrayList<Etiqueta> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Etiqueta e = new Etiqueta(Integer.parseInt(row.get("idetiqueta")));
            e.setNombre(row.get("nombre"));
            lista.add(e);
        }
        return lista;
    }

    /**
     * Inserta una nueva etiqueta en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        if (etiqueta != null) {
            this.etiqueta.setId(this.conexion.insert(
                    "INSERT INTO etiqueta "
                    + "(nombre) "
                    + "VALUES "
                    + "('" + this.etiqueta.getNombre() + "')"));
        }
    }

    /**
     * Carga una etiqueta desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idetiqueta, nombre "
                + "FROM etiqueta "
                + "WHERE idetiqueta = " + this.etiqueta.getId());
        for (HashMap<String, String> row : table) {
            Etiqueta e = new Etiqueta(Integer.parseInt(row.get("idetiqueta")));
            e.setNombre(row.get("nombre"));
            this.etiqueta = e;
        }
    }

    /**
     * Actualiza una etiqueta en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        if (etiqueta != null) {
            this.conexion.update(
                    "UPDATE etiqueta SET "
                    + "nombre = '" + this.etiqueta.getNombre() + "' "
                    + " WHERE idetiqueta = " + this.etiqueta.getId());
        }
    }

    /**
     * Elimina una etiqueta en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (etiqueta != null) {
            this.conexion.update(
                    "DELETE FROM etiqueta "
                    + "WHERE idetiqueta = " + this.etiqueta.getId());
        }
    }
    //</editor-fold>
}
