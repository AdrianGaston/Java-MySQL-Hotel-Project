
package br.com.silbeckpro.hotelcontinentaljpa.gui;

import br.com.silbeckpro.hotelcontinentaljpa.Credito;
import br.com.silbeckpro.hotelcontinentaljpa.Pagamento;
import br.com.silbeckpro.hotelcontinentaljpa.persistencia.ReservasDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class TelaCredito extends javax.swing.JFrame {
    private double valorTotal;
    private long reservaId;
    private TelaCheckOut checkOut;
    
    public TelaCredito(long reservaId, TelaCheckOut checkOut) {
        this.reservaId = reservaId;
        this.valorTotal = valorTotal;
        this.checkOut = checkOut;
        
        //Código para definir o ícone
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icons/Logo.png"));
        this.setIconImage(logo.getImage());
        
        initComponents();
        desabilitar();
        valorTotalReserva();
    }
    
    //Método para desabilitar a label e textfield
    public void desabilitar () {
        if (lbNumeroParcelas != null) {
            lbNumeroParcelas.setVisible(false);
        }
        if (ftfNumeroParcelas != null) {
            ftfNumeroParcelas.setVisible(false);
            ftfNumeroParcelas.setEnabled(false);
        }
    }
    
    //Método para obter o valor total dareserva
    public void valorTotalReserva() {
        ReservasDAO reservaDAO = new ReservasDAO();
        valorTotal = reservaDAO.getValorReserva(reservaId);
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        rbAvista = new javax.swing.JRadioButton();
        rbParcelado = new javax.swing.JRadioButton();
        lbNumeroParcelas = new javax.swing.JLabel();
        ftfNumeroParcelas = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btnPagar = new javax.swing.JButton();
        btnVoltarCredito = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRÉDITO");

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 22, 45));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Crédito");

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 22, 45));
        jLabel2.setText("Selecione o tipo de crédito");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        rbAvista.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbAvista);
        rbAvista.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        rbAvista.setForeground(new java.awt.Color(1, 22, 45));
        rbAvista.setText("À vista");
        rbAvista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbAvistaActionPerformed(evt);
            }
        });

        rbParcelado.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbParcelado);
        rbParcelado.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        rbParcelado.setForeground(new java.awt.Color(1, 22, 45));
        rbParcelado.setText("Parcelado");
        rbParcelado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbParceladoActionPerformed(evt);
            }
        });

        lbNumeroParcelas.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        lbNumeroParcelas.setForeground(new java.awt.Color(1, 22, 45));
        lbNumeroParcelas.setText("Escolha o número de parcelas (Até 6x):");

        try {
            ftfNumeroParcelas.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbAvista, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbParcelado, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(lbNumeroParcelas)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(ftfNumeroParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(rbAvista)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbParcelado)
                    .addComponent(lbNumeroParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ftfNumeroParcelas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnPagar.setBackground(new java.awt.Color(255, 255, 204));
        btnPagar.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnPagar.setForeground(new java.awt.Color(1, 22, 45));
        btnPagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Pagamento.png"))); // NOI18N
        btnPagar.setText("Pagar");
        btnPagar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagarActionPerformed(evt);
            }
        });

        btnVoltarCredito.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltarCredito.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnVoltarCredito.setForeground(new java.awt.Color(1, 22, 45));
        btnVoltarCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Sair_1.png"))); // NOI18N
        btnVoltarCredito.setText("Voltar");
        btnVoltarCredito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltarCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarCreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(btnVoltarCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(123, 123, 123))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(181, 181, 181)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(8, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarCreditoActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarCreditoActionPerformed

    private void btnPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagarActionPerformed
        if (!rbAvista.isSelected() && !rbParcelado.isSelected()) {
            JOptionPane.showMessageDialog(rootPane, "Atenção, nenhum tipo de crédito foi selecionado", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        } else {
            
            if (rbAvista.isSelected()) {
                
                int resposta = JOptionPane.showConfirmDialog(rootPane, "Confirma o pagamento à vista no crédito?", "CRÉDITO À VISTA", JOptionPane.YES_NO_OPTION);
                
                if (resposta == JOptionPane.YES_OPTION) {
                    Pagamento aVista = new Credito(true, 0);
                    aVista.setValor(valorTotal);
                    
                    ReservasDAO reservaDAO = new ReservasDAO();
                    reservaDAO.fazerCheckOut(reservaId);
                    
                    JOptionPane.showMessageDialog(rootPane, aVista.toString(), "CONFIRMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                    checkOut.carregarCheckOut();
                    dispose();
                    
                    if (checkOut.listaCheckout.isEmpty()) {
                        checkOut.dispose();
                    }
                }     
            } else {
                if (ftfNumeroParcelas.getText().trim().isEmpty() || ftfNumeroParcelas == null) {
                    JOptionPane.showMessageDialog(rootPane, "Atenção, não foi informado o número de parcelas", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                } else {
                    int numParcelas = Integer.parseInt(ftfNumeroParcelas.getText());
                    
                    if (numParcelas > 0 && numParcelas <= 6) {
                        
                        int resposta = JOptionPane.showConfirmDialog(rootPane, "Confirma o pagamento no crédito em " + numParcelas + "x?", "CRÉDITO À VISTA", JOptionPane.YES_NO_OPTION);
                        
                        if (resposta == JOptionPane.YES_OPTION) {
                            Pagamento parcelado = new Credito(false, numParcelas);
                            parcelado.setValor(valorTotal);
                            
                            ReservasDAO reservaDAO = new ReservasDAO();
                            reservaDAO.fazerCheckOut(reservaId);
                            
                            JOptionPane.showMessageDialog(rootPane, parcelado.toString(), "CONFIRMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
                            checkOut.carregarCheckOut();
                            dispose();
                            
                            if (checkOut.listaCheckout.isEmpty()) {
                                checkOut.dispose();
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Por favor, insira um número válido entre 1 e 6!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                    }                  
                }
            }
        }
    }//GEN-LAST:event_btnPagarActionPerformed

    private void rbParceladoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbParceladoActionPerformed
        lbNumeroParcelas.setVisible(true);
        ftfNumeroParcelas.setVisible(true);
        ftfNumeroParcelas.setEnabled(true); 
    }//GEN-LAST:event_rbParceladoActionPerformed

    private void rbAvistaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbAvistaActionPerformed
        desabilitar();
    }//GEN-LAST:event_rbAvistaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCredito.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCredito().setVisible(true);
            }
        });*/
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagar;
    private javax.swing.JButton btnVoltarCredito;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JFormattedTextField ftfNumeroParcelas;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel lbNumeroParcelas;
    private javax.swing.JRadioButton rbAvista;
    private javax.swing.JRadioButton rbParcelado;
    // End of variables declaration//GEN-END:variables
}
