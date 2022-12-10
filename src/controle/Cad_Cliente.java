package controle;

import java.awt.Color;
import conexao.Conexao;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */
public class Cad_Cliente extends javax.swing.JPanel {

    String salvar;
    Conexao con_cliente;
    Conexao con_telef;
    public String n;
    public String telef;
    private int linha_selecionada;
    public static String n1;

    public Cad_Cliente() {
        initComponents();
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_cliente.executarSQL("SELECT *\n"
                + "FROM tbclientes\n"
                + "INNER JOIN telefone_cliente ON tbclientes.telefone_cliente = telefone_cliente.cod_telefone");
        //INNER JOIN faz o select de duas variáveis ao mesmo tempo
        //INNER JOIN ON tabela1.atributo(PK) = tabela2.atributo(FK)
        //estabelece conexão entre as duas tabelas
        con_telef = new Conexao();
        con_telef.conecta();
        con_telef.executarSQL2("select * from telefone_cliente order by cod_telefone");
        jLabel1.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel8.setVisible(false);
        lblCadastroPJF.setVisible(false);
        jcbPessoa.setVisible(false);
        txtCPF.setVisible(false);
        txtCep.setVisible(false);
        txtCod.setVisible(false);
        txtFone.setVisible(false);
        txtNome.setVisible(false);
        txtNum.setVisible(false);
        txtResponsavel.setVisible(false);
        txtRua.setVisible(false);
        btnSalvar.setVisible(false);
        btnDeletar.setVisible(false);
        lblNome.setVisible(false);
        passaratributos();
        setBackground(new Color(245, 245, 245));
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
        txtResponsavel.setVisible(false);
        lblResponsavel.setVisible(false);

        txtCod.setText("" + Cad_Cliente.n1);//nome do campo.setText(Nome da classe main e o atributo que quer passar)
        /*txtCPF.setText(""+Consulta_cliente.n2);
        txtCNPJ.setText(""+Consulta_cliente.n3);
        txtCep.setText(""+Consulta_cliente.n4);
        txtFone.setText(""+Consulta_cliente.n5);
        txtRua.setText(""+Consulta_cliente.n6);
        txtNum.setText(""+Consulta_cliente.n7);*/

        System.out.println(txtCod.getText() + "");
        pesquisa();
    }

