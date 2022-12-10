package controle;

import java.awt.Color;
import conexao.Conexao;
import controle.Tela_gerente;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */

public class Cad_Produt extends javax.swing.JPanel {

    String salvar;
 Conexao con_cliente;
 Conexao con_telef;
 Conexao con_telef2;
 public String n;
 public String telef;
 public static String s;
 
    public Cad_Produt() {
        initComponents();
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executarSQL("SELECT a.cod_flor,a.id_material, b.cod_flor, c.id_material,b.especie,c.material,a.num_produto, a.preco_produto, a.nome FROM produto a, flor b, material c WHERE a.cod_flor = b.cod_flor AND a.id_material = c.id_material order by a.num_produto;");
        //mudar isso
        con_telef = new Conexao();
        con_telef.conecta();
        con_telef.executarSQL2("select * from material order by id_material");
        
        con_telef2 = new Conexao();
        con_telef2.conecta();
        con_telef2.executarSQL2("select * from flor order by cod_flor");
        
        preenchertabela();
        setBackground(new Color(245, 245, 245));
    }
    
    public void preenchertabela(){  
        
        tblProduto.getColumnModel().getColumn(1).setPreferredWidth(5); 
        tblProduto.getColumnModel().getColumn(1).setPreferredWidth(11);
        tblProduto.getColumnModel().getColumn(1).setPreferredWidth(14); 
        tblProduto.getColumnModel().getColumn(1).setPreferredWidth(100 ); 
        tblProduto.getColumnModel().getColumn(1).setPreferredWidth(14); 
        tblProduto.getColumnModel().getColumn(1).setPreferredWidth(14);
        
        DefaultTableModel modelo = (DefaultTableModel) tblProduto.getModel();
        modelo.setNumRows(0);
        try{
            
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()){
                modelo.addRow(new Object[]{
                   con_cliente.resultset.getString("num_produto"),
                    con_cliente.resultset.getString("nome"),
                    con_cliente.resultset.getString("especie"),
                    con_cliente.resultset.getString("material") , 
                    con_cliente.resultset.getString("preco_produto")
                //coloca todos os atributos que deseja mostrar e sua respectiva coluna
                });
            }
        }catch(SQLException erro){
    JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!!:");
            
        }
        
        
         DefaultTableModel modelo2 = (DefaultTableModel) tblMaterial.getModel();
        modelo2.setNumRows(0);
        try{
            con_telef.resultset.beforeFirst();
            while(con_telef.resultset.next()){
                modelo2.addRow(new Object[]{
                   con_telef.resultset.getString("material") 
                        //nome do atributo que deseja colocar na tabela
                });
            }
        }catch(SQLException erro){
    JOptionPane.showMessageDialog(null,"\n Erro ao listar dados da tabela!!:");}
        
        
        
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
    
    
    public void mostrar_Dados(){
        try{
            cod.setText(con_cliente.resultset.getString("cod"));
            int a= Integer.parseInt(cod.getText());
            System.out.println(a+1+"");
            Et.setText(con_cliente.resultset.getString("cod_flor"));
              Ft.setText(con_cliente.resultset.getString("material"));
              Nt.setText(con_cliente.resultset.getString("nome"));
              
           
                Pt.setText(con_cliente.resultset.getString("preco_produto"));
               
                  cod.setText(con_cliente.resultset.getString("num_produto"));
        }catch(SQLException erro){
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnDeletar = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblEspecie = new swing_classes.Table_Column();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblMaterial = new swing_classes.Table_Column();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblProduto = new swing_classes.Table_Column();
        cod = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Pt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Nt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        Ft = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        Et = new javax.swing.JTextField();

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

        tblMaterial.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Material"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblMaterial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblMaterialMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblMaterial);

        jScrollPane2.setBorder(null);
        jScrollPane2.setAutoscrolls(true);

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Lote", "Espécie", "Material", "Preço"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.setAutoscrolls(false);
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblProduto);

        cod.setEditable(false);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(102, 102, 102));
        jLabel10.setText("Material");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Espécie da flor");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Preço");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Nome");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("PRODUTO");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Registre quais serão os produtos da sua loja.");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("N° do lote");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel4)
                            .addComponent(jLabel2))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Pt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Nt, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Ft, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Et, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 182, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(263, 263, 263))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addGap(18, 18, 18)
                        .addComponent(btnSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btnAlterar)
                        .addGap(18, 18, 18)
                        .addComponent(btnDeletar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(cod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(Nt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(Et, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(Ft, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Pt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(68, 68, 68)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAlterar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(39, 39, 39)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
        // TODO add your handling code here:
        String sql="";
        try {
            int resposta=JOptionPane.showConfirmDialog(null, "Deseja excluir o registro: ","Confirmar Exclusão", JOptionPane.YES_NO_OPTION,3);
            if(resposta==0){
                sql="delete from produto where num_produto = "+cod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if(excluir==1){
                    con_cliente.executarSQL("SELECT a.cod_flor,a.id_material, b.cod_flor, c.id_material,b.especie,c.material,a.num_produto, a.preco_produto, a.nome FROM produto a, flor b, material c WHERE a.cod_flor = b.cod_flor AND a.id_material = c.id_material order by a.num_produto;");
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

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        cod.setText("");
        Et.setText("");
        Nt.setText("");
        Ft.setText("");
        Pt.setText("");

    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        String id=cod.getText();//declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String e=Et.getText();
        String nn=Nt.getText();
        String f=Ft.getText();
        String p=Pt.getText();
        try {
            String pesquisa="select * from material where material like'"+f+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa);
            con_cliente.resultset.first();
            String nf=con_cliente.resultset.getString("id_material");

            System.out.println(nf+"");

            String pesquisa2="select * from flor where especie like'"+e+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa2);
            con_cliente.resultset.first();
            String nf2=con_cliente.resultset.getString("cod_flor");

            System.out.println(nf2+"");

            con_cliente.executarSQL("select * from produto order by num_produto");
            String insert_sql="INSERT INTO `produto`(`id_material`, `cod_flor`, `preco_produto`, `nome`) values ('" + nf + "','" +  nf2 + "','" + p +"','" + nn +  "')";

            //declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
            con_cliente.statement.executeUpdate(insert_sql);//executa (no ambiente Java -virtualmente) o comando de inserção.

            con_cliente.executarSQL("SELECT a.cod_flor,a.id_material, b.cod_flor, c.id_material,b.especie,c.material,a.num_produto, a.preco_produto, a.nome FROM produto a, flor b, material c WHERE a.cod_flor = b.cod_flor AND a.id_material = c.id_material order by a.num_produto;");
            con_cliente.resultset.first();
            preenchertabela();
            mostrar_Dados();

        } catch (Exception errosql) {
            JOptionPane.showMessageDialog(null,"\n Erro de gravação: \n"+errosql,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        try {
            String id=cod.getText();//declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
            String e=Et.getText();
            String nn=Nt.getText();
            String f=Ft.getText();
            String p=Pt.getText();

            String pesquisa="select * from material where material like'"+f+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa);
            con_cliente.resultset.first();
            String nf=con_cliente.resultset.getString("id_material");

            String pesquisa2="select * from flor where especie like'"+e+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa2);
            con_cliente.resultset.first();
            String nf2=con_cliente.resultset.getString("cod_flor");

            con_cliente.executarSQL("select * from produto order by num_produto");
            String insert_sql="update produto set id_material='" +nf+"',nome='" + nn + "',cod_flor='" + nf2 + "',preco_produto='" + p + "' where num_produto = " + id;
            con_cliente.statement.executeUpdate(insert_sql);

            con_cliente.executarSQL("SELECT a.cod_flor,a.id_material, b.cod_flor, c.id_material,b.especie,c.material,a.num_produto, a.preco_produto, a.nome FROM produto a, flor b, material c WHERE a.cod_flor = b.cod_flor AND a.id_material = c.id_material order by a.num_produto;");
            con_cliente.resultset.first();
            preenchertabela();
            mostrar_Dados();

        } catch (Exception e) {
        }
    }//GEN-LAST:event_btnAlterarActionPerformed

    private void tblEspecieMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEspecieMouseClicked
        try{
                int linha_selecionadaa = tblEspecie.getSelectedRow();
                Et.setText(tblEspecie.getValueAt(linha_selecionadaa,0).toString());
                System.out.println(Et.getText()+"");

            } catch (Exception e) {

            }
    }//GEN-LAST:event_tblEspecieMouseClicked

    private void tblMaterialMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblMaterialMouseClicked
        try {

            int linha_selecionadaa = tblMaterial.getSelectedRow();
            Ft.setText(tblMaterial.getValueAt(linha_selecionadaa,0).toString());
            System.out.println(Ft.getText()+"");

        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblMaterialMouseClicked

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        int linha_selecionada = tblProduto.getSelectedRow();
        try {
        cod.setText(tblProduto.getValueAt(linha_selecionada,0).toString());
        Nt.setText(tblProduto.getValueAt(linha_selecionada,1).toString());
        Et.setText(tblProduto.getValueAt(linha_selecionada,2).toString());
        Ft.setText(tblProduto.getValueAt(linha_selecionada,3).toString());
        Pt.setText(tblProduto.getValueAt(linha_selecionada,4).toString());
        
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblProdutoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Et;
    private javax.swing.JTextField Ft;
    private javax.swing.JTextField Nt;
    private javax.swing.JTextField Pt;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JTextField cod;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private swing_classes.Table_Column tblEspecie;
    private swing_classes.Table_Column tblMaterial;
    private swing_classes.Table_Column tblProduto;
    // End of variables declaration//GEN-END:variables
}
