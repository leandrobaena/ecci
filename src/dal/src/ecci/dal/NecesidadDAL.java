package ecci.dal;

import ecci.entidades.Necesidad;
import ecci.database.ConexionMySQL;
import ecci.entidades.Etiqueta;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author
 */
public class NecesidadDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Necesidad que se desea persistir en base de datos
     */
    private Necesidad necesidad;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de las
     * necesidades
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public NecesidadDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae la necesidad que actualmente se está persistiendo
     *
     * @return Necesidad que actualmente se está persistiendo
     */
    public Necesidad getNecesidad() {
        return this.necesidad;
    }

    /**
     * Cambia la necesidad que actualmente se está persistiendo
     *
     * @param necesidad Nueva necesidad que actualmente se está persistiendo
     */
    public void setNecesidad(Necesidad necesidad) {
        this.necesidad = necesidad;
    }

    /**
     * Trae el listado de necesidades desde la base de datos
     *
     * @param padre Identificador de la necesidad padre de la que se trae las
     * neceidades hijas, si es 0 se bucan las necesidades sin padre
     * @return Listado de necesidades desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Necesidad> listar(int padre) throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idnecesidad, codigo, descripcion "
                + "FROM necesidad "
                + "WHERE idnecesidadpadre " + (padre == 0 ? "IS NULL" : "= " + padre));
        ArrayList<Necesidad> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Necesidad n = new Necesidad(Integer.parseInt(row.get("idnecesidad")));
            n.setCodigo(row.get("codigo"));
            n.setDescripcion(row.get("descripcion"));
            lista.add(n);
        }
        return lista;
    }

    /**
     * Inserta una nueva necesidad en la base de datos
     *
     * @param padre Identificador de la necesidad padre de la que se trae las
     * @throws SQLException
     */
    public void insertar(int padre) throws SQLException {
        if (necesidad != null) {
            this.necesidad.setId(this.conexion.insert(
                    "INSERT INTO necesidad "
                    + "(codigo, descripcion, idnecesidadpadre) "
                    + "VALUES "
                    + "('" + this.necesidad.getCodigo() + "', "
                    + "'" + this.necesidad.getDescripcion() + "', "
                    + (padre == 0 ? "NULL" : padre)
                    + ")"));
        }
    }

    /**
     * Carga una necesidad desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idnecesidad, codigo, descripcion "
                + "FROM descripcion "
                + "WHERE idnecesidad = " + this.necesidad.getId());
        for (HashMap<String, String> row : table) {
            Necesidad n = new Necesidad(Integer.parseInt(row.get("idnecesidad")));
            n.setCodigo(row.get("codigo"));
            n.setDescripcion(row.get("descripcion"));
            this.necesidad = n;
        }
    }

    /**
     * Actualiza una necesidad en la base de datos
     *
     * @param padre Identificador de la necesidad padre de la que se trae las
     * @throws SQLException
     */
    public void actualizar(int padre) throws SQLException {
        if (necesidad != null) {
            this.conexion.update(
                    "UPDATE necesidad SET "
                    + "codigo = '" + this.necesidad.getCodigo() + "', "
                    + "descripcion = '" + this.necesidad.getDescripcion() + "', "
                    + "idnecesidadpadre = " + (padre == 0 ? "NULL" : padre)
                    + " WHERE idnecesidad = " + this.necesidad.getId());
        }
    }

    /**
     * Elimina una necesidad en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (necesidad != null) {
            this.conexion.update(
                    "DELETE FROM necesidad "
                    + "WHERE idnecesidad = " + this.necesidad.getId());
        }
    }

    /**
     * Asocia un etiqueta a una necesidad en la base de datos
     *
     * @param etiqueta Etiqueta que se desea asociar a la necesidad
     * @throws SQLException
     */
    public void insertarEtiquetaEnNecesidad(Etiqueta etiqueta) throws SQLException {
        if (necesidad != null) {
            this.conexion.insert(
                    "INSERT INTO etiquetanecesidad "
                    + "(idnecesidad, idetiqueta) "
                    + "VALUES "
                    + "(" + this.necesidad.getId() + ", " + etiqueta.getId() + ")");
        }
    }

    /**
     * Desvincula una etiqueta de una necesidad en la base de datos
     *
     * @param etiqueta Etiqueta que se desea desvincular de la necesidad
     * @throws SQLException
     */
    public void eliminarEtiquetaEnNecesidad(Etiqueta etiqueta) throws SQLException {
        if (necesidad != null) {
            this.conexion.delete(
                    "DELETE FROM etiquetanecesidad "
                    + "WHERE idetiqueta = " + etiqueta.getId()
                    + " AND idnecesidad = " + this.necesidad.getId());
        }
    }

    /**
     * Trae las etiquetas que actualmente están asociadas a la necesidad
     *
     * @return Etiquetas que actualmente están asociadas a la necesidad
     * @throws java.sql.SQLException
     */
    public ArrayList<Etiqueta> listarEtiquetasActuales() throws SQLException {
        ArrayList<Etiqueta> etiquetas = new ArrayList<>();
        if (necesidad != null) {
            ArrayList<HashMap<String, String>> table = this.conexion.select(
                    "SELECT idetiqueta, nombre "
                    + "FROM vw_etiquetanecesidad "
                    + "WHERE idnecesidad = " + this.necesidad.getId());
            for (HashMap<String, String> row : table) {
                Etiqueta e = new Etiqueta(Integer.parseInt(row.get("idetiqueta")));
                e.setNombre(row.get("nombre"));
                etiquetas.add(e);
            }
        }
        return etiquetas;
    }

    /**
     * Trae las etiquetas que actualmente no están asociadas a la necesidad
     *
     * @return Etiquetas que actualmente no están asociadas a la necesidad
     * @throws java.sql.SQLException
     */
    public ArrayList<Etiqueta> listarEtiquetasExcluidas() throws SQLException {
        ArrayList<Etiqueta> etiqutas = new ArrayList<>();
        if (necesidad != null) {
            ArrayList<HashMap<String, String>> table = this.conexion.select(
                    "SELECT idetiqueta, nombre "
                    + "FROM etiqueta "
                    + "WHERE idetiqueta NOT IN ("
                    + "SELECT idetiqueta "
                    + "FROM etiquetanecesidad "
                    + "WHERE idnecesidad = " + this.necesidad.getId()
                    + ")");
            for (HashMap<String, String> row : table) {
                Etiqueta e = new Etiqueta(Integer.parseInt(row.get("idetiqueta")));
                e.setNombre(row.get("nombre"));
                etiqutas.add(e);
            }
        }
        return etiqutas;
    }
    //</editor-fold>
}
