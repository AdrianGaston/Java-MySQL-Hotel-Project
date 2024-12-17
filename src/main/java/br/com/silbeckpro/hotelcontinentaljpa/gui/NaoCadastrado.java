
package br.com.silbeckpro.hotelcontinentaljpa.gui;

import br.com.silbeckpro.hotelcontinentaljpa.Hospede;
import br.com.silbeckpro.hotelcontinentaljpa.persistencia.HospedeDAO;
import javax.swing.ImageIcon;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.JTable;


public class NaoCadastrado extends javax.swing.JFrame {
    private JTable tblHospede;
    private TelaReservas telaReservas;
    private TelaCriarReserva telaCriarReserva;
    private JFormattedTextField ftfNomeHospede;
    
    
    public NaoCadastrado(TelaReservas telaReservas, TelaCriarReserva telaCriarReserva) {
        initComponents();
        
        this.telaReservas = telaReservas;
        this.tblHospede = tblHospede;
        this.telaCriarReserva = telaCriarReserva;
        
        //Código para definir o ícone
        ImageIcon logo = new ImageIcon(getClass().getResource("/Icons/Logo.png"));
        this.setIconImage(logo.getImage());
    }
    
    //Método para capitalizar as primeiras letras de cada palavra
    public String capitalizarNomes(String nome) {
        String[] palavras = nome.toLowerCase().split(" ");
        StringBuilder nomeCapitalizado = new StringBuilder();
        
        for (String palavra: palavras) {
            if (!palavra.isEmpty()) {
                nomeCapitalizado.append(Character.toUpperCase(palavra.charAt(0))).append(palavra.substring(1)).append(" ");
            }
        }
        return nomeCapitalizado.toString().trim();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        ftfCpf = new javax.swing.JFormattedTextField();
        ftfNome = new javax.swing.JFormattedTextField();
        ftfCep = new javax.swing.JFormattedTextField();
        ftfEndereco = new javax.swing.JFormattedTextField();
        ftfCidade = new javax.swing.JFormattedTextField();
        ftfTelefone = new javax.swing.JFormattedTextField();
        jPanel2 = new javax.swing.JPanel();
        btnSairCadastro = new javax.swing.JButton();
        btbConfirmarHospede = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CADASTRO DE HÓSPEDE");

        jLabel1.setFont(new java.awt.Font("Baskerville Old Face", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(1, 22, 45));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Hóspede");

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        ftfCpf.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CPF *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 51, 51))); // NOI18N
        try {
            ftfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCpf.setNextFocusableComponent(ftfNome);

        ftfNome.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nome *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 51, 51))); // NOI18N
        ftfNome.setNextFocusableComponent(ftfCep);

        ftfCep.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "CEP *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 51, 51))); // NOI18N
        try {
            ftfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfCep.setNextFocusableComponent(ftfEndereco);

        ftfEndereco.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Endereço *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 51, 51))); // NOI18N
        ftfEndereco.setNextFocusableComponent(ftfCidade);

        ftfCidade.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cidade *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 51, 51))); // NOI18N
        ftfCidade.setNextFocusableComponent(ftfTelefone);

        ftfTelefone.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Telefone *", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 51, 51))); // NOI18N
        try {
            ftfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##)# ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftfTelefone.setNextFocusableComponent(btbConfirmarHospede);
        ftfTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftfTelefoneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ftfCidade, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(ftfCep)
                    .addComponent(ftfCpf))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfNome, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addComponent(ftfEndereco))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ftfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ftfCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        btnSairCadastro.setBackground(new java.awt.Color(204, 204, 204));
        btnSairCadastro.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btnSairCadastro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Sair_1.png"))); // NOI18N
        btnSairCadastro.setText("Sair");
        btnSairCadastro.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSairCadastro.setNextFocusableComponent(ftfCpf);
        btnSairCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairCadastroActionPerformed(evt);
            }
        });

        btbConfirmarHospede.setBackground(new java.awt.Color(204, 204, 204));
        btbConfirmarHospede.setFont(new java.awt.Font("Baskerville Old Face", 1, 18)); // NOI18N
        btbConfirmarHospede.setForeground(new java.awt.Color(38, 115, 57));
        btbConfirmarHospede.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/Salvar01.png"))); // NOI18N
        btbConfirmarHospede.setText("Salvar");
        btbConfirmarHospede.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btbConfirmarHospede.setNextFocusableComponent(btnSairCadastro);
        btbConfirmarHospede.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btbConfirmarHospedeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(149, Short.MAX_VALUE)
                .addComponent(btnSairCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48)
                .addComponent(btbConfirmarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(145, 145, 145))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSairCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btbConfirmarHospede, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(229, 229, 229)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ftfTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftfTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftfTelefoneActionPerformed

    private void btbConfirmarHospedeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btbConfirmarHospedeActionPerformed
        if (ftfCpf.getText().isEmpty() || ftfNome.getText().isEmpty() || ftfCep.getText().isEmpty() || ftfEndereco.getText().isEmpty() || ftfTelefone.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Atenção, para cadastrar um novo hóspede, todos os campos devem ser preenchidos!", "AVISO", JOptionPane.WARNING_MESSAGE);
        } else {
            Hospede novoHospede = new Hospede();
            
            try {
                novoHospede.setCpf(ftfCpf.getText());
                novoHospede.setNome(capitalizarNomes(ftfNome.getText()));
                novoHospede.setCep(ftfCep.getText());
                novoHospede.setEndereco(capitalizarNomes(ftfEndereco.getText()));
                novoHospede.setCidade(capitalizarNomes(ftfCidade.getText()));
                novoHospede.setTelefone(ftfTelefone.getText());
                
                HospedeDAO hospedeDAO = new HospedeDAO(tblHospede);
                hospedeDAO.cadastrar(novoHospede);
               
                if (novoHospede != null && telaCriarReserva != null) {
                    long hospedeId = novoHospede.getId();
                    
                    telaCriarReserva.setNomeHospede(novoHospede.getNome());
                    telaCriarReserva.setHospedeId(novoHospede.getId());
                    telaCriarReserva.setVisible(true);
                }
                
                dispose();
            } catch(Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(rootPane, "Erro ao cadastrar, confira os dados e tente novamente!", "ERRO", JOptionPane.ERROR_MESSAGE);
            }  
        }
    }//GEN-LAST:event_btbConfirmarHospedeActionPerformed

    private void btnSairCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairCadastroActionPerformed
        dispose();
    }//GEN-LAST:event_btnSairCadastroActionPerformed
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
            java.util.logging.Logger.getLogger(NaoCadastrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NaoCadastrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NaoCadastrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NaoCadastrado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaHospede().setVisible(true);
            }
        //</editor-fold>

        /* Create and display the form */
        /*java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NaoCadastrado().setVisible(true);
            }
        });*/
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btbConfirmarHospede;
    private javax.swing.JButton btnSairCadastro;
    private javax.swing.JFormattedTextField ftfCep;
    private javax.swing.JFormattedTextField ftfCidade;
    private javax.swing.JFormattedTextField ftfCpf;
    private javax.swing.JFormattedTextField ftfEndereco;
    private javax.swing.JFormattedTextField ftfNome;
    private javax.swing.JFormattedTextField ftfTelefone;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
