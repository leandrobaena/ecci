package ecci.bl;

import ecci.dal.GrupoDAL;
import ecci.entidades.Grupo;
import ecci.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author
 */
public class GrupoBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Grupo manipulado
     */
    private Grupo grupo;

    /**
     * Administrador de la persistencia
     */
    private GrupoDAL grupoDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea un nuevo grupo con su administrador de persistencia
     *
     * @param id Identificador del grupo
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public GrupoBL(int id, Properties propiedadesBD) throws IOException {
        this.grupo = new Grupo(id);
        this.grupoDAL = new GrupoDAL(propiedadesBD);
        this.grupoDAL.setGrupo(grupo);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del grupo
     *
     * @return Identificador del grupo
     */
    public int getId() {
        return this.grupo.getId();
    }

    /**
     * Cambia el identificador del grupo
     *
     * @param id Nuevo identificador del grupo
     */
    public void setId(int id) {
        this.grupo.setId(id);
    }

    /**
     * Trae el nombre del grupo
     *
     * @return Nombre del grupo
     */
    public String getNombre() {
        return this.grupo.getNombre();
    }

    /**
     * Cambia el nombre del grupo
     *
     * @param nombre Nuevo nombre del grupo
     */
    public void setNombre(String nombre) {
        this.grupo.setNombre(nombre);
    }

    /**
     * Trae si el grupo está o no activo
     *
     * @return Si el grupo está o no activo
     */
    public boolean isActivo() {
        return this.grupo.isActivo();
    }

    /**
     * Cambia si el grupo está o no activo
     *
     * @param activo Si el grupo está o no activo
     */
    public void setActivo(boolean activo) {
        this.grupo.setActivo(activo);
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return this.grupo.toString();
    }

    /**
     * Trae el listado de grupos desde la base de datos
     *
     * @return Listado de grupos desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Grupo> listar() throws SQLException {
        return this.grupoDAL.listar();
    }

    /**
     * Inserta un nuevo grupo en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        this.grupoDAL.insertar();
    }

    /**
     * Carga un grupo desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.grupoDAL.cargar();
    }

    /**
     * Actualiza un grupo en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.grupoDAL.actualizar();
    }

    /**
     * Elimina un grupo en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.grupoDAL.eliminar();
    }

    /**
     * Inserta un usuario en un grupo en la base de datos
     *
     * @param usuario Usuario que se desea insertar al grupo
     * @throws SQLException
     */
    public void insertarUsuarioEnGrupo(Usuario usuario) throws SQLException {
        this.grupoDAL.insertarUsuarioEnGrupo(usuario);
    }

    /**
     * Elimina un usuario de un grupo en la base de datos
     *
     * @param usuario Usuario que se desea eliminar del grupo
     * @throws SQLException
     */
    public void eliminarUsuarioEnGrupo(Grupo usuario) throws SQLException {
        this.grupoDAL.eliminarUsuarioEnGrupo(usuario);
    }

    /**
     * Trae los usuarios que actualmente tiene el grupo
     *
     * @return Usuarios que actualmente tiene el grupo
     * @throws java.sql.SQLException
     */
    public ArrayList<Usuario> listarUsuariosActuales() throws SQLException {
        return this.grupoDAL.listarUsuariosActuales();
    }

    /**
     * Trae los usuarios que actualmente no tiene el grupo
     *
     * @return Usuarios que actualmente no tiene el grupo
     * @throws java.sql.SQLException
     */
    public ArrayList<Usuario> listarUsuariosExcluidos() throws SQLException {
        return this.grupoDAL.listarUsuariosExcluidos();
    }
    //</editor-fold>
}
