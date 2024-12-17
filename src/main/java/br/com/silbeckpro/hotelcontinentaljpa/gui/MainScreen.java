package br.com.silbeckpro.hotelcontinentaljpa.gui;

import br.com.silbeckpro.hotelcontinentaljpa.Usuario;
import br.com.silbeckpro.hotelcontinentaljpa.persistencia.ReservasDAO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class MainScreen extends javax.swing.JFrame {
    private TelaReservas telaReservas;
    private JTable tblReservas;
    private JTable tblCheckIn;
    private JTable tblCheckOut;
    private Cadastrado hospedeCadastrado;
    private NaoCadastrado cadastroHospede;
    private Usuario usuario;
    private long hospedeId;
    
    public MainScreen(Usuario usuario) {
        this.usuario = usuario;
        
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        
        //Código para definir o ícone da janela
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icons/Logo.png"));
        this.setIconImage(logo.getImage()); 
        
        permissoes();
        
        atualizarNoShow();
        //finalizarCheckOuts();
    }
    
    //Método para configurar as permissões de usuário
    private void permissoes() {
        String tipoUsuario = usuario.getTipo().toLowerCase();
        
        switch (tipoUsuario) {
            case "reservas":
            case "assistente reservas":
                btnCheckIn.setEnabled(false);
                btnCheckOut.setEnabled(false);
                break;
                
            case "financeiro":
                btnCheckIn.setEnabled(false);
                btnCheckOut.setEnabled(false);
                btnOcupacaoAtual.setEnabled(false);
                break;
                
            case "recepção": 
                btnConfiguracoes.setEnabled(false);
                break;
                
            case "rh":
            case "compras":
                btnReservas.setEnabled(false);
                btnCheckIn.setEnabled(false);
                btnCheckOut.setEnabled(false);
                btnOcupacaoAtual.setEnabled(false);
                break;
                
            default:
                System.out.println("Tipo de usuário não reconhecido: " + tipoUsuario);
                break;
        }
    }
    //Método para mudar o status ds reservas que gerou "No Show"
    private void atualizarNoShow() {
        ReservasDAO reservaDAO = new ReservasDAO();
        reservaDAO.setNoShow();
    }
    
    //Método para encerrar os Check-Out's não feitos
    private void finalizarCheckOuts() {
        ReservasDAO reservaDAO = new ReservasDAO();
        reservaDAO.encerrarCheckOuts();
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnOpcoes = new javax.swing.JButton();
        btnReservas = new javax.swing.JButton();
        btnCheckIn = new javax.swing.JButton();
        btnCheckOut = new javax.swing.JButton();
        btnOcupacaoAtual = new javax.swing.JButton();
        btnConfiguracoes = new javax.swing.JButton();
        btnSair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbFundo = new javax.swing.JLabel();
        lbSilbeck = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("HOTEL CONTINENTAL");

        jPanel1.setBackground(new java.awt.Color(1, 22, 45));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnOpcoes.setBackground(new java.awt.Color(1, 22, 45));
        btnOpcoes.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnOpcoes.setForeground(new java.awt.Color(255, 240, 211));
        btnOpcoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Opcoes.png"))); // NOI18N
        btnOpcoes.setText("Opções");
        btnOpcoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOpcoes.setNextFocusableComponent(btnReservas);
        btnOpcoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOpcoesActionPerformed(evt);
            }
        });
        jPanel1.add(btnOpcoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 6, 205, -1));

        btnReservas.setBackground(new java.awt.Color(1, 22, 45));
        btnReservas.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnReservas.setForeground(new java.awt.Color(255, 240, 211));
        btnReservas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Reserva.png"))); // NOI18N
        btnReservas.setText("Reservas");
        btnReservas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnReservas.setNextFocusableComponent(btnCheckIn);
        btnReservas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReservasActionPerformed(evt);
            }
        });
        jPanel1.add(btnReservas, new org.netbeans.lib.awtextra.AbsoluteConstraints(21, 104, 205, 80));

        btnCheckIn.setBackground(new java.awt.Color(1, 22, 45));
        btnCheckIn.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnCheckIn.setForeground(new java.awt.Color(255, 240, 211));
        btnCheckIn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Check-In.png"))); // NOI18N
        btnCheckIn.setText("Check-In");
        btnCheckIn.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCheckIn.setNextFocusableComponent(btnCheckOut);
        btnCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckInActionPerformed(evt);
            }
        });
        jPanel1.add(btnCheckIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 205, 80));

        btnCheckOut.setBackground(new java.awt.Color(1, 22, 45));
        btnCheckOut.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnCheckOut.setForeground(new java.awt.Color(255, 240, 211));
        btnCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Check-Out.png"))); // NOI18N
        btnCheckOut.setText("Check-Out");
        btnCheckOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCheckOut.setNextFocusableComponent(btnOcupacaoAtual);
        btnCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckOutActionPerformed(evt);
            }
        });
        jPanel1.add(btnCheckOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, 205, 80));

        btnOcupacaoAtual.setBackground(new java.awt.Color(1, 22, 45));
        btnOcupacaoAtual.setFont(new java.awt.Font("Baskerville Old Face", 1, 14)); // NOI18N
        btnOcupacaoAtual.setForeground(new java.awt.Color(255, 240, 211));
        btnOcupacaoAtual.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Ocupacao.png"))); // NOI18N
        btnOcupacaoAtual.setText("Ocupação Atual");
        btnOcupacaoAtual.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnOcupacaoAtual.setNextFocusableComponent(btnConfiguracoes);
        btnOcupacaoAtual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOcupacaoAtualActionPerformed(evt);
            }
        });
        jPanel1.add(btnOcupacaoAtual, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 205, -1));

        btnConfiguracoes.setBackground(new java.awt.Color(1, 22, 45));
        btnConfiguracoes.setFont(new java.awt.Font("Baskerville Old Face", 1, 16)); // NOI18N
        btnConfiguracoes.setForeground(new java.awt.Color(255, 240, 211));
        btnConfiguracoes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Configuracoes.png"))); // NOI18N
        btnConfiguracoes.setText("Configurações");
        btnConfiguracoes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnConfiguracoes.setNextFocusableComponent(btnSair);
        btnConfiguracoes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfiguracoesActionPerformed(evt);
            }
        });
        jPanel1.add(btnConfiguracoes, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 500, 205, 80));

        btnSair.setBackground(new java.awt.Color(1, 22, 45));
        btnSair.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnSair.setForeground(new java.awt.Color(255, 240, 211));
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Sair.png"))); // NOI18N
        btnSair.setText("Sair");
        btnSair.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSair.setNextFocusableComponent(btnOpcoes);
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel1.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 600, 205, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Ajuda.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1330, 620, 30, 60));

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 22, 45));
        jLabel2.setText("Ajuda");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1320, 680, 60, 30));

        lbFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/SinoFundo.jpg"))); // NOI18N
        jPanel1.add(lbFundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(238, 6, 1242, 740));

        lbSilbeck.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        lbSilbeck.setForeground(new java.awt.Color(1, 22, 45));
        lbSilbeck.setText("SilbeckPro");
        jPanel1.add(lbSilbeck, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, 120, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 748, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 6, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnReservasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReservasActionPerformed
        TelaReservas reservas = new TelaReservas(tblReservas, hospedeCadastrado, cadastroHospede, hospedeId);
        reservas.setVisible(true);
    }//GEN-LAST:event_btnReservasActionPerformed

    private void btnCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckInActionPerformed
        TelaCheckIn checkIn = new TelaCheckIn(tblCheckIn);
        checkIn.setVisible(true);
    }//GEN-LAST:event_btnCheckInActionPerformed

    private void btnCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckOutActionPerformed
        TelaCheckOut checkOut = new TelaCheckOut(tblCheckOut);
        checkOut.setVisible(true);
    }//GEN-LAST:event_btnCheckOutActionPerformed

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed
        int resposta = JOptionPane.showConfirmDialog(rootPane, "Sair do sistema SB Hotel", "E AGORA?", JOptionPane.YES_NO_OPTION);
        
        if (resposta == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_btnSairActionPerformed

    private void btnOpcoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOpcoesActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Esta funcionalidade ainda não está disponível.", "AVISO", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnOpcoesActionPerformed

    private void btnConfiguracoesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfiguracoesActionPerformed
        JOptionPane.showMessageDialog(rootPane, "Esta funcionalidade ainda não está disponível.", "AVISO", JOptionPane.WARNING_MESSAGE);
    }//GEN-LAST:event_btnConfiguracoesActionPerformed

    private void btnOcupacaoAtualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOcupacaoAtualActionPerformed
        TelaOcupacaoAtual ocupacao = new TelaOcupacaoAtual();
        ocupacao.setVisible(true);
    }//GEN-LAST:event_btnOcupacaoAtualActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Usuario usuario = new Usuario();
                new MainScreen(usuario).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheckIn;
    private javax.swing.JButton btnCheckOut;
    private javax.swing.JButton btnConfiguracoes;
    private javax.swing.JButton btnOcupacaoAtual;
    private javax.swing.JButton btnOpcoes;
    private javax.swing.JButton btnReservas;
    private javax.swing.JButton btnSair;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbFundo;
    private javax.swing.JLabel lbSilbeck;
    // End of variables declaration//GEN-END:variables
}
