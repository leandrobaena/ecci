package ecci.dal;

import ecci.entidades.Modulo;
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
public class ModuloDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Modulo que se desea persistir en base de datos
     */
    private Modulo modulo;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de los módulos
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public ModuloDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el módulo que actualmente se está persistiendo
     *
     * @return Módulo que actualmente se está persistiendo
     */
    public Modulo getModulo() {
        return this.modulo;
    }

    /**
     * Cambia el módulo que actualmente se está persistiendo
     *
     * @param modulo Nuevo módulo que actualmente se está persistiendo
     */
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    /**
     * Trae el listado de módulos desde la base de datos
     *
     * @return Listado de módulos desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Modulo> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idmodulo, nombre, activo "
                + "FROM modulo");
        ArrayList<Modulo> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Modulo m = new Modulo(Integer.parseInt(row.get("idmodulo")));
            m.setNombre(row.get("nombre"));
            m.setActivo(row.get("activo").equals("1"));
            lista.add(m);
        }
        return lista;
    }

    /**
     * Inserta un nuevo módulo en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        if (modulo != null) {
            this.modulo.setId(this.conexion.insert(
                    "INSERT INTO modulo "
                    + "(nombre, activo) "
                    + "VALUES "
                    + "('" + this.modulo.getNombre() + "', "
                    + (this.modulo.isActivo() ? "1" : "0") + ")"));
        }
    }

    /**
     * Carga un módulo desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idmodulo, nombre, activo "
                + "FROM modulo "
                + "WHERE idmodulo = " + this.modulo.getId());
        for (HashMap<String, String> row : table) {
            Modulo m = new Modulo(Integer.parseInt(row.get("idmodulo")));
            m.setNombre(row.get("nombre"));
            m.setActivo(row.get("activo").equals("1"));
            this.modulo = m;
        }
    }

    /**
     * Actualiza un módulo en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        if (modulo != null) {
            this.conexion.update(
                    "UPDATE modulo SET "
                    + "nombre = '" + this.modulo.getNombre() + "', "
                    + "activo = " + (this.modulo.isActivo() ? "1" : "0")
                    + " WHERE idmodulo = " + this.modulo.getId());
        }
    }

    /**
     * Elimina un módulo en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (modulo != null) {
            this.conexion.update(
                    "DELETE FROM modulo "
                    + "WHERE idmodulo = " + this.modulo.getId());
        }
    }
    //</editor-fold>
}
