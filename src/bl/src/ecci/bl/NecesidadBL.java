package ecci.bl;

import ecci.dal.NecesidadDAL;
import ecci.entidades.Etiqueta;
import ecci.entidades.Necesidad;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author
 */
public class NecesidadBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Necesidad manipulado
     */
    private Necesidad necesidad;

    /**
     * Administrador de la persistencia
     */
    private NecesidadDAL necesidadDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva necesidad con su administrador de persistencia
     *
     * @param id Identificador de la necesidad
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public NecesidadBL(int id, Properties propiedadesBD) throws IOException {
        this.necesidad = new Necesidad(id);
        this.necesidadDAL = new NecesidadDAL(propiedadesBD);
        this.necesidadDAL.setNecesidad(necesidad);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la necesidad
     *
     * @return Identificador de la necesidad
     */
    public int getId() {
        return this.necesidad.getId();
    }

    /**
     * Cambia el identificador de la necesidad
     *
     * @param id Nuevo identificador de la necesidad
     */
    public void setId(int id) {
        this.necesidad.setId(id);
    }

    /**
     * Trae el código de la necesidad
     *
     * @return Código de la necesidad
     */
    public String getCodigo() {
        return this.necesidad.getCodigo();
    }

    /**
     * Cambia el código de la necesidad
     *
     * @param codigo Nuevo código de la necesidad
     */
    public void setCodigo(String codigo) {
        this.necesidad.setCodigo(codigo);
    }

    /**
     * Trae la descripción de la necesidad
     *
     * @return
     */
    public String getDescripcion() {
        return this.necesidad.getDescripcion();
    }

    /**
     * Cambia la descripción de la necesidad
     *
     * @param descripcion Nueva descripción de la necesidad
     */
    public void setDescripcion(String descripcion) {
        this.necesidad.setDescripcion(descripcion);
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
        return this.necesidadDAL.listar(padre);
    }

    /**
     * Inserta una nueva necesidad en la base de datos
     *
     * @param padre Identificador de la necesidad padre de la que se trae las
     * @throws SQLException
     */
    public void insertar(int padre) throws SQLException {
        this.necesidadDAL.insertar(padre);
    }

    /**
     * Carga una necesidad desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.necesidadDAL.cargar();
    }

    /**
     * Actualiza una necesidad en la base de datos
     *
     * @param padre Identificador de la necesidad padre de la que se trae las
     * @throws SQLException
     */
    public void actualizar(int padre) throws SQLException {
        this.necesidadDAL.actualizar(padre);
    }

    /**
     * Elimina una necesidad en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.necesidadDAL.eliminar();
    }

    /**
     * Asocia un etiqueta a una necesidad en la base de datos
     *
     * @param etiqueta Etiqueta que se desea asociar a la necesidad
     * @throws SQLException
     */
    public void insertarEtiquetaEnNecesidad(Etiqueta etiqueta) throws SQLException {
        this.necesidadDAL.insertarEtiquetaEnNecesidad(etiqueta);
    }

    /**
     * Desvincula una etiqueta de una necesidad en la base de datos
     *
     * @param etiqueta Etiqueta que se desea desvincular de la necesidad
     * @throws SQLException
     */
    public void eliminarEtiquetaEnNecesidad(Etiqueta etiqueta) throws SQLException {
        this.necesidadDAL.eliminarEtiquetaEnNecesidad(etiqueta);
    }

    /**
     * Trae las etiquetas que actualmente están asociadas a la necesidad
     *
     * @return Etiquetas que actualmente están asociadas a la necesidad
     * @throws java.sql.SQLException
     */
    public ArrayList<Etiqueta> listarEtiquetasActuales() throws SQLException {
        return this.necesidadDAL.listarEtiquetasActuales();
    }

    /**
     * Trae las etiquetas que actualmente no están asociadas a la necesidad
     *
     * @return Etiquetas que actualmente no están asociadas a la necesidad
     * @throws java.sql.SQLException
     */
    public ArrayList<Etiqueta> listarEtiquetasExcluidas() throws SQLException {
        return this.necesidadDAL.listarEtiquetasExcluidas();
    }
    //</editor-fold>
}
