package ecci.dal;

import ecci.entidades.Escolaridad;
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
public class EscolaridadDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Escolaridad que se desea persistir en base de datos
     */
    private Escolaridad escolaridad;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de las
     * escolaridades
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public EscolaridadDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae la escolaridad que actualmente se está persistiendo
     *
     * @return Escolaridad que actualmente se está persistiendo
     */
    public Escolaridad getEscolaridad() {
        return this.escolaridad;
    }

    /**
     * Cambia la escolaridad que actualmente se está persistiendo
     *
     * @param escolaridad Nueva escolaridad que actualmente se está persistiendo
     */
    public void setEscolaridad(Escolaridad escolaridad) {
        this.escolaridad = escolaridad;
    }

    /**
     * Trae el listado de escolaridades desde la base de datos
     *
     * @return Listado de escolaridades desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Escolaridad> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idescolaridad, nombre "
                + "FROM escolaridad");
        ArrayList<Escolaridad> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Escolaridad e = new Escolaridad(Integer.parseInt(row.get("idescolaridad")));
            e.setNombre(row.get("nombre"));
            lista.add(e);
        }
        return lista;
    }

    /**
     * Inserta una nueva escolaridad en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        if (escolaridad != null) {
            this.escolaridad.setId(this.conexion.insert(
                    "INSERT INTO escolaridad "
                    + "(nombre) "
                    + "VALUES "
                    + "('" + this.escolaridad.getNombre() + "')"));
        }
    }

    /**
     * Carga una escolaridad desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idescolaridad, nombre "
                + "FROM escolaridad "
                + "WHERE idescolaridad = " + this.escolaridad.getId());
        for (HashMap<String, String> row : table) {
            Escolaridad e = new Escolaridad(Integer.parseInt(row.get("idescolaridad")));
            e.setNombre(row.get("nombre"));
            this.escolaridad = e;
        }
    }

    /**
     * Actualiza una escolaridad en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        if (escolaridad != null) {
            this.conexion.update(
                    "UPDATE escolaridad SET "
                    + "nombre = '" + this.escolaridad.getNombre() + "' "
                    + " WHERE idescolaridad = " + this.escolaridad.getId());
        }
    }

    /**
     * Elimina una escolaridad en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (escolaridad != null) {
            this.conexion.update(
                    "DELETE FROM escolaridad "
                    + "WHERE idescolaridad = " + this.escolaridad.getId());
        }
    }
    //</editor-fold>
}
