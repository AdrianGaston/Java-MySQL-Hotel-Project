
package br.com.silbeckpro.hotelcontinentaljpa.gui;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import br.com.silbeckpro.hotelcontinentaljpa.Reserva;
import br.com.silbeckpro.hotelcontinentaljpa.persistencia.ReservasDAO;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.Locale;


public class TelaReservas extends javax.swing.JFrame {
    private Cadastrado hospedeCadastrado;
    private NaoCadastrado cadastrarHospede;
    private long hospedeId;
    
    public TelaReservas(JTable tblReservas, Cadastrado hospedeCadastrado, NaoCadastrado cadastrarHospede, long hospedeId) {
        this.hospedeCadastrado = hospedeCadastrado;
        this.cadastrarHospede = cadastrarHospede;
        this.hospedeId = hospedeId;
        initComponents();
        
        //Código para definir o ícone
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icons/Logo.png"));
        this.setIconImage(logo.getImage());
        
        carregarReservas();
    }
    
    //Método para carregar as reservas
    public void carregarReservas() {
        ReservasDAO reservaDAO = new ReservasDAO();
        List<Reserva> reservas = reservaDAO.listarReservas(retornarStatus());
        preencherTabela(reservas);
    }
    
    //Método para preencher a tabela
    public void preencherTabela(List<Reserva> reservas) {
        if (reservas.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Nenhuma reserva foi encontrada!", "SEM RESERVAS", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        String colunas[] = {"Id", "Nome", "Check-In", "Check-Out", "Quarto", "Total Dias", "Valor Total", "Status"};
        String dados[][] = new String [reservas.size()][colunas.length];
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
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
        tblReservas.setModel(model);
        
        //Configura a fonte do cabeçalho
        tblReservas.getTableHeader().setFont(new Font("Segoe UI", Font.BOLD, 12));

        //Ajusta a largura das colunas
        tblReservas.getColumnModel().getColumn(0).setPreferredWidth(60);
        tblReservas.getColumnModel().getColumn(1).setPreferredWidth(250);
        tblReservas.getColumnModel().getColumn(2).setPreferredWidth(75);
        tblReservas.getColumnModel().getColumn(3).setPreferredWidth(75);
        tblReservas.getColumnModel().getColumn(4).setPreferredWidth(50);
        tblReservas.getColumnModel().getColumn(5).setPreferredWidth(60);
        tblReservas.getColumnModel().getColumn(6).setPreferredWidth(95);
        tblReservas.getColumnModel().getColumn(7).setPreferredWidth(85);
    }
    
    //Método para retornar o status selecionado
    public String retornarStatus() {
        int statusAtual = cbxStatus.getSelectedIndex();

        switch (statusAtual) {
            case 1:
                return "Finalizada";
            case 2:
                return "Cancelada";
            case 3:
                return "No Show";
            case 4:
                return "Em andamento";
            default:
                return "Confirmada";
        }
    }
    
    //Método para verificar o status selecionado
    public void statusAtual() {
        ReservasDAO reservaDAO = new ReservasDAO();
        String status = retornarStatus();
        List<Reserva> reservas;
       
        reservas = reservaDAO.listarReservas(status);
        preencherTabela(reservas);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblReservas = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtPesquisa = new javax.swing.JTextField();
        rbtId = new javax.swing.JRadioButton();
        rbtHospede = new javax.swing.JRadioButton();
        btnPesquisar = new javax.swing.JButton();
        cbxStatus = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btnCriarReserva = new javax.swing.JButton();
        btnCancelarReserva = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        btnAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("RESERVAS");

        jScrollPane1.setBackground(new java.awt.Color(153, 153, 153));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setViewportBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        tblReservas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tblReservas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Hóspede", "Check-In", "Check-Out", "Quarto", "Total Dias", "Valor Total", "Status"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tblReservas.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(tblReservas);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(1, 22, 45));
        jLabel2.setText("Pesquisar Reserva:");

        rbtId.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbtId);
        rbtId.setText("ID");
        rbtId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtIdActionPerformed(evt);
            }
        });

        rbtHospede.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbtHospede);
        rbtHospede.setText("Hóspede");
        rbtHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtHospedeActionPerformed(evt);
            }
        });

        btnPesquisar.setBackground(new java.awt.Color(204, 204, 204));
        btnPesquisar.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnPesquisar.setForeground(new java.awt.Color(1, 22, 45));
        btnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Buscar.png"))); // NOI18N
        btnPesquisar.setText("Pesquisar");
        btnPesquisar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisarActionPerformed(evt);
            }
        });

        cbxStatus.setEditable(true);
        cbxStatus.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbxStatus.setForeground(new java.awt.Color(1, 22, 45));
        cbxStatus.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Confirmadas", "Finalizadas", "Canceladas", "No Show", "Em andamento" }));
        cbxStatus.setBorder(null);
        cbxStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxStatusActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(rbtId)
                        .addGap(198, 198, 198)
                        .addComponent(rbtHospede)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnPesquisar, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtId)
                    .addComponent(rbtHospede))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxStatus, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25))
        );

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 22, 45));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reservas");

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnCriarReserva.setBackground(new java.awt.Color(204, 204, 204));
        btnCriarReserva.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnCriarReserva.setForeground(new java.awt.Color(1, 22, 45));
        btnCriarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Criar.png"))); // NOI18N
        btnCriarReserva.setText("Criar Reserva");
        btnCriarReserva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCriarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarReservaActionPerformed(evt);
            }
        });

        btnCancelarReserva.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelarReserva.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnCancelarReserva.setForeground(new java.awt.Color(255, 51, 51));
        btnCancelarReserva.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Cancelar.png"))); // NOI18N
        btnCancelarReserva.setText("Cancelar");
        btnCancelarReserva.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelarReserva.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarReservaActionPerformed(evt);
            }
        });

        btnVoltar.setBackground(new java.awt.Color(204, 204, 204));
        btnVoltar.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Sair_1.png"))); // NOI18N
        btnVoltar.setText("Sair");
        btnVoltar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVoltarActionPerformed(evt);
            }
        });

        btnAtualizar.setBackground(new java.awt.Color(204, 204, 204));
        btnAtualizar.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnAtualizar.setForeground(new java.awt.Color(1, 22, 45));
        btnAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Atualizar.png"))); // NOI18N
        btnAtualizar.setText("Atualizar");
        btnAtualizar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(btnVoltar, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(55, 55, 55)
                .addComponent(btnAtualizar, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(51, 51, 51)
                .addComponent(btnCancelarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(58, 58, 58)
                .addComponent(btnCriarReserva, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(btnCriarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelarReserva, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(344, 344, 344)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(32, 32, 32)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarReservaActionPerformed
        Cadastrado hospedeCadastrado = new Cadastrado(this, null);
        NaoCadastrado cadastrarHospede = new NaoCadastrado(this, null);
        TelaCriarReserva novaReserva = new TelaCriarReserva(this, hospedeCadastrado, cadastrarHospede, hospedeId);
        novaReserva.setVisible(true);
    }//GEN-LAST:event_btnCriarReservaActionPerformed

    private void btnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisarActionPerformed
        ReservasDAO rd = new ReservasDAO();
        List<Reserva> reservas;    
        String status = retornarStatus();
        
        if (rbtId.isSelected()) {
            if (txtPesquisa.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Atenção, informe o ID para pesquisar uma reserva!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            } else {
                try {
                    long id = Long.parseLong(txtPesquisa.getText().trim());
                    reservas = rd.pesquisarId(id, status);
                    
                    if (reservas.isEmpty()) {
                        JOptionPane.showMessageDialog(rootPane, "Nenhuma reserva encontrada para o ID '" + id + "'", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                    } else {
                        preencherTabela(reservas);
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(rootPane, "ID inválido! Por favor, insira um número válido.", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                }
            }
        } else if (rbtHospede.isSelected()) {
            if (txtPesquisa.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Atenção, informe o nome do hóspede para pesquisar uma reserva!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            } else {
                String nome = txtPesquisa.getText().trim();
                reservas = rd.pesquisarNome(nome, status);
                
                if (reservas.isEmpty()) {
                    JOptionPane.showMessageDialog(rootPane, "Nenhuma reserva encontrada para o hóspede \"" + nome + "\".", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
                } else {
                    preencherTabela(reservas);
                }
            }
        } else {
            statusAtual();
        }
    }//GEN-LAST:event_btnPesquisarActionPerformed

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVoltarActionPerformed
        dispose();
    }//GEN-LAST:event_btnVoltarActionPerformed

    private void btnCancelarReservaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarReservaActionPerformed
        int linhaSelecionada = tblReservas.getSelectedRow();
        
        if (linhaSelecionada != -1) {
            long reservaId = Long.parseLong(String.valueOf(tblReservas.getValueAt(linhaSelecionada, 0)));
        
            ReservasDAO reservaDAO = new ReservasDAO();
            String status = reservaDAO.getStatus(reservaId);
        
            if ("Confirmada".equals(status)) {
                int resposta = JOptionPane.showConfirmDialog(rootPane, "Deseja mesmo cancelar a reserva?", "E AGORA?", JOptionPane.YES_NO_OPTION);
            
                if (resposta == JOptionPane.YES_OPTION) {
                    try {
                        reservaDAO.cancelarReserva(reservaId);
                        carregarReservas();
                        JOptionPane.showMessageDialog(rootPane, "Reserva cancelada com sucesso!", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "Erro ao cancelar a reserva: " + e.getMessage(), "ERRO", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(rootPane, "Somente reservas confirmadas podem ser canceladas", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Atenção, selecione uma reserva para cancelar!", "ATENÇÃO", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnCancelarReservaActionPerformed

    private void rbtIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtIdActionPerformed
        
    }//GEN-LAST:event_rbtIdActionPerformed

    private void rbtHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtHospedeActionPerformed
       
    }//GEN-LAST:event_rbtHospedeActionPerformed

    private void btnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizarActionPerformed
        txtPesquisa.setText("");
        cbxStatus.setSelectedIndex(0);
        
        if (rbtId.isSelected() || rbtHospede.isSelected()) {
            buttonGroup1.clearSelection();
        }
        carregarReservas();
    }//GEN-LAST:event_btnAtualizarActionPerformed

    private void cbxStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxStatusActionPerformed
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        JTable tblReservas = new JTable();
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
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new TelaReservas().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizar;
    private javax.swing.JButton btnCancelarReserva;
    private javax.swing.JButton btnCriarReserva;
    private javax.swing.JButton btnPesquisar;
    private javax.swing.JButton btnVoltar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbxStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtHospede;
    private javax.swing.JRadioButton rbtId;
    private javax.swing.JTable tblReservas;
    private javax.swing.JTextField txtPesquisa;
    // End of variables declaration//GEN-END:variables
}