    public void pesquisa() {
        try {
            String pesquisa = "select  *  from tbclientes where cod_cliente like'" + txtCod.getText() + "'";
            //O percentual significa que “qualquer complemento” será colocado a(s) letra(s) digitadas. Então digitado a letra “G”, o comando filtrou todos nomes começados com “G”.

            con_cliente.executarSQL(pesquisa);

            if (con_cliente.resultset.first()) {
                if ("null".equals(txtCod.getText())) {
                    System.out.println("a");
                    txtCod.setText("");
                    salvar = "insert";
                } else {
                    txtResponsavel.setText(con_cliente.resultset.getString("responsavel"));
                    diferenca();
                    jcbPessoa.setVisible(false);
                    txtNome.setText(con_cliente.resultset.getString("nome_contato"));
                    txtCPF.setText(con_cliente.resultset.getString("cpf"));
                    txtCep.setText(con_cliente.resultset.getString("cep"));
                    //txtFone.setText(con_cliente.resultset.getString("telefone"));
                    txtRua.setText(con_cliente.resultset.getString("Rua"));
                    txtNum.setText(con_cliente.resultset.getString("Numero"));
                    System.out.println(txtCPF.getText() + "");

                    telef = con_cliente.resultset.getString("telefone_cliente");

                    String pesquisa2 = "select * from telefone_cliente where cod_telefone like '" + telef + "'";
                    System.out.println(telef + "a");
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
            System.out.println("erro");
        }

    }

    public void diferenca() {
        /*o nome de contato precisa aparecer APENAS nas informações de clientes jurídicos
então fazemos um laço de if assim:
se(nomeDeContao = nulo){ dado do nome de contato invisível
}else{ dado do nome de contato visível*/
        if ("".equals(txtResponsavel.getText())) {
            txtResponsavel.setVisible(false);
            lblResponsavel.setVisible(false);
            jcbPessoa.setVisible(false);

        } else if (!"".equals(txtResponsavel.getText())) {//se for juridico faça
            txtResponsavel.setVisible(true);
            lblResponsavel.setVisible(true);
            System.out.println(txtCPF.getText() + "");

            lblNome.setText("Nome da empresa");
            lblCadastroPJF.setText("CNPJ");
            try {
                txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));

            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }

        } else {
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblCadastroPJF = new javax.swing.JLabel();
        lblNome = new javax.swing.JLabel();
        jcbPessoa = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        lblResponsavel = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtResponsavel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCod = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtNome = new javax.swing.JTextField();
        txtNum = new javax.swing.JTextField();
        txtFone = new javax.swing.JFormattedTextField();
        txtRua = new javax.swing.JTextField();
        txtCep = new javax.swing.JFormattedTextField();
        txtCPF = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        btnSalvar = new javax.swing.JButton();
        btnDeletar = new javax.swing.JButton();
        rbNao = new javax.swing.JRadioButton();
        rbSim = new javax.swing.JRadioButton();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblClientes = new swing_classes.Table_Column();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        lblCadastroPJF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCadastroPJF.setForeground(new java.awt.Color(102, 102, 102));
        lblCadastroPJF.setText("CPF");

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setForeground(new java.awt.Color(102, 102, 102));
        lblNome.setText("Nome");

        jcbPessoa.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jcbPessoa.setForeground(new java.awt.Color(102, 102, 102));
        jcbPessoa.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Físico", "Jurídico" }));
        jcbPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbPessoaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("CEP");

        lblResponsavel.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblResponsavel.setForeground(new java.awt.Color(102, 102, 102));
        lblResponsavel.setText("Responsável");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Telefone");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Rua");

        txtCod.setEditable(false);
        txtCod.setEnabled(false);

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(102, 102, 102));
        jLabel8.setText("Número");

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
            txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Código:");

        btnSalvar.setText("Salvar");
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnDeletar.setText("Excluir");
        btnDeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletarActionPerformed(evt);
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

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setText("Deseja cadastrar um cliente?");

        jScrollPane2.setBorder(null);

        tblClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Nome", "CPF/CNPJ", "Telefone", "CEP", "Rua", "N°", "Responsável"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblClientesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblClientes);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(102, 102, 102));
        jLabel2.setText("CLIENTE");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 102, 102));
        jLabel7.setText("Tela para consulta e cadastramento de clientes.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGap(133, 133, 133)
                                            .addComponent(rbSim))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(rbNao)
                                            .addGap(131, 131, 131)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel4)
                                            .addComponent(lblNome, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(30, 30, 30)
                                                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(26, 26, 26)
                                            .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(141, 141, 141))
                                        .addComponent(jcbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(lblResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(btnSalvar)
                                            .addGap(18, 18, 18)
                                            .addComponent(btnDeletar))))
                                .addGap(70, 70, 70)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblCadastroPJF)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1111, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbNao)
                            .addComponent(rbSim))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtCod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jcbPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(lblNome, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(22, 22, 22)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(lblCadastroPJF))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txtNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblResponsavel)
                    .addComponent(txtResponsavel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btnDeletar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(58, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jcbPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbPessoaActionPerformed
        // TODO add your handling code here:
        if ("Jurídico".equals(jcbPessoa.getSelectedItem().toString())) {
            lblResponsavel.setVisible(true);
            txtResponsavel.setVisible(true);
            lblNome.setText("Nome da empresa");
            lblCadastroPJF.setText("CNPJ");
            try {
                txtCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
            } catch (java.text.ParseException ex) {
                ex.printStackTrace();
            }
        } else if ("Físico".equals(jcbPessoa.getSelectedItem().toString())) {
            lblResponsavel.setVisible(false);
            txtResponsavel.setVisible(false);
            lblNome.setText("Nome do cliente");
            lblCadastroPJF.setText("CPF");
        }
    }//GEN-LAST:event_jcbPessoaActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed
        // TODO add your handling code here:
        String nome = txtNome.getText();
        String CPF = txtCPF.getText();
        String cep = txtCep.getText();
        String rua = txtRua.getText();
        String num = txtNum.getText();
        String telefone = txtFone.getText();
        String responsavel = txtResponsavel.getText();

        try {
            if ("insert".equals(salvar)) {
                con_telef.executarSQL2("select * from telefone_cliente order by cod_telefone");

                String insert_sql2 = "insert into telefone_cliente (telefone) values ('" + telefone + "')";
                con_telef.executarSQL2("select * from telefone_cliente order by cod_telefone");
                //declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
                con_telef.statement.executeUpdate(insert_sql2);//executa (no ambiente Java -virtualmente) o comando de inserção.
                System.out.println(con_telef.statement.executeUpdate(insert_sql2) + "");
                con_telef.executarSQL2("select * from telefone_cliente order by cod_telefone");
                con_telef.resultset.first();

                FK();

                con_cliente.executarSQL("select * from tbclientes order by cod_cliente");
                String insert_sql = "INSERT INTO `tbclientes`(`nome_contato`, `cpf`, `telefone_cliente`, `cep`, `rua`, `numero`, `responsavel`) values ('" + nome + "','" + CPF + "','" + n + "','"
                        + cep + "','" + rua + "','" + num + "','" + responsavel + "')";

                //declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
                con_cliente.statement.executeUpdate(insert_sql);//executa (no ambiente Java -virtualmente) o comando de inserção.
                con_cliente.executarSQL("select * from tbclientes order by cod_cliente");
                con_cliente.resultset.first();

            } else if ("update".equals(salvar)) {

                System.out.println(telef + "");
                String insert_sql2 = "update telefone_cliente set telefone='" + telefone + "' where cod_telefone = " + telef;
                //update telefone_cliente set telefone= 55 where cod_telefone = 2;
                con_telef.executarSQL2("select * from telefone_cliente order by cod_telefone");
                con_telef.statement.executeUpdate(insert_sql2);
                con_telef.executarSQL2("select * from telefone_cliente order by cod_telefone");
                con_telef.resultset.first();

                con_cliente.executarSQL("select * from tbclientes order by cod_cliente");
                String insert_sql = "update tbclientes set nome_contato='" + nome + "',cpf='" + CPF + "', cep='"
                        + cep + "', rua='" + rua + "', numero='" + num + "', responsavel='" + responsavel + "' where cod_cliente = " + txtCod.getText();
                con_cliente.statement.executeUpdate(insert_sql);
                con_cliente.executarSQL("select * from tbclientes order by cod_cliente");
                con_cliente.resultset.first();
                System.out.println(con_cliente.statement.executeUpdate(insert_sql) + "c");

            } else {
                System.out.println("s");
            }
        } catch (Exception errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro de gravação: \n" + errosql, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnDeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletarActionPerformed
        // TODO add your handling code here:
        String sql = "";
        try {
            int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir o registro: ", "Confirmar Exclusão", JOptionPane.YES_NO_OPTION, 3);
            if (resposta == 0) {
                sql = "delete from tbclientes where cod_cliente = " + txtCod.getText();
                int excluir = con_cliente.statement.executeUpdate(sql);
                if (excluir == 1) {
                    con_cliente.executarSQL("select * from tbclientes order by cod_cliente");
                    con_cliente.resultset.first();
                } else {
                    JOptionPane.showMessageDialog(null, "Exclusão não realizada");
                }
            }
        } catch (SQLException errosql) {
            JOptionPane.showMessageDialog(null, "Erro no SQL: " + errosql);
        }
    }//GEN-LAST:event_btnDeletarActionPerformed

    private void rbNaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNaoActionPerformed

        jLabel1.setVisible(false);
        jLabel3.setVisible(false);
        jLabel4.setVisible(false);
        jLabel5.setVisible(false);
        jLabel8.setVisible(false);
        lblCadastroPJF.setVisible(false);
        jcbPessoa.setVisible(false);
        txtCPF.setVisible(false);
        txtCep.setVisible(false);
        txtCod.setVisible(false);
        txtFone.setVisible(false);
        txtNome.setVisible(false);
        txtNum.setVisible(false);
        lblResponsavel.setVisible(false);
        txtResponsavel.setVisible(false);
        txtRua.setVisible(false);
        btnSalvar.setVisible(false);
        btnDeletar.setVisible(false);
        lblNome.setVisible(false);
    }//GEN-LAST:event_rbNaoActionPerformed

    private void rbSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbSimActionPerformed

        jLabel1.setVisible(true);
        jLabel3.setVisible(true);
        jLabel4.setVisible(true);
        jLabel5.setVisible(true);
        jLabel6.setVisible(true);
        jLabel8.setVisible(true);
        lblCadastroPJF.setVisible(true);
        jcbPessoa.setVisible(true);
        txtCPF.setVisible(true);
        txtCep.setVisible(true);
        txtCod.setVisible(true);
        txtFone.setVisible(true);
        txtNome.setVisible(true);
        txtNum.setVisible(true);
        lblResponsavel.setVisible(true);
        txtResponsavel.setVisible(true);
        txtRua.setVisible(true);
        btnSalvar.setVisible(true);
        btnDeletar.setVisible(true);
        lblNome.setVisible(true);
    }//GEN-LAST:event_rbSimActionPerformed

    private void tblClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblClientesMouseClicked
        this.linha_selecionada = tblClientes.getSelectedRow();

        n1 = tblClientes.getValueAt(linha_selecionada, 0).toString();//atribui n1 ao dado selecionado
        /*n2=tblClientes.getValueAt(linha_selecionada,1).toString();
        n3=tblClientes.getValueAt(linha_selecionada,1).toString();
        n4=tblClientes.getValueAt(linha_selecionada,2).toString();
        n5=tblClientes.getValueAt(linha_selecionada,3).toString();
        n6=tblClientes.getValueAt(linha_selecionada,4).toString();
        n7=tblClientes.getValueAt(linha_selecionada,5).toString();*/

        System.out.println(n1 + "");
    }//GEN-LAST:event_tblClientesMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDeletar;
    private javax.swing.JButton btnSalvar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JComboBox<String> jcbPessoa;
    private javax.swing.JLabel lblCadastroPJF;
    private javax.swing.JLabel lblNome;
    private javax.swing.JLabel lblResponsavel;
    private javax.swing.JRadioButton rbNao;
    private javax.swing.JRadioButton rbSim;
    private swing_classes.Table_Column tblClientes;
    private javax.swing.JFormattedTextField txtCPF;
    private javax.swing.JFormattedTextField txtCep;
    private javax.swing.JTextField txtCod;
    private javax.swing.JFormattedTextField txtFone;
    private javax.swing.JTextField txtNome;
    private javax.swing.JTextField txtNum;
    private javax.swing.JTextField txtResponsavel;
    private javax.swing.JTextField txtRua;
    // End of variables declaration//GEN-END:variables

    public int getLinha_selecionada() {
        return linha_selecionada;
    }

    public void setLinha_selecionada(int linha_selecionada) {
        this.linha_selecionada = linha_selecionada;
    }

    public String getN1() {
        return n1;
    }

    public void setN1(String n1) {
        this.n1 = n1;
    }
}
