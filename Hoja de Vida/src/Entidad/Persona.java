package Entidad;

public class Persona {
    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String ci;
    private String telefono;
    private String correo;
    private String direccion;
    private String puesto;
    private String discapacidad;
    private String detalle;
    private String idiomas;
    private String nivel;
    private String habilidades;

    public Persona(String nombres, String apellidos, String fechaNacimiento, String ci, String telefono, String correo, String direccion, String puesto, String discapacidad, String detalle, String idiomas, String nivel, String habilidades) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.ci = ci;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
        this.puesto = puesto;
        this.discapacidad = discapacidad;
        this.detalle = detalle;
        this.idiomas = idiomas;
        this.nivel = nivel;
        this.habilidades = habilidades;
    }

    public int calcularEdad(){
        String[] fecha = fechaNacimiento.split("-");
        int anioNacimiento = Integer.parseInt(fecha[0]);
        return 2025 - anioNacimiento;
    }

    @Override
    public String toString() {
        return "\n=============================================="+
                "\n                  HOJA DE VIDA               "+
                "\n============================================="+
                "\nNombres: "+nombres+ "          Apellidos: "+apellidos+
                "\nCedula de identidad: "+ci+ "           " +
                "\nFecha de nacimiento: "+fechaNacimiento+
                "\nEdad: "+calcularEdad()+" años"+
                "\n"+
                "\nCorreo electrónico: "+correo+
                "\nTeléfono: "+telefono+ "          Dirección: "+direccion+
                "\nPuesto de trabajo: "+puesto+
                "\n"+
                "\nDiscapacidad: "+discapacidad+
                "\nDetalle de discapacidad: "+detalle+
                "\n"+
                "\nIdiomas: "+idiomas+ "         Nivel: "+nivel+
                "\nHabilidades: "+habilidades;
    }
}

