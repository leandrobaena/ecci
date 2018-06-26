package ecci.dal;

import ecci.entidades.Grupo;
import ecci.database.ConexionMySQL;
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
    public ArrayList<Grupo> listar() throws SQLException {
        ArrayList<HashMap<String, String>> table = this.conexion.select("SELECT idgrupo, nombre FROM grupo");
        ArrayList<Grupo> lista = new ArrayList<>();
        for (HashMap<String, String> row : table) {
            Grupo g = new Grupo(Integer.parseInt(row.get("idgrupo")));
            g.setNombre(row.get("nombre"));
            lista.add(g);
        }
        return lista;
    }
    //</editor-fold>
}
