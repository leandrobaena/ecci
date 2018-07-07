package ecci.dal;

import ecci.entidades.Permiso;
import ecci.database.ConexionMySQL;
import ecci.entidades.Grupo;
import ecci.entidades.Modulo;
import ecci.entidades.NivelAcceso;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 *
 * @author
 */
public class PermisoDAL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Permiso que se desea persistir en base de datos
     */
    private Permiso permiso;

    /**
     * Conexión a la base de datos
     */
    private ConexionMySQL conexion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea una nueva instancia del administrador de persistencia de los
     * permisos
     *
     * @param propiedadesBd Propiedades de la conexión a la base de datos
     * @throws IOException Si no encuentra el archivo de configuración de la
     * base de datos
     */
    public PermisoDAL(Properties propiedadesBd) throws IOException {
        this.conexion = new ConexionMySQL(propiedadesBd);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el permiso que actualmente se está persistiendo
     *
     * @return Permiso que actualmente se está persistiendo
     */
    public Permiso getPermiso() {
        return this.permiso;
    }

    /**
     * Cambia el permiso que actualmente se está persistiendo
     *
     * @param permiso Nuevo permiso que actualmente se está persistiendo
     */
    public void setPermiso(Permiso permiso) {
        this.permiso = permiso;
    }

    /**
     * Trae el listado de permisos desde la base de datos
     *
     * @return Listado de permisos desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Permiso> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idpermiso, idgrupo, grupo, grupoActivo, idnivelacceso, nivelacceso, idmodulo, modulo, moduloActivo "
                + "FROM vw_permiso");
        ArrayList<Permiso> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Permiso p = new Permiso(Integer.parseInt(row.get("idpermiso")));
            p.setGrupo(new Grupo(Integer.parseInt(row.get("idgrupo"))));
            p.getGrupo().setNombre(row.get("grupo"));
            p.getGrupo().setActivo(row.get("grupoActivo").equals("1"));
            p.setNivelAcceso(new NivelAcceso(Integer.parseInt(row.get("idnivelacceso"))));
            p.getNivelAcceso().setNombre(row.get("nivelacceso"));
            p.setModulo(new Modulo(Integer.parseInt(row.get("idmodulo"))));
            p.getModulo().setNombre(row.get("modulo"));
            p.getModulo().setActivo(row.get("moduloActivo").equals("1"));
            lista.add(p);
        }
        return lista;
    }

    /**
     * Inserta un nuevo permiso en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        if (permiso != null) {
            this.permiso.setId(this.conexion.insert(
                    "INSERT INTO permiso "
                    + "(idgrupo, idnivelacceso, idmodulo) "
                    + "VALUES "
                    + "(" + this.permiso.getGrupo().getId() + ", "
                    + this.permiso.getNivelAcceso().getId() + ", "
                    + this.permiso.getModulo().getId() + ")"));
        }
    }

    /**
     * Carga un permiso desde la base de datos
     *
     * @throws SQLExcseption
     */
    public void cargar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select(
                "SELECT idgrupo, grupo, grupoActivo, idnivelacceso, nivelacceso, idmodulo, modulo, moduloActivo "
                + "FROM vw_permisos "
                + "WHERE idpermiso = " + this.permiso.getId());
        for (HashMap<String, String> row : table) {
            Permiso p = new Permiso(Integer.parseInt(row.get("idpermiso")));
            p.setGrupo(new Grupo(Integer.parseInt(row.get("idgrupo"))));
            p.getGrupo().setNombre(row.get("grupo"));
            p.getGrupo().setActivo(row.get("grupoActivo").equals("1"));
            p.setNivelAcceso(new NivelAcceso(Integer.parseInt(row.get("idnivelacceso"))));
            p.getNivelAcceso().setNombre(row.get("nivelacceso"));
            p.setModulo(new Modulo(Integer.parseInt(row.get("idmodulo"))));
            p.getModulo().setNombre(row.get("modulo"));
            p.getModulo().setActivo(row.get("moduloActivo").equals("1"));
            this.permiso = p;
        }
    }

    /**
     * Actualiza un permiso en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        if (permiso != null) {
            this.conexion.update(
                    "UPDATE permiso SET "
                    + "idgrupo = " + this.permiso.getGrupo().getId() + ", "
                    + "idnivelacceso = " + this.permiso.getNivelAcceso().getId() + ", "
                    + "idmodulo = " + this.permiso.getModulo().getId()
                    + " WHERE idpermiso = " + this.permiso.getId());
        }
    }

    /**
     * Elimina un permiso en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        if (permiso != null) {
            this.conexion.update(
                    "DELETE FROM permiso "
                    + "WHERE idpermiso = " + this.permiso.getId());
        }
    }
    //</editor-fold>
}
