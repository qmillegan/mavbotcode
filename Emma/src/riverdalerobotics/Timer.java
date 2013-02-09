/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdalerobotics;

/**
 *
 * @author Matt Morrise
 * Meaningless Change
 */
public class Timer
{
    
    double m_startTime = 0;
    static void delay(double time)
    {
         try
         {
            Thread.sleep((int) (time * 1000));
         }
         catch (Exception e)
         {
         }
    }
    
    void start()
    {
        m_startTime = ((double) System.currentTimeMillis());
    }
    
    double get()
    {
        double time = ((double) System.currentTimeMillis());
        return time-m_startTime;
    }
    
}
