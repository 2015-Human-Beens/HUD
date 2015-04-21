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
class HUDEnvironment extends Environment {//implements StatusProviderIntf {

    private TextBox myTextBox;
    private JPanel pnl, contentPanel;

    private StatusBar health;
    private StatusProviderIntf healthStatusProvider;

    private StatusBar fuel;
    private StatusProviderIntf fuelStatusProvider;

    private StatusBar oxygen;
    private StatusProviderIntf oxygenStatusProvider;

    private boolean showHUD = true;

    @Override
    public void initializeEnvironment() {
//        this.setLayout(new );
        setLayout(new BorderLayout());
//        contentPanel = new JPanel();
//        contentPanel.setBackground(Color.red);
//        this.add(contentPanel);

//        setContentPane(contentPanel);
        JPanel pnl = new JPanel();
        pnl.setLocation(new Point(400, 400));
        pnl.setBackground(Color.LIGHT_GRAY);
        pnl.setSize(new Dimension(300, 300));
        this.add(pnl);

        myTextBox = new TextBox(new Point(200, 200), new Dimension(300, 200));
        myTextBox.append("This is a test of the NA Early Warning System...");

//        oxygenStatusProvider = new StatusProviderIntf() {
//            private int status;
//            public int maxStatus = 1000;
//
//            public void setStatus(int status) {
//                this.status = status;
//            }
//
//            public void setMaxStatus(int maxStatus) {
//                this.maxStatus = maxStatus;
//            }
//
//            @Override
//            public int getStatus() {
//                return status;
//            }
//
//            @Override
//            public int getMaxStatus() {
//                return maxStatus;
//            }
//        };
        oxygenStatusProvider = new StatusProvider(900, 1000);
        oxygen = new StatusBar(oxygenStatusProvider, new Point(10, 20), new Dimension(100, 20));

        fuelStatusProvider = new StatusProvider(3000, 5000);
        fuel = new StatusBar(fuelStatusProvider, new Point(10, 60), new Dimension(100, 20));

        healthStatusProvider = new StatusProvider(100, 120);
        health = new StatusBar(healthStatusProvider, new Point(10, 100), new Dimension(100, 20));
    }

    private class StatusProvider implements StatusProviderIntf {

        public StatusProvider(int status, int maxStatus){
            this.status = status;
            this.maxStatus = maxStatus;
        }
        
        private int status;
        public int maxStatus;

        public void changeStatus(int change){
            setStatus(status + change);
        }
        
        public void setStatus(int status) {
            this.status = Math.min(Math.max(status, 0), maxStatus);
        }

        public void setMaxStatus(int maxStatus) {
            this.maxStatus = maxStatus;
        }

        @Override
        public int getStatus() {
            return status;
        }

        @Override
        public int getMaxStatus() {
            return maxStatus;
        }
    }

    @Override
    public void timerTaskHandler() {

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_0) {
            showHUD = !showHUD;
        } else if (e.getKeyCode() == KeyEvent.VK_1) {
            oxygenStatusProvider.changeStatus(-20);
        } else if (e.getKeyCode() == KeyEvent.VK_2) {
            oxygenStatusProvider.changeStatus(20);
        } else if (e.getKeyCode() == KeyEvent.VK_3) {
            fuelStatusProvider.changeStatus(-250);
        } else if (e.getKeyCode() == KeyEvent.VK_4) {
            fuelStatusProvider.changeStatus(250);
        } else if (e.getKeyCode() == KeyEvent.VK_5) {
            healthStatusProvider.changeStatus(1);
        } else if (e.getKeyCode() == KeyEvent.VK_6) {
            healthStatusProvider.changeStatus(1);
        }
    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {

    }

    public static Color HUD_GLASS = new Color(240, 240, 240, 50);

    @Override
    public void paintEnvironment(Graphics graphics) {
        if (showHUD) {
            graphics.setColor(HUD_GLASS);
            graphics.fill3DRect(0, 0, 200, this.getHeight(), true);
            
            if (oxygen != null) {
                oxygen.paint(graphics);
            }

            if (fuel != null) {
                fuel.paint(graphics);
            }

            if (health != null) {
                health.paint(graphics);
            }
            
//            if (myTextBox != null) {
//                myTextBox.paint(graphics);
//            }
        }

    }

//<editor-fold defaultstate="collapsed" desc="StatusProviderIntf">
//    @Override
//    public int getHealth() {
//        return health;
//    }
//
//    @Override
//    public int getMaxHealth() {
//        return maxHealth;
//    }
//</editor-fold>

}
