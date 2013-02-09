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
    Timer m_timer;
    
    Watchdog()
    {
        m_feedTime = 0;
        m_timer = new Timer();
    }
    
    void feed()
    {
        m_feedTime = m_timer.get();
    }
    
    boolean isAlive()
    {
        return m_feedTime - m_timer.get() < 0.1;
    }
    
    static Watchdog getInstance()
    {
        return m_watchdog;
    }
    
}
