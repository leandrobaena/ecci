package ecci.bl;

import ecci.dal.UsuarioDAL;
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
public class UsuarioBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Usuario manipulado
     */
    private Usuario usuario;

    /**
     * Administrador de la persistencia
     */
    private UsuarioDAL usuarioDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea un nuevo usuario con su administrador de persistencia
     *
     * @param id Identificador del usuario
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public UsuarioBL(int id, Properties propiedadesBD) throws IOException {
        this.usuario = new Usuario(id);
        this.usuarioDAL = new UsuarioDAL(propiedadesBD);
        this.usuarioDAL.setUsuario(usuario);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del usuario
     *
     * @return Identificador del usuario
     */
    public int getId() {
        return this.usuario.getId();
    }

    /**
     * Cambia el identificador del usuario
     *
     * @param id Nuevo identificador del usuario
     */
    public void setId(int id) {
        this.usuario.setId(id);
    }

    /**
     * Trae el login del usuario
     *
     * @return Login del usuario
     */
    public String getLogin() {
        return this.usuario.getLogin();
    }

    /**
     * Cambia el login del usuario
     *
     * @param login Nuevo login del usuario
     */
    public void setLogin(String login) {
        this.usuario.setLogin(login);
    }

    /**
     * Trae los nombres del usuario
     *
     * @return Nombres del usuario
     */
    public String getNombres() {
        return this.usuario.getNombres();
    }

    /**
     * Cambia los nombres del usuario
     *
     * @param nombres Nuevos nombres del usuario
     */
    public void setNombres(String nombres) {
        this.usuario.setNombres(nombres);
    }

    /**
     * Trae los apellidos del usuario
     *
     * @return Apellidos del usuario
     */
    public String getApellidos() {
        return this.usuario.getApellidos();
    }

    /**
     * Cambia los apellidos del usuario
     *
     * @param apellidos Nuevos apellidos del usuario
     */
    public void setApellidos(String apellidos) {
        this.usuario.setApellidos(apellidos);
    }

    /**
     * Trae si el usuario está o no activo
     *
     * @return Si el usuario está o no activo
     */
    public boolean isActivo() {
        return this.usuario.isActivo();
    }

    /**
     * Cambia si el usuario está o no activo
     *
     * @param activo Si el usuario está o no activo
     */
    public void setActivo(boolean activo) {
        this.usuario.setActivo(activo);
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return this.usuario.toString();
    }

    /**
     * Trae el listado de usuarios desde la base de datos
     *
     * @return Listado de usuarios desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Usuario> listar() throws SQLException {
        return this.usuarioDAL.listar();
    }

    /**
     * Inserta un nuevo usuario en la base de datos
     *
     * @param contrasenia Contraseña con la que se crea el usuario
     * @throws SQLException
     */
    public void insertar(String contrasenia) throws SQLException {
        this.usuarioDAL.insertar(contrasenia);
    }

    /**
     * Carga un usuario desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.usuarioDAL.cargar();
    }

    /**
     * Actualiza un usuario en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.usuarioDAL.actualizar();
    }

    /**
     * Actualiza la contraseña de un usuario en la base de datos
     *
     * @param contrasenia Nueva contraseña del usuario
     * @throws SQLException
     */
    public void actualizarContrasenia(String contrasenia) throws SQLException {
        this.usuarioDAL.actualizarContrasenia(contrasenia);
    }

    /**
     * Elimina un usuario de la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.usuarioDAL.eliminar();
    }

    /**
     * Inserta un usuario en un grupo en la base de datos
     *
     * @param grupo Grupo en el que se desea insertar al usuario
     * @throws SQLException
     */
    public void insertarUsuarioEnGrupo(Grupo grupo) throws SQLException {
        this.usuarioDAL.insertarUsuarioEnGrupo(grupo);
    }

    /**
     * Elimina un usuario de un grupo en la base de datos
     *
     * @param grupo Grupo del que se desea eliminar al usuario
     * @throws SQLException
     */
    public void eliminarUsuarioEnGrupo(Grupo grupo) throws SQLException {
        this.usuarioDAL.eliminarUsuarioEnGrupo(grupo);
    }

    /**
     * Trae los grupos en los que actualmente se encuentra el usuario
     *
     * @return Grupos en los que actualmente se encuentra el usuario
     * @throws java.sql.SQLException
     */
    public ArrayList<Grupo> listarGruposActuales() throws SQLException {
        return this.usuarioDAL.listarGruposActuales();
    }

    /**
     * Trae los grupos en los que actualmente no se encuentra el usuario
     *
     * @return Grupos en los que actualmente no se encuentra el usuario
     * @throws java.sql.SQLException
     */
    public ArrayList<Grupo> listarGruposExcluidos() throws SQLException {
        return this.usuarioDAL.listarGruposExcluidos();
    }

    /**
     * Valida que el login y la contraseña corresponden a un usuario del sistema
     * @param login Login del usuario
     * @param contrasenia Contraseña del usuario
     */
    public Usuario validarLogin(String login, String contrasenia) throws SQLException {
        return this.usuarioDAL.validarLogin(login, contrasenia);
    }
    //</editor-fold>
}
