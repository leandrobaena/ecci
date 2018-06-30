package prueba;

import ecci.dal.GrupoDAL;
import ecci.entidades.Grupo;
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
        GrupoDAL gDal = new GrupoDAL(p);
        
        /*ArrayList<Grupo> grupos = gDal.listar();
        for (Grupo grupo : grupos) {
            System.out.println(grupo.getNombre());
        }
        */
        Grupo g = new Grupo(2);
        gDal.setGrupo(g);
        gDal.eliminar();
    }
}
