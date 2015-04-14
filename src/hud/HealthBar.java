/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hud;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

/**
 *
 * @author david
 */
public class HealthBar {
    
    public HealthBar(HealthProviderIntf healthProvider, Point position){
        this.healthProvider = healthProvider;
        this.position = position;
    }
    
    private HealthProviderIntf healthProvider;
    private Point position;
    private Color HUDBLUE = new Color(0, 230, 220);
    private Color HUDGREY = new Color(80, 80, 80);
    
    public void paint(Graphics graphics){
        //draw...
        if (healthProvider != null){
            graphics.setColor(Color.gray);
            graphics.fill3DRect(position.x, position.y, healthProvider.getMaxHealth(), 20, true);

            graphics.setColor(HUDBLUE);
            graphics.fill3DRect(position.x, position.y, healthProvider.getHealth(), 20, true);
        }
        
    }
    
}
