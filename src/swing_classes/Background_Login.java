package swing_classes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.GeneralPath;
import javax.swing.JPanel;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */

public class Background_Login extends JPanel{

    public boolean isShowPaint() {
        return showPaint;
    }

    public void setShowPaint(boolean showPaint) {
        this.showPaint = showPaint;
    }

    public float getAnimacao() {
        return animacao;
    }

    public void setAnimacao(float animacao) {
        this.animacao = animacao;
        repaint();
    }
    
    private float easeOutQuint(float x) {
        return (float) (1 - Math.pow(1 - x, 5));
    }
    
    private float easeInOutCirc(float x) {
    double v =  x < 0.5
      ? (1 - Math.sqrt(1 - Math.pow(2 * x, 2))) / 2
      : (Math.sqrt(1 - Math.pow(-2 * x + 2, 2)) + 1) / 2;
        return (float) v;
    }
    
    private float animacao;
    private int header = 50;
    private boolean showPaint;
    
    public Background_Login() {
        setOpaque(false);
    }

    @Override
    public void paint(Graphics g) {
        if (!isShowPaint()) {
            super.paint(g);
        }
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int height = (int)(getHeight()*(1f-easeOutQuint(animacao)));
        g2d.setColor(new Color(254, 220, 216));
        g2d.fill(criarShape(height, 50, 70, 60, 100));
        g2d.setColor(new Color(252, 181, 173));
        g2d.fill(criarShape(height, 80, 50, 100, 50, 100, 50));
        g2d.setColor(new Color(250, 127, 114));
        g2d.fill(criarShape(height, 70, 20, 60, 20, 70)); 
        int bgHeight = (int) (getHeight() * (1f - easeInOutCirc(animacao )));
        bgHeight += header;
        g2d.setColor(new Color(245, 245, 245));
        g2d.fillRect(0, bgHeight, getWidth(), getHeight());
        g2d.dispose();
        if (isShowPaint()) {
            super.paint(g);
        }
    }
    
    private Shape criarShape(int location, int startInit, int ...points) {
        int width = getWidth();
        int height = getHeight();
        int ss = width/points.length;
        int size = location;
        GeneralPath gp = new GeneralPath();
        int espaco = 0;
        int xs = 0;
        int ys = location-startInit;
        
        for (int point:points) {
            point = size-point;
            int s = espaco+ss/2;
            gp.append(new CubicCurve2D.Double(xs, ys, s, ys, s, point, xs+ss, point), true);
            espaco += ss;
            xs += ss;
            ys = point;
        }
        
        gp.lineTo(width, ys);
        gp.lineTo(width, height);
        gp.lineTo(0, height);
        return gp;
    }
}
