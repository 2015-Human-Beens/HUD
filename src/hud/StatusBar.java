/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hud;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;

/**
 *
 * @author david
 */
public class StatusBar extends Component {
    
    {
        this.setBounds(new Rectangle(100, 100));
    }
    
    public StatusBar(StatusProviderIntf healthProvider, Point position, Dimension size){
        this.statusProvider = healthProvider;
        this.position = position;
        this.size = size;
    }
    
//    private String label;
    private StatusProviderIntf statusProvider;
    private Point position;
    private Dimension size;
    private Color statusColor = ProjectColors.HUD_BLUE;
    private Color statusBackgroundColor = ProjectColors.HUD_GREY;

    
    public void paint(Graphics graphics){
        if (statusProvider != null){
            graphics.setColor(statusBackgroundColor);
            graphics.fill3DRect(position.x, position.y, size.width, size.height, true);

            graphics.setColor(statusColor);
            graphics.fill3DRect(position.x, position.y, size.width * statusProvider.getStatus() / statusProvider.getMaxStatus(), size.height, true);
        }
        
    }
    
}
