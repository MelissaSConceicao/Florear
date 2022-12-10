package controle;

import conexao.Conexao;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */

public class Cad_Flore extends javax.swing.JPanel {

    Conexao con_cliente;
    
    public Cad_Flore() {
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executarSQL("select * from flor order by cod_flor");
        preencherTabela();
        mostrar_Dados();
        tblFlor.setAutoCreateRowSorter(true);
        setBackground(new Color(245, 245, 245));
    }

    public void preencherTabela(){
        
        tblFlor.getColumnModel().getColumn(0).setPreferredWidth(4);
        tblFlor.getColumnModel().getColumn(1).setPreferredWidth(40);
        tblFlor.getColumnModel().getColumn(2).setPreferredWidth(6);
        tblFlor.getColumnModel().getColumn(3).setPreferredWidth(100);
        
        DefaultTableModel modelo = (DefaultTableModel) tblFlor.getModel();
        modelo.setNumRows(0);
        
        try{
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()){
                modelo.addRow(new Object[]{
                   con_cliente.resultset.getString("cod_flor"),
                   con_cliente.resultset.getString("especie"),
                   con_cliente.resultset.getString("preco"),
                   con_cliente.resultset.getString("alergia"),
                });
            }
        }catch (SQLException erro){
            JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!! :\n"+erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void posicionarRegistro(){
        try{
            con_cliente.resultset.first();
            mostrar_Dados();
            }catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Não foi possivel posicionar no primeiro registro: "+erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public void mostrar_Dados(){
        txtArea.setEditable(false);
        txtArea.setVisible(false);
        try{
            txtIDFlor.setText(con_cliente.resultset.getString("cod_flor"));
            txtFlor.setText(con_cliente.resultset.getString("especie"));
            txtPreco.setText(con_cliente.resultset.getString("preco"));
            txtArea.setText(con_cliente.resultset.getString("alergia"));
        }catch (SQLException erro){
            
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel5 = new javax.swing.JLabel();
        btnAdd = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtArea = new javax.swing.JTextArea();
        btnSalvar = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnExcluir = new javax.swing.JButton();
        txtPreco = new javax.swing.JTextField();
        txtIDFlor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        rbNao = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        rbSim = new javax.swing.JRadioButton();
        txtFlor = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFlor = new swing_classes.Table_Column();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Esta flor causa algum dano?");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/add.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        txtArea.setColumns(20);
        txtArea.setRows(5);
        jScrollPane1.setViewportView(txtArea);

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/disk.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application_edit.png"))); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Preço unitário");

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application_delete.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtIDFlor.setEditable(false);
        txtIDFlor.setEnabled(false);

        jLabel1.setBackground(new java.awt.Color(245, 245, 245));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("CADASTRO DE FLORES");

        buttonGroup1.add(rbNao);
        rbNao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbNao.setForeground(new java.awt.Color(102, 102, 102));
        rbNao.setText("Não");
        rbNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNaoActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Nome da espécie");

        buttonGroup1.add(rbSim);
        rbSim.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbSim.setForeground(new java.awt.Color(102, 102, 102));
        rbSim.setText("Sim");
        rbSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbSimActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);

