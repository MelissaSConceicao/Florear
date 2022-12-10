package swing_componentes;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Model_menu;
import net.miginfocom.swing.MigLayout;
import swing_classes.ButtonCustom;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */

public class Menu extends javax.swing.JPanel {

    private MigLayout layout;
    private JPanel panelMenu;
    private JButton btnMenu;
    private JButton btnExit;
    private CabecalhoMenu cabecalho;
    private EventoMenuSelecionado evento;
    
    public Menu() {
        initComponents();
        setOpaque(false);
        iniciar();
    }
    public void setEvento(EventoMenuSelecionado evento) {
        this.evento = evento;
    }
    private void iniciar() {
        setLayout(new MigLayout("wrap, fillx, insets 0", "[fill]", "5[]0"));
        panelMenu = new JPanel();
        cabecalho = new CabecalhoMenu();
        criarButtonMenu();
        criarButtonExit();
        panelMenu.setOpaque(false);
        layout = new MigLayout("fillx, wrap", "0[fill]0", "0[]2[]0");
        panelMenu.setLayout(layout);
        add(btnMenu, "pos 1al 0al 100% 50");
        add(btnExit, "pos 1al 1al 100% 100, height 55!");
        add(cabecalho);
        add(panelMenu);
    }
    
    public void adicionarMenu(Model_menu menu) {
        ItensMenu itens = new ItensMenu(menu.getIcone(), menu.getMenuNome(), panelMenu.getComponentCount());
        itens.adicionarEvento(new EventoMenuSelecionado() {
            @Override
            public void selecionado(int index) {
                limparMenu(index);
            }
        });
        itens.adicionarEvento(evento);
        panelMenu.add(itens);
    }
    
    private void criarButtonMenu() {
        btnMenu = new JButton();
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnMenu.setIcon(new ImageIcon(getClass().getResource("/icones/menu-30.png")));
        btnMenu.setBorder(new EmptyBorder(5, 12, 5, 12));
    }
    
    private void criarButtonExit() {
        btnExit = new ButtonCustom();
        btnExit.setIcon(new ImageIcon(getClass().getResource("/icones/exit-25.png")));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#fb9b91"), 0, getHeight(), Color.decode("#fb9b91"));
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }
    
    private void limparMenu(int excecaoIndex) {
        for (Component comp : panelMenu.getComponents()) {
            ItensMenu itens = (ItensMenu) comp;
            if (itens.getIndex() != excecaoIndex) {
                itens.setSelecionado(false);
            }
        }
    }
    
    public void adicionarEvtMenu(ActionListener evt) {
        btnMenu.addActionListener(evt);
    }
    
    public void adicionarEvtExit(ActionListener evt) {
        btnExit.addActionListener(evt);
    }
    
    public void setAlpha(float alpha) {
        cabecalho.setAlpha(alpha);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
