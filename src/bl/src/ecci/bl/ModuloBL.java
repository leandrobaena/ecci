package ecci.bl;

import ecci.dal.ModuloDAL;
import ecci.entidades.Modulo;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author
 */
public class ModuloBL {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Módulo manipulado
     */
    private Modulo modulo;

    /**
     * Administrador de la persistencia
     */
    private ModuloDAL moduloDAL;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Crea un nuevo módulo con su administrador de persistencia
     *
     * @param id Identificador del módulo
     * @param propiedadesBD Propiedades de conexión a la base de datos
     * @throws IOException
     */
    public ModuloBL(int id, Properties propiedadesBD) throws IOException {
        this.modulo = new Modulo(id);
        this.moduloDAL = new ModuloDAL(propiedadesBD);
        this.moduloDAL.setModulo(modulo);
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador del módulo
     *
     * @return Identificador del módulo
     */
    public int getId() {
        return this.modulo.getId();
    }

    /**
     * Cambia el identificador del módulo
     *
     * @param id Nuevo identificador del módulo
     */
    public void setId(int id) {
        this.modulo.setId(id);
    }

    /**
     * Trae el nombre del módulo
     *
     * @return Nombre del módulo
     */
    public String getNombre() {
        return this.modulo.getNombre();
    }

    /**
     * Cambia el nombre del módulo
     *
     * @param nombre Nuevo nombre del módulo
     */
    public void setNombre(String nombre) {
        this.modulo.setNombre(nombre);
    }

    /**
     * Trae si el módulo está o no activo
     *
     * @return Si el módulo está o no activo
     */
    public boolean isActivo() {
        return this.modulo.isActivo();
    }

    /**
     * Cambia si el módulo está o no activo
     *
     * @param activo Si el módulo está o no activo
     */
    public void setActivo(boolean activo) {
        this.modulo.setActivo(activo);
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return this.modulo.toString();
    }

    /**
     * Trae el listado de módulos desde la base de datos
     *
     * @return Listado de módulos desde la base de datos
     * @throws SQLException
     */
    public ArrayList<Modulo> listar() throws SQLException {
        return this.moduloDAL.listar();
    }

    /**
     * Inserta un nuevo módulo en la base de datos
     *
     * @throws SQLException
     */
    public void insertar() throws SQLException {
        this.moduloDAL.insertar();
    }

    /**
     * Carga un módulo desde la base de datos
     *
     * @throws SQLException
     */
    public void cargar() throws SQLException {
        this.moduloDAL.cargar();
    }

    /**
     * Actualiza un módulo en la base de datos
     *
     * @throws SQLException
     */
    public void actualizar() throws SQLException {
        this.moduloDAL.actualizar();
    }

    /**
     * Elimina un módulo en la base de datos
     *
     * @throws SQLException
     */
    public void eliminar() throws SQLException {
        this.moduloDAL.eliminar();
    }
    //</editor-fold>
}
