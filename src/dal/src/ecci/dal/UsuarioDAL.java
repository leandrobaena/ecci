package ecci.dal;

import ecci.entidades.Usuario;
import ecci.database.ConexionMySQL;
import ecci.entidades.Grupo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author
 */
public class UsuarioDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Usuario que se desea persistir en base de datos
     */
    private Usuario usuario;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de los grupos
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public UsuarioDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el usuario que actualmente se está persistiendo
     *
     * @return Usuario que actualmente se está persistiendo
     */
    public Usuario getUsuario() {
        return this.usuario;
    }

    /**
     * Cambia el usuario que actualmente se está persistiendo
     *
     * @param usuario Nuevo usuario que actualmente se está persistiendo
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * Trae el listado de usuarios desde la base de datos
     *
     * @return Listado de usuarios desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Usuario> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idusuario, login, nombres, apellidos, activo "
                + "FROM usuario");
        ArrayList<Usuario> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Usuario u = new Usuario(Integer.parseInt(row.get("idusuario")));
            u.setLogin(row.get("login"));
            u.setNombres(row.get("nombres"));
            u.setApellidos(row.get("apellidos"));
            u.setActivo(row.get("activo").equals("1"));
            lista.add(u);
        }
        return lista;
    }

    /**
     * Inserta un nuevo usuario en la base de datos
     *
     * @param contrasenia Contraseña con la que se crea el usuario
     * @throws SQLException
     */
    public void insertar(String contrasenia) throws SQLException {
        if (usuario != null) {
            this.usuario.setId(this.conexion.insert(
                    "INSERT INTO usuario "
                    + "(login, nombres, apellidos, contrasenia, activo) "
                    + "VALUES "
                    + "('" + this.usuario.getLogin() + "', "
                    + "'" + this.usuario.getNombres() + "', "
                    + "'" + this.usuario.getApellidos() + "', "
                    + "MD5('" + contrasenia + "'), "
                    + (this.usuario.isActivo() ? "1" : "0")
                    + ")"));
        }
    }

    /**
     * Carga un usuario desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idusuario, login, nombres, apellidos, activo "
                + "FROM usuario "
                + "WHERE idusuario = " + this.usuario.getId());
        for (HashMap<String, String> row : table) {
            Usuario u = new Usuario(Integer.parseInt(row.get("idusuario")));
            u.setLogin(row.get("login"));
            u.setNombres(row.get("nombres"));
            u.setApellidos(row.get("apellidos"));
            u.setActivo(row.get("activo").equals("1"));
            this.usuario = u;
        }
    }

    /**
     * Actualiza un usuario en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        if (usuario != null) {
            this.conexion.update("UPDATE usuario SET "
                    + "login = '" + this.usuario.getLogin() + "', "
                    + "nombres = '" + this.usuario.getNombres() + "', "
                    + "apellidos = '" + this.usuario.getApellidos() + "', "
                    + "activo = " + (this.usuario.isActivo() ? "1" : "0") + " "
                    + "WHERE idusuario = " + this.usuario.getId());
        }
    }

    /**
     * Actualiza la contraseña de un usuario en la base de datos
     *
     * @param contrasenia Nueva contraseña del usuario
     * @throws SQLException
     */
    public void actualizarContrasenia(String contrasenia) throws SQLException {
        if (usuario != null) {
            this.conexion.update("UPDATE usuario SET "
                    + "contrasenia = MD5('" + this.usuario.getLogin() + "') "
                    + "WHERE idusuario = " + this.usuario.getId());
        }
    }

    /**
     * Elimina un usuario de la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (usuario != null) {
            this.conexion.update(
                    "DELETE "
                    + "FROM usuario "
                    + "WHERE idusuario = " + this.usuario.getId());
        }
    }

    /**
     * Inserta un usuario en un grupo en la base de datos
     *
     * @param grupo Grupo en el que se desea insertar al usuario
     * @throws SQLException
     */
    public void insertarUsuarioEnGrupo(Grupo grupo) throws SQLException {
        if (usuario != null) {
            this.conexion.insert(
                    "INSERT INTO usuariogrupo "
                    + "(idusuario, idgrupo) "
                    + "VALUES "
                    + "(" + this.usuario.getId() + ", " + grupo.getId() + ")");
        }
    }

    /**
     * Elimina un usuario de un grupo en la base de datos
     *
     * @param grupo Grupo del que se desea eliminar al usuario
     * @throws SQLException
     */
    public void eliminarUsuarioEnGrupo(Grupo grupo) throws SQLException {
        if (usuario != null) {
            this.conexion.delete("DELETE "
                    + "FROM usuariogrupo "
                    + "WHERE idusuario = " + this.usuario.getId()
                    + " AND idgrupo = " + grupo.getId());
        }
    }

    /**
     * Trae los grupos en los que actualmente se encuentra el usuario
     *
     * @return Grupos en los que actualmente se encuentra el usuario
     * @throws java.sql.SQLException
     */
    public ArrayList<Grupo> listarGruposActuales() throws SQLException {
        ArrayList<Grupo> grupos = new ArrayList<>();
        if (usuario != null) {
            ArrayList<HashMap<String, String>> table = this.conexion.select(
                    "SELECT idgrupo, nombre, grupoActivo "
                    + "FROM vw_usuariogrupo "
                    + "WHERE idusuario = " + this.usuario.getId());
            for (HashMap<String, String> row : table) {
                Grupo g = new Grupo(Integer.parseInt(row.get("idgrupo")));
                g.setNombre(row.get("nombre"));
                g.setActivo(row.get("grupoActivo").equals("1"));
                grupos.add(g);
            }
        }
        return grupos;
    }

    /**
     * Trae los grupos en los que actualmente no se encuentra el usuario
     *
     * @return Grupos en los que actualmente no se encuentra el usuario
     * @throws java.sql.SQLException
     */
    public ArrayList<Grupo> listarGruposExcluidos() throws SQLException {
        ArrayList<Grupo> grupos = new ArrayList<>();
        if (usuario != null) {
            ArrayList<HashMap<String, String>> table = this.conexion.select(
                    "SELECT idgrupo, nombre, activo "
                    + "FROM grupo "
                    + "WHERE idgrupo NOT IN ("
                    + "SELECT idgrupo "
                    + "FROM usuariogrupo "
                    + "WHERE idusuario = " + this.usuario.getId()
                    + ")");
            for (HashMap<String, String> row : table) {
                Grupo g = new Grupo(Integer.parseInt(row.get("idgrupo")));
                g.setNombre(row.get("nombre"));
                g.setActivo(row.get("activo").equals("1"));
                grupos.add(g);
            }
        }
        return grupos;
    }
    //</editor-fold>
}
