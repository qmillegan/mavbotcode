/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package riverdalerobotics;

/**
 *
 * @author Morrise
 */
public class Watchdog
{
    double m_feedTime;
    static Watchdog m_watchdog = new Watchdog();
    
    Watchdog()
    {
        m_feedTime = 0;
    }
    
    void feed()
    {
        m_feedTime = Timer.get();
    }
    
    boolean isAlive()
    {
        return m_feedTime - Timer.get() < 0.1;
    }
    
    static Watchdog getInstance()
    {
        return m_watchdog;
    }
    
}
