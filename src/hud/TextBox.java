/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hud;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JTextArea;

/**
 *
 * @author david
 */
class TextBox extends JTextArea {
    public static Font STENCIL = new Font("Stencil", Font.BOLD, 16);
    
    {
        setBackground(ProjectColors.HUD_GREY);
        setForeground(ProjectColors.HUD_BLUE);
        setFont(STENCIL);
        this.setLineWrap(true);
    }
    
    
    public TextBox(Point location){
        setLocation(location);
    }
    
    public TextBox(Point location, Dimension size){
        setLocation(location);
        setSize(size);
    }
    
    @Override
    public void paint(Graphics graphics) {
        super.paint(graphics);
    }
    
}
