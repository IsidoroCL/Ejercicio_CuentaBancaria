import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.io.*;

/**
 *
 * @author Isidoro
 */
public class AplicacionCuentaBancaria extends JFrame implements ActionListener{
    //Declara todos los menús
    AplicacionCuentaBancaria ventana_principal;
    
    JMenuBar MBar;
    JMenu MNuevo;
    JMenuItem MNuevoCuentaAhorro;
    JMenuItem MNuevoCuentaEmpresa;
    JMenuItem MNuevoCuentaPersonal;
    JMenuItem MListado;
    JMenuItem MDatos;
    JMenu MOperar;
    JMenuItem MIngresar;
    JMenuItem MRetirar;
    JMenuItem MConsultar;
    JMenuItem MSalir;
    
    JPanel formulario;
    JLabel label;
    JTextField textfield;
    JButton boton;
    
    Contenedor c;
    FormularioA formA = new FormularioA();
    FormularioB formB = new FormularioB();
    FormularioC formC = new FormularioC();
    Listado list = new Listado();
    
    //Array que almacena las cuentas corrientes
    public static ArrayList<CuentaBancaria> Cuentas = new ArrayList<>();
    
    public static void main(String[] args) {
        
        AplicacionCuentaBancaria ventana_principal = new AplicacionCuentaBancaria();
        ventana_principal.setSize(800, 600);
        ventana_principal.setLocationRelativeTo(null);
        ventana_principal.setVisible(true);
        ventana_principal.cargar();
        
    }
    
    public AplicacionCuentaBancaria() {
        //Abrir fichero
        

        //Creacion de la ventana de la aplicación
        MBar = new JMenuBar();
        MNuevo = new JMenu("Nueva Cuenta");
        MNuevoCuentaAhorro = new JMenuItem("Cuenta de ahorro");
        MNuevoCuentaEmpresa = new JMenuItem("Cuenta Corriente de Empresa");
        MNuevoCuentaPersonal = new JMenuItem("Cuenta Corriente Personal");
        MListado = new JMenuItem("Lista de cuentas");
        
        MOperar = new JMenu("Operaciones");
        MIngresar = new JMenuItem("Ingresar");
        MRetirar = new JMenuItem("Retirar");
        MConsultar = new JMenuItem("Consultar");
        MSalir = new JMenuItem("Salir");
        
        //Añadir listener
        MNuevoCuentaAhorro.addActionListener(this);
        MNuevoCuentaEmpresa.addActionListener(this);
        MNuevoCuentaPersonal.addActionListener(this);
        MListado.addActionListener(this);
        
        MIngresar.addActionListener(this);
        MRetirar.addActionListener(this);
        MConsultar.addActionListener(this);
        MSalir.addActionListener(this);
        
        //Construir barra de menús
        MBar.add(MNuevo);
        MBar.add(MListado);
        
        MBar.add(MOperar);
        MBar.add(MSalir);
        
        MNuevo.add(MNuevoCuentaAhorro);
        MNuevo.add(MNuevoCuentaEmpresa);
        MNuevo.add(MNuevoCuentaPersonal);
        MOperar.add(MIngresar);
        MOperar.add(MRetirar);
        MOperar.add(MConsultar);
        
        setJMenuBar(MBar);
        setResizable(false);
        
        //constructor Panel contenedor
        add(c = new  Contenedor());
        
        //Deshabilito las operaciones, se habilitan en la pestaña listado
        MIngresar.setEnabled(false);
            MRetirar.setEnabled(false);
            MConsultar.setEnabled(false);
        
               
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
        //Evalua el botón del menú pulsado
        if (e.getSource() == MNuevoCuentaAhorro) {
            cuentaAhorroVisible();
        }
        if (e.getSource() == MNuevoCuentaEmpresa) {
            cuentaEmpresaVisible();
        }
        if (e.getSource() == MNuevoCuentaPersonal) {
            cuentaPersonalVisible();
        }
        
        if (e.getSource() == MListado) {
            c.add(list);
            formA.setVisible(false);
            formB.setVisible(false);
            formC.setVisible(false);
            list.setVisible(true);
            list.mostrarDatos(Cuentas);
            MIngresar.setEnabled(true);
            MRetirar.setEnabled(true);
            MConsultar.setEnabled(true);
            c.validate(); //Actualiza la vista
        }
        
        if (e.getSource() == MIngresar) {
            String x1 = JOptionPane.showInputDialog("Introduzca el dinero a ingresar en la cuenta seleccionada: ");
            try {
                double x2 = Double.parseDouble(x1);
                list.cambiarSaldo(x2);
            } catch (Exception z) {
                JOptionPane.showMessageDialog(null, "No se ha introducido una cantidad válida", "Ingresar", JOptionPane.ERROR_MESSAGE);
            }
            
        }
        if (e.getSource() == MRetirar) {
           String y1 = JOptionPane.showInputDialog("Introduzca el dinero a retirar en la cuenta seleccionada: ");
            try {
                double y2 = Double.parseDouble(y1);
                list.cambiarSaldo(-y2);
            } catch (Exception z) {
                JOptionPane.showMessageDialog(null, "No se ha introducido una cantidad válida", "Ingresar", JOptionPane.ERROR_MESSAGE);
            } 
           
        }
        if (e.getSource() == MConsultar) {
            CuentaBancaria cuenta = list.consulta();
            consultar(cuenta);
            //Permite elegir cuenta y consultar saldo
        }
        if (e.getSource() == MSalir) {
            //Guarda los clientes
            guardar(Cuentas);
            //Cierra la aplicación
            System.exit(0);
        }
    }
    
