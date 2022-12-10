package controle;

import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.Color;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */
public class Cad_Materia extends javax.swing.JPanel {

    String salvar;
    Conexao con_cliente;
    Conexao con_telef;
    public String n;
    public String telef;
    public static String s;

    public Cad_Materia() {
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executarSQL("SELECT * FROM material INNER JOIN fornecedor ON material.cod_fornecedor= fornecedor.cod_fornecedor ORDER by id_material");
        //INNER JOIN faz o select de duas variáveis ao mesmo tempo

        //SELECT * FROM tabela_principal INNER JOIN ON tabela_principal.atributo(PK) = tabela_estrangeira.atributo(FK)
        //estabelece conexão entre as duas tabelas
        con_telef = new Conexao();
        con_telef.conecta();
        con_telef.executarSQL2("select * from fornecedor order by cod_fornecedor");
        //select * from tabela_estrangeira order by cod_da_tabela_estrangeira

        preenchertabela();
        setBackground(new Color(245, 245, 245));
    }

    public void preenchertabela() {
        tblMateriais.getColumnModel().getColumn(0).setPreferredWidth(4);
        tblMateriais.getColumnModel().getColumn(1).setPreferredWidth(40);
        tblMateriais.getColumnModel().getColumn(2).setPreferredWidth(30);
        tblMateriais.getColumnModel().getColumn(3).setPreferredWidth(20);
        tblMateriais.getColumnModel().getColumn(4).setPreferredWidth(6);

        DefaultTableModel modelo = (DefaultTableModel) tblMateriais.getModel();
        modelo.setNumRows(0);
        try {
            con_cliente.resultset.beforeFirst();
            while (con_cliente.resultset.next()) {
                modelo.addRow(new Object[]{
                    con_cliente.resultset.getString("id_material"), 
                    con_cliente.resultset.getString("material"), 
                    con_cliente.resultset.getString("cor"), 
                    con_cliente.resultset.getString("cod_fornecedor"), 
                    con_cliente.resultset.getString("preco")
                //coloca todos os atributos que deseja mostrar e sua respectiva coluna
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!:");
        }

        tblMateriais.getColumnModel().getColumn(1).setPreferredWidth(14);

        DefaultTableModel modelo2 = (DefaultTableModel) tblFornecedor.getModel();
        modelo2.setNumRows(0);
        try {
            con_telef.resultset.beforeFirst();
            while (con_telef.resultset.next()) {
                modelo2.addRow(new Object[]{
                    con_telef.resultset.getString("nome_fornecedor")
                //nome do atributo que deseja colocar na tabela
                });
            }
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "\n Erro ao listar dados da tabela!!:");
        }
    }

    public void posicionarRegistro() {
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel posicionar no primeiro registro:" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public void mostrar_Dados() {
        try {
            //nessa área você transfere os os atributos do banco para o textfield 

            cod.setText(con_cliente.resultset.getString("id_material"));
            int a = Integer.parseInt(cod.getText());
            System.out.println(a + 1 + "");
            txtM.setText(con_cliente.resultset.getString("material"));
            txtF.setText(con_cliente.resultset.getString("nome_fornecedor"));
            System.out.println(txtF.getText() + "");
            txtC.setText(con_cliente.resultset.getString("cor"));
            txtP.setText(con_cliente.resultset.getString("preco"));

        } catch (SQLException erro) {

        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txtC = new javax.swing.JTextField();
        txtM = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtP = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cod = new javax.swing.JTextField();
        txtF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblMateriais = new swing_classes.Table_Column();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblFornecedor = new swing_classes.Table_Column();
        jLabel4 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(245, 245, 245));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("MATERIAIS");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Código");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Preço");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Cor");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Material");

        cod.setEditable(false);
        cod.setEnabled(false);

        txtF.setEditable(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Fornecedor");

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/disk.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application_edit.png"))); // NOI18N
        btnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlterarActionPerformed(evt);
            }
        });

        btnDeletar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application_delete.png"))); // NOI18N
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
            }
        });

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/add.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        jScrollPane2.setBorder(null);

        tblMateriais.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código", "Material", "Cor", "Fornecedor", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMateriais.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMateriaisMouseClicked(evt);
            }
        });
        tblMateriais.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblMateriaisKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblMateriais);

        jScrollPane3.setBorder(null);

        tblFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Fornecedor"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFornecedor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFornecedorMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblFornecedor);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Cadastre os materiais utilizados.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDeletar))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtP, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(41, 41, 41)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtM)
                                        .addComponent(txtF)
                                        .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(214, 214, 214)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(431, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnDeletar))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(93, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        String id = cod.getText();//declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String m = txtM.getText();
        String c = txtC.getText();
        String f = txtF.getText();
        String p = txtP.getText();
        try {
            String pesquisa = "select * from fornecedor where nome_fornecedor like'" + f + "%'";
            //"select * from tabela_estrangeira where atributo que está no JTable_estrangeira like'"+f+"%'"

            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa);
            con_cliente.resultset.first();
            String nf = con_cliente.resultset.getString("cod_fornecedor");
            //con_cliente.resultset.getString("cod_estrangeira");

            System.out.println(nf + "");

            con_cliente.executarSQL("select * from material order by id_material");
            //select * from tabela_principal order by cod_principal
            String insert_sql = "INSERT INTO `material`(`cod_fornecedor`, `material`, `cor`, `preco`) values ('" + nf + "','" + m + "','" + c + "','" + p + "')";
            //insere todos os atributos na tabela em exceção da FK e na posição (values) coloca nf

            con_cliente.statement.executeUpdate(insert_sql);
            con_cliente.executarSQL("SELECT * FROM material INNER JOIN fornecedor ON material.cod_fornecedor= fornecedor.cod_fornecedor ORDER by id_material");

            //SELECT * FROM tabela_principal INNER JOIN ON tabela_principal.atributo(PK) = tabela_estrangeira.atributo(FK)
            con_cliente.resultset.first();
            preenchertabela();
            mostrar_Dados();

        } catch (Exception errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro de gravação: \n" + errosql, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        String id = cod.getText();//declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String m = txtM.getText();
        String c = txtC.getText();
        String f = txtF.getText();
        String p = txtP.getText();
        try {
            String pesquisa = "select * from fornecedor where nome_fornecedor like'" + f + "%'";
            //"select * from tabela_estrangeira where atributo que está no JTable_estrangeira like'"+f+"%'"

            con_cliente.executarSQL(pesquisa);
            con_cliente.resultset.first();
            String nf = con_cliente.resultset.getString("cod_fornecedor");
            //con_cliente.resultset.getString("cod_estrangeira");

            con_cliente.executarSQL("select * from material order by id_material");
            String insert_sql = "update material set cor='" + c + "',cod_fornecedor='" + nf + "',material='" + m + "',preco='" + p + "' where id_material = " + id;
            //faz o update, na hora de colocar a FK pra atualizar, coloque nf

            con_cliente.statement.executeUpdate(insert_sql);

            con_cliente.executarSQL("SELECT * FROM material INNER JOIN fornecedor ON material.cod_fornecedor= fornecedor.cod_fornecedor ORDER by id_material");
            //INNER JOIN
            con_cliente.resultset.first();
            preenchertabela();
            mostrar_Dados();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        String sql = "";
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro: ", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, 3);
            if (resposta == 0) {
                sql = "delete from material where id_material = " + cod.getText();
                //deleta a tabela junto de seu cod.getText(); cujo amostra no texfield cod
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    con_cliente.executarSQL("SELECT * FROM material INNER JOIN fornecedor ON material.cod_fornecedor= fornecedor.cod_fornecedor ORDER by id_material");
                    con_cliente.resultset.first();
                    preenchertabela();
                    mostrar_Dados();
                } else {
                    JOptionPane.showMessageDialog(null, "a");
                }
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "ad");
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        cod.setText("");
        txtM.setText("");
        txtC.setText("");
        txtF.setText("");
        txtP.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblMateriaisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMateriaisMouseClicked
        int linha_selecionada = tblMateriais.getSelectedRow();

        try {

            cod.setText(tblMateriais.getValueAt(linha_selecionada, 0).toString());
            txtM.setText(tblMateriais.getValueAt(linha_selecionada, 1).toString());
            txtC.setText(tblMateriais.getValueAt(linha_selecionada, 2).toString());
            txtF.setText(tblMateriais.getValueAt(linha_selecionada, 3).toString());
            txtP.setText(tblMateriais.getValueAt(linha_selecionada, 4).toString());
            //textfield(JTable_principal.getValueAt(linha_selecionada,coluna).toString());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblMateriaisMouseClicked

    private void tblMateriaisKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblMateriaisKeyPressed
        try {

            int linha_selecionadaa = tblFornecedor.getSelectedRow();
            txtF.setText(tblFornecedor.getValueAt(linha_selecionadaa, 0).toString());
            System.out.println(txtF.getText() + "");
            //textfield(JTable_estrangeira.getValueAt(linha_selecionada,coluna).toString());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblMateriaisKeyPressed

    private void tblFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFornecedorMouseClicked
        // TODO add your handling code here:
        try {

            int linha_selecionadaa = tblFornecedor.getSelectedRow();
            txtF.setText(tblFornecedor.getValueAt(linha_selecionadaa, 0).toString());
            System.out.println(txtF.getText() + "");
            //textfield(JTable_estrangeira.getValueAt(linha_selecionada,coluna).toString());

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblFornecedorMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField cod;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private swing_classes.Table_Column tblFornecedor;
    private swing_classes.Table_Column tblMateriais;
    private javax.swing.JTextField txtC;
    private javax.swing.JTextField txtF;
    private javax.swing.JTextField txtM;
    private javax.swing.JTextField txtP;
    // End of variables declaration//GEN-END:variables
}
