/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hud;

import environment.Environment;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 *
 * @author david
 */
class HUDEnvironment extends Environment implements HealthProviderIntf {
    private int maxHealth = 100;
    private int health = 78;
    
    private HealthBar myHealthBar;
    private TextBox myTextBox;

    @Override
    public void initializeEnvironment() {
        myHealthBar = new HealthBar(this, new Point(100, 100));
    }

    @Override
    public void timerTaskHandler() {
    
    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_0){
            health++;
        } else if (e.getKeyCode() == KeyEvent.VK_MINUS){
            health--;
        }
        
       
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {
    
    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {
    
    }

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (myHealthBar != null){
            myHealthBar.paint(graphics);
        }
        
        if (myTextBox !=null){
            myTextBox.paint(graphics);
        
        }
        
    }

//<editor-fold defaultstate="collapsed" desc="HealthProviderIntf">
    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public int getMaxHealth() {
        return maxHealth;
    }
//</editor-fold>
    
}
