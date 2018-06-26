package database;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * Conexión a la base de dsatos de MySQL
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
    public ConexionMySQL(Properties dbProperties) throws FileNotFoundException, IOException {
        this.urlConnection = dbProperties.getProperty("url");
        this.user = dbProperties.getProperty("user");
        this.password = dbProperties.getProperty("password");
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    public ResultSet select(String sql) throws SQLException {
        MysqlDataSource ds = new MysqlDataSource();
        ds.setURL(this.urlConnection);
        ds.setUser(this.user);
        ds.setPassword(this.password);
        
        Connection connection = ds.getConnection();
        Statement st = connection.createStatement();
        ResultSet rs = st.executeQuery(sql);

        connection.close();
        return rs;
    }
    //</editor-fold>
}
