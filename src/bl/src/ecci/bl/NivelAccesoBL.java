package ecci.bl;

import ecci.dal.NivelAccesoDAL;
import ecci.entidades.NivelAcceso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author
 */
public class NivelAccesoBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Nivel de acceso manipulado
     */
    private NivelAcceso nivelAcceso;

    /**
     * Administrador de la persistencia
     */
    private NivelAccesoDAL nivelAccesoDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea un nuevo nivel de acceso con su administrador de persistencia
     *
     * @param id Identificador del nivel de acceso
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public NivelAccesoBL(int id, Properties propiedadesBD) throws IOException {
        this.nivelAcceso = new NivelAcceso(id);
        this.nivelAccesoDAL = new NivelAccesoDAL(propiedadesBD);
        this.nivelAccesoDAL.setNivelAcceso(nivelAcceso);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del nivel de acceso
     *
     * @return Identificador del nivel de acceso
     */
    public int getId() {
        return this.nivelAcceso.getId();
    }

    /**
     * Cambia el identificador del nivel de acceso
     *
     * @param id Nuevo identificador del nivel de acceso
     */
    public void setId(int id) {
        this.nivelAcceso.setId(id);
    }

    /**
     * Trae el nombre del nivel de acceso
     *
     * @return Nombre del nivel de acceso
     */
    public String getNombre() {
        return this.nivelAcceso.getNombre();
    }

    /**
     * Cambia el nombre del nivel de acceso
     *
     * @param nombre Nuevo nombre del nivel de acceso
     */
    public void setNombre(String nombre) {
        this.nivelAcceso.setNombre(nombre);
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return this.nivelAcceso.toString();
    }

    /**
     * Trae el listado de niveles de acceso desde la base de datos
     *
     * @return Listado de niveles de acceso desde la base de datos
     * @throws SQLException
     */
    public ArrayList<NivelAcceso> listar() throws SQLException {
        return this.nivelAccesoDAL.listar();
    }

    /**
     * Inserta un nuevo nivel de acceso en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        this.nivelAccesoDAL.insertar();
    }

    /**
     * Carga un nivel de acceso desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.nivelAccesoDAL.cargar();
    }

    /**
     * Actualiza un nivel de acceso en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.nivelAccesoDAL.actualizar();
    }

    /**
     * Elimina un nivel de acceso en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.nivelAccesoDAL.eliminar();
    }
    //</editor-fold>
}
