package controle;

import conexao.Conexao;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */
public class Cad_Pedid extends javax.swing.JPanel {

    String salvar;
    Conexao con_cliente;
    Conexao con_telef;
    Conexao con_telef2;
    Conexao con_telef3;
    public String n;
    public String telef;
    public static String s;

    public Cad_Pedid() {
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executarSQL("SELECT a.cod_cliente,a.cod_adereco, a.num_produto, b.cod_cliente,b.nome_contato,c.num_produto,c.nome, d.cod_adereco,d.tipo_adereco,a.valor,a.observacao,a.cod_funcionario, a.id_pedido FROM pedido a, tbclientes b, produto c, adereco d WHERE a.cod_cliente = b.cod_cliente AND a.num_produto = c.num_produto AND a.cod_adereco = d.cod_adereco order by a.id_pedido;");
        //mudar isso
        con_telef = new Conexao();
        con_telef.conecta();
        con_telef.executarSQL2("select * from tbclientes order by cod_cliente");
        
        con_telef2 = new Conexao();
        con_telef2.conecta();
        con_telef2.executarSQL2("select * from produto order by num_produto");
        
        con_telef3 = new Conexao();
        con_telef3.conecta();
        con_telef3.executarSQL2("select * from adereco order by cod_adereco");
        
        preenchertabela();
        setBackground(new Color(245, 245, 245));
    }

    public void preenchertabela(){  
        tblPedido.getColumnModel().getColumn(0).setPreferredWidth(5); 
        tblPedido.getColumnModel().getColumn(1).setPreferredWidth(30);
        tblPedido.getColumnModel().getColumn(2).setPreferredWidth(30); 
        tblPedido.getColumnModel().getColumn(3).setPreferredWidth(30); 
        tblPedido.getColumnModel().getColumn(4).setPreferredWidth(25); 
        tblPedido.getColumnModel().getColumn(5).setPreferredWidth(6);
        tblPedido.getColumnModel().getColumn(6).setPreferredWidth(150);
        
        DefaultTableModel modelo = (DefaultTableModel) tblPedido.getModel();
        modelo.setNumRows(0);
        
        try{
            con_cliente.resultset.beforeFirst();
            while(con_cliente.resultset.next()){
                modelo.addRow(new Object[]{
                   con_cliente.resultset.getString("id_pedido"),
                   con_cliente.resultset.getString("valor"),
                   con_cliente.resultset.getString("observacao")
                //coloca todos os atributos que deseja mostrar e sua respectiva coluna
                });
            }
        }catch(SQLException erro){
    JOptionPane.showMessageDialog(null,"\n Erro ao listar os atributos que deseja mostrar na tabela!!:");
        }
        
        
        DefaultTableModel modelo2 = (DefaultTableModel) tblCliente.getModel();
        modelo2.setNumRows(0);
        try{
            con_telef.resultset.beforeFirst();
            while(con_telef.resultset.next()){
                modelo2.addRow(new Object[]{
                   con_telef.resultset.getString("nome_contato"),
                   con_telef.resultset.getString("responsavel") 
                        //nome do atributo que deseja colocar na tabela
                });
            }
        }catch(SQLException erro){
    JOptionPane.showMessageDialog(null,"\n Erro ao listar dados estrangeiros do cliente!!:");}
        
        
        
        DefaultTableModel modelo3 = (DefaultTableModel) tblProduto.getModel();
        modelo3.setNumRows(0);
        try{
            con_telef2.resultset.beforeFirst();
            while(con_telef2.resultset.next()){
                modelo3.addRow(new Object[]{
                   con_telef2.resultset.getString("nome") 
                        //nome do atributo que deseja colocar na tabela
                });
            }
        }catch(SQLException erro){
    JOptionPane.showMessageDialog(null,"\n Erro ao listar dados estrangeiros do produto!!:");}
        
        DefaultTableModel modelo4 = (DefaultTableModel) tblAderecos.getModel();
        modelo4.setNumRows(0);
        try{
            con_telef3.resultset.beforeFirst();
            while(con_telef3.resultset.next()){
                modelo4.addRow(new Object[]{
                   con_telef3.resultset.getString("tipo_adereco") 
                        //nome do atributo que deseja colocar na tabela
                });
            }
        }catch(SQLException erro){
    JOptionPane.showMessageDialog(null,"\n Erro ao listar dados estrangeiros da tabela adereço!!:");}
    
    
        
    }
    
