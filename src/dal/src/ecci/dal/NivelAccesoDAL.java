package ecci.dal;

import ecci.entidades.NivelAcceso;
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
public class NivelAccesoDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Nivel de acceso que se desea persistir en base de datos
     */
    private NivelAcceso nivelAcceso;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de los niveles
     * de acceso
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public NivelAccesoDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el nivel de acceso que actualmente se está persistiendo
     *
     * @return Nivel de acceso que actualmente se está persistiendo
     */
    public NivelAcceso getNivelAcceso() {
        return this.nivelAcceso;
    }

    /**
     * Cambia el nivel de acceso que actualmente se está persistiendo
     *
     * @param nivelAcceso Nuevo nivel de acceso que actualmente se está
     * persistiendo
     */
    public void setNivelAcceso(NivelAcceso nivelAcceso) {
        this.nivelAcceso = nivelAcceso;
    }

    /**
     * Trae el listado de niveles de acceso desde la base de datos
     *
     * @return Listado de niveles de acceso desde la base de datos
     * @throws SQLException
     */
    public ArrayList<NivelAcceso> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idnivelacceso, nombre "
                + "FROM nivelacceso");
        ArrayList<NivelAcceso> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            NivelAcceso na = new NivelAcceso(Integer.parseInt(row.get("idnivelacceso")));
            na.setNombre(row.get("nombre"));
            lista.add(na);
        }
        return lista;
    }

    /**
     * Inserta un nuevo nivel de acceso en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        if (nivelAcceso != null) {
            this.nivelAcceso.setId(this.conexion.insert(
                    "INSERT INTO nivelacceso "
                    + "(nombre) "
                    + "VALUES "
                    + "('" + this.nivelAcceso.getNombre() + "')"));
        }
    }

    /**
     * Carga un nivel de acceso desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idnivelacceso, nombre "
                + "FROM nivelacceso "
                + "WHERE idnivelacceso = " + this.nivelAcceso.getId());
        for (HashMap<String, String> row : table) {
            NivelAcceso na = new NivelAcceso(Integer.parseInt(row.get("idnivelacceso")));
            na.setNombre(row.get("nombre"));
            this.nivelAcceso = na;
        }
    }

    /**
     * Actualiza un nivel de acceso en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        if (nivelAcceso != null) {
            this.conexion.update(
                    "UPDATE nivelacceso SET "
                    + "nombre = '" + this.nivelAcceso.getNombre() + "' "
                    + " WHERE idnivelacceso = " + this.nivelAcceso.getId());
        }
    }

    /**
     * Elimina un nivel de acceso en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (nivelAcceso != null) {
            this.conexion.update(
                    "DELETE FROM nivelacceso "
                    + "WHERE idnivelacceso = " + this.nivelAcceso.getId());
        }
    }
    //</editor-fold>
}
