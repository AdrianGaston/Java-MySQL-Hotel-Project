package br.com.silbeckpro.hotelcontinentaljpa.gui;

import br.com.silbeckpro.hotelcontinentaljpa.Reserva;
import br.com.silbeckpro.hotelcontinentaljpa.persistencia.ReservasDAO;
import java.awt.Font;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class TelaCheckOut extends javax.swing.JFrame {
    private TelaCheckOut checkOut;
    public List<Reserva> listaCheckout;
    
    public TelaCheckOut(JTable tblCheckOut) {
        initComponents();
        
        //Código para definir o ícone
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icons/Logo.png"));
        this.setIconImage(logo.getImage());
        
        carregarCheckOut();
    }
    
    //Método para carregar os Check-Out
    public void carregarCheckOut() {
        ReservasDAO reservaDAO = new ReservasDAO();
        listaCheckout = reservaDAO.listarCheckOut();
        preencherCheckOut(listaCheckout);
    }
    
    //Método para preencher a tabela
    public void preencherCheckOut(List<Reserva> reservas) {
        if (reservas.isEmpty()) {
            LocalDate hoje = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/y");
            String dataFormatada = hoje.format(formatter);
            
            JOptionPane.showMessageDialog(rootPane, "Não há Check-Out's confirmados para hoje '" + dataFormatada + "'!", "SEM CHECK-OUT'S", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String colunas[] = {"Id", "Nome", "Check-In", "Check-Out", "Quarto", "Total Dias", "Valor Total", "Status"};
        String dados[][] = new String [reservas.size()][colunas.length];
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/y");
        NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
    
        int i = 0;
        for(Reserva r: reservas){
            String totalFormatado = formatoMoeda.format(r.getValorTotal());
            
            dados[i] = new String[]{
                String.valueOf(r.getId()),
                r.getHospede().getNome(),
                r.getCheckin().format(formatter),
                r.getCheckout().format(formatter),
                r.getQuarto().getNumero(),
                String.valueOf(r.getTotalDias()),
                totalFormatado,
                r.getEstatus()
            };
            i++;
        }
        DefaultTableModel model = new DefaultTableModel(dados, colunas);
        tblCheckOut.setModel(model);
        
        //Configura a fonte do cabeçalho
        tblCheckOut.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));
        
        //Ajusta a largura das colunas
        tblCheckOut.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblCheckOut.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblCheckOut.getColumnModel().getColumn(2).setPreferredWidth(75);
        tblCheckOut.getColumnModel().getColumn(3).setPreferredWidth(75);
        tblCheckOut.getColumnModel().getColumn(4).setPreferredWidth(55);
        tblCheckOut.getColumnModel().getColumn(5).setPreferredWidth(60);
        tblCheckOut.getColumnModel().getColumn(6).setPreferredWidth(85);
        tblCheckOut.getColumnModel().getColumn(7).setPreferredWidth(100);
    }
    
    //Método para pegar o ID da reserva
    private long reservaSelecionada() {
        int linhaSelecionada = tblCheckOut.getSelectedRow();
        if (linhaSelecionada != -1) {
            String reservaString = (String) tblCheckOut.getValueAt(linhaSelecionada, 0);            
            return Long.parseLong(reservaString);
        } else {
            JOptionPane.showMessageDialog(rootPane, "Atenção: selecione a reserva para realizar o Check-Out!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            return -1;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCheckOut = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        btnVoltarCheckOut = new javax.swing.JButton();
        btnPagamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CHECK-OUT");

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 22, 45));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Check-Out");

        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setForeground(new java.awt.Color(102, 102, 102));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblCheckOut.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Hóspede", "Check-In", "Check-Out", "Quarto", "Dias", "Valor Total", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblCheckOut.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblCheckOut);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnVoltarCheckOut.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltarCheckOut.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnVoltarCheckOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Sair_1.png"))); // NOI18N
        btnVoltarCheckOut.setText("Sair");
        btnVoltarCheckOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltarCheckOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarCheckOutActionPerformed(evt);
            }
        });

        btnPagamento.setBackground(new java.awt.Color(204, 204, 204));
        btnPagamento.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnPagamento.setForeground(new java.awt.Color(1, 22, 45));
        btnPagamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Pagamento.png"))); // NOI18N
        btnPagamento.setText("Pagamento");
        btnPagamento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(215, 215, 215)
                .addComponent(btnVoltarCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(btnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVoltarCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(321, 321, 321)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVoltarCheckOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarCheckOutActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarCheckOutActionPerformed

    private void btnPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPagamentoActionPerformed
        long reservaId = reservaSelecionada();
        
        if (reservaId != -1) {
            TelaPagamento pagamento = new TelaPagamento(reservaId, this);
            pagamento.setVisible(true);
        } 
    }//GEN-LAST:event_btnPagamentoActionPerformed
    
     /* @param args the command line arguments
     */
    public static void main(String args[]) {
        JTable tblCheckOut = new JTable();
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
            java.util.logging.Logger.getLogger(TelaCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCheckOut.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCheckOut(tblCheckOut).setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPagamento;
    private javax.swing.JButton btnVoltarCheckOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblCheckOut;
    // End of variables declaration//GEN-END:variables
}
