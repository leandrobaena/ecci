package ecci.dal;

import ecci.entidades.Profesion;
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
public class ProfesionDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Profesión que se desea persistir en base de datos
     */
    private Profesion profesion;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de las
     * profesiones
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public ProfesionDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae la profesión que actualmente se está persistiendo
     *
     * @return Profesión que actualmente se está persistiendo
     */
    public Profesion getProfesion() {
        return this.profesion;
    }

    /**
     * Cambia la profesión que actualmente se está persistiendo
     *
     * @param profesion Nueva profesión que actualmente se está persistiendo
     */
    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }

    /**
     * Trae el listado de profesiones desde la base de datos
     *
     * @return Listado de profesiones desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Profesion> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idprofesion, nombre "
                + "FROM profesion");
        ArrayList<Profesion> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Profesion p = new Profesion(Integer.parseInt(row.get("idprofesion")));
            p.setNombre(row.get("nombre"));
            lista.add(p);
        }
        return lista;
    }

    /**
     * Inserta una nueva profesión en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        if (profesion != null) {
            this.profesion.setId(this.conexion.insert(
                    "INSERT INTO profesion "
                    + "(nombre) "
                    + "VALUES "
                    + "('" + this.profesion.getNombre() + "')"));
        }
    }

    /**
     * Carga una profesión desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idprofesion, nombre "
                + "FROM profesion "
                + "WHERE idprofesion = " + this.profesion.getId());
        for (HashMap<String, String> row : table) {
            Profesion p = new Profesion(Integer.parseInt(row.get("idprofesion")));
            p.setNombre(row.get("nombre"));
            this.profesion = p;
        }
    }

    /**
     * Actualiza una profesión en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        if (profesion != null) {
            this.conexion.update(
                    "UPDATE profesion SET "
                    + "nombre = '" + this.profesion.getNombre() + "' "
                    + " WHERE idprofesion = " + this.profesion.getId());
        }
    }

    /**
     * Elimina una profesión en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (profesion != null) {
            this.conexion.update(
                    "DELETE FROM profesion "
                    + "WHERE idprofesion = " + this.profesion.getId());
        }
    }
    //</editor-fold>
}
