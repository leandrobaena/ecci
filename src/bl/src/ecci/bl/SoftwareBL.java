package ecci.bl;

import ecci.dal.SoftwareDAL;
import ecci.entidades.Software;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author
 */
public class SoftwareBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Software manipulado
     */
    private Software software;

    /**
     * Administrador de la persistencia
     */
    private SoftwareDAL softwareDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea un nuevo software con su administrador de persistencia
     *
     * @param id Identificador del software
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public SoftwareBL(int id, Properties propiedadesBD) throws IOException {
        this.software = new Software(id);
        this.softwareDAL = new SoftwareDAL(propiedadesBD);
        this.softwareDAL.setSoftware(software);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del software
     *
     * @return El identificador del software
     */
    public int getId() {
        return this.software.getId();
    }

    /**
     * Cambia el identificador del software
     *
     * @param id Nuevo identificador del software
     */
    public void setId(int id) {
        this.software.setId(id);
    }

    /**
     * Trae el nombre del software
     *
     * @return El nombre del software
     */
    public String getNombre() {
        return this.software.getNombre();
    }

    /**
     * Cambia el nombre del software
     *
     * @param nombre El nuevo nombre del software
     */
    public void setNombre(String nombre) {
        this.software.setNombre(nombre);
    }

    /**
     * Trae la decripción del software
     *
     * @return La decripción del software
     */
    public String getDescripcion() {
        return this.software.getDescripcion();
    }

    /**
     * Cambia la decripción del software
     *
     * @param descripcion La bueva decripción del software
     */
    public void setDescripcion(String descripcion) {
        this.software.setDescripcion(descripcion);
    }

    /**
     * Trae la licencia del software
     *
     * @return La licencia del software
     */
    public String getLicencia() {
        return this.software.getLicencia();
    }

    /**
     * Cambia la licencia del software
     *
     * @param licencia La nueva licencia del software
     */
    public void setLicencia(String licencia) {
        this.software.setLicencia(licencia);
    }

    /**
     * Trae la url del software
     *
     * @return La url del software
     */
    public String getUrl() {
        return this.software.getUrl();
    }

    /**
     * Cambia la url del software
     *
     * @param url La nueva url del software
     */
    public void setUrl(String url) {
        this.software.setUrl(url);
    }

    /**
     * Trae la versión del software
     *
     * @return La versión del software
     */
    public String getVersion() {
        return this.software.getVersion();
    }

    /**
     * Cambia la versión del software
     *
     * @param version La nueva versión del software
     */
    public void setVersion(String version) {
        this.software.setVersion(version);
    }

    /**
     * Trae el listado de softwares desde la base de datos
     *
     * @return Listado de softwares desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Software> listar() throws SQLException {
        return this.softwareDAL.listar();
    }

    /**
     * Inserta un nuevo software en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        this.softwareDAL.insertar();
    }

    /**
     * Carga un software desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.softwareDAL.cargar();
    }

    /**
     * Actualiza un software en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.softwareDAL.actualizar();
    }

    /**
     * Elimina un software en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.softwareDAL.eliminar();
    }
    //</editor-fold>
}
