package controle;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import model.Model_menu;
import net.miginfocom.swing.MigLayout;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;
import org.jdesktop.animation.timing.triggers.TimingTrigger;
import swing_componentes.EventoMenuSelecionado;
import swing_componentes.Menu;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */

public class Tela_gerente extends javax.swing.JFrame {

    private Menu menu = new Menu();
    private JPanel panelItens = new JPanel();
    private MigLayout layout;
    private Animator animator;
    private boolean menuAparecer;
    
    public Tela_gerente() {
        initComponents();
        iniciar();
        
        setIconImage(getIconImage());
    }
    
    public final Image getIconImage(){
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("icones/rosa.png"));
        return icon;
    }

    private void iniciar() {
        layout = new MigLayout("fill", "0[]10[]0", "0[fill]0");
        panelGerente.setLayout(layout);
        panelItens.setOpaque(false);
        panelItens.setLayout(new BorderLayout());
        menu.adicionarEvtExit(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                Fom_Login login = new Fom_Login();
                login.setVisible(true);
            }
        });
        menu.adicionarEvtMenu(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!animator.isRunning()) {
                    animator.start();
                }
            }
        });
        menu.setEvento(new EventoMenuSelecionado() {
            @Override
            public void selecionado(int tela) {
                if (tela == 0) {
                    mostrarPanel(new Cad_Adereco());
                } else if (tela == 1) {
                    mostrarPanel(new Cad_Flore());
                } else if (tela == 2) {
                    mostrarPanel(new Cad_Fornecedo());
                } else if (tela == 3) {
                    mostrarPanel(new Cad_Lot());
                } else if (tela == 4) {
                    mostrarPanel(new Cad_Materia());
                } else if (tela == 5) {
                    mostrarPanel(new Cad_Pedid());
                } else if (tela == 6) {
                    mostrarPanel(new Cad_Produt());
                } else if (tela == 7) {
                    mostrarPanel(new Cad_Cliente());
                } else if (tela == 8) {
                    mostrarPanel(new Cad_Agendamento());
                } else if (tela == 9) {
                    mostrarPanel(new Servico_Entreg());
                }
            }
        });
        menu.adicionarMenu(new Model_menu("Adereços", new ImageIcon(getClass().getResource("/icones/adereco-24.png"))));
        menu.adicionarMenu(new Model_menu("Flores", new ImageIcon(getClass().getResource("/icones/flor-24.png"))));
        menu.adicionarMenu(new Model_menu("Fornecedores", new ImageIcon(getClass().getResource("/icones/fornecedor-24.png"))));
        menu.adicionarMenu(new Model_menu("Lote", new ImageIcon(getClass().getResource("/icones/lote-24.png"))));
        menu.adicionarMenu(new Model_menu("Material", new ImageIcon(getClass().getResource("/icones/materiais-24.png"))));
        menu.adicionarMenu(new Model_menu("Pedido", new ImageIcon(getClass().getResource("/icones/pedido-24.png"))));
        menu.adicionarMenu(new Model_menu("Produto", new ImageIcon(getClass().getResource("/icones/produto-24.png"))));
        menu.adicionarMenu(new Model_menu("Cliente", new ImageIcon(getClass().getResource("/icones/cliente-24.png"))));
        menu.adicionarMenu(new Model_menu("Agendamento", new ImageIcon(getClass().getResource("/icones/agendamento-24.png"))));
        menu.adicionarMenu(new Model_menu("Entrega", new ImageIcon(getClass().getResource("/icones/entrega-24.png"))));
        panelGerente.add(menu, "w 50!");
        panelGerente.add(panelItens, "w 100%");
        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                double width;
                if (menuAparecer) {
                    width = 50 + (150 * (1f-fraction));
                    menu.setAlpha(1f-fraction);
                }else {
                    width = 50 + (150 * fraction);
                    menu.setAlpha(fraction);
                }
                layout.setComponentConstraints(menu, "w " + width + "!");
                panelGerente.revalidate();
            }

            @Override
            public void end() {
                menuAparecer = !menuAparecer;
            }
        };
        animator = new Animator(400, target);
        animator.setResolution(0);
        animator.setAcceleration(0.5f);
        animator.setDeceleration(0.5f);
        mostrarPanel(new Cad_Adereco());
    }

    private void mostrarPanel(Component comp) {
        panelItens.removeAll();
        panelItens.add(comp);
        panelItens.repaint();
        panelItens.revalidate();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelGerente = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelGerente.setBackground(new java.awt.Color(245, 245, 245));

        javax.swing.GroupLayout panelGerenteLayout = new javax.swing.GroupLayout(panelGerente);
        panelGerente.setLayout(panelGerenteLayout);
        panelGerenteLayout.setHorizontalGroup(
            panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        panelGerenteLayout.setVerticalGroup(
            panelGerenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelGerente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Tela_gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tela_gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tela_gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tela_gerente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela_gerente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel panelGerente;
    // End of variables declaration//GEN-END:variables
}
