package ecci.dal;

import ecci.entidades.Necesidad;
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
                "SELECT idnecesidad, codigo, descricion "
                + "FROM necesidad "
                + "WHERE idnecesidadpadre " + (padre == 0 ? "IS NULL" : "= " + padre));
        ArrayList<Necesidad> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Necesidad n = new Necesidad(Integer.parseInt(row.get("idnecesidad")));
            n.setCodigo(row.get("codigo"));
            n.setDescripcion(row.get("descipcion"));
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
                    + (padre == 0 ? "NULL" : "" + padre) + ", "
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
                    + "idnecesidadpare = " + (padre == 0 ? "NULL" : "" + padre)
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
    //</editor-fold>
}
