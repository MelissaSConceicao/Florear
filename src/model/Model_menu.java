package model;

import javax.swing.Icon;

/*
 * @author Kezia, Lucas Hideo e Melissa
 */

public class Model_menu {
    
    private String menuNome;
    private Icon icone;

    public String getMenuNome() {
        return menuNome;
    }

    public void setMenuNome(String menuNome) {
        this.menuNome = menuNome;
    }

    public Icon getIcone() {
        return icone;
    }

    public void setIcone(Icon icone) {
        this.icone = icone;
    }
    
    public Model_menu(String menuNome, Icon icone) {
        this.menuNome = menuNome;
        this.icone = icone;
    }
    
    public Model_menu() {
        
    }
}
