package prueba;

import ecci.dal.UsuarioDAL;
import ecci.entidades.Grupo;
import ecci.entidades.Usuario;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author
 */
public class Prueba {

    public static void main(String[] args) throws FileNotFoundException, IOException, SQLException {
        Properties p = new Properties();
        p.load(new FileReader("database.properties"));
 
        UsuarioDAL uDal = new UsuarioDAL(p);
        
        Usuario u = new Usuario(1);
        uDal.setUsuario(u);
        
        ArrayList<Grupo> grupos = uDal.listarGruposActuales();
        for (Grupo grupo : grupos) {
            System.err.println(grupo.getNombre());
        }
    }
}
