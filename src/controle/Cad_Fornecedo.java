package controle;

import conexao.Conexao;
import static controle.Cad_Fornecedo.n1;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */
public class Cad_Fornecedo extends javax.swing.JPanel {
    
    String salvar;
    Conexao con_cliente;
    Conexao con_telef;
    private int linha_selecionada;
    public static String n1;
    public String n;
    public String telef;
    
    public Cad_Fornecedo() {
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executarSQL("select * from fornecedor order by cod_fornecedor");
        
        con_telef = new Conexao();
        con_telef.conecta();
        con_telef.executarSQL2("select * from telefone_fornecedor order by cod_telefone");
        con_cliente.executarSQL("SELECT *\n" +
        "FROM fornecedor\n" +
        "INNER JOIN telefone_fornecedor ON fornecedor.cod_telefone = telefone_fornecedor.cod_telefone");
        n1="null";
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel7.setVisible(false);
        txtCNPJ.setVisible(false);
        txtCep.setVisible(false);
        txtCod.setVisible(false);
        txtFone.setVisible(false);
        txtNome.setVisible(false);
        txtProduto.setVisible(false);
        btnSalvar.setVisible(false);
        btnExcluir.setVisible(false);
        preencherTabela();
        passaratributos();
        setBackground(new Color(245, 245, 245));
        
    }
    //consulta
       public void preencherTabela(){
        
        tblFornecedor.getColumnModel().getColumn(0).setPreferredWidth(4); 
        tblFornecedor.getColumnModel().getColumn(1).setPreferredWidth(150); 
        tblFornecedor.getColumnModel().getColumn(2).setPreferredWidth(150); 
        tblFornecedor.getColumnModel().getColumn(3).setPreferredWidth(110);
        tblFornecedor.getColumnModel().getColumn(4).setPreferredWidth(14); 
        tblFornecedor.getColumnModel().getColumn(5).setPreferredWidth(100 ); 
        
        DefaultTableModel modelo = (DefaultTableModel) tblFornecedor.getModel();
        modelo.setNumRows(0);
        
        try{
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()){
                modelo.addRow(new Object[]{
                   con_cliente.resultset.getString("cod_fornecedor"),
                   con_cliente.resultset.getString("produto_fornecido"),
                   con_cliente.resultset.getString("nome_fornecedor"),
                   con_cliente.resultset.getString("cnpj"),
                   con_cliente.resultset.getString("cep_fornecedor"), 
                   con_cliente.resultset.getString("cod_telefone") 
                });
            }
        }catch(SQLException erro){
            JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!!:");
        }
    }
    
    public void FK() {
        try {
            con_telef.resultset.last();
            n = con_telef.resultset.getString("cod_telefone");
            int a = Integer.parseInt(n);
            int n = a + 1;
            System.out.println(n + "");
            
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "não foi possivel posicionar no último registro" + erro);
        }
        
    }

    public void passaratributos() {
        txtCod.setText("" + Cad_Fornecedo.n1);//nome do campo.setText(Nome da classe main e o atributo que quer passar)
        
        System.out.println(txtCod.getText() + "c");
        pesquisa();
    }
    
    public void pesquisa() {
        try {
            String pesquisa = "select  *  from fornecedor where cod_fornecedor like'" + txtCod.getText() + "'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            
            con_cliente.executarSQL("select * from fornecedor order by cod_fornecedor");
            con_cliente.executarSQL(pesquisa);
            
            if (con_cliente.resultset.first()) {
                if ("null".equals(txtCod.getText())) {
                    System.out.println("a");
                    txtCod.setText("");
                    salvar = "insert";                    
                } else {
                    txtNome.setText(con_cliente.resultset.getString("nome_fornecedor"));
                    txtCNPJ.setText(con_cliente.resultset.getString("cnpj"));
                    txtCep.setText(con_cliente.resultset.getString("cep_fornecedor"));
                    //txtFone.setText(con_cliente.resultset.getString("telefone"));
                    txtProduto.setText(con_cliente.resultset.getString("produto_fornecido"));
                    telef = con_cliente.resultset.getString("cod_telefone");
                    System.out.println(telef + "a");
                    
                    String pesquisa2 = "select * from telefone_fornecedor where cod_telefone like '" + telef + "'";
                    
                    con_cliente.executarSQL(pesquisa2);
                    con_cliente.resultset.first();
                    txtFone.setText(con_cliente.resultset.getString("telefone"));
                    System.out.println(telef + "");
                    salvar = "update";                    
                }
            } else {
                System.out.println("a");
                txtCod.setText("");
                salvar = "insert";                
            }
        } catch (SQLException errosql) {
            System.out.println(telef + "");
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtFone = new javax.swing.JFormattedTextField();
        txtProduto = new javax.swing.JTextField();
        txtCep = new javax.swing.JFormattedTextField();
        txtCNPJ = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        btnExcluir = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        rbNao = new javax.swing.JRadioButton();
        rbSim = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblFornecedor = new swing_classes.Table_Column();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel1.setBackground(new java.awt.Color(245, 245, 245));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("CADASTRO DE FORNECEDORES");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("CEP");

        try {
            txtFone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            txtCNPJ.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Telefone");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Código");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("CNPJ");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Produto");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("Nome");

        txtCod.setEditable(false);
        txtCod.setEnabled(false);

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/application_delete.png"))); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/disk.png"))); // NOI18N
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbNao);
        rbNao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbNao.setForeground(new java.awt.Color(102, 102, 102));
        rbNao.setSelected(true);
        rbNao.setText("Não");
        rbNao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNaoActionPerformed(evt);
            }
        });

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

        tblFornecedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Produto Fornecido", "Nome", "CNPJ", "CEP", "Telefone"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
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
        tblFornecedor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblFornecedorKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblFornecedor);

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Deseja cadastrar um fornecedor?");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Consulte e cadastre os fornecedores.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcluir))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbNao))
                        .addGap(34, 34, 34)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtCNPJ, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCod, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtFone, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(rbSim, javax.swing.GroupLayout.Alignment.LEADING)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(274, 274, 274)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCep)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel6)
                    .addComponent(jLabel1))
                .addContainerGap(555, Short.MAX_VALUE))
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbNao)
                    .addComponent(rbSim))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel7))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3))))
                        .addGap(21, 21, 21)
                        .addComponent(txtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnExcluir, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(34, 34, 34))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        // TODO add your handling code here:
        String sql = "";
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro: ", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, 3);
            if (resposta == 0) {
                sql = "delete from fornecedor where cod_fornecedor = " + txtCod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    con_cliente.executarSQL("select * from fornecedor order by cod_fornecedor");
                    con_cliente.resultset.first();
                } else {
                    JOptionPane.showMessageDialog(null, "a");
                }
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "ad");
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        String CPF = txtCNPJ.getText();
        String cep = txtCep.getText();
        String produto_fornecido = txtProduto.getText();
        String telefone = txtFone.getText();
        
        try {
            if ("insert".equals(salvar)) {
                con_telef.executarSQL2("select * from telefone_fornecedor order by cod_telefone");
                
                String insert_sql2 = "insert into telefone_fornecedor (telefone) values ('" + telefone + "')";
                con_telef.executarSQL2("select * from telefone_fornecedor order by cod_telefone");
                //declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
                con_telef.statement.executeUpdate(insert_sql2);//executa (no ambiente Java -virtualmente) o comando de inserção.
                con_telef.executarSQL2("select * from telefone_fornecedor order by cod_telefone");
                con_telef.resultset.first();
                FK();
                
                con_cliente.executarSQL("select * from fornecedor order by cod_fornecedor");
                String insert_sql = "INSERT INTO `fornecedor`(`nome_fornecedor`, `cnpj`, `cod_telefone`, `cep_fornecedor`, `produto_fornecido`) values ('" + nome + "','" + CPF + "','" + n + "','" + cep + "','" + produto_fornecido + "')";

                //declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
                con_cliente.statement.executeUpdate(insert_sql);//executa (no ambiente Java -virtualmente) o comando de inserção.
                con_cliente.executarSQL("select * from fornecedor order by cod_fornecedor");
                con_cliente.resultset.first();
                preencherTabela();
                mostrar_Dados();
                
            } else if ("update".equals(salvar)) {
                
                System.out.println(telef + "");
                String insert_sql2 = "update telefone_fornecedor set telefone='" + telefone + "' where cod_telefone = " + telef;
                //update telefone_fornecedor set telefone= 55 where cod_telefone = 2;
                con_telef.executarSQL2("select * from telefone_fornecedor order by cod_telefone");
                con_telef.statement.executeUpdate(insert_sql2);
                con_telef.executarSQL2("select * from telefone_fornecedor order by cod_telefone");
                con_telef.resultset.first();
                
                con_cliente.executarSQL("select * from fornecedor order by cod_fornecedor");
                String insert_sql = "update fornecedor set nome_fornecedor='" + nome + "',cnpj='" + CPF + "', cep_fornecedor='"
                        + cep + "', produto_fornecido='" + produto_fornecido + "' where cod_fornecedor = " + txtCod.getText();
                con_cliente.statement.executeUpdate(insert_sql);
                con_cliente.executarSQL("select * from fornecedor order by cod_fornecedor");
                con_cliente.resultset.first();
                preencherTabela();
                mostrar_Dados();
                
            } else {
                System.out.println("s");
            }
        } catch (Exception errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro de gravação: \n" + errosql, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void rbNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNaoActionPerformed
        
        jLabel10.setVisible(false);
        jLabel11.setVisible(false);
        jLabel2.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel7.setVisible(false);
        txtCNPJ.setVisible(false);
        txtCep.setVisible(false);
        txtCod.setVisible(false);
        txtFone.setVisible(false);
        txtNome.setVisible(false);
        txtProduto.setVisible(false);
        btnSalvar.setVisible(false);
        btnExcluir.setVisible(false);
    }//GEN-LAST:event_rbNaoActionPerformed

    private void rbSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSimActionPerformed
        
        jLabel10.setVisible(true);
        jLabel11.setVisible(true);
        jLabel2.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel7.setVisible(true);
        txtCNPJ.setVisible(true);
        txtCep.setVisible(true);
        txtCod.setVisible(true);
        txtFone.setVisible(true);
        txtNome.setVisible(true);
        txtProduto.setVisible(true);
        btnSalvar.setVisible(true);
        btnExcluir.setVisible(true);
    }//GEN-LAST:event_rbSimActionPerformed

    private void tblFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFornecedorMouseClicked
        setLinha_selecionada(tblFornecedor.getSelectedRow());
        n1=tblFornecedor.getValueAt(getLinha_selecionada(),0).toString();
        System.out.println(n1+"");
        
        int selecao = tblFornecedor.getSelectedRow();
        txtCod.setText(tblFornecedor.getValueAt(selecao, 0).toString());
        txtProduto.setText(tblFornecedor.getValueAt(selecao, 1).toString());
        txtNome.setText(tblFornecedor.getValueAt(selecao, 2).toString());
        txtCNPJ.setText(tblFornecedor.getValueAt(selecao, 3).toString());
        txtCep.setText(tblFornecedor.getValueAt(selecao, 4).toString());
        txtFone.setText(tblFornecedor.getValueAt(selecao, 5).toString());
    }//GEN-LAST:event_tblFornecedorMouseClicked

    private void tblFornecedorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblFornecedorKeyPressed
       int selecao = tblFornecedor.getSelectedRow();
        txtCod.setText(tblFornecedor.getValueAt(selecao, 0).toString());
        txtProduto.setText(tblFornecedor.getValueAt(selecao, 1).toString());
        txtNome.setText(tblFornecedor.getValueAt(selecao, 2).toString());
        txtCNPJ.setText(tblFornecedor.getValueAt(selecao, 3).toString());
        txtCep.setText(tblFornecedor.getValueAt(selecao, 4).toString());
        txtFone.setText(tblFornecedor.getValueAt(selecao, 5).toString());
        
    }//GEN-LAST:event_tblFornecedorKeyPressed

    public int getLinha_selecionada() {
        return linha_selecionada;
    }

    public void setLinha_selecionada(int linha_selecionada) {
        this.linha_selecionada = linha_selecionada;
    }
    
    public void mostrar_Dados(){
        try{
            txtCod.setText(con_cliente.resultset.getString("cod_adereco"));
            txtProduto.setText(con_cliente.resultset.getString("tipo_adereco"));
            txtNome.setText(con_cliente.resultset.getString("preco_adereco"));
            txtCNPJ.setText(con_cliente.resultset.getString("cnpj"));
            txtCep.setText(con_cliente.resultset.getString("cep_fornecedor"));
            txtProduto.setText(con_cliente.resultset.getString("produto_fornecido"));
            telef = con_cliente.resultset.getString("cod_telefone");
        }catch (SQLException erro){
            
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbSim;
    private swing_classes.Table_Column tblFornecedor;
    private javax.swing.JFormattedTextField txtCNPJ;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCod;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables
}
