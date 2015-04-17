/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hud;

import environment.Environment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;

/**
 *
 * @author david
 */
class HUDEnvironment extends Environment implements HealthProviderIntf {
    private int maxHealth = 100;
    private int health = 78;
    
    private HealthBar myHealthBar;
    private TextBox myTextBox;
    private JPanel pnl, contentPanel;
    

    @Override
    public void initializeEnvironment() {
//        this.setLayout(new );
        setLayout(new BorderLayout());
//        contentPanel = new JPanel();
//        contentPanel.setBackground(Color.red);
//        this.add(contentPanel);
        
//        setContentPane(contentPanel);
        
        myHealthBar = new HealthBar(this, new Point(10, 400));
        
        JPanel pnl = new JPanel();
        pnl.setLocation(new Point(400, 400));
        pnl.setBackground(Color.red);
        pnl.setSize(new Dimension(300, 300));
        this.add(pnl);
        
        myTextBox = new TextBox(new Point(200, 200), new Dimension(300, 200));
        myTextBox.append("This is a test of the NA Early Warning System...");
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
