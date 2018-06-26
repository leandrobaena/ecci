package ecci.database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

/**
 * Conexión a la base de datos de MySQL
 *
 * @author
 */
public class ConexionMySQL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Url de conexión a la base de datos
     */
    private String urlConnection;

    /**
     * Usuario con que se conecta a la base de datos
     */
    private String user;

    /**
     * Contraseña con que se conecta a la base de datos
     */
    private String password;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    public ConexionMySQL(Properties propiedadesBd) throws FileNotFoundException, IOException {
        this.urlConnection = propiedadesBd.getProperty("url");
        this.user = propiedadesBd.getProperty("user");
        this.password = propiedadesBd.getProperty("password");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae un conjunto de resultados
     *
     * @param sql Consulta ejecutada
     * @return Conjunto de resultados producto de la consulta
     * @throws SQLException Si hay un error en la consulta
     */
    public ArrayList<HashMap<String, String>> select(String sql) throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(this.urlConnection);
        ds.setUser(this.user);
        ds.setPassword(this.password);

        ArrayList<HashMap<String, String>> table = new ArrayList<>();
        try (Connection connection = ds.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                HashMap<String, String> row = new HashMap<>();
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    row.put(rs.getMetaData().getColumnName(i), rs.getString(i));
                }
                table.add(row);
            }
        }
        return table;
    }
    //</editor-fold>
}
