package swing_componentes;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.Icon;
import javax.swing.SwingUtilities;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */

public class ItensMenu extends javax.swing.JPanel {

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSelecionado() {
        return selecionado;
    }

    public void setSelecionado(boolean selecionado) {
        this.selecionado = selecionado;
        repaint();
    }

    private final List<EventoMenuSelecionado> evento = new ArrayList<>();
    private int index;
    private boolean selecionado;
    private boolean mouseOver;
    
    public ItensMenu(Icon icone, String nome, int index) {
        initComponents();
        setOpaque(false);
        this.index = index;
        lblIconeMenu.setIcon(icone);
        lblNomeMenu.setText(nome);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                mouseOver = true;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                mouseOver = false;
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e)) {
                    if (mouseOver) {
                        setSelecionado(true);
                        repaint();
                        rodarEvento();
                    }
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (isSelecionado()) {
            Graphics2D g2d = (Graphics2D)g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(new Color(250, 127, 114));
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.5f));
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.setComposite(AlphaComposite.SrcOver);
            g2d.setColor(new Color(245, 245, 245 ));
            g2d.fillRect(0, 0, 2, getHeight());
        }
        super.paintComponent(g);
    }

    private void rodarEvento() {
        for (EventoMenuSelecionado event: evento) {
            event.selecionado(getIndex());
        }
    }
    
    public void adicionarEvento(EventoMenuSelecionado event) {
        evento.add(event);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblIconeMenu = new javax.swing.JLabel();
        lblNomeMenu = new javax.swing.JLabel();

        lblNomeMenu.setFont(new java.awt.Font("Segoe UI Semibold", 0, 13)); // NOI18N
        lblNomeMenu.setForeground(new java.awt.Color(250, 250, 250));
        lblNomeMenu.setText("nome menu");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(lblIconeMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(lblNomeMenu)
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIconeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNomeMenu, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblIconeMenu;
    private javax.swing.JLabel lblNomeMenu;
    // End of variables declaration//GEN-END:variables
}
