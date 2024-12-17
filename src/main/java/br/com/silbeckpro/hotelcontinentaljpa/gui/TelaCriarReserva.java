
package br.com.silbeckpro.hotelcontinentaljpa.gui;

import br.com.silbeckpro.hotelcontinentaljpa.Categoria;
import br.com.silbeckpro.hotelcontinentaljpa.Hospede;
import br.com.silbeckpro.hotelcontinentaljpa.Quarto;
import br.com.silbeckpro.hotelcontinentaljpa.Reserva;
import br.com.silbeckpro.hotelcontinentaljpa.persistencia.CategoriaDAO;
import br.com.silbeckpro.hotelcontinentaljpa.persistencia.HospedeDAO;
import br.com.silbeckpro.hotelcontinentaljpa.persistencia.QuartoDAO;
import br.com.silbeckpro.hotelcontinentaljpa.persistencia.ReservasDAO;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class TelaCriarReserva extends javax.swing.JFrame {
    private TelaReservas telaReservas;
    private TelaCriarReserva telaCriarReserva;
    private JTable tblHospede;
    private Cadastrado hospedeCadastrado;
    private NaoCadastrado cadastrarHospede;
    private long hospedeId;
    
    public TelaCriarReserva(TelaReservas telaReservas, Cadastrado hospedeCadastrado, NaoCadastrado cadastrarHospede, long hospedeId) {
        this.telaReservas = telaReservas;
        this.hospedeCadastrado = hospedeCadastrado;
        this.cadastrarHospede = cadastrarHospede;
        this.hospedeId = hospedeId;
        
        //Referenciando a tabela de hóspedes
        this.tblHospede = hospedeCadastrado.getTblHospede();
        initComponents();
        preencherCategoria();
        
       //Código para definir o ícone
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icons/Logo.png"));
        this.setIconImage(logo.getImage());
        
        //Adiciona um actionlistener para o combobox categoria e verifica as datas inseridas
        cbxCategoria.addActionListener(e -> {
            Categoria categoriaSelecionada = (Categoria) cbxCategoria.getSelectedItem();
            if (categoriaSelecionada != null) {
                try {
                    LocalDate checkIn = LocalDate.parse(ftfCheckIn.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    LocalDate checkOut = LocalDate.parse(ftfCheckOut.getText().trim(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
                            
                    if (checkIn.isBefore(LocalDate.now())) {        
                        String dataFormatada = LocalDate.now().format(formatter);
                        JOptionPane.showMessageDialog(rootPane, "A data de Check-In não pode ser anterior à data de hoje " + dataFormatada + "!", "AVISO", JOptionPane.WARNING_MESSAGE);
                        ftfCheckIn.setText("");
                        return;
                    } else if (checkOut.isBefore(checkIn) || checkOut.equals(checkIn)) {
                        JOptionPane.showMessageDialog(rootPane, "A data de Check-Out deve ser posterior à data de Check-In!", "AVISO", JOptionPane.WARNING_MESSAGE);
                        ftfCheckOut.setText("");
                        return; 
                    }
                
                    atualizarDisponibilidade(categoriaSelecionada.getId(), checkIn, checkOut);
                } catch (DateTimeParseException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Por favor, insira datas válidas de Check-In e Check-Out!", "AVISO", JOptionPane.WARNING_MESSAGE);
                    ftfCheckIn.setText("");
                    ftfCheckOut.setText("");
                    cbxCategoria.setSelectedItem(null);
                }
            }
        });
    }
    
    //Método para atualizar os quartos disponíveis
    private void atualizarDisponibilidade(int categoriaId, LocalDate checkIn, LocalDate checkOut) {
        QuartoDAO quartoDAO = new QuartoDAO(); 
        List<Quarto> quartosDisponiveis = quartoDAO.listarQuartosDisponiveis(categoriaId, checkIn, checkOut);
    
        cbxQuarto.removeAllItems(); 
        for (Quarto quarto : quartosDisponiveis) {
            cbxQuarto.addItem(quarto); 
        }
        if (quartosDisponiveis.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Não há quartos disponíveis nesta categoria para as datas selecionadas.", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    //Método para listar as categorias no combobox
    private void preencherCategoria() {
        CategoriaDAO categoriaDAO = new CategoriaDAO();
        List<Categoria> categorias = categoriaDAO.listarCategoria();
        
        for (Categoria c: categorias) {
            cbxCategoria.addItem(c);
        }
    }
    
    //Método para definir o id do hóspede
    public void setHospedeId(long hospedeId) {
        this.hospedeId = hospedeId;
    }
    
    //Método para atualizar o nome do hóspede
    public void setNomeHospede(String nome) {
        ftfNomeHospede.setText(nome);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ftfCheckIn = new javax.swing.JFormattedTextField();
        ftfCheckOut = new javax.swing.JFormattedTextField();
        cbxCategoria = new javax.swing.JComboBox<>();
        rbCadastrado = new javax.swing.JRadioButton();
        rbNaoCadastrado = new javax.swing.JRadioButton();
        ftfNomeHospede = new javax.swing.JFormattedTextField();
        cbxQuarto = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("NOVA RESERVA");

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 22, 45));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Reserva");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ftfCheckIn.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Check-In", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        try {
            ftfCheckIn.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCheckIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfCheckInActionPerformed(evt);
            }
        });

        ftfCheckOut.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Data Check-Out", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N
        try {
            ftfCheckOut.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        cbxCategoria.setToolTipText("");
        cbxCategoria.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Categoria", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N
        cbxCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxCategoriaActionPerformed(evt);
            }
        });

        rbCadastrado.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbCadastrado);
        rbCadastrado.setText("Cadastrado");
        rbCadastrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbCadastradoActionPerformed(evt);
            }
        });

        rbNaoCadastrado.setBackground(new java.awt.Color(204, 204, 204));
        buttonGroup1.add(rbNaoCadastrado);
        rbNaoCadastrado.setText("Não Cadastrado");
        rbNaoCadastrado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNaoCadastradoActionPerformed(evt);
            }
        });

        ftfNomeHospede.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome do Hóspede", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(102, 102, 102))); // NOI18N

        cbxQuarto.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Número", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Segoe UI", 0, 11), new java.awt.Color(102, 102, 102))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ftfNomeHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(rbCadastrado)
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ftfCheckIn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ftfCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(cbxCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(3, 3, 3)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(rbNaoCadastrado)
                        .addContainerGap(23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(cbxQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftfCheckIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfCheckOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbxCategoria)
                    .addComponent(cbxQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftfNomeHospede, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(rbCadastrado)
                    .addComponent(rbNaoCadastrado))
                .addContainerGap(23, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSalvar.setBackground(new java.awt.Color(204, 204, 204));
        btnSalvar.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnSalvar.setForeground(new java.awt.Color(38, 115, 57));
        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Salvar.png"))); // NOI18N
        btnSalvar.setText("Salvar");
        btnSalvar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(204, 204, 204));
        btnCancelar.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Sair_1.png"))); // NOI18N
        btnCancelar.setText("Sair");
        btnCancelar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(190, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(286, 286, 286)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        if (ftfCheckIn.getText().trim().isEmpty() || ftfCheckOut.getText().trim().isEmpty() || 
            ftfNomeHospede.getText().trim().isEmpty() || cbxQuarto.getSelectedItem() == null) {
        
            JOptionPane.showMessageDialog(rootPane, "Atenção, para realizar a reserva todos os campos devem ser preenchidos!", "AVISO", JOptionPane.WARNING_MESSAGE); 
            return;
        } else {
            //Formatando as datas
            DateTimeFormatter formatoData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate hoje = LocalDate.now();

            try {
                LocalDate checkIn = LocalDate.parse(ftfCheckIn.getText().trim(), formatoData);
                LocalDate checkOut = LocalDate.parse(ftfCheckOut.getText().trim(), formatoData);
                
                //Pegando o hóspede do banco de dados
                HospedeDAO hospedeDAO = new HospedeDAO();
                Hospede hospedeSelecionado = hospedeDAO.buscarporId(hospedeId);
                
                //Criando a reserva
                Reserva novaReserva = new Reserva();
                novaReserva.setHospede(hospedeSelecionado);
                
                //Configurando Check-In e Check-Out
                novaReserva.setCheckin(checkIn);
                novaReserva.setCheckout(checkOut);
                
               //Selecionando o quarto    
                Quarto quartoSelecionado = (Quarto) cbxQuarto.getSelectedItem();
                novaReserva.setQuarto(quartoSelecionado);
                
                //Calculando o total de dias e valor total
                novaReserva.calcularValores();
                int totalDias = novaReserva.getTotalDias();
                double valorTotal = novaReserva.getValorTotal();
                
                //Configurando o status
                novaReserva.setEstatus("Confirmada");
                
                //Carregando a reserva no banco de dados
                ReservasDAO reservaDAO = new ReservasDAO();
                reservaDAO.cadastrar(novaReserva);
                
                JOptionPane.showMessageDialog(rootPane, novaReserva.toString(), "SUCESSO!", JOptionPane.INFORMATION_MESSAGE);
                telaReservas.carregarReservas();
                dispose();
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Erro ao criar a reserva: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void rbNaoCadastradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNaoCadastradoActionPerformed
        NaoCadastrado cadastrarHospede = new NaoCadastrado(telaReservas, this);
        cadastrarHospede.setVisible(true);
    }//GEN-LAST:event_rbNaoCadastradoActionPerformed

    private void rbCadastradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbCadastradoActionPerformed
        Cadastrado hospedeCadastrado = new Cadastrado(telaReservas, this);
        hospedeCadastrado.setVisible(true);
    }//GEN-LAST:event_rbCadastradoActionPerformed

    private void cbxCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxCategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxCategoriaActionPerformed

    private void ftfCheckInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfCheckInActionPerformed
       
    }//GEN-LAST:event_ftfCheckInActionPerformed
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
            java.util.logging.Logger.getLogger(TelaCriarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCriarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCriarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCriarReserva.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCriarReserva().setVisible(true);
            }
        });*/
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<Categoria> cbxCategoria;
    private javax.swing.JComboBox<Quarto> cbxQuarto;
    private javax.swing.JFormattedTextField ftfCheckIn;
    private javax.swing.JFormattedTextField ftfCheckOut;
    private javax.swing.JFormattedTextField ftfNomeHospede;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JRadioButton rbCadastrado;
    private javax.swing.JRadioButton rbNaoCadastrado;
    // End of variables declaration//GEN-END:variables
}
