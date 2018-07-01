package ecci.dal;

import ecci.entidades.Grupo;
import ecci.database.ConexionMySQL;
import ecci.entidades.Usuario;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author
 */
public class GrupoDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Grupo que se desea persistir en base de datos
     */
    private Grupo grupo;

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
    public GrupoDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el grupo que actualmente se está persistiendo
     *
     * @return Grupo que actualmente se está persistiendo
     */
    public Grupo getGrupo() {
        return this.grupo;
    }

    /**
     * Cambia el grupo que actualmente se está persistiendo
     *
     * @param grupo Nuevo grupo que actualmente se está persistiendo
     */
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    /**
     * Trae el listado de grupos desde la base de datos
     *
     * @return Listado de grupos desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Grupo> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idgrupo, nombre "
                + "FROM grupo");
        ArrayList<Grupo> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Grupo g = new Grupo(Integer.parseInt(row.get("idgrupo")));
            g.setNombre(row.get("nombre"));
            g.setActivo(row.get("activo").equals("1"));
            lista.add(g);
        }
        return lista;
    }

    /**
     * Inserta un nuevo grupo en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        if (grupo != null) {
            this.grupo.setId(this.conexion.insert(
                    "INSERT INTO grupo "
                    + "(nombre, activo) "
                    + "VALUES "
                    + "('" + this.grupo.getNombre() + "', "
                    + (this.grupo.isActivo() ? "1" : "0") + ")"));
        }
    }

    /**
     * Carga un grupo desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idgrupo, nombre "
                + "FROM grupo "
                + "WHERE idgrupo = " + this.grupo.getId());
        for (HashMap<String, String> row : table) {
            Grupo g = new Grupo(Integer.parseInt(row.get("idgrupo")));
            g.setNombre(row.get("nombre"));
            g.setActivo(row.get("activo").equals("1"));
            this.grupo = g;
        }
    }

    /**
     * Actualiza un grupo en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        if (grupo != null) {
            this.conexion.update(
                    "UPDATE grupo SET "
                    + "nombre = '" + this.grupo.getNombre() + "', "
                    + "activo = " + (this.grupo.isActivo() ? "1" : "0")
                    + " WHERE idgrupo = " + this.grupo.getId());
        }
    }

    /**
     * Elimina un grupo en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (grupo != null) {
            this.conexion.update(
                    "DELETE FROM grupo "
                    + "WHERE idgrupo = " + this.grupo.getId());
        }
    }

    /**
     * Inserta un usuario en un grupo en la base de datos
     *
     * @param usuario Usuario que se desea insertar al grupo
     * @throws SQLException
     */
    public void insertarUsuarioEnGrupo(Usuario usuario) throws SQLException {
        if (grupo != null) {
            this.conexion.insert(
                    "INSERT INTO usuariogrupo "
                    + "(idusuario, idgrupo) "
                    + "VALUES "
                    + "(" + usuario.getId() + ", " + this.grupo.getId() + ")");
        }
    }

    /**
     * Elimina un usuario de un grupo en la base de datos
     *
     * @param usuario Usuario que se desea eliminar del grupo
     * @throws SQLException
     */
    public void eliminarUsuarioEnGrupo(Grupo usuario) throws SQLException {
        if (grupo != null) {
            this.conexion.delete(
                    "DELETE FROM usuariogrupo "
                    + "WHERE idusuario = " + usuario.getId()
                    + " AND idgrupo = " + this.grupo.getId());
        }
    }

    /**
     * Trae los usuarios que actualmente tiene el grupo
     *
     * @return Usuarios que actualmente tiene el grupo
     * @throws java.sql.SQLException
     */
    public ArrayList<Usuario> listarUsuariosActuales() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        if (grupo != null) {
            ArrayList<HashMap<String, String>> table = this.conexion.select(
                    "SELECT idusuario, login, nombres, apellidos, usuarioActivo "
                    + "FROM vw_usuariogrupo "
                    + "WHERE idgrupo = " + this.grupo.getId());
            for (HashMap<String, String> row : table) {
                Usuario u = new Usuario(Integer.parseInt(row.get("idusuario")));
                u.setLogin(row.get("login"));
                u.setNombres(row.get("nombres"));
                u.setApellidos(row.get("apellidos"));
                u.setActivo(row.get("usuarioActivo").equals("1"));
                usuarios.add(u);
            }
        }
        return usuarios;
    }

    /**
     * Trae los usuarios que actualmente no tiene el grupo
     *
     * @return Usuarios que actualmente no tiene el grupo
     * @throws java.sql.SQLException
     */
    public ArrayList<Usuario> listarUsuariosExcluidos() throws SQLException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        if (grupo != null) {
            ArrayList<HashMap<String, String>> table = this.conexion.select(
                    "SELECT idusuario, login, nombres, apellidos, activo "
                    + "FROM usuario "
                    + "WHERE idusuario NOT IN ("
                    + "SELECT idusuario "
                    + "FROM usuariogrupo "
                    + "WHERE idgrupo = " + this.grupo.getId()
                    + ")");
            for (HashMap<String, String> row : table) {
                Usuario u = new Usuario(Integer.parseInt(row.get("idusuario")));
                u.setLogin(row.get("login"));
                u.setNombres(row.get("nombres"));
                u.setApellidos(row.get("apellidos"));
                u.setActivo(row.get("activo").equals("1"));
                usuarios.add(u);
            }
        }
        return usuarios;
    }
    //</editor-fold>
}
