package ecci.dal;

import ecci.entidades.Etiqueta;
import ecci.database.ConexionMySQL;
import ecci.entidades.Necesidad;
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

    /**
     * Asocia un necesidad a una etiqueta en la base de datos
     *
     * @param necesidad Necesidad que se desea asociar a la etiqueta
     * @throws SQLException
     */
    public void insertarNecesidadEnEtiqueta(Necesidad necesidad) throws SQLException {
        if (etiqueta != null) {
            this.conexion.insert(
                    "INSERT INTO etiquetanecesidad "
                    + "(idnecesidad, idetiqueta) "
                    + "VALUES "
                    + "(" + necesidad.getId() + ", " + this.etiqueta.getId() + ")");
        }
    }

    /**
     * Desvincula una necesidad de una etiqueta en la base de datos
     *
     * @param necesidad Necesidad que se desea desvincular de la etiqueta
     * @throws SQLException
     */
    public void eliminarNecesidadEnEtiqueta(Necesidad necesidad) throws SQLException {
        if (etiqueta != null) {
            this.conexion.delete(
                    "DELETE FROM etiquetanecesidad "
                    + "WHERE idnecesidad = " + necesidad.getId()
                    + " AND idetiqueta = " + this.etiqueta.getId());
        }
    }

    /**
     * Trae las necesidades que actualmente están asociadas a la etiqueta
     *
     * @return Necesidades que actualmente están asociadas a la etiqueta
     * @throws java.sql.SQLException
     */
    public ArrayList<Necesidad> listarNecesidadesActuales() throws SQLException {
        ArrayList<Necesidad> necesidades = new ArrayList<>();
        if (etiqueta != null) {
            ArrayList<HashMap<String, String>> table = this.conexion.select(
                    "SELECT idnecesidad, codigo, descripcion "
                    + "FROM vw_etiquetanecesidad "
                    + "WHERE idetiqueta = " + this.etiqueta.getId());
            for (HashMap<String, String> row : table) {
                Necesidad n = new Necesidad(Integer.parseInt(row.get("idnecesidad")));
                n.setCodigo(row.get("codigo"));
                n.setDescripcion(row.get("descripcion"));
                necesidades.add(n);
            }
        }
        return necesidades;
    }

    /**
     * Trae las necesidades que actualmente no están asociadas a la etiqueta
     *
     * @return Necesidades que actualmente no están asociadas a la etiqueta
     * @throws java.sql.SQLException
     */
    public ArrayList<Necesidad> listarNecesidadesExcluidas() throws SQLException {
        ArrayList<Necesidad> necesidades = new ArrayList<>();
        if (etiqueta != null) {
            ArrayList<HashMap<String, String>> table = this.conexion.select(
                    "SELECT idnecesidad, codigo, descripcion "
                    + "FROM necesidad "
                    + "WHERE idnecesidad NOT IN ("
                    + "SELECT idnecesidad "
                    + "FROM etiquetanecesidad "
                    + "WHERE idetiqueta = " + this.etiqueta.getId()
                    + ")");
            for (HashMap<String, String> row : table) {
                Necesidad n = new Necesidad(Integer.parseInt(row.get("idnecesidad")));
                n.setCodigo(row.get("codigo"));
                n.setDescripcion(row.get("descripcion"));
                necesidades.add(n);
            }
        }
        return necesidades;
    }
    //</editor-fold>
}
