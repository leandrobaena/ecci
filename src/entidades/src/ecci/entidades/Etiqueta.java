package ecci.entidades;

/**
 * Etiqueta por la que se realiza la búqueda de neceidades y software que las
 * satisface
 *
 * @author
 */
public class Etiqueta {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Identificador de la etiqueta
     */
    private int id;

    /**
     * Nombre de la etiqueta
     */
    private String nombre;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Contructores">
    /**
     * Constructor por defecto de la etiqueta
     */
    public Etiqueta() {
        this.id = 0;
        this.nombre = "";
    }

    /**
     * Crea una etiqueta con un identificador determinado
     *
     * @param id Identificador de la etiqueta
     */
    public Etiqueta(int id) {
        this.id = id;
        this.nombre
                = "";
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la etiqueta
     *
     * @return El identificador de la etiqueta
     */
    public int getId() {
        return this.id;
    }

    /**
     * Cambia el identificador de la etiqueta
     *
     * @param id El nuevo identificador de la etiqueta
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae el nombre de la etiqueta
     *
     * @return El nombre de la etiqueta
     */
    public String getNombre() {
        return this.nombre;
    }

    /**
     * Cambia el nombre de la etiqueta
     *
     * @param nombre El nuevo nombre de la etiqueta
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna una representación del objeto en formato JSON
     *
     * @return Representación del objeto en formato JSON
     */
    @Override
    public String toString() {
        return "{\"id\": " + this.id + ","
                + "\"nombre\": \"" + this.nombre + "\""
                + "}";
    }
    //</editor-fold>
}