    /*
        id pedido
        nome do cliente
        nome do contato
        produto
        adereço
        preço
        obs
        */
    public void mostrar_Dados(){
        try{
            txtCod.setText(con_cliente.resultset.getString("id_pedido"));
            int a= Integer.parseInt(txtCod.getText());
            System.out.println(a+1+"");
            txtCliente.setText(con_cliente.resultset.getString("nome_contato"));
            txtProduto.setText(con_cliente.resultset.getString("nome"));
            txtAdereco.setText(con_cliente.resultset.getString("tipo_adereco"));
            txtPreco.setText(con_cliente.resultset.getString("valor"));
            txtContato.setText(con_cliente.resultset.getString("cod_cliente"));
            txtObs.setText(con_cliente.resultset.getString("observacao"));
        }catch(SQLException erro){
            
        }
    
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalvar = new javax.swing.JButton();
        btnAlterar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblPedido = new swing_classes.Table_Column();
        jLabel9 = new javax.swing.JLabel();
        txtPreco = new javax.swing.JTextField();
        txtContato = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        txtProduto = new javax.swing.JTextField();
        txtAdereco = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblCliente = new swing_classes.Table_Column();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblProduto = new swing_classes.Table_Column();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblAderecos = new swing_classes.Table_Column();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtObs = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

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

        tblPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Pedido", "Cliente", "Contato ( jurídico )", "Produto", "Adereço", "Preço", "Observação"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPedido.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPedidoMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPedido);

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("Produto");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("N° do responsável");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Cliente");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Adereço");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Valor");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("N° do pedido");

        txtCod.setEditable(false);
        txtCod.setEnabled(false);

        jScrollPane6.setBorder(null);

        tblCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClienteMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblCliente);

        jScrollPane7.setBorder(null);

        tblProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Produto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProduto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProdutoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblProduto);

        jScrollPane8.setBorder(null);

        tblAderecos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Adereços"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAderecos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAderecosMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblAderecos);

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(102, 102, 102));
        jLabel11.setText("Observações");

        txtObs.setColumns(20);
        txtObs.setRows(5);
        jScrollPane4.setViewportView(txtObs);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("PEDIDO");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Cadastre pedidos.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel9)
                                        .addComponent(jLabel2))
                                    .addGap(48, 48, 48)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtProduto, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                        .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtCliente)))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel8))
                                    .addGap(82, 82, 82)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtAdereco, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                        .addComponent(txtPreco)))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtContato)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAdd)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnSalvar)
                                .addGap(14, 14, 14)
                                .addComponent(btnAlterar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnDeletar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 186, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(45, 45, 45)
                                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane4))
                        .addGap(47, 47, 47))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(txtProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtAdereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAdd)
                    .addComponent(btnSalvar)
                    .addComponent(btnAlterar)
                    .addComponent(btnDeletar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        String id=txtCod.getText();//declara as variáveis e atribui a elas obs valor de cada caixa de texto respectivamente, através do método “getText()”.
        String m=txtCliente.getText();
        String c=txtProduto.getText();
        String f=txtAdereco.getText();
        String d=txtPreco.getText();
        String ff=txtContato.getText();
        String obs=txtObs.getText();
        try {
            String pesquisa="select * from tbclientes where nome_contato like'"+m+"%'";
            System.out.println(m+"");
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, obs comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa);
            con_cliente.resultset.first();
            String nf=con_cliente.resultset.getString("cod_cliente");

            System.out.println(nf+"1a");

            String pesquisa2="select * from produto where nome like'"+c+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, obs comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa2);
            con_cliente.resultset.first();
            String nf2=con_cliente.resultset.getString("num_produto");

            System.out.println(nf2+"2b");

            String pesquisa3="select * from adereco where tipo_adereco like'"+f+"%'";

            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, obs comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa3);

            con_cliente.resultset.first();
            System.out.println("a");
            String nf3=con_cliente.resultset.getString("cod_adereco");//aquii
            System.out.println("aa");
            System.out.println(nf3+"3c");
            System.out.println("");

            con_cliente.executarSQL("select * from pedido order by id_pedido");
            String insert_sql="INSERT INTO `pedido`(`cod_cliente`, `num_produto`, `cod_adereco`, `valor`,`matricula`,`observacao`) values ('" + nf + "','" +  nf2 + "','" + nf3 +"','" + d +"','" + ff +"','" + obs + "')";

            //declara as variáveis e atribui a elas obs valor de cada caixa de texto respectivamente, através do método “getText()”.
            con_cliente.statement.executeUpdate(insert_sql);//executa (no ambiente Java -virtualmente) obs comando de inserção.

            con_cliente.executarSQL("SELECT a.cod_cliente,a.cod_adereco, a.num_produto, b.cod_cliente,b.nome_contato,c.num_produto,c.nome, d.cod_adereco,d.tipo_adereco,a.valor,a.observacao,a.matricula, a.id_pedido FROM pedido a, tbclientes b, produto c, adereco d WHERE a.cod_cliente = b.cod_cliente AND a.num_produto = c.num_produto AND a.cod_adereco = d.cod_adereco order by a.id_pedido;");
            con_cliente.resultset.first();

            preenchertabela();
            mostrar_Dados();

        } catch (Exception errosql) {
            JOptionPane.showMessageDialog(null,"\n Erro de gravação: \n"+errosql,"Mensagem do programa",JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlterarActionPerformed
        // TODO add your handling code here:
        String id=txtCod.getText();//declara as variáveis e atribui a elas obs valor de cada caixa de texto respectivamente, através do método “getText()”.
        String m=txtCliente.getText();
        String c=txtProduto.getText();
        String f=txtAdereco.getText();
        String d=txtPreco.getText();
        String ff=txtContato.getText();
        String obs=txtObs.getText();
        try {
            String pesquisa="select * from tbclientes where nome_contato like'"+m+"%'";
            System.out.println(m+"");
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, obs comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa);
            con_cliente.resultset.first();
            System.out.println("1");
            String nf=con_cliente.resultset.getString("cod_cliente");
            System.out.println(nf+"");

            String pesquisa2="select * from produto where nome like'"+c+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, obs comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa2);
            con_cliente.resultset.first();
            String nf2=con_cliente.resultset.getString("num_produto");
            System.out.println(nf2+"");

            String pesquisa3="select * from adereco where tipo_adereco like'"+f+"%'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, obs comando filtrou todos nomes começados com “G”.
            con_cliente.executarSQL(pesquisa3);
            con_cliente.resultset.first();
            String nf3=con_cliente.resultset.getString("cod_adereco");
            System.out.println(nf3+"cc");

            con_cliente.executarSQL("select * from pedido order by id_pedido");
            System.out.println("1z");
            String insert_sql="update pedido set cod_adereco='"+nf3+"', cod_cliente='"+nf+"',valor='" + d + "',num_produto='" + nf2 +"',observacao='" +obs+"',matricula='" +ff+ "' where id_pedido = " + id;
            //String insert_sql="update lote set cor_flores='" + c +"',cod_fornecedor='" +nf+"',dt_entrega='" + d + "',cod_flor='" + nf2 + "',quantidade_flores='" + p + "' where num_lote = " + id;

            //`cod_cliente`='1',`num_produto`='[value-3]',`valor`='[value-4]',`cod_adereco`='[value-5]',`observacao`='[value-6]',`matricula`='[value-7]'
            System.out.println("");
            con_cliente.statement.executeUpdate(insert_sql);
            System.out.println("2a");

            con_cliente.executarSQL("SELECT a.cod_cliente,a.cod_adereco, a.num_produto, b.cod_cliente,b.nome_contato,c.num_produto,c.nome, d.cod_adereco,d.tipo_adereco,a.valor,a.observacao,a.matricula, a.id_pedido FROM pedido a, tbclientes b, produto c, adereco d WHERE a.cod_cliente = b.cod_cliente AND a.num_produto = c.num_produto AND a.cod_adereco = d.cod_adereco order by a.id_pedido;");
            System.out.println("3b");
            con_cliente.resultset.first();
            preenchertabela();
            System.out.println("4c");
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
                sql="delete from pedido where id_pedido = "+txtCod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if(excluir==1){
                    con_cliente.executarSQL("SELECT a.cod_cliente,a.cod_adereco, a.num_produto, b.cod_cliente,b.nome_contato,c.num_produto,c.nome, d.cod_adereco,d.tipo_adereco,a.valor,a.observacao,a.matricula, a.id_pedido FROM pedido a, tbclientes b, produto c, adereco d WHERE a.cod_cliente = b.cod_cliente AND a.num_produto = c.num_produto AND a.cod_adereco = d.cod_adereco order by a.id_pedido;");
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
        String id=txtCod.getText();//declara as variáveis e atribui a elas obs valor de cada caixa de texto respectivamente, através do método “getText()”.
        String m=txtCliente.getText();
        String c=txtProduto.getText();
        String f=txtAdereco.getText();
        String d=txtPreco.getText();
    }//GEN-LAST:event_btnAddActionPerformed

    private void tblPedidoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPedidoMouseClicked
        int linha_selecionada = tblPedido.getSelectedRow();
        try {
            
        
        txtCod.setText(tblPedido.getValueAt(linha_selecionada,0).toString());
        txtCliente.setText(tblPedido.getValueAt(linha_selecionada,1).toString());
        txtProduto.setText(tblPedido.getValueAt(linha_selecionada,2).toString());
        txtAdereco.setText(tblPedido.getValueAt(linha_selecionada,3).toString());
        txtPreco.setText(tblPedido.getValueAt(linha_selecionada,4).toString());
       /* String pesquisa="select  *  from fornecedor where cod_fornecedor like'"+Ft.getText()+"'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, obs comando filtrou todos nomes começados com “G”.
            Ft.setText(con_cliente.resultset.getString("nome_fornecedor"));
            con_cliente.executarSQL(pesquisa);
        System.out.println(linha_selecionada+"");*/
        } catch (Exception e) {
        }
    }//GEN-LAST:event_tblPedidoMouseClicked

    private void tblClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClienteMouseClicked
        try{
            int linha_selecionadaa = tblCliente.getSelectedRow();
            txtCliente.setText(tblCliente.getValueAt(linha_selecionadaa,0).toString());
            System.out.println(txtCliente.getText()+"");

        } catch (Exception e) {
    
        }
    }//GEN-LAST:event_tblClienteMouseClicked

    private void tblProdutoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProdutoMouseClicked
        try{
            int linha_selecionadaa = tblProduto.getSelectedRow();
            txtProduto.setText(tblProduto.getValueAt(linha_selecionadaa,0).toString());
            System.out.println(txtProduto.getText()+"");

        } catch (Exception e) {
    
        }
    }//GEN-LAST:event_tblProdutoMouseClicked

    private void tblAderecosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAderecosMouseClicked
        try{
            int linha_selecionadaa = tblAderecos.getSelectedRow();
            txtAdereco.setText(tblAderecos.getValueAt(linha_selecionadaa,0).toString());
            System.out.println(txtAdereco.getText()+"");

        } catch (Exception e) {
    
        }
    }//GEN-LAST:event_tblAderecosMouseClicked

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAlterar;
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private swing_classes.Table_Column tblAderecos;
    private swing_classes.Table_Column tblCliente;
    private swing_classes.Table_Column tblPedido;
    private swing_classes.Table_Column tblProduto;
    private javax.swing.JTextField txtAdereco;
    private javax.swing.JTextField txtCliente;
    private javax.swing.JTextField txtCod;
    private javax.swing.JTextField txtContato;
    private javax.swing.JTextArea txtObs;
    private javax.swing.JTextField txtPreco;
    private javax.swing.JTextField txtProduto;
    // End of variables declaration//GEN-END:variables
}
