package controle;

import conexao.Conexao;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.sql.*;
import java.awt.Color;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */
public class Fom_Login extends javax.swing.JFrame {

    private Animator animatorLogin;
    private Animator animatorCadastro;
    private boolean login;
    Conexao con_cliente;
    Conexao con_telef;
    private String num;
    private String n;

    public Fom_Login() {
        initComponents();
        
        
        con_cliente = new Conexao();
        con_cliente.conecta();
        con_telef = new Conexao();
        con_telef.conecta();
        con_cliente.executarSQL("select * from funcionario order by matricula");
        con_telef.executarSQL2("select * from telefone_funcionario order by cod_telefone");
        //mostrarMatricula();
        mostrarMatricula();
        FK();
        
        try{
            con_cliente.resultset.last();
            
           }catch(SQLException erro){
               JOptionPane.showMessageDialog(null,"não foi possivel posicionar no último registro"+erro);
           }

        getContentPane().setBackground(new Color(245, 245, 245));
        TimingTarget targetLogin = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (login) {
                    background.setAnimacao(fraction);
                } else {
                    background.setAnimacao(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (login) {
                    panelLogin.setVisible(false);
                    background.setShowPaint(true);
                    panelTransparent.setAlpha(0);
                    panelTransparent.setVisible(true);
                    animatorCadastro.start();
                } else {
                    enableLogin(true);
                    txtUsuario.grabFocus();
                }
            }
        };

        TimingTarget targetCadastro = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                if (login) {
                    panelTransparent.setAlpha(fraction);
                } else {
                    panelTransparent.setAlpha(1f - fraction);
                }
            }

