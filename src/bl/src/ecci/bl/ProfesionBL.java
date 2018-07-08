package ecci.bl;

import ecci.dal.ProfesionDAL;
import ecci.entidades.Profesion;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author
 */
public class ProfesionBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Profesion manipulado
     */
    private Profesion profesion;

    /**
     * Administrador de la persistencia
     */
    private ProfesionDAL profesionDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva profesión con su administrador de persistencia
     *
     * @param id Identificador de la profesión
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public ProfesionBL(int id, Properties propiedadesBD) throws IOException {
        this.profesion = new Profesion(id);
        this.profesionDAL = new ProfesionDAL(propiedadesBD);
        this.profesionDAL.setProfesion(profesion);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la profesión
     *
     * @return Identificador de la profesión
     */
    public int getId() {
        return this.profesion.getId();
    }

    /**
     * Cambia el identificador de la profesión
     *
     * @param id Nuevo identificador de la profesión
     */
    public void setId(int id) {
        this.profesion.setId(id);
    }

    /**
     * Trae el nombre de la profesión
     *
     * @return Nombre de la profesión
     */
    public String getNombre() {
        return this.profesion.getNombre();
    }

    /**
     * Cambia el nombre de la profesión
     *
     * @param nombre Nuevo nombre de la profesión
     */
    public void setNombre(String nombre) {
        this.profesion.setNombre(nombre);
    }

    /**
     * Trae el listado de profesiones desde la base de datos
     *
     * @return Listado de profesiones desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Profesion> listar() throws SQLException {
        return this.profesionDAL.listar();
    }

    /**
     * Inserta una nueva profesión en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        this.profesionDAL.insertar();
    }

    /**
     * Carga una profesión desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.profesionDAL.cargar();
    }

    /**
     * Actualiza una profesión en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.profesionDAL.actualizar();
    }

    /**
     * Elimina una profesión en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.profesionDAL.eliminar();
    }
    //</editor-fold>
}
