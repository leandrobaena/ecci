package ecci.bl;

import ecci.dal.PermisoDAL;
import ecci.entidades.Grupo;
import ecci.entidades.Modulo;
import ecci.entidades.NivelAcceso;
import ecci.entidades.Permiso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author
 */
public class PermisoBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Permiso manipulado
     */
    private Permiso permiso;

    /**
     * Administrador de la persistencia
     */
    private PermisoDAL permisoDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea un nuevo permiso con su administrador de persistencia
     *
     * @param id Identificador del permiso
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public PermisoBL(int id, Properties propiedadesBD) throws IOException {
        this.permiso = new Permiso(id);
        this.permisoDAL = new PermisoDAL(propiedadesBD);
        this.permisoDAL.setPermiso(permiso);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del permiso
     *
     * @return Identificador del permiso
     */
    public int getId() {
        return this.permiso.getId();
    }

    /**
     * Cambia el identificador del nivel de acceso
     *
     * @param id Nuevo identificador del nivel de acceso
     */
    public void setId(int id) {
        this.permiso.setId(id);
    }

    /**
     * Trae el grupo al que se le da permiso
     *
     * @return Grupo al que se le da permiso
     */
    public Grupo getGrupo() {
        return this.permiso.getGrupo();
    }

    /**
     * Cambia el grupo al que se le da permiso
     *
     * @param grupo Nuevo grupo al que se la permiso
     */
    public void setGrupo(Grupo grupo) {
        this.permiso.setGrupo(grupo);
    }

    /**
     * Trae el nivel de acceso dado en el permiso
     *
     * @return Nivel de acceso dado en el permiso
     */
    public NivelAcceso getNivelAcceso() {
        return permiso.getNivelAcceso();
    }

    /**
     * Cambia el nivel de acceso dado en el permiso
     *
     * @param nivelAcceso Nuevo nivel de acceso dado en el permiso
     */
    public void setNivelAcceso(NivelAcceso nivelAcceso) {
        this.permiso.setNivelAcceso(nivelAcceso);
    }

    /**
     * Trae el módulo al que se le da permiso
     *
     * @return Módulo al que se le da permiso
     */
    public Modulo getModulo() {
        return this.permiso.getModulo();
    }

    /**
     * Cambia el módulo al que se le da permiso
     *
     * @param modulo Nuevo módulo al que se le da permiso
     */
    public void setModulo(Modulo modulo) {
        this.permiso.setModulo(modulo);
    }

    /**
     * Trae el listado de permisos desde la base de datos
     *
     * @return Listado de permisos desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Permiso> listar() throws SQLException {
        return this.permisoDAL.listar();
    }

    /**
     * Inserta un nuevo permiso en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        this.permisoDAL.insertar();
    }

    /**
     * Carga un permiso desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.permisoDAL.cargar();
    }

    /**
     * Actualiza un permiso en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.permisoDAL.actualizar();
    }

    /**
     * Elimina un permiso en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.permisoDAL.eliminar();
    }
    //</editor-fold>
}
