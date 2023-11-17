import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Principal;
    private JTextField txtNombre;
    private JButton btnRegistrar;
    private JTextArea txtListaEmpleados;
    private JButton btnListarEmpleados;
    private JTextField txtCedula;
    private JTextField txtSueldo;
    private JButton btnEliminar;
    private JTabbedPane tabbedPane1;
    private JTextArea txtDeudas;
    private JButton btnListarEndeudados;
    private JTextField txtBuscarCedula;
    private JButton btnBuscar;
    private JTextArea txtListarBuscar;
    private JTextField txtRemplazarNombre;
    private JTextField txtRemplazarSueldo;
    private JButton btnRemplazarEmpleado;
    ListaEmpleados listaEmpleados = new ListaEmpleados();
    Impuesto impuesto = new Impuesto();


    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public Ventana() {

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cedulaLetra = txtCedula.getText();
                if (cedulaLetra.length()==10){
                    try {
                        if (listaEmpleados.soloNumerosComando(cedulaLetra)){
                            int cedula=Integer.parseInt(txtCedula.getText().toString());
                            String nombre = txtNombre.getText();
                            float sueldo=Integer.parseInt(txtSueldo.getText().toString());
                            float seguro=impuesto.seguroSocial(sueldo);
                            float impuestos=impuesto.calcularImpuestoRenta(sueldo);
                            listaEmpleados.agregarEmpleado(new RolEmpleado(cedula,nombre,sueldo,seguro,impuestos));
                            txtListaEmpleados.setText(listaEmpleados.listarEmpleadoSinDeuda());
                        }
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null,ex.getMessage());
                    }
                }else{JOptionPane.showMessageDialog(null,"SIGA EL FORMATO ESTABLECIDO");}
            }
        });
        btnListarEmpleados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListaEmpleados.setText(listaEmpleados.listarEmpleadoSinDeuda().toString());
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                listaEmpleados.eliminarEmpleado();
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnListarEndeudados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                txtDeudas.setText(listaEmpleados.listarEmpleado().toString());
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int cedula=Integer.parseInt(txtBuscarCedula.getText().toString());
                try {
                     txtListarBuscar.setText(listaEmpleados.buscarCedula(cedula).listarEmpleados2());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });
        btnRemplazarEmpleado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtRemplazarNombre.getText().equals("") && txtRemplazarSueldo.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"SI DESEA REMPLAZAR NO DEJE LOS ESPACIOS VACIOS");
                }else {
                    //REMPLAZAR AMBAS
                    if (!txtRemplazarNombre.getText().equals("") && !txtRemplazarSueldo.getText().equals("")) {
                        String nombreNuevo=txtRemplazarNombre.getText();
                        float sueldoNuevo=Integer.parseInt(txtRemplazarSueldo.getText());
                        int cedula=Integer.parseInt(txtBuscarCedula.getText());
                        try {
                            int posicion = listaEmpleados.hallarPosicion(listaEmpleados.buscarCedula(cedula));
                            RolEmpleado nuevoEmpledo=listaEmpleados.remplazarAmbas(nombreNuevo,sueldoNuevo,posicion);
                            listaEmpleados.nuevoEmpleadoExacto(nuevoEmpledo);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null,ex.getMessage());
                        }
                        try {
                            listaEmpleados.eliminarEmpleadoExacto(listaEmpleados.hallarPosicion(listaEmpleados.buscarCedula(Integer.parseInt(txtBuscarCedula.getText()))));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    } else {
                        //REMPLAZAR NOMBRE
                    if (!txtRemplazarNombre.getText().equals("")) {
                        try {
                            RolEmpleado nuevoEmpleado = listaEmpleados.remplazarNombre(txtRemplazarNombre.getText(), listaEmpleados.hallarPosicion(
                                    listaEmpleados.buscarCedula(Integer.parseInt(txtBuscarCedula.getText()))));
                            listaEmpleados.nuevoEmpleadoExacto(nuevoEmpleado);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                        try {
                            listaEmpleados.eliminarEmpleadoExacto(listaEmpleados.hallarPosicion(listaEmpleados.buscarCedula(Integer.parseInt(txtBuscarCedula.getText()))));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                    //REMPLAZAR SUELDO
                    if (!txtRemplazarSueldo.getText().equals("")) {
                        float sueldoNuevo = Integer.parseInt(txtRemplazarSueldo.getText());
                        try {
                            RolEmpleado nuevoEmpleado = listaEmpleados.remplazarSueldo(sueldoNuevo, listaEmpleados.hallarPosicion(
                                    listaEmpleados.buscarCedula(Integer.parseInt(txtBuscarCedula.getText()))));
                            listaEmpleados.nuevoEmpleadoExacto(nuevoEmpleado);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                        try {
                            listaEmpleados.eliminarEmpleadoExacto(listaEmpleados.hallarPosicion(listaEmpleados.buscarCedula(Integer.parseInt(txtBuscarCedula.getText()))));
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage());
                        }
                    }
                }

                }

                int cedula=Integer.parseInt(txtBuscarCedula.getText().toString());
                try {
                    txtListarBuscar.setText(listaEmpleados.buscarCedula(cedula).listarEmpleados2());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }

        });
    }



}
