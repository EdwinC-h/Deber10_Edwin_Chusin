package Entidad;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class HojaDeVida extends JFrame{
    private JLabel lblTitulo;
    private JLabel lblNombre;
    private JLabel lblApellido;
    private JLabel lblPuestoTrabajo;
    private JTextField txtNombres;
    private JTextField txtApellidos;
    private JTextField txtTrabajo;
    private JTextField txtEmail;
    private JTextField txtCelular;
    private JTextField txtLocalidad;
    private JLabel lblCorreo;
    private JLabel lblTelefono;
    private JLabel lblDireccion;
    private JTextField txtFechaNacimiento;
    private JLabel lblNacimiento;
    private JRadioButton rdbSi;
    private JLabel lblDetalles;
    private JTextField txtDetalleDiscapacidad;
    private JLabel lblHabilidades;
    private JCheckBox chkComunicacion;
    private JCheckBox chkLiderazgo;
    private JCheckBox chkTomaDecision;
    private JCheckBox chkTrabajaEnEquipo;
    private JLabel lblIdiomas;
    private JTextField txtIdiomas;
    private JComboBox cbNivel;
    private JLabel lblNivel;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JPanel Panel1;
    private JRadioButton rdbNo;
    private JTextField txtCedula;
    private JLabel lblCedula;
    private JLabel lblTieneDiscapacidad;
    private ButtonGroup grupoDiscapacidad;

    public HojaDeVida() throws HeadlessException {
        setContentPane(Panel1);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,600);
        setLocationRelativeTo(null);

        Panel1.setBorder(
                BorderFactory.createEmptyBorder(20,40,30,0) //Inge es para dejar un espacio vacio en los bordes,
        );                                                                        //esq se ve feo si no esta centrado.
        grupoDiscapacidad = new ButtonGroup();
        grupoDiscapacidad.add(rdbSi);
        grupoDiscapacidad.add(rdbNo);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarDocumento();
            }
        });

        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }
    public void guardarDocumento(){
        String Nombre = txtNombres.getText();
        String Apellido = txtApellidos.getText();
        String FechaDeNacimiento = txtFechaNacimiento.getText();
        String cedula = txtCedula.getText();
        String PuestoDeTrabajo = txtTrabajo.getText();
        String Telefono = txtCelular.getText();
        String Correo = txtEmail.getText();
        String Direccion = txtLocalidad.getText();
        String Idiomas = txtIdiomas.getText();
        String nivel = cbNivel.getSelectedItem().toString();
        String discapacidad = rdbSi.isSelected()?"Si":"No";
        String detalle = txtDetalleDiscapacidad.getText();

        String habilidades = "";
        if (chkLiderazgo.isSelected()) habilidades += "\n    - Liderazgo";
        if (chkComunicacion.isSelected()) habilidades += "\n    - Comunicación efectiva";
        if (chkTomaDecision.isSelected()) habilidades += "\n    - Toma de decisiones";
        if (chkTrabajaEnEquipo.isSelected()) habilidades += "\n    - Trabajo en equipo";

        Persona p1 = new Persona(Nombre, Apellido, FechaDeNacimiento, cedula, Telefono,Correo,Direccion, PuestoDeTrabajo,discapacidad,detalle,Idiomas,nivel,habilidades);

        long tiempo = System.currentTimeMillis();
        String nombreArchivo = "Hoja_vida_"+tiempo+".txt";
        try{
            FileWriter nuevoArchivo = new FileWriter(nombreArchivo,true);
            nuevoArchivo.write(p1.toString());
            nuevoArchivo.close();

            JOptionPane.showMessageDialog(this,"Datos guardados correctamente");

        }catch (IOException ex){
            JOptionPane.showMessageDialog(this,"Error al guardar el archivo");
        }
    }

    public void limpiar(){
        txtNombres.setText("");
        txtApellidos.setText("");
        txtCedula.setText("");
        txtIdiomas.setText("");
        txtCelular.setText("");
        txtDetalleDiscapacidad.setText("");
        txtEmail.setText("");
        txtFechaNacimiento.setText("YYYY-MM-DD");
        txtLocalidad.setText("");
        txtTrabajo.setText("");

        rdbSi.setSelected(false);
        rdbNo.setSelected(false);

        cbNivel.setSelectedIndex(0);

        chkLiderazgo.setSelected(false);
        chkComunicacion.setSelected(false);
        chkTomaDecision.setSelected(false);
        chkTrabajaEnEquipo.setSelected(false);
    }

    public static void main(String[] args) {
        HojaDeVida h1 = new HojaDeVida();
        h1.setVisible(true);
    }
}
