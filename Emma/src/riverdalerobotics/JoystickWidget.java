package riverdalerobotics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;

public class JoystickWidget extends javax.swing.JPanel 
{
    
    int jx, jy;
    boolean inited = false;
    final int stickSize = 7;
    public JoystickWidget() 
    {
        Dimension size = getSize();
    }
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponents(g);
        Graphics2D g2d = (Graphics2D) g;
        Dimension size = getSize();
        // Fill background
        g2d.setColor(Color.white);
        g2d.fillRect(0, 0, size.width, size.height);
        g2d.setColor(Color.black);  
        // Draw center liens and bounding box
        g2d.drawRect(0, 0, size.width-1, size.height-1);
        g2d.drawLine(0, size.height/2, size.width, size.height/2);
        g2d.drawLine(size.width/2, 0, size.width/2, size.height);
        // Draw knob
        g2d.setColor(Color.blue); 
        if (!inited)
        {
            jx = size.width/2;
            jy = size.height/2; 
            inited = true;
        }
        g2d.fillOval(jx-stickSize, jy-stickSize, stickSize*2, stickSize*2);
    }
    
    public void setXY(int x, int y)
    {
        jx = x;
        jy = y;
        Dimension size = getSize();
        // Make sure not to close to edge
        if ( jx < stickSize*2)
            jx = stickSize*2;
        if ( jy < stickSize*2)
            jy = stickSize*2;
        if (jx > size.width-stickSize*2)
            jx = size.width-stickSize*2;
        if (jy > size.height-stickSize*2)
            jy = size.height-stickSize*2;
        // Force to center line
        if (Math.abs(jx-size.width/2) < 5)
            jx = size.width/2;
        if (Math.abs(jy-size.height/2) < 5)
            jy = size.height/2;
        // Repaint
        this.invalidate();
        this.repaint();
    }
    
    public double getStickX()
    {
        Dimension size = getSize();
        double x = jx;
        x = (x - size.width/2) / (size.width/2-stickSize*2);
        return x;
    }

    public double getStickY()
    {
        Dimension size = getSize();
        double y = jy;
        y = (y - size.height/2) / (size.height/2-stickSize*2);
        return -y;
    }

}
