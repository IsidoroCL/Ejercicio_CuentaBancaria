

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Isidoro
 */
public class Listado extends javax.swing.JPanel {

    /**
     * Creates new form Listado
     */
    public Listado() {
        initComponents();
    }
    
    public void mostrarDatos(ArrayList Cuentas) {
        
        for (int i = 0; i < Cuentas.size(); i++) {
            CuentaBancaria cuenta = (CuentaBancaria) Cuentas.get(i);
            Tb_list.setValueAt(cuenta.titular, i, 0);
            Tb_list.setValueAt(cuenta.ccc, i, 1);
            Tb_list.setValueAt(cuenta.saldo, i, 2);
            Tb_list.setValueAt(cuenta.getClass().getSimpleName(), i, 3);
        }
        
    }
    
    public void cambiarSaldo (double x) {
        int row = Tb_list.getSelectedRow();
        CuentaBancaria cuenta = (CuentaBancaria) AplicacionCuentaBancaria.Cuentas.get(row);
        cuenta.saldo += x;
        AplicacionCuentaBancaria.Cuentas.add(row, cuenta);
        AplicacionCuentaBancaria.Cuentas.remove(row+1);
        mostrarDatos(AplicacionCuentaBancaria.Cuentas);
    }
    
    public CuentaBancaria consulta() {
        int row = Tb_list.getSelectedRow();
        CuentaBancaria cuenta = (CuentaBancaria) AplicacionCuentaBancaria.Cuentas.get(row);
        return cuenta;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Tb_list = new javax.swing.JTable();

        Tb_list.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nombre", "CCC", "Saldo", "Tipo Cuenta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Tb_list);
        if (Tb_list.getColumnModel().getColumnCount() > 0) {
            Tb_list.getColumnModel().getColumn(0).setResizable(false);
            Tb_list.getColumnModel().getColumn(1).setResizable(false);
            Tb_list.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 731, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(140, 140, 140))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tb_list;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