        tblFlor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Código", "Espécie", "Preço", "Cuidado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFlor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFlorMouseClicked(evt);
            }
        });
        tblFlor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblFlorKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblFlor);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Código");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Realizar cadastramento de flores.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel6))
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btnAdd)
                .addGap(18, 18, 18)
                .addComponent(btnSalvar)
                .addGap(18, 18, 18)
                .addComponent(btnEditar)
                .addGap(18, 18, 18)
                .addComponent(btnExcluir))
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1118, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGap(40, 40, 40)
                            .addComponent(jLabel4)
                            .addGap(35, 35, 35))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFlor, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(90, 90, 90)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createSequentialGroup()
                    .addGap(40, 40, 40)
                    .addComponent(jLabel2)
                    .addGap(18, 18, 18)
                    .addComponent(txtIDFlor, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(225, 225, 225)
                    .addComponent(jLabel5)
                    .addGap(12, 12, 12)
                    .addComponent(rbNao)
                    .addGap(70, 70, 70)
                    .addComponent(rbSim)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addComponent(jLabel6)
                .addGap(63, 63, 63)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtIDFlor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(rbNao)
                    .addComponent(rbSim))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtFlor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnSalvar)
                    .addComponent(btnEditar)
                    .addComponent(btnExcluir))
                .addGap(25, 25, 25)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        txtIDFlor.setText("");
        txtFlor.setText("");
        txtPreco.setText("");
        txtArea.setText("");
        txtFlor.requestFocus();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String nome = txtFlor.getText();
        String preco = txtPreco.getText();
        String alergia = txtArea.getText();

        try{

            String insert_sql = "insert into flor (especie, preco, alergia) values ('" + nome + "', '" + preco + "','" + alergia + "')";
            con_cliente.statement.executeUpdate(insert_sql);
            con_cliente.executarSQL("select * from flor order by cod_flor");
            con_cliente.resultset.first();
            preencherTabela();
            mostrar_Dados();

        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n"+errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        String nome = txtFlor.getText();
        String preco = txtPreco.getText();
        String alergia = txtArea.getText();
        String sql="";
        String msg="";

        try{
            if(txtIDFlor.getText().equals("")){
                sql="insert into flor (especie, preco, alergia) values ('" + nome + "', '" + preco + "','" + alergia + "')";
                msg="Gravação de um novo registro";
            }else{
                sql="update flor set especie='" + nome + "', preco='" + preco + "', alergia='" + alergia + "' where cod_flor = " + txtIDFlor.getText();
                msg="Alteração de registro";
            }

            con_cliente.statement.executeUpdate(sql);
            con_cliente.executarSQL("select * from flor order by cod_flor");
            con_cliente.resultset.first();
            preencherTabela();
            mostrar_Dados();

        }catch(SQLException errosql){
            JOptionPane.showMessageDialog(null, "\n Erro na gravação :\n"+errosql, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        String sql="";
        try{
            int resposta = JOptionPane.showConfirmDialog(null,"Deseja excluir o resgistro:","Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
            if(resposta == 0){
                sql="delete from flor where cod_flor = " + txtIDFlor.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if(excluir==1){
                    con_cliente.executarSQL("select * from flor order by cod_flor");
                    con_cliente.resultset.first();
                    preencherTabela();
                    mostrar_Dados();

                }else{
                    JOptionPane.showMessageDialog(null,"Operação cancelada pelo usuário","Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }catch(SQLException excecao){
            JOptionPane.showMessageDialog(null, "Erro na exclusão: "+excecao, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void rbNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNaoActionPerformed
        if(rbNao.isSelected() == true){
            txtArea.setText("");
            txtArea.setEditable(false);
            txtArea.setVisible(false);
        }
    }//GEN-LAST:event_rbNaoActionPerformed

    private void rbSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSimActionPerformed
        if(rbSim.isSelected() == true){
            txtArea.setEditable(true);
            txtArea.setEditable(true);
            txtArea.setVisible(true);
        }
    }//GEN-LAST:event_rbSimActionPerformed

    private void tblFlorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFlorMouseClicked
        int selecao = tblFlor.getSelectedRow();
        txtIDFlor.setText(tblFlor.getValueAt(selecao, 0).toString());
        txtFlor.setText(tblFlor.getValueAt(selecao, 1).toString());
        txtPreco.setText(tblFlor.getValueAt(selecao, 2).toString());
        txtArea.setText(tblFlor.getValueAt(selecao, 3).toString());
    }//GEN-LAST:event_tblFlorMouseClicked

    private void tblFlorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFlorKeyPressed
        int selecao = tblFlor.getSelectedRow();
        txtIDFlor.setText(tblFlor.getValueAt(selecao, 0).toString());
        txtFlor.setText(tblFlor.getValueAt(selecao, 1).toString());
        txtPreco.setText(tblFlor.getValueAt(selecao, 2).toString());
        txtArea.setText(tblFlor.getValueAt(selecao, 3).toString());
    }//GEN-LAST:event_tblFlorKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbSim;
    private swing_classes.Table_Column tblFlor;
    private javax.swing.JTextArea txtArea;
    private javax.swing.JTextField txtFlor;
    private javax.swing.JTextField txtIDFlor;
    private javax.swing.JTextField txtPreco;
    // End of variables declaration//GEN-END:variables
}
