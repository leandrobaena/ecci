package ecci.entidades;

import java.util.Date;

/**
 * Solicitud de búsqueda realizada por un usuario para encontrar uno o varios
 * softwares que satisfagan su necesidades
 *
 * @author
 */
public class Solicitud {

    //<editor-fold defaultstate="collapsed" desc="Atributos">
    /**
     * Identificador de la solicitud
     */
    private int id;

    /**
     * Fecha de la búsqueda
     */
    private Date date;

    /**
     * Email de la persona que realiza la solicitud
     */
    private String email;

    /**
     * Escolaridad de la persona que realiza la solicitud
     */
    private Escolaridad escolaridad;

    /**
     * Ocupación o profesión de la persona que realiza la solicitud
     */
    private Profesion labor;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto de la solicitud
     */
    public Solicitud() {
        this.id = 0;
        this.date = new Date();
        this.email = "";
        this.escolaridad = new Escolaridad();
        this.labor = new Profesion();
    }

    /**
     * Crea una solicitud con un identificador determinado
     *
     * @param id Identificador de la solicitud
     */
    public Solicitud(int id) {
        this.id = id;
        this.date = new Date();
        this.email = "";
        this.escolaridad = new Escolaridad();
        this.labor = new Profesion();
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Métodos">
    /**
     * Trae el identificador de la solicitud
     *
     * @return Identificador de la solicitud
     */
    public int getId() {
        return id;
    }

    /**
     * Cambia el identificador de la solicitud
     *
     * @param id Identificador de la solicitud
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Trae la fecha de la solicitud
     *
     * @return Fecha de la solicitud
     */
    public Date getDate() {
        return date;
    }

    /**
     * Cambia la fecha de la solicitud
     *
     * @param date Nueva fecha de la solicitud
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Trae el email del usuario que hace la solicitud
     *
     * @return Email del usuario que hace la solicitud
     */
    public String getEmail() {
        return email;
    }

    /**
     * Cambia el email del usuario que hace la solicitud
     *
     * @param email Nuevo email del usuario que hace la solicitud
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Trae el nivel de escolaridad del usuario que hace la solicitud
     *
     * @return Nivel de escolaridad del usuario que hace la solicitud
     */
    public Escolaridad getEscolaridad() {
        return escolaridad;
    }

    /**
     * Cambia el nivel de escolaridad del usuario que hace la solicitud
     *
     * @param escolaridad Nuevo nivel de escolaridad del usuario que hace la
     * solicitud
     */
    public void setEscolaridad(Escolaridad escolaridad) {
        this.escolaridad = escolaridad;
    }

    /**
     * Trae la ocupación o profesión del usuario que hace la solicitud
     *
     * @return Ocupación o profesión del usuario que hace la solicitud
     */
    public Profesion getLabor() {
        return labor;
    }

    /**
     * Cambia la ocupación o profesión del usuario que hace la solicitud
     *
     * @param labor Ocupación o profesión del usuario que hace la solicitud
     */
    public void setLabor(Profesion labor) {
        this.labor = labor;
    }
    //</editor-fold>
}
