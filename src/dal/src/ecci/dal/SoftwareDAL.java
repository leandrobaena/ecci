package ecci.dal;

import ecci.entidades.Software;
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
public class SoftwareDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Software que se desea persistir en base de datos
     */
    private Software software;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de los
     * softwares
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public SoftwareDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el software que actualmente se está persistiendo
     *
     * @return Software que actualmente se está persistiendo
     */
    public Software getSoftware() {
        return this.software;
    }

    /**
     * Cambia el software que actualmente se está persistiendo
     *
     * @param software Nuevo software que actualmente se está persistiendo
     */
    public void setSoftware(Software software) {
        this.software = software;
    }

    /**
     * Trae el listado de softwares desde la base de datos
     *
     * @return Listado de softwares desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Software> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idsoftware, nombre, descripcion, licencia, url, version "
                + "FROM software");
        ArrayList<Software> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Software s = new Software(Integer.parseInt(row.get("idsoftware")));
            s.setNombre(row.get("nombre"));
            s.setDescripcion(row.get("descripcion"));
            s.setLicencia(row.get("licencia"));
            s.setUrl(row.get("url"));
            s.setVersion(row.get("version"));
            lista.add(s);
        }
        return lista;
    }

    /**
     * Inserta un nuevo software en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        if (software != null) {
            this.software.setId(this.conexion.insert(
                    "INSERT INTO software "
                    + "(nombre, descripcion, licencia, url, version) "
                    + "VALUES "
                    + "('" + this.software.getNombre() + "', "
                    + "'" + this.software.getDescripcion() + "', "
                    + "'" + this.software.getLicencia() + "', "
                    + "'" + this.software.getUrl() + "', "
                    + "'" + this.software.getVersion() + "')"));
        }
    }

    /**
     * Carga un software desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT nombre, descripcion, licencia, version "
                + "FROM software "
                + "WHERE idsoftware = " + this.software.getId());
        for (HashMap<String, String> row : table) {
            Software s = new Software(Integer.parseInt(row.get("idsoftware")));
            s.setNombre(row.get("nombre"));
            s.setDescripcion(row.get("descripcion"));
            s.setLicencia(row.get("licencia"));
            s.setUrl(row.get("url"));
            s.setVersion(row.get("version"));
            this.software = s;
        }
    }

    /**
     * Actualiza un software en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        if (software != null) {
            this.conexion.update(
                    "UPDATE software SET "
                    + "nombre = '" + this.software.getNombre() + "', "
                    + "descripcion = '" + this.software.getDescripcion() + "', "
                    + "licencia = '" + this.software.getLicencia() + "', "
                    + "url = '" + this.software.getUrl() + "', "
                    + "version = '" + this.software.getVersion() + "'"
                    + " WHERE idsoftware = " + this.software.getId());
        }
    }

    /**
     * Elimina un software en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (software != null) {
            this.conexion.update(
                    "DELETE FROM software "
                    + "WHERE idsoftware = " + this.software.getId());
        }
    }
    //</editor-fold>
}
