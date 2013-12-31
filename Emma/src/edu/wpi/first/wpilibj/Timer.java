/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj;

/**
 *
 * @author Matt Morrise
 * Meaningless Change
 */
public class Timer
{
    
    double m_startTime = 0;
    public static void delay(double time)
    {
         try
         {
            Thread.sleep((int) (time * 1000));
         }
         catch (Exception e)
         {
         }
    }
    
    public void start()
    {
        m_startTime = ((double) System.currentTimeMillis());
    }
    
    public double get()
    {
        double time = ((double) System.currentTimeMillis());
        return time-m_startTime;
    }
    
}
