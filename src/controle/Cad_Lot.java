package controle;

import java.awt.Color;
import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;


/*
 * @author Kezia, Lucas Hideo e Melissa
 */

public class Cad_Lot extends javax.swing.JPanel {

    String salvar;
    Conexao con_cliente;
    Conexao con_telef;
    Conexao con_telef2;
    public String n;
    public String telef;
    public static String s;
    
    public Cad_Lot() {
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executarSQL("SELECT a.cod_flor,a.cod_fornecedor, b.cod_flor, c.cod_fornecedor,b.especie,c.nome_fornecedor,a.num_lote, a.quantidade_flores, a.cor_flores,a.dt_entrega FROM lote a, flor b, fornecedor c WHERE a.cod_flor = b.cod_flor AND a.cod_fornecedor = c.cod_fornecedor order by a.num_lote;");
        //mudar isso
        con_telef = new Conexao();
        con_telef.conecta();
        con_telef.executarSQL2("select * from fornecedor order by cod_fornecedor");
        
        con_telef2 = new Conexao();
        con_telef2.conecta();
        con_telef2.executarSQL2("select * from flor order by cod_flor");
  
        preenchertabela();
        setBackground(new Color(245, 245, 245));
    }
    
     public void preenchertabela(){  
        tblLote.getColumnModel().getColumn(0).setPreferredWidth(5); 
        tblLote.getColumnModel().getColumn(1).setPreferredWidth(11);
        tblLote.getColumnModel().getColumn(2).setPreferredWidth(14); 
        tblLote.getColumnModel().getColumn(3).setPreferredWidth(100); 
        tblLote.getColumnModel().getColumn(4).setPreferredWidth(14); 
        tblLote.getColumnModel().getColumn(5).setPreferredWidth(14);
        
        DefaultTableModel modelo = (DefaultTableModel) tblLote.getModel();
        modelo.setNumRows(0);
        try{
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()){
                modelo.addRow(new Object[]{
                   con_cliente.resultset.getString("num_lote"),
                   con_cliente.resultset.getString("especie"),
                   con_cliente.resultset.getString("cor_flores"), 
                   con_cliente.resultset.getString("cod_fornecedor"), 
                   con_cliente.resultset.getString("quantidade_flores"),
                   con_cliente.resultset.getString("dt_entrega")
                //coloca todos os atributos que deseja mostrar e sua respectiva coluna
                });
                //System.out.println("a");
            }
        }catch(SQLException erro){
    JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!!:");
            
        }
        //Tabela Fornecedor
        DefaultTableModel modelo2 = (DefaultTableModel) tblFornecedor.getModel();
        modelo2.setNumRows(0);
        try{
            con_telef.resultset.beforeFirst();
            while(con_telef.resultset.next()){
                modelo2.addRow(new Object[]{
                   con_telef.resultset.getString("nome_fornecedor") 
                        //nome do atributo que deseja colocar na tabela
                });
            }
        }catch(SQLException erro){
    JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!!:");}
        
        
        //Tabela Flores
        DefaultTableModel modelo3 = (DefaultTableModel) tblEspecie.getModel();
        modelo3.setNumRows(0);
        try{
            con_telef2.resultset.beforeFirst();
            while(con_telef2.resultset.next()){
                modelo3.addRow(new Object[]{
                   con_telef2.resultset.getString("especie") 
                        //nome do atributo que deseja colocar na tabela
                });
            }
        }catch(SQLException erro){
    JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!!:");}
    
    }
     
     
     public void posicionarRegistro() {
        try {
            con_cliente.resultset.first();
            mostrar_Dados();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Não foi possivel posicionar no primeiro registro:" + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }
     
     
    
    
    public void mostrar_Dados(){
        try{
            txtCod.setText(con_cliente.resultset.getString("cod_flor"));
            int a= Integer.parseInt(txtCod.getText());
            System.out.println(a+1+"");
            
            txtEspecie.setText(con_cliente.resultset.getString("especie"));
            txtFornecedor.setText(con_cliente.resultset.getString("nome_fornecedor"));
              
            txtCor.setText(con_cliente.resultset.getString("cor_flores"));
            txtQuant.setText(con_cliente.resultset.getString("quantidade_flores"));
            txtDtEntrega.setText(con_cliente.resultset.getString("dt_entrega"));
            txtCod.setText(con_cliente.resultset.getString("num_lote"));
        }catch(SQLException erro){
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLote = new swing_classes.Table_Column();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtFornecedor = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtEspecie = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCor = new javax.swing.JTextField();
        txtDtEntrega = new javax.swing.JTextField();
        txtQuant = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblEspecie = new swing_classes.Table_Column();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblFornecedor = new swing_classes.Table_Column();
        jLabel8 = new javax.swing.JLabel();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("CADASTRO DE LOTE");

        jScrollPane2.setBorder(null);

        tblLote.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "N° do lote", "Espécie", "Cor", "Quantidade", "Fornecedor", "Data de Entrega"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLote.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoteMouseClicked(evt);
            }
        });
        tblLote.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tblLoteKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(tblLote);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Espécie da flor");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Quantidade");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Data de Entrega");

        txtFornecedor.setEditable(false);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("N° do lote");

        txtEspecie.setEditable(false);

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Cor");

        txtCod.setEditable(false);
        txtCod.setEnabled(false);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Fornecedor");

        btnAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/add.png"))); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

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

        jScrollPane6.setBorder(null);

        tblEspecie.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Espécie"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEspecie.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEspecieMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblEspecie);

        jScrollPane7.setBorder(null);

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
        jScrollPane7.setViewportView(tblFornecedor);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Tela para cadastramento de lotes.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))
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
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(26, 26, 26)
                                        .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(25, 25, 25)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(txtCor)
                                                .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 208, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(256, 256, 256))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel3)
                                    .addComponent(txtEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtCor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4)
                                    .addComponent(txtQuant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5)
                                    .addComponent(txtDtEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(btnDeletar))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(55, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblLoteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoteMouseClicked
        int linha_selecionada = tblLote.getSelectedRow();
        try {
            
        
        txtCod.setText(tblLote.getValueAt(linha_selecionada,0).toString());
        txtEspecie.setText(tblLote.getValueAt(linha_selecionada,1).toString());
        txtCor.setText(tblLote.getValueAt(linha_selecionada,2).toString());
        txtFornecedor.setText(tblLote.getValueAt(linha_selecionada,3).toString());
        txtQuant.setText(tblLote.getValueAt(linha_selecionada,4).toString());
        txtDtEntrega.setText(tblLote.getValueAt(linha_selecionada,5).toString());
       /* String pesquisa="select  *  from fornecedor where cod_fornecedor like'"+Ft.getText()+"'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            Ft.setText(con_cliente.resultset.getString("nome_fornecedor"));
            con_cliente.executarSQL(pesquisa);
        System.out.println(linha_selecionada+"");*/
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblLoteMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        txtCod.setText("");
        txtEspecie.setText("");
        txtCor.setText("");
        txtFornecedor.setText("");
        txtQuant.setText("");
        txtDtEntrega.setText("");
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        String id=txtCod.getText();//declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String m=txtEspecie.getText();
        String c=txtCor.getText();
        String f=txtFornecedor.getText();
        String p=txtQuant.getText();
        String d=txtDtEntrega.getText();
        try {
            String pesquisa="select * from fornecedor where nome_fornecedor like'"+f+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa);
            con_cliente.resultset.first();
            String nf=con_cliente.resultset.getString("cod_fornecedor");

            System.out.println(nf+"");

            String pesquisa2="select * from flor where especie like'"+m+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa2);
            con_cliente.resultset.first();
            String nf2=con_cliente.resultset.getString("cod_flor");

            System.out.println(nf2+"");

            con_cliente.executarSQL("select * from lote order by num_lote");
            String insert_sql="INSERT INTO `lote`(`cod_fornecedor`, `cod_flor`, `cor_flores`, `quantidade_flores`,`dt_entrega`) values ('" + nf + "','" +  nf2 + "','" + c +"','" + p +"','" + d + "')";

            //declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
            con_cliente.statement.executeUpdate(insert_sql);//executa (no ambiente Java -virtualmente) o comando de inserção.

            con_cliente.executarSQL("SELECT a.cod_flor,a.cod_fornecedor, b.cod_flor, c.cod_fornecedor,b.especie,c.nome_fornecedor,a.num_lote, a.quantidade_flores, a.cor_flores,a.dt_entrega FROM lote a, flor b, fornecedor c WHERE a.cod_flor = b.cod_flor AND a.cod_fornecedor = c.cod_fornecedor order by a.num_lote;");
            con_cliente.resultset.first();
            preenchertabela();
            mostrar_Dados();

        } catch (Exception errosql) {
            JOptionPane.showMessageDialog(null,"\n Erro de gravação: \n"+errosql,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        String id=txtCod.getText();//declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String m=txtEspecie.getText();
        String c=txtCor.getText();
        String f=txtFornecedor.getText();
        String p=txtQuant.getText();
        String d=txtDtEntrega.getText();
        try {
            String pesquisa="select * from fornecedor where nome_fornecedor like'"+f+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa);
            con_cliente.resultset.first();
            String nf=con_cliente.resultset.getString("cod_fornecedor");

            String pesquisa2="select * from flor where especie like'"+m+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa2);
            con_cliente.resultset.first();
            String nf2=con_cliente.resultset.getString("cod_flor");

            con_cliente.executarSQL("select * from lote order by num_lote");
            String insert_sql="update lote set cor_flores='" + c +"',cod_fornecedor='" +nf+"',dt_entrega='" + d + "',cod_flor='" + nf2 + "',quantidade_flores='" + p + "' where num_lote = " + id;
            con_cliente.statement.executeUpdate(insert_sql);

            con_cliente.executarSQL("SELECT a.cod_flor,a.cod_fornecedor, b.cod_flor, c.cod_fornecedor,b.especie,c.nome_fornecedor,a.num_lote, a.quantidade_flores, a.cor_flores,a.dt_entrega FROM lote a, flor b, fornecedor c WHERE a.cod_flor = b.cod_flor AND a.cod_fornecedor = c.cod_fornecedor order by a.num_lote;");
            con_cliente.resultset.first();
            preenchertabela();
            mostrar_Dados();
        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String sql="";
        try {
            int resposta=JOptionPane.showConfirmDialog(null, "Deseja excluir o registro: ","Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
            if(resposta==0){
                sql="delete from lote where num_lote = "+txtCod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if(excluir==1){
                    con_cliente.executarSQL("SELECT a.cod_flor,a.cod_fornecedor, b.cod_flor, c.cod_fornecedor,b.especie,c.nome_fornecedor,a.num_lote, a.quantidade_flores, a.cor_flores,a.dt_entrega FROM lote a, flor b, fornecedor c WHERE a.cod_flor = b.cod_flor AND a.cod_fornecedor = c.cod_fornecedor order by a.num_lote;");
                    con_cliente.resultset.first();
                    preenchertabela();
                    mostrar_Dados();
                }
                else{
                    JOptionPane.showMessageDialog(null, "a");
                }
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "ad");
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void tblEspecieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEspecieMouseClicked
        try {

            int linha_selecionadaa = tblFornecedor.getSelectedRow();
            txtFornecedor.setText(tblFornecedor.getValueAt(linha_selecionadaa,0).toString());
            System.out.println(txtFornecedor.getText()+"");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblEspecieMouseClicked

    private void tblFornecedorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFornecedorMouseClicked
        try{
                int linha_selecionadaa = tblEspecie.getSelectedRow();
                txtEspecie.setText(tblEspecie.getValueAt(linha_selecionadaa,0).toString());
                System.out.println(txtEspecie.getText()+"");

            } catch (Exception e) {

            }
    }//GEN-LAST:event_tblFornecedorMouseClicked

    private void tblLoteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tblLoteKeyPressed
        int linha_selecionada = tblLote.getSelectedRow();
        try {
            
        
        txtCod.setText(tblLote.getValueAt(linha_selecionada,0).toString());
        txtEspecie.setText(tblLote.getValueAt(linha_selecionada,1).toString());
        txtCor.setText(tblLote.getValueAt(linha_selecionada,2).toString());
        txtFornecedor.setText(tblLote.getValueAt(linha_selecionada,3).toString());
        txtQuant.setText(tblLote.getValueAt(linha_selecionada,4).toString());
        txtDtEntrega.setText(tblLote.getValueAt(linha_selecionada,5).toString());
       /* String pesquisa="select  *  from fornecedor where cod_fornecedor like'"+Ft.getText()+"'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            Ft.setText(con_cliente.resultset.getString("nome_fornecedor"));
            con_cliente.executarSQL(pesquisa);
        System.out.println(linha_selecionada+"");*/
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblLoteKeyPressed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private swing_classes.Table_Column tblEspecie;
    private swing_classes.Table_Column tblFornecedor;
    private swing_classes.Table_Column tblLote;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtCor;
    private javax.swing.JTextField txtDtEntrega;
    private javax.swing.JTextField txtEspecie;
    private javax.swing.JTextField txtFornecedor;
    private javax.swing.JTextField txtQuant;
    // End of variables declaration//GEN-END:variables
}
