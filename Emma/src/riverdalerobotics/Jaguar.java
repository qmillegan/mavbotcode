package riverdalerobotics;

// Meaningless Change

public class Jaguar
{
    
    javax.swing.JTextField m_jaguar;
    private double m_speed;
    
    public Jaguar(final int channel) 
    {
        m_jaguar = EmmaGui.m_emmaGui.getJaguar(channel);
    }   
    
    
    public void set(double speed) 
    {
        m_speed = speed;
        m_jaguar.setText(Double.toString(speed));
    }

    /**
     * Get the recently set value of the PWM.
     *
     * @return The most recently set value for the PWM between -1.0 and 1.0.
     */
    public double get() 
    {
        return m_speed;
    }
    
}
