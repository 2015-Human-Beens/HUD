/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hud;

import environment.Environment;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author kevin.lawrence
 */
class HUDTestEnvironment extends Environment {// implements StatusProviderIntf {

    JPanel pnlControl;
    JPanel pnlHUD;
    JPanel pnlMap;
    JPanel pnlContent;
    
    JPanel pnlStatusBars;
    
    StatusBar health;
    StatusBar oxygen;
    StatusBar fuel;
    StatusBar resources;
    
    
    {
        pnlControl = new JPanel();
        pnlControl.setBounds(0, 0, 800, 100);
        
        pnlHUD = new JPanel();
        pnlHUD.setLayout(new BorderLayout());
        pnlHUD.setBackground(Color.BLUE);

//        health = new StatusBar(this, new Point(0,0));

//        oxygen = new StatusBar(this, new Point(0,0));
//        fuel = new StatusBar(this, new Point(0,0));
//        resources = new StatusBar(this, new Point(0,0));
        
        pnlStatusBars = new JPanel();
        pnlStatusBars.setLayout(new BoxLayout(pnlStatusBars, BoxLayout.Y_AXIS));
        pnlStatusBars.add(health);
        pnlStatusBars.add(fuel);
        pnlStatusBars.add(oxygen);
        pnlStatusBars.add(resources);
        
        
        pnlHUD.add(pnlStatusBars, BorderLayout.PAGE_START);
        pnlHUD.setBounds(0, 0, 800, 300);
        
        
        
//        listPane.setLayout(new BoxLayout(listPane, BoxLayout.PAGE_AXIS));
        
        
        pnlMap = new JPanel();
        pnlMap.setBackground(Color.DARK_GRAY);
        
        pnlMap.add(pnlStatusBars);
        
        pnlContent = new JPanel();
        pnlContent.setBackground(Color.RED);
        
        setLayout(new BorderLayout());
        this.add(pnlContent, SwingConstants.CENTER);
        
        pnlContent.setLayout(new BorderLayout());
        pnlContent.add(pnlControl, BorderLayout.PAGE_END);
//        pnlContent.add(pnlHUD, BorderLayout.LINE_START);
//        pnlContent.add(pnlStatusBars, BorderLayout.LINE_START);
        pnlContent.add(pnlMap, BorderLayout.CENTER);
        
        
    }
    
    
    public HUDTestEnvironment() {
    }

    @Override
    public void initializeEnvironment() {

    }

    @Override
    public void timerTaskHandler() {

    }

    @Override
    public void keyPressedHandler(KeyEvent e) {

    }

    @Override
    public void keyReleasedHandler(KeyEvent e) {

    }

    @Override
    public void environmentMouseClicked(MouseEvent e) {

    }

    @Override
    public void paintEnvironment(Graphics graphics) {

    }

//    @Override
//    public int getStatus() {
//        return 22;
//    }
//
//    @Override
//    public int getMaxStatus() {
//        return 112;
//    }
    
}