    public static boolean ValidaCCC(String ccc) {
        boolean valido = false;
        ccc = ccc.trim();
        ccc = ccc.replace(" ", "");
        int digitos = ccc.length();
        if (digitos == 20) {
            
            //Calculo primer número de control
            int sumatorio = (Integer.parseInt(ccc.substring(0, 1))*4)+
                    (Integer.parseInt(ccc.substring(1, 2))*8)+
                    (Integer.parseInt(ccc.substring(2, 3))*5)+
                    (Integer.parseInt(ccc.substring(3, 4))*10)+
                    (Integer.parseInt(ccc.substring(4, 5))*9)+
                    (Integer.parseInt(ccc.substring(5, 6))*7)+
                    (Integer.parseInt(ccc.substring(6, 7))*3)+
                    (Integer.parseInt(ccc.substring(7, 8))*6);
            //JOptionPane.showMessageDialog(null, "Sumatorio es: "+sumatorio, "Dígitos de Control", JOptionPane.INFORMATION_MESSAGE);
            int DC1 = 11 - (sumatorio % 11);
            if (DC1 == 10) DC1 = 1;
            if (DC1 == 11) DC1 = 0;
            
                        
            //Calculo segundo número de control
            int sumatorio2 = (Integer.parseInt(ccc.substring(10, 11)))+
                    (Integer.parseInt(ccc.substring(11, 12))*2)+
                    (Integer.parseInt(ccc.substring(12, 13))*4)+
                    (Integer.parseInt(ccc.substring(13, 14))*8)+
                    (Integer.parseInt(ccc.substring(14, 15))*5)+
                    (Integer.parseInt(ccc.substring(15, 16))*10)+
                    (Integer.parseInt(ccc.substring(16, 17))*9)+
                    (Integer.parseInt(ccc.substring(17, 18))*7)+
                    (Integer.parseInt(ccc.substring(18, 19))*3)+
                    (Integer.parseInt(ccc.substring(19, 20))*6);
            int DC2 = 11 - (sumatorio2 % 11);
            if (DC2 == 10) DC2 = 1;
            if (DC2 == 11) DC2 = 0;
            JOptionPane.showMessageDialog(null, "Los dígitos de control calculados son: "+DC1+DC2, "Dígitos de Control", JOptionPane.INFORMATION_MESSAGE);
            
            //Comprueba el dígito de control
            if (DC1 == Integer.parseInt(ccc.substring(8,9)) && DC2 == Integer.parseInt(ccc.substring(9,10))) {
                valido = true;
            }
            
        } else {JOptionPane.showMessageDialog(null, "La cuenta no tiene 20 dígitos", "Validar Cuenta", JOptionPane.INFORMATION_MESSAGE); }
        return valido;
    }
    
    private void guardar(ArrayList Cuentas) {
        //Guarda el archivo en un .dat
        //File fi = new File("clientes.dat");
        try {
            
            ObjectOutputStream guardar = new ObjectOutputStream(new FileOutputStream("clientes.dat"));
            guardar.writeObject(Cuentas);
            guardar.close();
            JOptionPane.showMessageDialog(null, "Cuentas guardadas", "Guardar cuentas", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
             String error = e.getMessage();
            JOptionPane.showMessageDialog(null, error, "Guardar cuentas", JOptionPane.ERROR_MESSAGE);
        }
                
    }
    
    private void cargar() {
        //Cargar archivo .dat
        //File fi = new File("clientes.dat");
        try {

            ObjectInputStream cargar = new ObjectInputStream(new FileInputStream("clientes.dat"));
            Cuentas = (ArrayList<CuentaBancaria>) cargar.readObject();
            
        } catch (Exception e) {
            String error = e.getMessage();
            JOptionPane.showMessageDialog(null, "No se ha podido cargar el archivo de los clientes. \nSi es la primera vez que abre este programa este mensaje es normal.\n"+ error, "Cargar cuentas", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void cuentaAhorroVisible() {
            c.add(formA);
            formB.setVisible(false);
            formC.setVisible(false);
            formA.setVisible(true);
            list.setVisible(false);
            c.validate(); //Actualiza la vista
            MIngresar.setEnabled(false);
            MRetirar.setEnabled(false);
            MConsultar.setEnabled(false);
            formA.activarBoton();
    }
    
    private void cuentaEmpresaVisible() {
            c.add(formB);
            formA.setVisible(false);
            formB.setVisible(true);
            formC.setVisible(false);
            list.setVisible(false);
            c.validate(); //Actualiza la vista
            MIngresar.setEnabled(false);
            MRetirar.setEnabled(false);
            MConsultar.setEnabled(false);
            formB.activarBoton();
    }
    
    private void cuentaPersonalVisible() {
            c.add(formC);
            formA.setVisible(false);
            formB.setVisible(false);
            formC.setVisible(true);
            list.setVisible(false);
            c.validate(); //Actualiza la vista
            MIngresar.setEnabled(false);
            MRetirar.setEnabled(false);
            MConsultar.setEnabled(false);
            formC.activarBoton();
    }
    
    public void consultar(CuentaBancaria cuenta) {
        String nombreClase = cuenta.getClass().getSimpleName();
        switch (nombreClase) {
            case "CuentaAhorro": 
                cuentaAhorroVisible();
                formA.mostrarDatos(cuenta);
                break;
            case "CuentaEmpresa": 
                cuentaEmpresaVisible();
                formB.mostrarDatos(cuenta);
                break;
            case "CuentaPersonal": 
                cuentaPersonalVisible();
                formC.mostrarDatos(cuenta);
                break;
        }
    }
    
    
    
}
