
package br.com.silbeckpro.hotelcontinentaljpa.gui;

import br.com.silbeckpro.hotelcontinentaljpa.Debito;
import br.com.silbeckpro.hotelcontinentaljpa.Dinheiro;
import br.com.silbeckpro.hotelcontinentaljpa.Pagamento;
import br.com.silbeckpro.hotelcontinentaljpa.Pix;
import br.com.silbeckpro.hotelcontinentaljpa.persistencia.ReservasDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class TelaPagamento extends javax.swing.JFrame {
    private long reservaId;
    private double valorTotal;
    private TelaCheckOut checkOut;
    
    public TelaPagamento(long reservaId, TelaCheckOut checkOut) {
       this.reservaId = reservaId;
       this.checkOut = checkOut;
       
        //Código para definir o ícone
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icons/Logo.png"));
        this.setIconImage(logo.getImage());
      
        initComponents();
        getValorReserva();
    }
    
    //Método para carregar o valor da reserva
    public void getValorReserva() {
        ReservasDAO reservaDAO = new ReservasDAO();
        valorTotal = reservaDAO.getValorReserva(reservaId);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        btnVoltarPagamento = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnDebito = new javax.swing.JButton();
        btnPix = new javax.swing.JButton();
        btnDinheiro = new javax.swing.JButton();
        btnCredito = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PAGAMENTO");

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 22, 45));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Pagamento");

        btnVoltarPagamento.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltarPagamento.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnVoltarPagamento.setForeground(new java.awt.Color(255, 51, 51));
        btnVoltarPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Cancelar.png"))); // NOI18N
        btnVoltarPagamento.setText("Cancelar");
        btnVoltarPagamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltarPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarPagamentoActionPerformed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnDebito.setBackground(new java.awt.Color(255, 240, 211));
        btnDebito.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnDebito.setForeground(new java.awt.Color(1, 22, 45));
        btnDebito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Debito.png"))); // NOI18N
        btnDebito.setText("Débito");
        btnDebito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDebito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDebitoActionPerformed(evt);
            }
        });

        btnPix.setBackground(new java.awt.Color(255, 240, 211));
        btnPix.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        btnPix.setForeground(new java.awt.Color(1, 22, 45));
        btnPix.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Pix.png"))); // NOI18N
        btnPix.setText("    PIX");
        btnPix.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPix.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPixActionPerformed(evt);
            }
        });

        btnDinheiro.setBackground(new java.awt.Color(255, 240, 211));
        btnDinheiro.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        btnDinheiro.setForeground(new java.awt.Color(1, 22, 45));
        btnDinheiro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/dinheiro.png"))); // NOI18N
        btnDinheiro.setText("Dinheiro");
        btnDinheiro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnDinheiro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDinheiroActionPerformed(evt);
            }
        });

        btnCredito.setBackground(new java.awt.Color(255, 240, 211));
        btnCredito.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnCredito.setForeground(new java.awt.Color(1, 22, 45));
        btnCredito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Credito.png"))); // NOI18N
        btnCredito.setText("Crédito");
        btnCredito.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCredito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreditoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDinheiro, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addComponent(btnPix, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnDinheiro, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(btnDebito, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCredito, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPix, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(174, 174, 174)
                        .addComponent(jLabel1)
                        .addGap(0, 176, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 6, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnVoltarPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(165, 165, 165))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnVoltarPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCreditoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreditoActionPerformed
        TelaCredito credito = new TelaCredito(reservaId, checkOut);
        credito.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnCreditoActionPerformed
    private void btnVoltarPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarPagamentoActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarPagamentoActionPerformed
    private void btnDinheiroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDinheiroActionPerformed
        int resposta = JOptionPane.showConfirmDialog(rootPane, "Confirma o pagamento em dinheiro?", "DINHEIRO", JOptionPane.YES_NO_OPTION);
            
        if (resposta == JOptionPane.YES_OPTION) {
            Pagamento dinheiro = new Dinheiro();
            dinheiro.setValor(valorTotal);
            
            ReservasDAO reservaDAO = new ReservasDAO();
            reservaDAO.fazerCheckOut(reservaId);
            
            JOptionPane.showMessageDialog(rootPane, dinheiro.toString(), "CONFIRMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            checkOut.carregarCheckOut();
            dispose();
            
            if (checkOut.listaCheckout.isEmpty()) {
                checkOut.dispose();
            }
        }
    }//GEN-LAST:event_btnDinheiroActionPerformed
    private void btnDebitoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDebitoActionPerformed
        int resposta = JOptionPane.showConfirmDialog(rootPane, "Confirma o pagamento no débito?", "DÉBITO", JOptionPane.YES_NO_OPTION);
            
        if (resposta == JOptionPane.YES_OPTION) {
            Pagamento debito = new Debito();
            debito.setValor(valorTotal);
            
            ReservasDAO reservaDAO = new ReservasDAO();
            reservaDAO.fazerCheckOut(reservaId);
            
            
            JOptionPane.showMessageDialog(rootPane, debito.toString(), "CONFIRMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            checkOut.carregarCheckOut();
            dispose();
            
            if (checkOut.listaCheckout.isEmpty()) {
                checkOut.dispose();
            }
        }
    }//GEN-LAST:event_btnDebitoActionPerformed

    private void btnPixActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPixActionPerformed
        int resposta = JOptionPane.showConfirmDialog(rootPane, "Confirma o pagamento via PIX?", "PIX", JOptionPane.YES_NO_OPTION);
            
        if (resposta == JOptionPane.YES_OPTION) {
            Pagamento pix = new Pix();
            pix.setValor(valorTotal);
            
            ReservasDAO reservaDAO = new ReservasDAO();
            reservaDAO.fazerCheckOut(reservaId);
            
            JOptionPane.showMessageDialog(rootPane, pix.toString(), "CONFIRMAÇÃO", JOptionPane.INFORMATION_MESSAGE);
            checkOut.carregarCheckOut();
            dispose();
            
            if (checkOut.listaCheckout.isEmpty()) {
                checkOut.dispose();
            }
        }
    }//GEN-LAST:event_btnPixActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPagamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPagamento().setVisible(true);
            }
        });*/
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCredito;
    private javax.swing.JButton btnDebito;
    private javax.swing.JButton btnDinheiro;
    private javax.swing.JButton btnPix;
    private javax.swing.JButton btnVoltarPagamento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
