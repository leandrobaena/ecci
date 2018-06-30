package ecci.entidades;

/**
 * Necesidad que tiene un usuario sobre un software
 *
 * @author
 */
public class Necesidad {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Identificador de la necesidad
     */
    private int id;

    /**
     * Código de la necesidad
     */
    private String codigo;

    /**
     * Descripción de la necesidad
     */
    private String descripcion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto
     */
    public Necesidad() {
        this.id = 0;
        this.codigo = "";
        this.descripcion = "";
    }

    /**
     * Crea una necesidad con un identificador determinado
     */
    public Necesidad(int id) {
        this.id = id;
        this.codigo = "";
        this.descripcion = "";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la necesidad
     *
     * @return Identificador de la necesidad
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador de la necesidad
     *
     * @param id Nuevo identificador de la necesidad
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el código de la necesidad
     *
     * @return Código de la necesidad
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * Cambia el código de la necesidad
     *
     * @param codigo Nuevo código de la necesidad
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    /**
     * Trae la descripción de la necesidad
     *
     * @return
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Cambia la descripción de la necesidad
     *
     * @param descripcion Nueva descripción de la necesidad
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    //</editor-fold>
}
