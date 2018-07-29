package ecci.bl;

import ecci.dal.EtiquetaDAL;
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
public class EtiquetaBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Etiqueta manipulada
     */
    private Etiqueta etiqueta;

    /**
     * Administrador de la persistencia
     */
    private EtiquetaDAL etiquetaDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Crea una etiqueta con su administrador de persistencia
     *
     * @param id Identificador de la etiqueta
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public EtiquetaBL(int id, Properties propiedadesBD) throws IOException {
        this.etiqueta = new Etiqueta(id);
        this.etiquetaDAL = new EtiquetaDAL(propiedadesBD);
        this.etiquetaDAL.setEtiqueta(etiqueta);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la etiqueta
     *
     * @return El identificador de la etiqueta
     */
    public int getId() {
        return this.etiqueta.getId();
    }

    /**
     * Cambia el identificador de la etiqueta
     *
     * @param id El nuevo identificador de la etiqueta
     */
    public void setId(int id) {
        this.etiqueta.setId(id);
    }

    /**
     * Trae el nombre de la etiqueta
     *
     * @return El nombre de la etiqueta
     */
    public String getNombre() {
        return this.etiqueta.getNombre();
    }

    /**
     * Cambia el nombre de la etiqueta
     *
     * @param nombre El nuevo nombre de la etiqueta
     */
    public void setNombre(String nombre) {
        this.etiqueta.setNombre(nombre);
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return this.etiqueta.toString();
    }

    /**
     * Trae el listado de etiquetas desde la base de datos
     *
     * @return Listado de etiquetas desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Etiqueta> listar() throws SQLException {
        return this.etiquetaDAL.listar();
    }

    /**
     * Inserta una nueva etiqueta en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        this.etiquetaDAL.insertar();
    }

    /**
     * Carga una etiqueta desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.etiquetaDAL.cargar();
    }

    /**
     * Actualiza una etiqueta en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.etiquetaDAL.actualizar();
    }

    /**
     * Elimina una etiqueta en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.etiquetaDAL.eliminar();
    }

    /**
     * Asocia un necesidad a una etiqueta en la base de datos
     *
     * @param necesidad Necesidad que se desea asociar a la etiqueta
     * @throws SQLException
     */
    public void insertarNecesidadEnEtiqueta(Necesidad necesidad) throws SQLException {
        this.etiquetaDAL.insertarNecesidadEnEtiqueta(necesidad);
    }

    /**
     * Desvincula una necesidad de una etiqueta en la base de datos
     *
     * @param necesidad Necesidad que se desea desvincular de la etiqueta
     * @throws SQLException
     */
    public void eliminarNecesidadEnEtiqueta(Necesidad necesidad) throws SQLException {
        this.etiquetaDAL.eliminarNecesidadEnEtiqueta(necesidad);
    }

    /**
     * Trae las necesidades que actualmente están asociadas a la etiqueta
     *
     * @return Necesidades que actualmente están asociadas a la etiqueta
     * @throws java.sql.SQLException
     */
    public ArrayList<Necesidad> listarNecesidadesActuales() throws SQLException {
        return this.etiquetaDAL.listarNecesidadesActuales();
    }

    /**
     * Trae las necesidades que actualmente no están asociadas a la etiqueta
     *
     * @return Necesidades que actualmente no están asociadas a la etiqueta
     * @throws java.sql.SQLException
     */
    public ArrayList<Necesidad> listarNecesidadesExcluidas() throws SQLException {
        return this.etiquetaDAL.listarNecesidadesExcluidas();
    }
    //</editor-fold>
}
