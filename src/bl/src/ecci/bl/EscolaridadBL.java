package ecci.bl;

import ecci.dal.EscolaridadDAL;
import ecci.entidades.Escolaridad;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author
 */
public class EscolaridadBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Escolaridad manipulada
     */
    private Escolaridad escolaridad;

    /**
     * Administrador de la persistencia
     */
    private EscolaridadDAL escolaridadDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una escolaridad de acceso con su administrador de persistencia
     *
     * @param id Identificador de la escolaridad
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public EscolaridadBL(int id, Properties propiedadesBD) throws IOException {
        this.escolaridad = new Escolaridad(id);
        this.escolaridadDAL = new EscolaridadDAL(propiedadesBD);
        this.escolaridadDAL.setEscolaridad(escolaridad);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del escolaridad
     *
     * @return Identificador del escolaridad
     */
    public int getId() {
        return this.escolaridad.getId();
    }

    /**
     * Cambia el identificador del escolaridad
     *
     * @param id Nuevo identificador del escolaridad
     */
    public void setId(int id) {
        this.escolaridad.setId(id);
    }

    /**
     * Trae el nombre del escolaridad
     *
     * @return Nombre del escolaridad
     */
    public String getNombre() {
        return this.escolaridad.getNombre();
    }

    /**
     * Cambia el nombre del escolaridad
     *
     * @param nombre Nuevo nombre del escolaridad
     */
    public void setNombre(String nombre) {
        this.escolaridad.setNombre(nombre);
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return this.escolaridad.toString();
    }

    /**
     * Trae el listado de escolaridades desde la base de datos
     *
     * @return Listado de escolaridades desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Escolaridad> listar() throws SQLException {
        return this.escolaridadDAL.listar();
    }

    /**
     * Inserta una nueva escolaridad en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        this.escolaridadDAL.insertar();
    }

    /**
     * Carga una escolaridad desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.escolaridadDAL.cargar();
    }

    /**
     * Actualiza una escolaridad en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.escolaridadDAL.actualizar();
    }

    /**
     * Elimina una escolaridad en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.escolaridadDAL.eliminar();
    }
    //</editor-fold>
}
