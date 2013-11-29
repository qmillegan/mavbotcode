package riverdalerobotics;

/**
 * Handle input from standard Joysticks connected to the Driver Station.
 * This class handles standard input that comes from the Driver Station. Each time a value is requested
 * the most recent value is returned. There is a single class instance for each joystick and the mapping
 * of ports to hardware buttons depends on the code in the driver station.
 */
public class Joystick
{

    private final javax.swing.JToggleButton[] m_buttons;
    private final javax.swing.JToggleButton m_trigger;
    private final JoystickWidget m_joystick;

    /**
     * Construct an instance of a joystick.
     * The joystick index is the usb port on the drivers station.
     *
     * @param port The port on the driver station that the joystick is plugged into.
     */
    public Joystick(final int port) 
    {
        m_buttons = EmmaGui.m_emmaGui.getButtons(port);
        m_trigger = EmmaGui.m_emmaGui.getTrigger(port);
        m_joystick = EmmaGui.m_emmaGui.getJoystick(port);
    }

    public boolean getRawButton(final int button) 
    {
        return m_buttons[button-1].isSelected();
    }
    
    
    public boolean getTrigger() 
    {
        return m_trigger.isSelected();
    }

    /**
     * Get the X value of the joystick.
     * In actual joystick class this is from the base class
     */
    public final double getX() 
    {
        return m_joystick.getStickX();
    }

    public final double getY() 
    {
        return m_joystick.getStickY();
    }

}
