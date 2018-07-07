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
    private Date fecha;

    /**
     * Nombre del usuario que hace la solicitud
     */
    private String nombre;
    
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
    private Profesion profesion;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Constructores">
    /**
     * Constructor por defecto de la solicitud
     */
    public Solicitud() {
        this.id = 0;
        this.fecha = new Date();
        this.nombre = "";
        this.email = "";
        this.escolaridad = new Escolaridad();
        this.profesion = new Profesion();
    }

    /**
     * Crea una solicitud con un identificador determinado
     *
     * @param id Identificador de la solicitud
     */
    public Solicitud(int id) {
        this.id = id;
        this.fecha = new Date();
        this.nombre = "";
        this.email = "";
        this.escolaridad = new Escolaridad();
        this.profesion = new Profesion();
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
    public Date getFecha() {
        return fecha;
    }

    /**
     * Cambia la fecha de la solicitud
     *
     * @param fecha Nueva fecha de la solicitud
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Trae el nombre del usuario que realiza la solicitud
     *
     * @return Nombre del usuario que realiza la solicitud
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del usuario que realiza la solicitud
     *
     * @param nombre Nuevo nombre del usuario que realiza la solicitud
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    public Profesion getProfesion() {
        return profesion;
    }

    /**
     * Cambia la ocupación o profesión del usuario que hace la solicitud
     *
     * @param profesion Ocupación o profesión del usuario que hace la solicitud
     */
    public void setProfesion(Profesion profesion) {
        this.profesion = profesion;
    }
    //</editor-fold>
}