            @Override
            public void end() {
                if (login == false) {
                    panelTransparent.setVisible(false);
                    background.setShowPaint(false);
                    background.setAnimacao(1);
                    panelLogin.setVisible(true);
                    animatorLogin.start();
                }
            }
        };
        animatorLogin = new Animator(2500, targetLogin);
        animatorCadastro = new Animator(500, targetCadastro);
        animatorLogin.setResolution(0);
        animatorCadastro.setResolution(0);
        jPanel3.setOpaque(false);

    }

    public void mostrarMatricula(){
        try{
            con_cliente.resultset.last();
            txtMatricula.setText(con_cliente.resultset.getString("matricula"));
            int a= Integer.parseInt(txtMatricula.getText());
            System.out.println(a+1+"");
            txtMatricula.setText(a+1+"");
            
           }catch(SQLException erro){
               JOptionPane.showMessageDialog(null,"não foi possivel posicionar no último registro"+erro);
           }
       
    }
    public void FK(){
        try{
            con_telef.resultset.last();
            setN(con_telef.resultset.getString("cod_telefone"));
            int a= Integer.parseInt(getN());
            setN(a+1+"");
            System.out.println(getN()+"");
            
           }catch(SQLException erro){
               JOptionPane.showMessageDialog(null,"não foi possivel posicionar no último registro"+erro);
           }
       
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new swing_classes.Background_Login();
        panelLogin = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        txtUsuario = new swing_classes.TextField_Login();
        txtSenha = new swing_classes.PasswordField_Login();
        btnLogar = new swing_classes.Button();
        btnCadastrar = new swing_classes.Button();
        jLabel3 = new javax.swing.JLabel();
        lblSemCadastro = new javax.swing.JLabel();
        lblTitle = new javax.swing.JLabel();
        lblSubTitle = new javax.swing.JLabel();
        panelTransparent = new swing_classes.PanelTransparent();
        jPanel3 = new javax.swing.JPanel();
        btnCadastrar1 = new swing_classes.Button();
        txtSenha1 = new swing_classes.PasswordField_Login();
        txtNome = new swing_classes.TextField_Login();
        txtCPF = new swing_classes.TextField_Login();
        txtFone = new swing_classes.TextField_Login();
        txtData = new swing_classes.TextField_Login();
        txtMatricula = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(new java.awt.Dimension(1050, 585));

        background.setLayout(new java.awt.CardLayout());

        panelLogin.setOpaque(false);

        jPanel1.setOpaque(false);

        txtUsuario.setBackground(new java.awt.Color(245, 245, 245));
        txtUsuario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtUsuario.setLabelText("Matrícula");
        txtUsuario.setLineColor(new java.awt.Color(253, 215, 210));

        txtSenha.setBackground(new java.awt.Color(245, 245, 245));
        txtSenha.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSenha.setLabelText("Senha");
        txtSenha.setLineColor(new java.awt.Color(253, 215, 210));

        btnLogar.setBackground(new java.awt.Color(250, 127, 114));
        btnLogar.setForeground(new java.awt.Color(255, 255, 255));
        btnLogar.setText("Login");
        btnLogar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogarActionPerformed(evt);
            }
        });

        btnCadastrar.setBackground(new java.awt.Color(250, 127, 114));
        btnCadastrar.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar.setText("Cadastre-se");
        btnCadastrar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrarActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("É novo por aqui?");

        lblSemCadastro.setForeground(new java.awt.Color(255, 50, 48));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(lblSemCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 95, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSenha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(txtSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblSemCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        lblTitle.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        lblTitle.setForeground(new java.awt.Color(102, 102, 102));
        lblTitle.setText("Olá, seja muito bem-vindo ao Florear!");

        lblSubTitle.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        lblSubTitle.setForeground(new java.awt.Color(102, 102, 102));
        lblSubTitle.setText("O sistema ideal para o gerenciamento da sua floricultura.");

        javax.swing.GroupLayout panelLoginLayout = new javax.swing.GroupLayout(panelLogin);
        panelLogin.setLayout(panelLoginLayout);
        panelLoginLayout.setHorizontalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLoginLayout.createSequentialGroup()
                .addGap(385, 385, 385)
                .addComponent(lblSubTitle)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addContainerGap(353, Short.MAX_VALUE)
                .addGroup(panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(lblTitle)
                        .addGap(348, 348, 348))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(363, 363, 363))))
        );
        panelLoginLayout.setVerticalGroup(
            panelLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLoginLayout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(lblTitle)
                .addGap(18, 18, 18)
                .addComponent(lblSubTitle)
                .addGap(79, 79, 79)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(182, Short.MAX_VALUE))
        );

        background.add(panelLogin, "card2");

        jPanel3.setOpaque(false);

        btnCadastrar1.setBackground(new java.awt.Color(250, 127, 114));
        btnCadastrar1.setForeground(new java.awt.Color(255, 255, 255));
        btnCadastrar1.setText("Cadastrar");
        btnCadastrar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCadastrar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnCadastrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadastrar1ActionPerformed(evt);
            }
        });

        txtSenha1.setBackground(new java.awt.Color(245, 245, 245));
        txtSenha1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSenha1.setLabelText("Senha");
        txtSenha1.setLineColor(new java.awt.Color(253, 215, 210));

        txtNome.setBackground(new java.awt.Color(245, 245, 245));
        txtNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtNome.setLabelText("Nome completo");
        txtNome.setLineColor(new java.awt.Color(253, 215, 210));

        txtCPF.setBackground(new java.awt.Color(245, 245, 245));
        txtCPF.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtCPF.setLabelText("CPF");
        txtCPF.setLineColor(new java.awt.Color(253, 215, 210));

        txtFone.setBackground(new java.awt.Color(245, 245, 245));
        txtFone.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtFone.setLabelText("Telefone");
        txtFone.setLineColor(new java.awt.Color(253, 215, 210));

        txtData.setBackground(new java.awt.Color(245, 245, 245));
        txtData.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtData.setLabelText("Data de nascimento");
        txtData.setLineColor(new java.awt.Color(253, 215, 210));

        txtMatricula.setEditable(false);
        txtMatricula.setBackground(new java.awt.Color(245, 245, 245));
        txtMatricula.setBorder(null);
        txtMatricula.setEnabled(false);
        txtMatricula.setSelectionColor(new java.awt.Color(252, 181, 173));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 153, 153));
        jLabel2.setText("Matrícula");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(txtCPF, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
            .addComponent(txtNome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtMatricula)
            .addComponent(txtFone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(txtSenha1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(175, 175, 175)
                        .addComponent(btnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtFone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSenha1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(btnCadastrar1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 28)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setText("Cadastre-se no Florear");

        javax.swing.GroupLayout panelTransparentLayout = new javax.swing.GroupLayout(panelTransparent);
        panelTransparent.setLayout(panelTransparentLayout);
        panelTransparentLayout.setHorizontalGroup(
            panelTransparentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTransparentLayout.createSequentialGroup()
                .addContainerGap(327, Short.MAX_VALUE)
                .addGroup(panelTransparentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparentLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(319, 319, 319))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparentLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(438, 438, 438))))
        );
        panelTransparentLayout.setVerticalGroup(
            panelTransparentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTransparentLayout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61))
        );

        background.add(panelTransparent, "card3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnLogarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogarActionPerformed

        if (!animatorLogin.isRunning()) {
            try {
                String matricula;
                String pesquisa = "select * from funcionario where matricula like '" + txtUsuario.getText() + "' && senha = '" + txtSenha.getText() + "'";
                con_cliente.executarSQL(pesquisa);
                login = true;
                boolean action = true;
                if (con_cliente.resultset.first()) {
                    //alterado, ambos vão para a tela do gerente
                    if ("1".equals(txtUsuario.getText())) {
                        Tela_gerente gerente = new Tela_gerente();
                        animatorLogin.start();
                        lblSemCadastro.setText("");
                        gerente.setVisible(true);
                        dispose();
                    } else {
                        Tela_gerente gerente = new Tela_gerente();
                        gerente.setVisible(true);
                        lblSemCadastro.setVisible(false);
                        dispose();
                    }
                }
                if ("".equals(txtUsuario.getText())) {
                    txtUsuario.setHelperText("Insira o n° de matrícula");
                    txtUsuario.grabFocus();
                    lblSemCadastro.setText("");
                } else {
                    txtUsuario.setHelperText("");
                    lblSemCadastro.setText("Matrícula ou senha incorretos");
                }
                if ("".equals(txtSenha.getText())) {
                    txtSenha.setHelperText("Insira a senha");
                    lblSemCadastro.setText("");
                    action = false;
                } else {
                    txtSenha.setHelperText("");
                    action = false;
                }
                if (action) {
                    animatorLogin.start();
                    enableLogin(false);
                }

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "\n Os dados digitados não foram localizados! :\n " + erro, "Mensagem do Programa", JOptionPane.INFORMATION_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnLogarActionPerformed

    private void btnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrarActionPerformed
        if (!animatorLogin.isRunning()) {
            login = true;
            boolean action = true;
            if (action) {
                animatorLogin.start();
                enableLogin(false);
            }
        }
    }//GEN-LAST:event_btnCadastrarActionPerformed

    private void btnCadastrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadastrar1ActionPerformed
        String matricula = getTxtMatricula().getText();//declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
        String nome = txtNome.getText();
        String CPF = txtCPF.getText();
        String telefone = txtFone.getText();
        String data_nasc = txtData.getText();
        String senha = txtSenha.getText();
        try {
            con_telef.executarSQL2("select * from telefone_funcionario order by cod_telefone");

            String insert_sql2 = "insert into telefone_funcionario (telefonec) values ('" + telefone + "')";
            con_telef.executarSQL2("select * from telefone_funcionario order by cod_telefone");
//declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
            con_telef.statement.executeUpdate(insert_sql2);//executa (no ambiente Java -virtualmente) o comando de inserção.
            con_telef.executarSQL2("select * from telefone_funcionario order by cod_telefone");
            con_telef.resultset.first();

            con_cliente.executarSQL("select * from funcionario order by matricula");
            String insert_sql = "insert into funcionario (senha ,telefone,cpf, nome , data) values ('" + senha + "','" + getN() + "','" + CPF + "','" + nome + "','" + data_nasc + "')";

//declara as variáveis e atribui a elas o valor de cada caixa de texto respectivamente, através do método “getText()”.
            con_cliente.statement.executeUpdate(insert_sql);//executa (no ambiente Java -virtualmente) o comando de inserção.
            con_cliente.executarSQL("select * from funcionario order by matricula");
            con_cliente.resultset.first();
            login = false;
            clearLogin();
            animatorCadastro.start();
            

        } catch (Exception errosql) {
            JOptionPane.showMessageDialog(null, "\n Erro de gravação: \n" + errosql, "Mensagem do programa", JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnCadastrar1ActionPerformed

    private void enableLogin(boolean action) {
        txtUsuario.setEditable(action);
        txtSenha.setEditable(action);
        btnLogar.setEnabled(action);
    }

    public void clearLogin() {
        txtUsuario.setText("");
        txtSenha.setText("");
        txtSenha.setHelperText("");
        txtSenha.setHelperText("");
        lblSemCadastro.setText("");
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Fom_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Fom_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Fom_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Fom_Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Fom_Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private swing_classes.Background_Login background;
    private swing_classes.Button btnCadastrar;
    private swing_classes.Button btnCadastrar1;
    private swing_classes.Button btnLogar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lblSemCadastro;
    private javax.swing.JLabel lblSubTitle;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JPanel panelLogin;
    private swing_classes.PanelTransparent panelTransparent;
    private swing_classes.TextField_Login txtCPF;
    private swing_classes.TextField_Login txtData;
    private swing_classes.TextField_Login txtFone;
    private javax.swing.JTextField txtMatricula;
    private swing_classes.TextField_Login txtNome;
    private swing_classes.PasswordField_Login txtSenha;
    private swing_classes.PasswordField_Login txtSenha1;
    private swing_classes.TextField_Login txtUsuario;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getTxtMatricula() {
        return txtMatricula;
    }

    public void setTxtMatricula(javax.swing.JTextField txtMatricula) {
        this.txtMatricula = txtMatricula;
    }

    /**
     * @return the num
     */
    public String getNum() {
        return num;
    }

    /**
     * @param num the num to set
     */
    public void setNum(String num) {
        this.num = num;
    }

    /**
     * @return the n
     */
    public String getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(String n) {
        this.n = n;
    }
}
